package FABuilder;

import org.jgrapht.graph.DirectedPseudograph;

import java.util.ArrayList;
import java.util.Set;
import java.util.TreeSet;

public class FAGraph extends DirectedPseudograph<Vertex, Edge>{
    public Vertex root;
    public Vertex errorVertex = null;

    String rule; // between the '/' and the '/'
    RegexFlags flags; // after both the '/'s

    ArrayList<String> referencesUsed;

    FAGraph(){
        super(Edge.class);
        root = null;

        rule = "";
        referencesUsed = new ArrayList<>();
    }

    public Vertex getRoot() {
        return root;
    }

    public Vertex getErrorVertex() {
        return errorVertex;
    }

    public String getRule() {
        return rule;
    }

    public RegexFlags getFlags() {
        return flags;
    }

    public static String getConditionStr(int start, int stop){
        String str;

        if(start >= 32 && start <= 126) //all readable chars
            str = "" + (char)start;
        else{
            str = String.format("\\x%02X", start);
        }

        if(start != stop){
            str +=  "-" + ((stop >= 32 && stop <= 126)? "" +  (char)stop : String.format("\\x%02X", stop));
        }

        return str;
    }

    public ArrayList<String> getReferencesUsed() {
        return referencesUsed;
    }

    public static int parseCc_literal(String literal){
        if(literal.length() == 1) // 'a'
            return literal.charAt(0);
        else // '\x00'
            return Integer.parseInt(literal.substring(2, 4),16);

    }

    public static int[] parseCondition(String condition){
        //only supports hexa and characters
        int start = -1, stop = -1;

        String[] parts = condition.split("-");

        if(parts.length == 1)
            return new int[]{parseCc_literal(parts[0]), parseCc_literal(parts[0])};
        else
            return new int[]{parseCc_literal(parts[0]), parseCc_literal(parts[1])};
    }

    public void invertConditionNaming(Edge edge){
        simplifyConditions(edge);//guarantees order in the conditions
        ArrayList<String> newConditions = new ArrayList<>();
        int start = 0, stop;
        for (String condition : edge.conditions){
            int[] startStop = parseCondition(condition);
            if(startStop[0] > start){
                stop = startStop[0]-1;

                newConditions.add(getConditionStr(start, stop));
            }
            start = startStop[1]+1; //will never try to get values outside
        }
        if(start < 256){
            stop = 255;
            newConditions.add(getConditionStr(start, stop));
        }

        edge.negativeConditions = !edge.negativeConditions; //invert polarity
        edge.conditions = newConditions;
    }

    public void simplifyConditions(Edge edge){
        if(edge.conditions.size() == 0 || edge.conditions.size() == 1)
            return;

        TreeSet<String> set = new TreeSet<>(edge.conditions);

        edge.conditions.clear();

        String curr = null;
        int[] startStop;
        int currStart = -1, currStop = -1;

        for (String c : set){
            if (curr == null) {
                curr = c;
                startStop = parseCondition(curr);
                currStart = startStop[0];
                currStop  = startStop[1];
                continue;
            }

            startStop = parseCondition(c);
            int start = startStop[0], stop = startStop[1];
            if(start == currStop + 1){
                currStop = stop;
            }
            else {
                edge.conditions.add(getConditionStr(currStart, currStop));
                curr = c;
                currStart = start;
                currStop = stop;
            }
        }

        //close it
        edge.conditions.add(getConditionStr(currStart, currStop));
    }

    public void mergeVertexBInToA(Vertex a, Vertex b){
        removeVertex(copyVertexBinToA(a, b));
    }

    public Vertex copyVertexBinToA(Vertex a, Vertex b){
        //Vertex properties

        //only important for expr concatenation and alternatives
        //this combination works
        a.isTerminalVertex = a.isTerminalVertex && b.isTerminalVertex;

        //edge merging
        Set<Edge> outEdges = outgoingEdgesOf(b);
        for(Edge edge : outEdges){
            Vertex target = getEdgeTarget(edge);
            addEdge(a, target, new Edge(edge));
        }
        Set<Edge> inEdges = incomingEdgesOf(b);
        for(Edge edge : inEdges){
            Vertex target = getEdgeSource(edge);
            Edge existingEdge = null;
            for (Edge e : getAllEdges(target, a)){
                if(edge.conditions.equals(e.conditions) &&
                        edge.negativeConditions == e.negativeConditions &&
                        edge.loopInteractions.equals(e.loopInteractions)){
                    existingEdge = e;
                    break;
                }
            }

            if(existingEdge != null){
                existingEdge.captureGroups.addAll(edge.captureGroups);
                existingEdge.varInteractions.addAll(edge.varInteractions);
            }
            else {
                addEdge(target, a, new Edge(edge));
            }
        }

        return b;
    }

    public void mergeGraph(FAGraph g){
        for (Vertex v : g.vertexSet()){
            this.addVertex(v);
        }

        for (Edge e : g.edgeSet()){
            this.addEdge(g.getEdgeSource(e), g.getEdgeTarget(e), e);
        }

        this.mergeVertexBInToA(root, g.root);
    }
}
