package FABuilder;

import java.io.FileWriter;
import java.io.IOException;

public class DOTFAExporter {
    public DOTFAExporter(FAGraph graph, String filename) throws IOException {
        FileWriter fileWriter = new FileWriter(filename);

        fileWriter.write("digraph G {\n");

        int i = 1;
        for (Vertex v : graph.vertexSet()){
            fileWriter.write("\t" + v.hashCode() + "[ ");

            if(graph.getRoot() == v){ //start vertex
                fileWriter.write("label=\"start\"");
            }
            else {
                fileWriter.write("label=\"" + i + "\"");
                i++;
            }

            if(v.isTerminalVertex){
                fileWriter.write(", peripheries=2 ");
            }

            fileWriter.write("];\n");
        }

        for (Edge e : graph.edgeSet()){
            fileWriter.write("\t"
                    + graph.getEdgeSource(e).hashCode()
                    + " -> "
                    + graph.getEdgeTarget(e).hashCode()
                    + " [ label=\"" + e.toString() + "\" ];\n"
            );
        }

        fileWriter.write("}\n");
        fileWriter.close();
    }

}
