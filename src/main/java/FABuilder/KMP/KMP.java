package FABuilder.KMP;

import FABuilder.Edge;
import FABuilder.FAGraph;
import FABuilder.Vertex;

import java.util.*;

class QueuableKMP{
    Edge toTake;
    ArrayList<Edge> prefix, path;
    Set<Edge> visited;

    QueuableKMP(Edge toTake, ArrayList<Edge> prefix, ArrayList<Edge> path, Set<Edge> visited){
        this.toTake = toTake;
        this.prefix = prefix;
        this.path = path;
        this.visited = visited;
    }
}

public class KMP {
    Queue<QueuableKMP> kmpQueue = new ArrayDeque<>();

    ArrayList<Edge> prefix;
    ArrayList<Edge> path;
    Set<Edge> visited;
    Set<Edge> created = new HashSet<>();

    FAGraph graph;
    public KMP(FAGraph graph){
        this.graph = graph;

        Vertex root = graph.getRoot();
        for(Edge out : graph.outgoingEdgesOf(root)){
            kmpQueue.add(new QueuableKMP(out, new ArrayList<>(), new ArrayList<>(), new LinkedHashSet<>()));
        }

        while (!kmpQueue.isEmpty()){
            QueuableKMP queuableKMP = kmpQueue.remove();

            Edge chosenEdge = queuableKMP.toTake;
            prefix = queuableKMP.prefix;
            path = queuableKMP.path;
            visited = queuableKMP.visited;


            Vertex currVertex = graph.getEdgeSource(chosenEdge);

            while (true){
                //if the edge wasn't previously picked
                if(chosenEdge == null){
                    Set<Edge> validOut = new LinkedHashSet<>(graph.outgoingEdgesOf(currVertex));

                    //filter the outgoing edges
                    ArrayList<Edge> toRemove = new ArrayList<>();
                    for (Edge out : validOut){
                        if(visited.contains(out) || created.contains(out)){
                            toRemove.add(out);
                        }
                    }
                    validOut.removeAll(toRemove);

                    //queue up alternative edges
                    if(validOut.size() >= 1){
                        for (Edge out : validOut){
                            if(chosenEdge == null)
                                chosenEdge = out;
                            else
                                kmpQueue.add(new QueuableKMP(out, new ArrayList<>(prefix), new ArrayList<>(path), new HashSet<>(visited)));
                        }
                    }
                }
                //edge has been chosen



                //no path means no checking prefix
                if(!path.isEmpty()){
                    Vertex copyOutgoingOfThis = graph.root; //default

                    //compare with prefix
                    if(!prefix.isEmpty() && chosenEdge != null){
                        //verify with the last one
                        ArrayList<String> conditions = Edge.intersectionConditions(
                                chosenEdge.conditions,
                                path.get(prefix.size()).conditions);


                        if(conditions.size() > 0){ //there is overlap on the prefix
                            prefix.add(chosenEdge); //TODO handle partial prefixes

                            copyOutgoingOfThis = null; //just leave vertex as is
                        }
                        else {
                            copyOutgoingOfThis = graph.getEdgeSource(prefix.get(prefix.size()-1));

                            prefix.clear();
                        }
                    }


                    if(copyOutgoingOfThis != null){
                        for (Edge out : new ArrayList<>(graph.outgoingEdgesOf(copyOutgoingOfThis))){
                            Edge copy = new Edge(out);
                            graph.addEdge(currVertex, graph.getEdgeTarget(out), copy);

                            created.add(copy);
                        }
                    }

                }

                if(chosenEdge == null)
                    break;

                path.add(chosenEdge);
                currVertex = graph.getEdgeTarget(chosenEdge);
                chosenEdge = null;
            }
        }
    }
}
