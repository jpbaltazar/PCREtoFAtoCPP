package FABuilder;

public class Vertex {
    public boolean isTerminalVertex = false;
    boolean isEndOfSubject = false;

    public Vertex(){
    }

    public Vertex(Vertex v){
        this.isTerminalVertex = v.isTerminalVertex;
        this.isEndOfSubject = v.isEndOfSubject;
    }

    @Override
    public String toString() {
        String representation = "";
        if (isTerminalVertex){
            representation += "<T>";
        }
        else
            representation += " ";//this.hashCode();

        return representation;
    }
}
