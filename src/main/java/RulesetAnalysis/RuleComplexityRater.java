package RulesetAnalysis;


import CodeGenerator.NewDecoder.Decoder;
import CodeGenerator.Options.CodeGeneratorOptions;
import FABuilder.FABuilder;
import FABuilder.FAGraph;
import gen.PCREGrammarBaseListener;
import gen.PCREGrammarLexer;
import gen.PCREGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jgrapht.Graph;
import org.junit.Rule;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;


class RuleRating implements Comparable<RuleRating>{
    FAGraph graph;

    double score = 0;
    int ID;
    //MULTIPLIERS

    //Length
    double vertexMult = 1;
    double edgeMult = 1.5;

    //featureUse
    double numberedQuantifierMult = 2;

    //
    double decoderWidthMult = 2;

    //Calculation
    RuleRating(FAGraph graph, int ID){
        this.graph = graph;
        this.ID = ID;

        score = calculateScore();
    }

    RuleRating(FAGraph graph, int ID, Double score){
        this.graph = graph;
        this.score = score;
        this.ID = ID;
    }

    double calculateScore(){
        double baseline = 1000.00;

        double dfaScore = graph.vertexSet().size() * vertexMult;
        dfaScore += graph.edgeSet().size() * edgeMult;

        CodeGeneratorOptions options = new CodeGeneratorOptions("");
        options.decoderOptions.preDisambiguationDecoder = true;
        options.decoderOptions.functionDecoder = true;

        Decoder d = new Decoder(graph, options, 0);

        double decoderScore = d.getWidth() * decoderWidthMult;

        return (baseline - dfaScore - decoderScore);
    }

    @Override
    public String toString() {
        return "Rule %d: %s".formatted(ID, graph.getRule());
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != this.getClass())
            return false;

        return graph.getRule().equals(((RuleRating) obj).graph.getRule());
    }

    @Override
    public int compareTo(RuleRating o) {
        return Double.compare(score, o.score);
    }
}

public class RuleComplexityRater extends PCREGrammarBaseListener {
    ArrayList<RuleRating> ratings = new ArrayList<>();
    ArrayList<RuleRating> realRatings = new ArrayList<>();


    RuleComplexityRater(ArrayList<FAGraph> graphs, ArrayList<Double> timings){
        for (int i = 0; i < graphs.size(); i++) {
            if(timings.size() <= i)
                break;

            ratings.add(new RuleRating(graphs.get(i), i));
            realRatings.add(new RuleRating(graphs.get(i), i, timings.get(i)));
        }

        Collections.sort(ratings);
        Collections.reverse(ratings);
        Collections.sort(realRatings);
    }

    public ArrayList<RuleRating> getRatings() {
        return ratings;
    }

    public ArrayList<RuleRating> getRealRatings() {
        return realRatings;
    }

    @Override
    public void exitParse(PCREGrammarParser.ParseContext ctx) {
        super.exitParse(ctx);
    }


}
