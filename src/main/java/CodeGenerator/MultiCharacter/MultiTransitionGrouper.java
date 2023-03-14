package CodeGenerator.MultiCharacter;

import FABuilder.Edge;
import FABuilder.FAGraph;
import FABuilder.Vertex;

import java.util.*;

public class MultiTransitionGrouper{

    FAGraph g;
    int stride;
    Map<Vertex, List<Vertex>> graphToGraphVertexMap = new HashMap<>();
    //list of vertices which correspond to vertex in FAGraph
    //only needs a terminal and non-terminal version which have the same outputs;


    MultiTransitionFAGraph newGraph;

    void EdgeCollectionComposer(List<List<Edge>> superEdges, List<Boolean> edgeTargetIsTerminal, Stack<Edge> edgeStack, int depth){
        //check if stack size is equal to depth
        List<Edge> edgeList;

        edgeList = new ArrayList<>(List.copyOf(edgeStack));

        boolean terminal = false;
        for (Edge e : edgeList){
            if(g.getEdgeTarget(e).isTerminalVertex){
                terminal = true;
                //if terminal, any characters following should throw a terminal
                break;
            }
        }

        while (edgeList.size() < depth){
            edgeList.add(null);
        }

        superEdges.add(edgeList);
        edgeTargetIsTerminal.add(terminal);
    }

    //TODO still need the isTerminal variable
    void EdgeCollector(List<List<Edge>> superEdges, List<Boolean> edgeTargetIsTerminal, Stack<Edge> edgeStack, Vertex curr, int depth){
        if(depth < stride){ //explore
            for (Edge e : g.outgoingEdgesOf(curr)){
                edgeStack.push(e);
                EdgeCollector(superEdges, edgeTargetIsTerminal, edgeStack, g.getEdgeTarget(e), depth + 1);
                edgeStack.pop();
            }
        }
        else{
            EdgeCollectionComposer(superEdges, edgeTargetIsTerminal, edgeStack, depth);
        }

    }

    public MultiTransitionGrouper(FAGraph g, int stride){
        this.g = g;
        this.stride = stride;

        newGraph = new MultiTransitionFAGraph();

        ArrayList<Edge> transitionEdges;

        Stack<Vertex> depthFirstStack = new Stack<>();

        Set<Vertex> visitedVertices = new HashSet<>();


        depthFirstStack.push(g.root);

        Vertex rootRepresentation = new Vertex();
        newGraph.addVertex(rootRepresentation);
        ArrayList<Vertex> rootRepresentationList = new ArrayList<>();
        rootRepresentationList.add(rootRepresentation);

        graphToGraphVertexMap.put(g.root, rootRepresentationList);

        while (depthFirstStack.size() > 0){
            Vertex v = depthFirstStack.pop();
            if(!visitedVertices.contains(v)){

                visitedVertices.add(v);

                Stack<Edge> edgesOfTransition = new Stack<>();
                LinkedList<List<Edge>> connectingSuperEdges = new LinkedList<>();
                LinkedList<Boolean> superEdgeTargetIsTerminal = new LinkedList<>();
                EdgeCollector(connectingSuperEdges, superEdgeTargetIsTerminal, edgesOfTransition, v, 0);

                //get superEdge targets and push them
                for (List<Edge> superEdge : connectingSuperEdges){
                    Vertex superEdgeTarget = g.getEdgeTarget(superEdge.get(superEdge.size()-1));

                    //connections?

                    //naive way atm


                    depthFirstStack.push(superEdgeTarget);
                }
            }
        }

    }

    MultiTransitionFAGraph exportMTFAGraph(){
        return newGraph;
    }
}
