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
import java.util.ArrayList;
import java.util.Collections;

public class RuleComplexityParamCalibration {
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

        ArrayList<RuleExpectedTiming> ruleTimings = new ArrayList<>();
        int i = 0;
        for (FAGraph graph : graphs){
            ruleTimings.add(new RuleExpectedTiming(graph, i, timings.get(i)));
            i++;
        }

        //TODO remove
        ArrayList<RuleExpectedTiming> toFilter = new ArrayList<>();
        for (RuleExpectedTiming r : ruleTimings){
            if(r.graph.getRule().matches("/\\^.*\\{.*/[a-zA-Z]*\\r?\\n")){
                toFilter.add(r);
            }
        }
        ruleTimings.removeAll(toFilter);

        RuleExpectedTiming.edgeMult = 0;
        RuleExpectedTiming.decoderWidthMult = 0;
        double step = .01;
        double max = 10;

        double minimumError = Double.MAX_VALUE;
        double bestMult = 0;

        while (RuleExpectedTiming.edgeMult < max){
            int totalError = 0;

            for (RuleExpectedTiming r : ruleTimings){
                r.calculateScore();
            }

            RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
            Collections.sort(ruleTimings);
            ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

            RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
            Collections.sort(ruleTimings);
            ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

            for (int j = 0; j < sortedByReal.size(); j++) {
                int ratedIndex = sortedBySimulated.indexOf(sortedByReal.get(j));

                int error = Math.abs(ratedIndex - j);
                totalError += error;
            }

            double averageError = totalError/(double)sortedByReal.size();

            if(minimumError > averageError){
                minimumError = averageError;
                bestMult = RuleExpectedTiming.edgeMult;
            }

            //update vars
            RuleExpectedTiming.edgeMult += step;
        }

        System.out.printf("Best ordering obtained for EdgeMult of %f with error of %f%n", bestMult, minimumError);

        RuleExpectedTiming.edgeMult = bestMult;
        minimumError = Double.MAX_VALUE;
        bestMult = 0;

        RuleExpectedTiming.decoderWidthMult = 0;
        max = 20;
        while (RuleExpectedTiming.decoderWidthMult < max){
            int totalError = 0;

            for (RuleExpectedTiming r : ruleTimings){
                r.calculateScore();
            }

            RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
            Collections.sort(ruleTimings);
            ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

            RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
            Collections.sort(ruleTimings);
            ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

            for (int j = 0; j < sortedByReal.size(); j++) {
                int ratedIndex = sortedBySimulated.indexOf(sortedByReal.get(j));

                int error = Math.abs(ratedIndex - j);
                totalError += error;
            }

            double averageError = totalError/(double)sortedByReal.size();

            if(minimumError > averageError){
                minimumError = averageError;
                bestMult = RuleExpectedTiming.decoderWidthMult;
            }

            //update vars
            RuleExpectedTiming.decoderWidthMult += step;
        }

        System.out.printf("Best ordering obtained for decoderWidthMult of %f with error of %f%n", bestMult, minimumError);

    }

    public static void main3(String[] args) throws IOException {
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

        //TODO remove
        ArrayList<RuleExpectedTiming> toFilter = new ArrayList<>();
        for (RuleExpectedTiming r : ruleTimings){
            if(r.graph.getRule().matches("/.*\\{.*/[a-zA-Z]*\\r?\\n") ||
                    r.graph.getRule().matches("/.*\\\\[0-9]+.*/[a-zA-Z]*\\r?\\n")){
                toFilter.add(r);
            }
        }
        ruleTimings.removeAll(toFilter);


        double edgeStep = .001;
        double edgeMax = 3;
        RuleExpectedTiming.edgeMult = 1 + edgeStep;

        double minimumError = Double.MAX_VALUE;
        double bestEdgeMult = 0;
        double bestDecoderWidthMult = 0;
        while (RuleExpectedTiming.edgeMult < edgeMax){

            double decoderStep = .01;
            double decoderMax = 2;
            RuleExpectedTiming.decoderWidthMult = decoderStep;

            double bestFixedMinimumError = Double.MAX_VALUE;
            double bestFixedDecoderWidthMult = 0;

            while (RuleExpectedTiming.decoderWidthMult < decoderMax){
                int totalError = 0;

                for (RuleExpectedTiming r : ruleTimings){
                    r.calculateScore();
                }

                RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
                Collections.sort(ruleTimings);
                ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

                RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
                Collections.sort(ruleTimings);
                ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

                for (int j = 0; j < sortedByReal.size(); j++) {
                    int ratedIndex = sortedBySimulated.indexOf(sortedByReal.get(j));

                    int error = Math.abs(ratedIndex - j);
                    totalError += error;
                }

                double averageError = totalError/(double)sortedByReal.size();

                if(bestFixedMinimumError > averageError){
                    bestFixedMinimumError = averageError;
                    bestFixedDecoderWidthMult = RuleExpectedTiming.decoderWidthMult;
                }

                RuleExpectedTiming.decoderWidthMult += decoderStep;
            }

            System.out.printf("Ordering obtained for EdgeMult of %f; decoderWidthMult of %f with error of %f%n", RuleExpectedTiming.edgeMult, bestFixedDecoderWidthMult, bestFixedMinimumError);


            if(minimumError > bestFixedMinimumError){
                minimumError = bestFixedMinimumError;

                bestEdgeMult = RuleExpectedTiming.decoderWidthMult;
                bestDecoderWidthMult = bestFixedDecoderWidthMult;
            }

            //update vars
            RuleExpectedTiming.edgeMult += edgeStep;
        }

        System.out.printf("Best ordering obtained for EdgeMult of %f; decoderWidthMult of %f with error of %f%n", bestEdgeMult, bestDecoderWidthMult, minimumError);

    }

    public static void main4(String[] args) throws IOException {
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

        //TODO remove
        ArrayList<RuleExpectedTiming> toFilter = new ArrayList<>();
        for (RuleExpectedTiming r : ruleTimings){
            if(r.graph.getRule().matches("/.*\\{.*/[a-zA-Z]*\\r?\\n") ||
                    r.graph.getRule().matches("/.*\\\\[0-9]+.*/[a-zA-Z]*\\r?\\n")){
                toFilter.add(r);
            }
        }
        ruleTimings.removeAll(toFilter);


        RuleExpectedTiming.vertexMult = .01;

        double edgeStep = .01;
        double edgeMax = 20;
        RuleExpectedTiming.edgeMult = 0 + edgeStep;

        double minimumError = Double.MAX_VALUE;
        double bestEdgeMult = 0;
        double bestMaximumAlternativeMult = 0;
        while (RuleExpectedTiming.edgeMult < edgeMax){

            double alternativeStep = .1;
            double alternativeMax = 20;
            RuleExpectedTiming.maximumAlternativeMult = alternativeStep;

            double bestFixedMinimumError = Double.MAX_VALUE;
            double bestFixedAlternativeMult = 0;

            while (RuleExpectedTiming.maximumAlternativeMult < alternativeMax){
                int totalError = 0;

                for (RuleExpectedTiming r : ruleTimings){
                    r.calculateScore();
                }

                RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
                Collections.sort(ruleTimings);
                ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

                RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
                Collections.sort(ruleTimings);
                ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

                for (int j = 0; j < sortedByReal.size(); j++) {
                    int ratedIndex = sortedBySimulated.indexOf(sortedByReal.get(j));

                    int error = Math.abs(ratedIndex - j);
                    totalError += error;
                }

                double averageError = totalError/(double)sortedByReal.size();

                if(bestFixedMinimumError > averageError){
                    bestFixedMinimumError = averageError;
                    bestFixedAlternativeMult = RuleExpectedTiming.maximumAlternativeMult;
                }

                RuleExpectedTiming.maximumAlternativeMult += alternativeStep;
            }

            System.out.printf("Ordering obtained for EdgeMult of %f; maximumAlternativeMult of %f with error of %f%n", RuleExpectedTiming.edgeMult, bestFixedAlternativeMult, bestFixedMinimumError);


            if(minimumError > bestFixedMinimumError){
                minimumError = bestFixedMinimumError;

                bestEdgeMult = RuleExpectedTiming.edgeMult;
                bestMaximumAlternativeMult = bestFixedAlternativeMult;
            }

            //update vars
            RuleExpectedTiming.edgeMult += edgeStep;
        }

        System.out.printf("\nBest ordering obtained for EdgeMult of %f; maximumAlternativeMult of %f with error of %f\n\n", bestEdgeMult, bestMaximumAlternativeMult, minimumError);

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

        for (int j = 0; j < sortedBySimulated.size(); j++) {
            System.out.printf("%dth| simulated: rule\t%d\treal: rule\t%d\n", j+1, sortedBySimulated.get(j).ID, sortedByReal.get(j).ID);
        }

        System.out.println();

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.ID;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedByID = new ArrayList<>(ruleTimings);

        for (RuleExpectedTiming r : sortedByID){
            System.out.printf("Rule\t%d:\tranking in real:\t%d\t(%f)\tranking in simulated:\t%d\t(%f)\t\t%s",
                    r.ID, sortedByReal.indexOf(r), r.realTiming,
                    sortedBySimulated.indexOf(r), r.simulatedTiming,
                    r.graph.getRule());
        }
    }

    public static void main5(String[] args) throws IOException {
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

        //TODO remove
        ArrayList<RuleExpectedTiming> toFilter = new ArrayList<>();
        for (RuleExpectedTiming r : ruleTimings){
            if(r.graph.getRule().matches("/.*\\{.*/[a-zA-Z]*\\r?\\n") ||
                    r.graph.getRule().matches("/.*\\\\[0-9]+.*/[a-zA-Z]*\\r?\\n")){
                toFilter.add(r);
            }
        }
        ruleTimings.removeAll(toFilter);


        RuleExpectedTiming.vertexMult = .00;
        RuleExpectedTiming.edgeMult = .00;
        RuleExpectedTiming.maximumAlternativeMult = 10;
        RuleExpectedTiming.decoderWidthMult = 0;
        RuleExpectedTiming.decoderComplexityMult = 0.08;

        double edgeStep = .01;
        double edgeMax = 20;
        RuleExpectedTiming.vertexMult = 0;

        double minimumError = Double.MAX_VALUE;
        double bestEdgeMult = 0;
        double bestMaximumAlternativeMult = 0;
        while (RuleExpectedTiming.vertexMult < edgeMax){

            double alternativeStep = .1;
            double alternativeMax = 20;
            RuleExpectedTiming.edgeMult = 0;

            double bestFixedMinimumError = Double.MAX_VALUE;
            double bestFixedAlternativeMult = 0;

            while (RuleExpectedTiming.edgeMult < alternativeMax){
                int totalError = 0;

                for (RuleExpectedTiming r : ruleTimings){
                    r.calculateScore();
                }

                RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
                Collections.sort(ruleTimings);
                ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

                RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
                Collections.sort(ruleTimings);
                ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

                for (int j = 0; j < sortedByReal.size(); j++) {
                    int ratedIndex = sortedBySimulated.indexOf(sortedByReal.get(j));

                    int error = Math.abs(ratedIndex - j);
                    totalError += error;
                }

                double averageError = totalError/(double)sortedByReal.size();

                if(bestFixedMinimumError > averageError){
                    bestFixedMinimumError = averageError;
                    bestFixedAlternativeMult = RuleExpectedTiming.edgeMult;
                }

                RuleExpectedTiming.edgeMult += alternativeStep;
            }

            System.out.printf("Ordering obtained for vertexMult of %f; edgeMult of %f with error of %f%n", RuleExpectedTiming.vertexMult, bestFixedAlternativeMult, bestFixedMinimumError);


            if(minimumError > bestFixedMinimumError){
                minimumError = bestFixedMinimumError;

                bestEdgeMult = RuleExpectedTiming.vertexMult;
                bestMaximumAlternativeMult = bestFixedAlternativeMult;
            }

            //update vars
            RuleExpectedTiming.vertexMult += edgeStep;
        }

        System.out.printf("\nBest ordering obtained for vertexMult of %f; edgeMult of %f with error of %f\n\n", bestEdgeMult, bestMaximumAlternativeMult, minimumError);

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.simulatedTiming;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedBySimulated = new ArrayList<>(ruleTimings);

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.realTiming;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedByReal = new ArrayList<>(ruleTimings);

        for (int j = 0; j < sortedBySimulated.size(); j++) {
            System.out.printf("%dth| simulated: rule\t%d\treal: rule\t%d\n", j+1, sortedBySimulated.get(j).ID, sortedByReal.get(j).ID);
        }

        System.out.println();

        RuleExpectedTiming.sortingStyle = RuleExpectedTiming.SortingStyle.ID;
        Collections.sort(ruleTimings);
        ArrayList<RuleExpectedTiming> sortedByID = new ArrayList<>(ruleTimings);

        for (RuleExpectedTiming r : sortedByID){
            System.out.printf("Rule\t%d:\tranking in real:\t%d\t(%f)\tranking in simulated:\t%d\t(%f)\t\t%s",
                    r.ID, sortedByReal.indexOf(r), r.realTiming,
                    sortedBySimulated.indexOf(r), r.simulatedTiming,
                    r.graph.getRule());
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

        System.out.println(timings);
    }
}
