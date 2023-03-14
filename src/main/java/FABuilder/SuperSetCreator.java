package FABuilder;

import FABuilder.Loops.IterationCountVar;
import FABuilder.Loops.LoopInteraction;
import org.jgrapht.graph.DirectedPseudograph;

import java.util.*;

public class SuperSetCreator {
    DirectedPseudograph<Vertex, Edge> g;

    Map<Vertex, ArrayList<Edge>> transitionMap = new HashMap<>();
    Map<Vertex, Set<Vertex>> epsilonSetOfVertex = new HashMap<>();

    Set<Vertex> terminalSuperVertices = new HashSet<>();

    Map<Set<Vertex>, Vertex> superVertexToVertex = new HashMap<>();

    Vertex newStart;
    Vertex newStop;

    Vertex getVertexOfSuperVertex(Set<Vertex> superSet){
        Vertex correspondentVertex;
        if(!superVertexToVertex.containsKey(superSet)) {
            correspondentVertex = new Vertex();
            g.addVertex(correspondentVertex);
            for (Vertex v1 : superSet){
                if (v1.isTerminalVertex) {
                    correspondentVertex.isTerminalVertex = true;
                    terminalSuperVertices.add(correspondentVertex);
                    break;
                }
            }

            superVertexToVertex.put(superSet, correspondentVertex);
        }
        else
            correspondentVertex = superVertexToVertex.get(superSet);

        return correspondentVertex;
    }

    public SuperSetCreator(DirectedPseudograph<Vertex, Edge> g, Vertex start){
        this.g = g;

        //get starting set
        Stack<Vertex> vertices = new Stack<>();
        Set<Vertex> visitedVertices = new HashSet<>();

        vertices.push(start);
        visitedVertices.add(start);

        while (vertices.size() > 0){
            Vertex v = vertices.pop();

            ArrayList<Edge> adjacencyList = new ArrayList<>(); //only for terminals
            transitionMap.put(v, adjacencyList);

            epsilonSetOfVertex.put(v, recursiveEpsilonSet(g, v));
            for (Edge e : g.outgoingEdgesOf(v)){
                if(e.negativeConditions)
                    e.invertConditionNaming();

                Vertex target = g.getEdgeTarget(e);

                if(!visitedVertices.contains(target)){
                    visitedVertices.add(target);
                    vertices.push(target);
                }

                if(e.conditions.size() > 0 || e.loopInteractions.size() > 0){
                    adjacencyList.add(e);
                }

            }
        }

        //create superSet

        Stack<Set<Vertex>> superVertices = new Stack<>();
        Set<Set<Vertex>> visitedSuperVertices = new HashSet<>();

        Set<Vertex> startSuperSet = new HashSet<>();
        startSuperSet.add(start);

        superVertices.add(startSuperSet);
        visitedSuperVertices.add(startSuperSet);

        newStart = getVertexOfSuperVertex(startSuperSet);

        while(superVertices.size() > 0){
            Set<Vertex> superState = superVertices.pop();

            for (Vertex v : superState) {
                for (Edge e : transitionMap.get(v)) {
                    if(e.conditions.size() > 0){ //it's a literal

                        //[condition] epsilon*
                        Set<Vertex> preconditionSet = epsilonSetOfVertex.get(g.getEdgeTarget(e));

                        boolean conditionalsFound = false;
                        //[condition] epsilon* epsilon(i<min) epsilon*
                        for (Vertex v2 : preconditionSet){
                            for (Edge e2 : transitionMap.get(v2)){
                                //look for pure LoopInteraction edges
                                if(e2.conditions.size() == 0 && e2.loopInteractions.size() > 0){
                                    conditionalsFound = true;

                                    //contains precondition and postcondition set
                                    Set<Vertex> targetSuperSet = new HashSet<>(preconditionSet);
                                    targetSuperSet.addAll(epsilonSetOfVertex.get(g.getEdgeTarget(e2)));

                                    //check if exists or
                                    //add to super set graph
                                    Vertex correspondentTargetVertex = getVertexOfSuperVertex(targetSuperSet);
                                    Vertex correspondentSourceVertex = getVertexOfSuperVertex(superState);
                                    //from edge with literal
                                    Edge superEdge = new Edge(e);
                                    //from edge with condition
                                    if(correspondentSourceVertex.isTerminalVertex) {
                                        if(e2.loopInteractions.get(0).getInteractionType() == LoopInteraction.InteractionType.complete){
                                            //no need to add
                                            if(e2.loopInteractions.get(0).getVar().getVarType() == IterationCountVar.varType.bound){
                                                superEdge.loopInteractions.addAll(e2.loopInteractions);
                                            }

                                            g.addEdge(correspondentSourceVertex, correspondentTargetVertex, superEdge);
                                        }
                                        //no need to do so for impossible transitions
                                        //i.e. i < 0 when i<=1 has been travelled
                                    }
                                    else {
                                        superEdge.loopInteractions.addAll(e2.loopInteractions);
                                        //TODO is this enough?

                                        g.addEdge(correspondentSourceVertex, correspondentTargetVertex, superEdge);
                                    }


                                    if(!visitedSuperVertices.contains(targetSuperSet)){
                                        superVertices.push(targetSuperSet);
                                        visitedSuperVertices.add(targetSuperSet);
                                    }
                                }
                            }
                        }

                        if(!conditionalsFound){
                            //add as is to super set graph

                            Vertex currSuperVertex = getVertexOfSuperVertex(superState);
                            Vertex targetSuperVertex = getVertexOfSuperVertex(preconditionSet);


                            if(!g.containsEdge(currSuperVertex, targetSuperVertex))
                                g.addEdge(currSuperVertex, targetSuperVertex, new Edge(e));
                            //to prevent cases for which there are ambiguous transitions with different varIncrements
                            //i.e. "/b" var1++ and "/b" var1++ var2++
                            else{
                                //if same conditions, add varIncrements instead of creating edge
                                for (Edge edge : g.getAllEdges(currSuperVertex, targetSuperVertex)){
                                    if(edge.negativeConditions == e.negativeConditions
                                            && edge.conditions.equals(e.conditions)
                                            && edge.loopInteractions.equals(e.loopInteractions)){

                                        edge.varInteractions.addAll(e.varInteractions);
                                    }
                                }
                            }

                            if(!visitedSuperVertices.contains(preconditionSet)){
                                superVertices.push(preconditionSet);
                                visitedSuperVertices.add(preconditionSet);
                            }
                        }
                    }
                }
            }
        }

        for (Vertex v : visitedVertices){
            g.removeVertex(v);
        }

        if(terminalSuperVertices.size() > 1){
            Vertex totalTerminal = new Vertex();
            g.addVertex(totalTerminal);
            totalTerminal.isTerminalVertex = true;

            for (Vertex terminalVertex : terminalSuperVertices){
                terminalVertex.isTerminalVertex = false;
                g.addEdge(terminalVertex, totalTerminal); //epsilon transition to global terminal
            }

            newStop = totalTerminal;
        }
        else{
            newStop = terminalSuperVertices.iterator().next();
        }
    }

    Set<Vertex> recursiveEpsilonSet(DirectedPseudograph<Vertex, Edge> g, Vertex v){
        Set<Vertex> set = new HashSet<>();
        set.add(v);

        for (Edge e : g.outgoingEdgesOf(v)){
            if(e.conditions.size() == 0 && e.loopInteractions.size() == 0){
                set.addAll(recursiveEpsilonSet(g, g.getEdgeTarget(e)));
            }
        }

        return set;
    }

    public Vertex getNewStart() {
        return newStart;
    }

    public Vertex getNewStop() {
        return newStop;
    }
}
