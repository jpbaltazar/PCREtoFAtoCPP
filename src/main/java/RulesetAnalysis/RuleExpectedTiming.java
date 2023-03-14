package RulesetAnalysis;

import CodeGenerator.NewDecoder.Decoder;
import CodeGenerator.Options.CodeGeneratorOptions;
import FABuilder.FAGraph;
import FABuilder.Vertex;

public class RuleExpectedTiming implements Comparable<RuleExpectedTiming>{
    FAGraph graph;
    double simulatedTiming;
    double realTiming;
    int ID;

    //Properties
    int vertexCount;
    int edgeCount;
    int numberedQuantifier = 0;
    int decoderWidth = -1;
    int decoderComplexity = -1;

    //MULTIPLIERS

    //Length
    public static double vertexMult = 1;
    public static double edgeMult = 1.5;

    //featureUse
    public static double maximumAlternativeMult = 2;

    public static double numberedQuantifierMult = 2;

    //
    public static double decoderWidthMult = 2;
    public static double decoderComplexityMult = 2;

    //SORTING help
    public enum SortingStyle{
        ID,
        simulatedTiming,
        realTiming
    }
    static public SortingStyle sortingStyle = SortingStyle.ID;

    RuleExpectedTiming(FAGraph graph, int ID, double realTiming){
        this.graph = graph;
        calculateScore();
        this.realTiming = realTiming;
        this.ID = ID;

    }

    public double calculateScore(){
        double baseline = 1000.00;

        //vertex, transition count and feature use
        double vertexScore = graph.vertexSet().size() * vertexMult;
        double edgeScore = graph.edgeSet().size() * edgeMult;

        double alternativeScore = 0;
        for (Vertex v : graph.vertexSet()){
            if(alternativeScore < graph.outDegreeOf(v))
                alternativeScore = graph.outDegreeOf(v);
        }
        alternativeScore *= maximumAlternativeMult;

        //double dfaScore = vertexScore + edgeScore;
        double dfaScore = Double.max(vertexScore, edgeScore);
        dfaScore = Double.max(dfaScore, alternativeScore);

        CodeGeneratorOptions options = new CodeGeneratorOptions("");
        options.decoderOptions.preDisambiguationDecoder = true;
        options.decoderOptions.functionDecoder = true;

        if(decoderWidth == -1){
            Decoder d = new Decoder(graph, options, 0);
            decoderWidth = d.getWidth();
            decoderComplexity = d.getDecoderComplexity();
        }
        //decoder complexity
        double decoderScore = Double.max(decoderWidth * decoderWidthMult, decoderComplexity * decoderComplexityMult);

        vertexCount = graph.vertexSet().size();
        edgeCount = graph.edgeSet().size();


        //simulatedTiming = (baseline - dfaScore - decoderScore); //4.97
        //simulatedTiming = (baseline - dfaScore * decoderScore); //5.35
        simulatedTiming = (baseline - Double.max(dfaScore,decoderScore)); //5.03

        return simulatedTiming;
    }

    @Override
    public int compareTo(RuleExpectedTiming o) {
        return switch (sortingStyle) {
            case ID -> Integer.compare(ID, o.ID);
            case realTiming -> Double.compare(realTiming, o.realTiming);
            case simulatedTiming -> Double.compare(simulatedTiming, o.simulatedTiming);
        };
    }

    @Override
    public boolean equals(Object obj) {
        if(obj.getClass() != RuleExpectedTiming.class)
            return false;
        RuleExpectedTiming r = (RuleExpectedTiming) obj;

        return ID == r.ID && graph.getRule().equals(r.graph.getRule());
    }
}

