package RulesetAnalysis;

import FABuilder.FABuilder;
import FABuilder.FAGraph;
import gen.PCREGrammarLexer;
import gen.PCREGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;

public class ComplexityCriteriaTest {
    public static ArrayList<FAGraph> createGraphs(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        PCREGrammarLexer lexer = new PCREGrammarLexer(CharStreams.fromStream(in));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PCREGrammarParser parser = new PCREGrammarParser(tokens);
        ParseTree tree = parser.parse();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        FABuilder faBuilder = new FABuilder();
        parseTreeWalker.walk(faBuilder, tree);

        return faBuilder.getFaGraphs();
    }

    public static void main2(String[] args) throws IOException {
        ArrayList<FAGraph> graphs = createGraphs("src/main/resources/groupM.txt");

        ArrayList<Double> timings = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/estimatedTimingGroupM.txt"));

        ArrayList<String> lines = new ArrayList<>();
        while (true){
            String line = bufferedReader.readLine();
            if(line == null)
                break;

            lines.add(line);
        }

        for (String line : lines){
            timings.add(Double.parseDouble(line));
        }

        RuleComplexityRater ruleComplexityRater = new RuleComplexityRater(graphs, timings);

        ArrayList<RuleRating> ratings = ruleComplexityRater.getRatings(),
                realRatings = ruleComplexityRater.getRealRatings();

        ArrayList<RuleRating> toFilterEstimated = new ArrayList<>();

        for (RuleRating r : ratings){
            if(r.graph.getRule().matches("/\\^.*\\{.*/[a-zA-Z]*\\r?\\n")){
                toFilterEstimated.add(r);
                realRatings.remove(r);
            }
        }

        ratings.removeAll(toFilterEstimated);

        System.out.printf("%d %d\n", ratings.size(), realRatings.size());

        int maxError = 0;
        int maxErrorID = -1;
        int minError = Integer.MAX_VALUE;
        int minErrorID = -1;
        int totalError = 0;


        for (int i = 0; i < realRatings.size(); i++) {
            int ratedIndex = ratings.indexOf(new RuleRating(null, realRatings.get(i).ID, 0.0));

            int error = Math.abs(ratedIndex - i);

            if(maxError < error)
                maxError = error;
                maxErrorID = realRatings.get(i).ID;
            if(minError > error){
                minError = error;
                minErrorID = realRatings.get(i).ID;
            }
            totalError += error;
        }

        System.out.printf("Error statistics: Max error %f %d (rule %d), Min Error %f %d (rule %d), Avg Error %f(%d)\n",
                maxError/(double)realRatings.size(),
                maxError,
                maxErrorID,
                minError/(double)realRatings.size(),
                minError,
                minErrorID,
                totalError/(double)realRatings.size(),
                totalError);


        //print
        for (int i = 0; i < ratings.size(); i++) {
            RuleRating real = realRatings.get(i);
            RuleRating simulated = ratings.get(i);

            System.out.printf("Rule\t%d:\t%f\t%s\t", real.ID, real.score, real.graph.getRule());
            System.out.printf("Rule\t%d:\t%f\t%s\n", simulated.ID, simulated.score, simulated.graph.getRule());
        }

        System.out.println("\n\n");

        for (int i = 0; i < ratings.size(); i++) {
            RuleRating indexBasis = new RuleRating(null, i, 0.0);
            if(realRatings.contains(indexBasis))
                System.out.printf("Rule\t%d:\tranking in real: %d\tranking in simulated: %d\t\t%s", i, realRatings.indexOf(indexBasis), ratings.indexOf(indexBasis), ratings.get(ratings.indexOf(indexBasis)).graph.getRule());
        }
    }

    public static void main(String[] args) throws IOException {
        ArrayList<FAGraph> graphs = createGraphs("src/main/resources/groupM.txt");

        ArrayList<Double> timings = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/estimatedTimingGroupM.txt"));

        ArrayList<String> lines = new ArrayList<>();
        while (true){
            String line = bufferedReader.readLine();
            if(line == null)
                break;

            lines.add(line);
        }

        for (String line : lines){
            timings.add(Double.parseDouble(line));
        }

        ArrayList<RuleExpectedTiming> ruleTimings = new ArrayList<>();
        int i = 0;
        for (FAGraph graph : graphs){
            ruleTimings.add(new RuleExpectedTiming(graph, i, timings.get(i)));
            i++;
        }

        ArrayList<RuleExpectedTiming> toFilter = new ArrayList<>();

        for (RuleExpectedTiming r : ruleTimings){
            if(r.graph.getRule().matches("/\\^.*\\{.*/[a-zA-Z]*\\r?\\n")){
                toFilter.add(r);
            }
        }

        ruleTimings.removeAll(toFilter);

        int maxError = 0;
        int maxErrorID = -1;
        int minError = Integer.MAX_VALUE;
        int minErrorID = -1;
        int totalError = 0;

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

        for (int j = 0; j < sortedByReal.size(); j++) {
            int ratedIndex = sortedBySimulated.indexOf(sortedByReal.get(j));

            int error = Math.abs(ratedIndex - j);

            if(maxError < error)
                maxError = error;
            maxErrorID = sortedByReal.get(j).ID;
            if(minError > error){
                minError = error;
                minErrorID = sortedByReal.get(j).ID;
            }
            totalError += error;
        }


        System.out.printf("Error statistics: Max error %f %d (rule %d), Min Error %f %d (rule %d), Avg Error %f, Total Error(%d)\n\n",
                maxError/(double)ruleTimings.size(),
                maxError,
                maxErrorID,
                minError/(double)ruleTimings.size(),
                minError,
                minErrorID,
                totalError/(double)ruleTimings.size(),
                totalError);


        //print
        for (int j = 0; j < ruleTimings.size(); j++) {
            RuleExpectedTiming real = sortedByReal.get(j);
            RuleExpectedTiming simulated = sortedBySimulated.get(j);

            System.out.printf("Rule\t%d:\t%f\t%s\t", real.ID, real.realTiming, real.graph.getRule());
            System.out.printf("Rule\t%d:\t%f\t%s\n", simulated.ID, simulated.simulatedTiming, simulated.graph.getRule());
        }

        System.out.println("\n\n");


        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.ID;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedByID = new ArrayList<>(ruleTimings);

        for (RuleExpectedTiming r : sortedByID){
            System.out.printf("Rule\t%d:\tranking in real:\t%d\t(%f)\tranking in simulated:\t%d\t(%f)\t\t%s",
                    r.ID, sortedByReal.indexOf(r), r.realTiming,
                    sortedBySimulated.indexOf(r), r.simulatedTiming,
                    r.graph.getRule());
        }

        for (RuleExpectedTiming r : sortedByID){
            System.out.printf("Rule\t%d: %d %d \n", r.ID, r.graph.vertexSet().size(), r.graph.edgeSet().size());
        }
    }
}


