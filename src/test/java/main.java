import CodeGenerator.CodeGenerator;
import CodeGenerator.Options.CodeGeneratorOptions;
import CodeGenerator.NewDecoder.Decoder;
import FABuilder.*;
import FABuilder.NewDisambiguator.NewDisambiguator;
import SnortParser.SnortParser;
import gen.PCREGrammarLexer;
import gen.PCREGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

public class main {
    public static ArrayList<FAGraph> createGraphs(String filename) throws IOException {
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


    public static void mergeAll(String[] args) throws IOException{
        ArrayList<FAGraph> graphs = createGraphs("src/main/resources/merge.txt");
        //ArrayList<FAGraph> graphs = createGraphs("src/main/resources/groupM.txt");
        //ArrayList<FAGraph> graphs = createGraphs("src/test/java/sandbox.txt");
        if(graphs.size() == 0)
            return;

        ArrayList<FAGraph> groupedFAs = new ArrayList<>();

        int i = 0;
        int groupSize = 1; //single size
        FAGraph groupGraph = null;
        for (FAGraph g : graphs){
            new NewDisambiguator(g);

            if(i % groupSize == 0){
                if (groupGraph != null)
                    groupedFAs.add(groupGraph);
                groupGraph = g;
                i = 0;
            }
            else{
                groupGraph.mergeGraph(g);
            }
            i++;
        }

        groupedFAs.add(groupGraph);

        //new NewDisambiguator(groupGraph);

        CodeGeneratorOptions options = new CodeGeneratorOptions("regexEngine");

        options.payloadSize = 8;
        options.ifElseORSwitch = true;
        options.createDecoder = true;
        options.softwareCompile = false;
        options.stateActionOptions.internalStateAction = true;
        options.decoderOptions.functionDecoder = true;
        options.decoderOptions.functionSwitchDecoder = true;
        options.decoderOptions.preDisambiguationDecoder = true;

        options.createDefaultTestbench = true;
        options.testbenchSettings.testbenchStringSize = 64;
        options.testbenchSettings.testString = "REST 1\n";
        options.testbenchSettings.fitToSize = true;


        new CodeGenerator(groupedFAs, options);

    }

    public static void decoderTest(String[] args) throws IOException{
        CodeGeneratorOptions options = new CodeGeneratorOptions("groupvssingle");

        options.payloadSize = 32;
        options.ifElseORSwitch = true;
        options.createDecoder = true;
        options.softwareCompile = false;

        options.createDefaultTestbench = true;
        options.testbenchSettings.testString = "pm_path=https";
        options.testbenchSettings.fitToSize = false;

        ArrayList<FAGraph> graphs = createGraphs("//C:/Users/Asus/IdeaProjects/PCREtoFAtoC/src/test/java/sandbox.txt");
        if(graphs.size() == 0)
            return;

        new DOTFAExporter(graphs.get(0), "debug.dot");

        options.decoderOptions.functionDecoder = true;
        options.decoderOptions.functionSwitchDecoder = true;
        options.decoderOptions.preDisambiguationDecoder = true;
        Decoder dec = new Decoder(graphs.get(0), options, 0);

        System.out.println("Pre decoder");
        System.out.println(dec.exportImplementation());
        System.out.println("[ace]: \t" + dec.getDecoding(new ArrayList<>(Arrays.asList("a", "c", "e"))));
        System.out.println("[a-d]: \t" + dec.getDecoding(new ArrayList<>(Collections.singletonList("a-d"))));
        System.out.println("[e]: \t" + dec.getDecoding(new ArrayList<>(Collections.singletonList("e"))));
        System.out.println("[ac]: \t" + dec.getDecoding(new ArrayList<>(Arrays.asList("a", "c"))));
        System.out.println("[bd]: \t" + dec.getDecoding(new ArrayList<>(Arrays.asList("b", "d"))));

        for (FAGraph g : graphs){
            new NewDisambiguator(g);
        }

        new DOTFAExporter(graphs.get(0), "file.dot");

        System.out.println("\nPost decoder");
        options.decoderOptions.functionDecoder = true;
        options.decoderOptions.functionSwitchDecoder = false;
        options.decoderOptions.preDisambiguationDecoder = false;
        Decoder dec2 = new Decoder(graphs.get(0), options, 0);

        System.out.println(dec2.exportImplementation());
        System.out.println("[ace]: \t" + dec2.getDecoding(new ArrayList<>(Arrays.asList("a", "c", "e"))));
        System.out.println("[a-d]: \t" + dec2.getDecoding(new ArrayList<>(Collections.singletonList("a-d"))));
        System.out.println("[e]: \t" + dec2.getDecoding(new ArrayList<>(Collections.singletonList("e"))));
        System.out.println("[ac]: \t" + dec2.getDecoding(new ArrayList<>(Arrays.asList("a", "c"))));
        System.out.println("[bd]: \t" + dec2.getDecoding(new ArrayList<>(Arrays.asList("b", "d"))));


        //new CodeGenerator(graphs, options);

        //TODO fix current
        //positives should be added for
        String str = """
                Pre decoder
                static const ap_uint<3> rule0Decoder[256]{
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 6, 4, 6, 4, 2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s

                }


                [bd]: 	[[2], [1]]
                [ac]: 	[[1, 2], []]
                [e]: 	[[1], [2]]
                [a-d]: 	[[2], []]
                [ace]: 	[[1], []]

                Post decoder
                static const ap_uint<4> rule0Decoder[256]{
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 2, 1, 2, 1, 4, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 8, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s
                	0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,\s

                }


                [bd]: 	[[0], []]
                [ac]: 	[[1], []]
                [e]: 	[[2], []]
                [a-d]: 	[[], []] //needs to be [[1, 2],[]]
                [ace]: 	[[], []] //needs to be [[2, 4], []]
                """;

    }

    public static void regularGen(String[] args) throws IOException {
        ArrayList<FAGraph> graphs = createGraphs("src/test/java/sandbox.txt");
        if(graphs.size() == 0)
            return;

        new DOTFAExporter(graphs.get(0), "file.dot");

        CodeGeneratorOptions options = new CodeGeneratorOptions("regex");
        options.payloadSize = 8;
        options.stateActionOptions.internalStateAction = true;
        options.ifElseORSwitch = true;
        options.createDecoder = true;
        options.softwareCompile = false;
        options.decoderOptions.functionDecoder = true;
        options.decoderOptions.functionSwitchDecoder = true;
        options.decoderOptions.preDisambiguationDecoder = false;

        options.createDefaultTestbench = true;
        options.testbenchSettings.testbenchStringSize = 64;
        options.testbenchSettings.testString = "REST 1\n";
        options.testbenchSettings.fitToSize = true;

        //Hardware version
        new CodeGenerator(graphs, options);
        options.filename = "regexSOFT";
        options.createDecoder = false;
        options.softwareCompile = true;

        //Software version
        //new CodeGenerator(graphs, options);
    }

    public static void parseSnortRules(String[] args) throws IOException {
        new SnortParser("src/main/resources/snort3-community.rules", "newSnortRuleset.txt");
    }

    public static void main(String[] args) throws IOException {
        //parseSnortRules(args);
        //mergeAll(args);
        regularGen(args);
        //decoderTest(args);
    }


}
