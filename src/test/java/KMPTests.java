import FABuilder.FABuilder;
import FABuilder.FAGraph;
import FABuilder.KMP.KMP;
import FABuilder.NewDisambiguator.NewDisambiguator;
import FABuilder.Vertex;
import FABuilder.Edge;
import FABuilder.DOTFAExporter;
import gen.PCREGrammarLexer;
import gen.PCREGrammarParser;
import junit.framework.TestCase;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

public class KMPTests extends TestCase {
    public ArrayList<FAGraph> createGraphs(String filename) throws IOException {
        FileInputStream in = new FileInputStream(filename);
        PCREGrammarLexer lexer = new PCREGrammarLexer(CharStreams.fromStream(in));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PCREGrammarParser parser = new PCREGrammarParser(tokens);
        ParseTree tree = parser.parse();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        FABuilder faBuilder = new FABuilder();
        parseTreeWalker.walk(faBuilder, tree);

        return faBuilder.getFaGraphs();
    }

    public void testKMPBasic() throws IOException, NonDeterminismException {
        ArrayList<FAGraph> graphs = createGraphs("src/test/resources/KMPTests/basicTest.txt");
        // /^abac/
        FAGraph graph = graphs.get(0);

        new DOTFAExporter(graph, "beforeKMP.dot");

        //new KMP(graph);
        //new NewDisambiguator(graph);
        new DOTFAExporter(graph, "afterKMP.dot");

        FATester tester = new FATester(graph);
        ArrayList<Integer> expectedMatches = new ArrayList<>();
        expectedMatches.add(5);

        try {
            assertTrue(tester.TestInput("ababac", expectedMatches));
        }
        catch (NonDeterminismException e){
            System.out.println(e.getMessage());
            System.out.println("Bad graph.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void testKMPPartialPrefix() throws IOException {
        ArrayList<FAGraph> graphs = createGraphs("src/test/resources/KMPTests/partialPrefix.txt");
        // /^abac/
        FAGraph graph = graphs.get(0);

        for(Vertex v : graph.vertexSet()){
            if(v == graph.getErrorVertex()) {
                graph.removeVertex(v);
                break;
            }
        }

        new DOTFAExporter(graph, "beforeKMP.dot");

        new KMP(graph);
        new NewDisambiguator(graph);
        new DOTFAExporter(graph, "afterKMP.dot");

        FATester tester = new FATester(graph);
        ArrayList<Integer> expectedMatches = new ArrayList<>();
        expectedMatches.add(5);

        try {
            assertTrue(tester.TestInput("a@a@b?", expectedMatches));
        }
        catch (NonDeterminismException e){
            System.out.println(e.getMessage());
            System.out.println("Bad graph.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void testKMPPartialSuffix() throws IOException {
        ArrayList<FAGraph> graphs = createGraphs("src/test/resources/KMPTests/partialSuffix.txt");
        // /^abac/
        FAGraph graph = graphs.get(0);

        for(Vertex v : graph.vertexSet()){
            if(v == graph.getErrorVertex()) {
                graph.removeVertex(v);
                break;
            }
        }

        new DOTFAExporter(graph, "beforeKMP.dot");

        new KMP(graph);
        new NewDisambiguator(graph);
        new DOTFAExporter(graph, "afterKMP.dot");

        FATester tester = new FATester(graph);
        ArrayList<Integer> expectedMatches = new ArrayList<>();
        expectedMatches.add(8);

        try {
            assertTrue(tester.TestInput("a@a@b?", expectedMatches));
        }
        catch (NonDeterminismException e){
            System.out.println(e.getMessage());
            System.out.println("Bad graph.");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

    public void testContasAVida() throws IOException, NonDeterminismException {
        ArrayList<FAGraph> graphs = createGraphs("src/test/resources/KMPTests/basicTest.txt");
        // /^abac/
        FAGraph graph = graphs.get(0);

        for(Vertex v : graph.vertexSet()){
            if(v == graph.getErrorVertex()) {
                graph.removeVertex(v);
                break;
            }
        }


        new KMP(graph);
        new DOTFAExporter(graph, "beforeKMP.dot");

        new NewDisambiguator(graph);
        new DOTFAExporter(graph, "afterKMP.dot");

        graphs = createGraphs("src/test/resources/KMPTests/basicTest.txt");
        graph = graphs.get(0);


        Vertex root = graph.getRoot();
        for(Vertex v : graph.vertexSet()){
            if(v != root){
                for (Edge out : graph.outgoingEdgesOf(root)){
                    graph.addEdge(v, graph.getEdgeTarget(out), new Edge(out));
                }
            }
        }
        new DOTFAExporter(graph, "beforeNOKMP.dot");

        new NewDisambiguator(graph);

        new DOTFAExporter(graph, "afterNOKMP.dot");
    }
}
