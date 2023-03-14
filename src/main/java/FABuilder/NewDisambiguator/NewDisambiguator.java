package FABuilder.NewDisambiguator;

import FABuilder.Edge;
import FABuilder.FAGraph;
import FABuilder.Loops.IterationCountVar;
import FABuilder.Loops.LoopInteraction;
import FABuilder.Vertex;

import java.util.*;

public class NewDisambiguator {
    FAGraph graph;

    Set<Vertex> initialVertexSet = new HashSet<>();//collected to be deleted

    Map<Vertex, Map<Transition, Set<Vertex>>> vertexTransitionMap = new HashMap<>();
    Map<Set<Vertex>, Map<Transition, Set<Vertex>>> megaTransitionMap = new HashMap<>();
    Map<Set<Vertex>, Vertex> representingVertexMap = new HashMap<>();

    Map<Vertex, Map<Transition, Set<Transition>>> unloopedToLoopedTransitions = new HashMap<>();
    Map<Vertex, Set<Transition>> redundantTransitions = new HashMap<>();

    Vertex createVertex(){
        Vertex v = new Vertex();
        graph.addVertex(v);

        return v;
    }

    Vertex createVertex(boolean isTerminal){
        Vertex v = new Vertex();
        v.isTerminalVertex = isTerminal;
        graph.addVertex(v);

        return v;
    }

    boolean setIsTerminal(Set<Vertex> set){
        boolean terminal = false;
        for (Vertex v : set){
            if (v.isTerminalVertex) {
                terminal = true;
                break;
            }
        }

        return terminal;
    }

    public NewDisambiguator(FAGraph graph){
        this.graph = graph;

        Vertex root = graph.getRoot();

        initialVertexSet.addAll(graph.vertexSet());

        Queue<Vertex> visitQueue = new ArrayDeque<>();
        if(graph.errorVertex != null)
            visitQueue.add(graph.errorVertex);
        else
            visitQueue.add(root);

        //populate with graph transitions
        while (visitQueue.size() > 0){
            Vertex v = visitQueue.remove();

            Map<Transition, Set<Vertex>> transitionMap = vertexTransitionMap.get(v);
            //checks if the vertex has been visited
            if(transitionMap == null){
                transitionMap = new HashMap<>();
                vertexTransitionMap.put(v, transitionMap);

                for (Edge e : graph.outgoingEdgesOf(v)){
                    Set<Transition> transitions = Transition.EdgeToTransitionSet(e);
                    Vertex targetVertex = graph.getEdgeTarget(e);

                    for (Transition t : transitions){
                        if(t.loopInteractions.size() > 0){
                            Transition unlooped = new Transition(t);
                            unlooped.loopInteractions.clear();
                            Map<Transition, Set<Transition>> unloopedToLoopedMap = unloopedToLoopedTransitions.computeIfAbsent(v, k -> new HashMap<>());
                            Set<Transition> loopedTransitionSet = unloopedToLoopedMap.computeIfAbsent(unlooped, k -> new HashSet<>());
                            loopedTransitionSet.add(t);

                            Set<Transition> transitionSet = redundantTransitions.computeIfAbsent(v, k -> new HashSet<>());
                            transitionSet.add(unlooped);
                        }

                        Set<Vertex> resultingSet = vertexTransitionMap.get(v).computeIfAbsent(t, k -> new HashSet<>());
                        resultingSet.add(targetVertex);
                    }

                    visitQueue.add(targetVertex);
                }
            }

        }

        //expand loop sets
        //to account for different loops
        //TODO
        //not really important tbh
        /*for (Vertex v : vertexTransitionMap.keySet()){
            Map<Transition, Set<Vertex>> vertexMap = vertexTransitionMap.get(v);
            Map<ArrayList<IterationCountVar>, Set<Transition>> variableToTransitionMap = new HashMap<>();

            //group all transitions
            for (Transition t : vertexMap.keySet()){
                if(!redundantTransitions.get(v).contains(t)){
                    ArrayList<IterationCountVar> varArray = new ArrayList<>();
                    for (LoopInteraction li : t.loopInteractions){
                        varArray.add(li.getVar());
                    }

                    Set<Transition> transitionSet = variableToTransitionMap.computeIfAbsent(varArray, k -> new HashSet<>());
                    transitionSet.add(t);
                }
            }

            //link them
            //(i=0, i=1) and (j=0, j=1) -> (i=0 && j=0) and (i=0 && j=1)
            for (ArrayList<IterationCountVar> varArray : variableToTransitionMap.keySet()){

            }
        }*/


        Set<Vertex> rootSet = new HashSet<>();
        rootSet.add(root);

        Vertex newRoot = createVertex();
        representingVertexMap.put(rootSet, newRoot);

        Queue<Set<Vertex>> setVisitQueue = new ArrayDeque<>();
        setVisitQueue.add(rootSet);

        //for edge "e"
        //if edges "e (i<2)" and "e (i<=3)" exist
        //still kept to add until the end to add the target states of "e" to the ones with loop conditions


        while (setVisitQueue.size() > 0){
            Set<Vertex> set = setVisitQueue.remove();

            Map<Transition, Set<Vertex>> transitionSetMap = megaTransitionMap.get(set);
            if(transitionSetMap == null){
                transitionSetMap = new HashMap<>();
                megaTransitionMap.put(set, transitionSetMap);

                //populate map
                for (Vertex v : set){
                    for (Transition t : vertexTransitionMap.get(v).keySet()){
                        if(t.loopInteractions.size() == 0 && (redundantTransitions.get(v) == null || !redundantTransitions.get(v).contains(t))){
                            Set<Vertex> targetSet = transitionSetMap.computeIfAbsent(t, k -> new HashSet<>());
                            targetSet.addAll(vertexTransitionMap.get(v).get(t));
                        }
                        else if (t.loopInteractions.size() > 0){
                            Set<Vertex> targetSet = transitionSetMap.computeIfAbsent(t, k -> new HashSet<>());
                            targetSet.addAll(vertexTransitionMap.get(v).get(t));

                            Transition unlooped = new Transition(t);
                            unlooped.loopInteractions.clear();

                            if(vertexTransitionMap.get(v).get(unlooped) != null){
                                targetSet.addAll(vertexTransitionMap.get(v).get(unlooped));
                            }
                        }
                    }
                }

                //make connecting sets
                for (Transition t : transitionSetMap.keySet()){
                    Set<Vertex> targetVertexSet = transitionSetMap.get(t);

                    setVisitQueue.add(targetVertexSet);

                    Vertex targetVertex = representingVertexMap.computeIfAbsent(targetVertexSet,
                            k -> createVertex(setIsTerminal(targetVertexSet)));

                    Vertex sourceVertex = representingVertexMap.get(set);//always exists


                    Set<Edge> allEdges = graph.getAllEdges(sourceVertex, targetVertex);
                    boolean foundStackable = false;
                    for (Edge e : allEdges){
                        if(t.isStackableTo(e)){
                            foundStackable = true;
                            e.conditions.add("" + t.condition);
                            break;
                        }
                    }

                    if(!foundStackable)
                        graph.addEdge(sourceVertex, targetVertex, t.toEdge());
                }


            }
        }

        graph.removeAllVertices(initialVertexSet);
        //keep only the only new ones
        graph.root = newRoot;

        if(graph.errorVertex != null){
            Vertex newErrorVertex = new Vertex();
            graph.addVertex(newErrorVertex);
            graph.errorVertex = newErrorVertex;

            Edge errorRestartEdge = new Edge("\\x00");
            if(graph.getFlags().m)
                errorRestartEdge.conditions.add("\n");
            graph.addEdge(graph.errorVertex, graph.root, new Edge(errorRestartEdge));
        }

        for (Edge e : graph.edgeSet()){
            e.simplifyConditions();
        }
    }
}
