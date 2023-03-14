package RulesetAnalysis;

import FABuilder.Edge;
import FABuilder.FAGraph;
import FABuilder.Vertex;
import gen.PCREGrammarBaseListener;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

//Each graph needs to get the most complex transitions
// out degree; range quantifiers; variable interactions (e.g. i++); char sets;

public class RuleMaxLatencyCalc {
    FAGraph graph;

    int calculateConditionComplexity(Edge e){
        int TotalCharsetComplexity = 0;
        int nonTrivialCharSetMultiplier = 2; //if not a single character, multiply its complexity by this value
        for (String s : e.conditions){
            int[] conditionInterval = Edge.parseCondition(s);
            int setComplexity = 1;
            if(conditionInterval[0] != conditionInterval[1]){
                setComplexity *= nonTrivialCharSetMultiplier;
            }
            TotalCharsetComplexity += setComplexity;
        }

        return TotalCharsetComplexity;
    }

    //Get the complexity of the most complex state
    Edge MostComplexEdge(){
        ArrayList<Edge> edges = new ArrayList<>(graph.edgeSet());
        edges.sort((o1, o2) -> {
            int rangeQuantDif = o1.loopInteractions.size() - o2.loopInteractions.size(); //criterion 1
            if (rangeQuantDif != 0){
                return rangeQuantDif;
            }

            int outDegreeDif = graph.outDegreeOf(graph.getEdgeSource(o1)) - graph.outDegreeOf(graph.getEdgeSource(o1)); //criterion 2
            if(outDegreeDif != 0){
                return outDegreeDif;
            }

            int mostComplexCharSets = calculateConditionComplexity(o1) - calculateConditionComplexity(o2); //criterion 3
            if (mostComplexCharSets != 0){
                return mostComplexCharSets;
            }

            return o1.varInteractions.size() - o2.varInteractions.size(); //criterion 4
        });

        return edges.get(0);
    }
}
