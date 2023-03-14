package FABuilder;

public class QueuableSubGraph {
    public Vertex start;
    public Vertex stop;
    public Type type;
    public String context;

    public enum Type{
        alternation("alternation"),
        expr("expr"),
        atom("atom"),
        cc_atom("cc_atom"),
        literal("cc_literal"),
        SEPARATOR("SEPARATOR");

        Type(String representation){
            this.representation = representation;
        }
        String representation;
    }

    QueuableSubGraph(Vertex start, Vertex stop, Type type, String context){
        this.start = start;
        this.stop = stop;
        this.type = type;
        this.context = context;
    }

    @Override
    public String toString() {
        if(context.equals("")){
            return "\"" + start + "\"" +
                    " \"" + stop + "\" " +
                    type.representation;
        }
        return context;
    }
}
