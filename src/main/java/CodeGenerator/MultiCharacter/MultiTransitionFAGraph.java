package CodeGenerator.MultiCharacter;

import FABuilder.Vertex;
import org.jgrapht.graph.Pseudograph;

public class MultiTransitionFAGraph extends Pseudograph<Vertex, MultiEdge> {

    public MultiTransitionFAGraph() {
        super(MultiEdge.class);

    }
}
