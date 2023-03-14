import FABuilder.Edge;
import FABuilder.FAGraph;
import FABuilder.Vertex;
import org.jgrapht.Graph;

import java.util.ArrayList;

class NonDeterminismException extends Exception{
    FAGraph graph;
    ArrayList<Edge> edges;
    NonDeterminismException(FAGraph graph, ArrayList<Edge> edges){
        this.graph = graph;
        this.edges = edges;
    }

    @Override
    public String getMessage() {
        Vertex source = graph.getEdgeSource(edges.iterator().next());
        Vertex target = graph.getEdgeTarget(edges.iterator().next());
        StringBuilder edgeString = new StringBuilder();
        for (Edge e : edges){
            edgeString.append("%s ".formatted(e));
        }

        return "Deterministic graph has more than one possible path (From %s to %s, using edges %s). Determinism violated.".formatted(source, target, edgeString);
    }
}

public class FATester {
    FAGraph graph;
    FATester(FAGraph graph){
        this.graph = graph;
    }

    ArrayList<Integer> TestInput(String inputString) throws NonDeterminismException{
        Vertex currVertex = graph.root;

        ArrayList<Integer> matches = new ArrayList<>();


        char[] chars = inputString.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            char input = chars[i];

            ArrayList<Edge> possibleEdges = new ArrayList<>();

            for (Edge out : graph.outgoingEdgesOf(currVertex)){
                if(out.conditionsContainCharacter(input)) { //simple, does not cover: backrefs, numbered quantifiers
                    possibleEdges.add(out);
                }
            }

            if(possibleEdges.size() == 0){
                if(!graph.getFlags().startOfString)
                    currVertex = graph.root;
                else
                    currVertex = graph.errorVertex;
            }

            if(possibleEdges.size() > 1)
                throw new NonDeterminismException(graph, possibleEdges);

            Edge edge = possibleEdges.get(0);

            currVertex = graph.getEdgeTarget(edge);
            if(currVertex.isTerminalVertex){
                matches.add(i);
            }
        }

        return matches;
    }

    boolean TestInput(String inputString, ArrayList<Integer> expectedMatchIndexes) throws NonDeterminismException {
        ArrayList<Integer> matches = TestInput(inputString);

        return matches.equals(expectedMatchIndexes);
    }
}
