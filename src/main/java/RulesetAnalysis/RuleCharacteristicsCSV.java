package RulesetAnalysis;

import gen.PCREGrammarLexer;
import gen.PCREGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.*;
import java.util.ArrayList;
import java.util.Map;

public class RuleCharacteristicsCSV {

    public static void main(String[] args) throws IOException {
        ArrayList<Double> timings = new ArrayList<>();
        BufferedReader bufferedReader = new BufferedReader(new FileReader("src/main/resources/estimatedTimingGroupM.txt"));

        ArrayList<String> lines = new ArrayList<>();
        while (true){
            String line = bufferedReader.readLine();
            if(line == null)
                break;

            lines.add(line);
        }

        for (String line : lines){
            timings.add(Double.parseDouble(line));
        }

        FileInputStream in = new FileInputStream("src/main/resources/groupM.txt");
        PCREGrammarLexer lexer = new PCREGrammarLexer(CharStreams.fromStream(in));

        CommonTokenStream tokens = new CommonTokenStream(lexer);
        PCREGrammarParser parser = new PCREGrammarParser(tokens);
        ParseTree tree = parser.parse();

        ParseTreeWalker parseTreeWalker = new ParseTreeWalker();
        RulesetAnalyserListener analyser = new RulesetAnalyserListener();
        parseTreeWalker.walk(analyser, tree);


        ///////////////////////////////////////
        /////////////Definitions///////////////
        ///////////////////////////////////////
        System.out.println("From " + analyser.ruleCount + " rules:");
        System.out.println("//////////////////////");

        FileOutputStream out = new FileOutputStream("ruleProps.csv");
        BufferedWriter writer = new BufferedWriter(new FileWriter("ruleProps.csv", true));
        writer.write("ruleID,maxExprInAlternation,maxExprCount,maxElementInExpr,containStartOfString,containIgnoreCase,containMultiline,contains_s_Flag,containsAFlag,containsEFlag,containsGFlag,containsRFlag,Quantifier Count,? quantifiers, + quantifiers, * quantifiers,Range Quantifiers,Bound Quantifiers {x/y}, Unbound Quantifiers {x/}, Exact Quantifiers {x/x}, character class Count,Real timing\n");

        int i = 0;


        for (RuleFields m : analyser.rulesetFields){
            int maxExprInAlternation = 0;
            int maxExprCount = 0;
            int maxElementInExpr = 0;
            int containStartOfString = 0;

            //Flags
            int containIgnoreCase = 0;
            int containMultiline = 0;
            int contains_s_Flag = 0;
            int containsAFlag = 0;
            int containsEFlag = 0;
            int containsGFlag = 0;
            int containsRFlag = 0;


            int quantifierCount = 0;

            int containIfOneQuantifier = 0;
            int containAtLeastOneQuantifier = 0;
            int containAnyQuantifier = 0; // "*" quantifier not any quantifier

            int containRangeQuantifier = 0;

            int containBoundRangeCount = 0;
            int containExactRangeCount = 0;
            int containUnboundRangeCount = 0;

            int containsCharacterClass = 0;
            //General
            maxExprInAlternation = m.integerFields.getOrDefault("maxExprInAlternation", 0);
            maxExprCount = m.integerFields.getOrDefault("exprCount", 0);
            maxElementInExpr = m.integerFields.getOrDefault("maxElementInExpr", 0);
            containStartOfString = m.integerFields.getOrDefault("startOfString", 0);
            containIgnoreCase = m.integerFields.getOrDefault("ignoreCase", 0);
            containMultiline = m.integerFields.getOrDefault("multiline", 0);
            contains_s_Flag = m.integerFields.getOrDefault("s_flag", 0);
            containsAFlag = m.integerFields.getOrDefault("A_flag", 0);
            containsEFlag = m.integerFields.getOrDefault("E_flag", 0);
            containsGFlag = m.integerFields.getOrDefault("G_flag", 0);
            containsRFlag = m.integerFields.getOrDefault("Relative_flag", 0);
            quantifierCount = m.integerFields.getOrDefault("Quantifier Count", 0);

            containIfOneQuantifier = m.integerFields.getOrDefault("ifOneQuantifier Count", 0);
            containAtLeastOneQuantifier = m.integerFields.getOrDefault("atLeastOneQuantifier Count", 0);
            containAnyQuantifier = m.integerFields.getOrDefault("anyQuantifier Count", 0);

            containRangeQuantifier = m.integerFields.getOrDefault("rangeQuantifier Count", 0);

            containBoundRangeCount = m.integerFields.getOrDefault("boundRangeQuantifier Count", 0);
            containUnboundRangeCount = m.integerFields.getOrDefault("UnboundRange Count", 0);
            containExactRangeCount = m.integerFields.getOrDefault("exactRange Count", 0);

            containsCharacterClass = m.integerFields.getOrDefault("characterClass Count", 0);

            writer.write(i+",");
            writer.write(maxExprInAlternation + ",");
            writer.write(maxExprCount + ",");
            writer.write(maxElementInExpr + ",");
            writer.write(containStartOfString + ",");
            writer.write(containIgnoreCase + ",");
            writer.write(containMultiline + ",");
            writer.write(contains_s_Flag + ",");
            writer.write(containsAFlag + ",");
            writer.write(containsEFlag + ",");
            writer.write(containsGFlag + ",");
            writer.write(containsRFlag + ",");
            writer.write(quantifierCount + ",");
            writer.write(containAnyQuantifier + ",");
            writer.write(containAtLeastOneQuantifier + ",");
            writer.write(containIfOneQuantifier + ",");
            writer.write(containRangeQuantifier + ",");
            writer.write(containBoundRangeCount + ",");
            writer.write(containUnboundRangeCount + ",");
            writer.write(containExactRangeCount + ",");
            writer.write(containsCharacterClass + ",");
            writer.write(timings.get(i).toString());
            writer.write("\n");

            i++;
        }
        writer.close();
    }
}
