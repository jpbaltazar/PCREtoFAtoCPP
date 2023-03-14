import FABuilder.Edge;
import FABuilder.FABuilder;
import FABuilder.FAGraph;
import FABuilder.Vertex;
import com.mxgraph.layout.hierarchical.mxHierarchicalLayout;
import com.mxgraph.layout.mxCompactTreeLayout;
import com.mxgraph.layout.mxIGraphLayout;
import com.mxgraph.swing.mxGraphComponent;
import gen.PCREGrammarLexer;
import gen.PCREGrammarParser;
import junit.framework.TestCase;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.jgrapht.Graph;
import org.jgrapht.ext.JGraphXAdapter;

import javax.swing.*;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class FABuilderTests extends TestCase {
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

    public static void visualize(FAGraph faGraph, boolean horizontal){
        JFrame frame = new JFrame("Graph");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //MyAdapter<FABuilder.Vertex, FABuilder.Edge> adapter = new MyAdapter<>(g); //horrible, horrible hack
        JGraphXAdapter<Vertex, Edge> adapter = new JGraphXAdapter<>(faGraph); //horrible, horrible hack
        adapter.setAutoSizeCells(true);

        mxIGraphLayout layout;
        if(horizontal)
            layout = new mxCompactTreeLayout(adapter); //not perfect
        else
            layout = new mxHierarchicalLayout(adapter);

        layout.execute(adapter.getDefaultParent());

        frame.add(new mxGraphComponent(adapter));

        frame.pack();
        frame.setLocationByPlatform(true);
        frame.setVisible(true);
    }

    public void testSingleExpr() throws IOException {
        FAGraph faGraph = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/resources/FABuilderTests/singleExpr.txt").get(0);

        assertEquals(2, faGraph.vertexSet().size());
        assertEquals(1, faGraph.edgeSet().size());

        assertEquals(new ArrayList<>(Collections.singletonList("a")), ((Edge)faGraph.edgeSet().toArray()[0]).conditions);

        assertEquals("a", faGraph.getRule());
        //assertEquals("directive", faGraph.getDirectives());
    }

    public void testMultipleRules() throws IOException {
        ArrayList<FAGraph> graphs = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/resources/FABuilderTests/multipleRules.txt");

        assertEquals(2, graphs.size());

        assertEquals("a", graphs.get(0).getRule());
        //assertEquals("one", graphs.get(0).getDirectives());

        assertEquals("b", graphs.get(1).getRule());
        //assertEquals("two", graphs.get(1).getDirectives());
    }

    public void testAlternation() throws IOException{
        FAGraph graph = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/resources/FABuilderTests/alternation.txt").get(0);

        visualize(graph, false);
    }

    public void testCaptureGroups() throws IOException{
        FAGraph graph = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/resources/FABuilderTests/captureGroup.txt").get(0);

        assertEquals(3, graph.vertexSet().size());
        assertEquals(2, graph.edgeSet().size());

        Edge a = null;
        Edge b = null;
        for (Edge e : graph.edgeSet()){
            if(e.conditions.size() == 1 && e.conditions.get(0).equals("a")){
                assertNull(a);
                a = e;
            }
            else if(e.conditions.size() == 1 && e.conditions.get(0).equals("b")){
                assertNull(b);
                b = e;
            }
        }

        assertNotNull(a);
        assertTrue(a.captureGroups.contains("1"));
        assertTrue(a.captureGroups.contains("2"));

        assertNotNull(b);
        assertTrue(b.captureGroups.contains("1"));
        assertFalse(b.captureGroups.contains("2"));
    }

    public void testBackRefTest() throws IOException{
        FAGraph graph = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/resources/FABuilderTests/backref.txt").get(0);

        assertEquals(2, graph.vertexSet().size());
        assertEquals(1, graph.edgeSet().size());

        Edge backRef = (Edge) graph.edgeSet().toArray()[0];

        assertEquals(1, backRef.conditions.size());
        assertEquals("1", backRef.conditions.get(0)); //ref to 1
    }

    public void testCharacterClass() throws IOException {
        FAGraph graph = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/resources/FABuilderTests/cctest.txt").get(0);
        Edge e = (Edge) graph.edgeSet().toArray()[0];

        ArrayList<String> expectedConditions = new ArrayList<>(Arrays.asList("a-z", "B-D", "b"));
        assertEquals(expectedConditions, e.conditions);
        assertTrue(e.negativeConditions);
    }

    /*public void testRangeQuantifier() throws IOException {

        FAGraph graph = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/resources/FABuilderTests/loopTests/test1.txt").get(0);
        // ab{3}c

        assertEquals(5, graph.vertexSet().size());
        assertEquals(5, graph.edgeSet().size());

        Edge exitLoopEdge = null;
        Edge iterationLoopEdge = null;

        Edge errorEdge = null;

        for (Edge e : graph.edgeSet()){
            if(e.loopInstances.size() == 1){
                if (e.loopInstances.get(0).isIterationAndNotExit)
                    iterationLoopEdge = e;
                else if(!e.loopInstances.get(0).isIterationAndNotExit)
                    exitLoopEdge = e;
                else
                    errorEdge = e;
            }
        }

        assertNotNull(exitLoopEdge);
        assertNotNull(iterationLoopEdge);
        assertNull(errorEdge);
        //TODO finish this
        //and test toDFA conversion too

        assertEquals(Collections.singletonList("b"), exitLoopEdge.conditions);
        assertEquals(Collections.singletonList("b"), iterationLoopEdge.conditions);

    }*/
}
