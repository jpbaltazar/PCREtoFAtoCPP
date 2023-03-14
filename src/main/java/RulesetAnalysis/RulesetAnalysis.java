package RulesetAnalysis;

import gen.PCREGrammarLexer;
import gen.PCREGrammarParser;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;

public class RulesetAnalysis {
    static int globalFieldMax(Map<String, Integer> map, Integer globalField, String field){
        if(map.containsKey(field))
            return Math.max(globalField, map.get(field));
        else
            return globalField;
    }

    static int globalFieldMin(Map<String, Integer> map, Integer globalField, String field){
        if(map.containsKey(field))
            return Math.min(globalField, map.get(field));
        else
            return globalField;
    }

    static void globalFieldAverageCount(Map<String, Integer> map, Mean globalField, String field){
        if(map.containsKey(field)){
            globalField.add(map.get(field));
        }
    }

    static void globalFieldAverageAverage(Map<String, Mean> map, Mean globalField, String field){
        if(map.containsKey(field)){
            globalField.add(map.get(field).getMean());
        }
    }

    static int globalFieldContains(Map<String, Integer> map, Integer globalField, String field){
        if(map.containsKey(field)){
            globalField++;
        }
        return globalField;
    }




    public static void main(String[] args) throws IOException {
        //FileInputStream in = new FileInputStream("src/main/resources/snortRuleset.txt");
        //FileInputStream in = new FileInputStream("newSnortRuleset.txt");
        //FileInputStream in = new FileInputStream("src/main/resources/reducedNew.txt");
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

        //General
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

        //Quantifiers
        int containQuantifier = 0;
        Mean averageQuantifierCount = new Mean();
        int maxQuantifiers = 0;

        int containIfOneQuantifier = 0;
        int containAtLeastOneQuantifier = 0;
        int containAnyQuantifier = 0; // "*" quantifier not any quantifier

        //      Range quantifiers
        int containRangeQuantifier = 0;
        Mean averageRangeQuantifierCount = new Mean();
        int maxQuantifierCount = 0;

        int containBoundRangeCount = 0;
        int maxBoundRangeQuantifierCount = 0;
        int maxRangeNonInfBoundDif = 0;
        int minRangeMax = 0; //{[2], 3}
        int minRangeMin = Integer.MAX_VALUE;
        Mean minRangeAverage = new Mean();
        int maxRangeMax = 0; //{2, [3]}
        int maxRangeMin = Integer.MAX_VALUE;
        Mean maxRangeAverage = new Mean();

        int containUnboundRangeCount = 0;

        int containExactRangeCount = 0;
        int minExactRange = Integer.MAX_VALUE;
        int maxExactRange = 0;
        Mean averageExactRange = new Mean();

        //      Quantifier types
        int containsPossessiveQuantifier = 0;// "+" quantifier type
        int containsLazyQuantifier = 0;// "?" quantifier type
        int containsGreedyQuantifier = 0; // "" quantifier type

        //Character Class
        int containsCharacterClass = 0;

        //Capture Count
        int containsCapture = 0;
        int maxCaptureCount = 0;

        int containsUnnamedGroups = 0;
        int containsNamedGroups = 0;

        //Backreferences
        int containsBackreferences = 0;
        int maxBackreferencesCount = 0;

        int containsAbsoluteReferences = 0;
        int containsRelativeReferences = 0;

        //LookAround
        int containsLookAround = 0;

        int containsLookAhead = 0;
        int containsPositiveLookAhead = 0;
        int containsNegativeLookAhead = 0;

        int containsLookBehind = 0;
        int containsPositiveLookBehind = 0;
        int containsNegativeLookBehind = 0;

        //subroutine
        int containsSubroutineReference = 0;

        ///////////////////////////////////////
        ///////////////Analysis////////////////
        ///////////////////////////////////////

        for (RuleFields m : analyser.rulesetFields){
            //General
            maxExprInAlternation = globalFieldMax(m.integerFields,
                    maxExprInAlternation,
                    "maxExprInAlternation");
            maxExprCount = globalFieldMax(m.integerFields,
                    maxExprCount,
                    "exprCount");
            maxElementInExpr = globalFieldMax(m.getIntegerFields(),
                    maxElementInExpr,
                    "maxElementInExpr");

            containStartOfString = globalFieldContains(m.getIntegerFields(),
                    containStartOfString,
                    "startOfString");

            containIgnoreCase = globalFieldContains(m.getIntegerFields(),
                    containIgnoreCase,
                    "ignoreCase");
            containMultiline = globalFieldContains(m.getIntegerFields(),
                    containMultiline,
                    "multiline");
            contains_s_Flag = globalFieldContains(m.getIntegerFields(),
                    contains_s_Flag,
                    "s_flag");
            containsAFlag = globalFieldContains(m.getIntegerFields(),
                    containsAFlag,
                    "A_flag");
            containsEFlag = globalFieldContains(m.getIntegerFields(),
                    containsEFlag,
                    "E_flag");
            containsGFlag = globalFieldContains(m.getIntegerFields(),
                    containsGFlag,
                    "G_flag");
            containsRFlag = globalFieldContains(m.getIntegerFields(),
                    containsRFlag,
                    "Relative_flag");


            //Quantifiers
            containQuantifier = globalFieldContains(m.getIntegerFields(),
                    containQuantifier,
                    "Quantifier Count");
            maxQuantifiers = globalFieldMax(m.getIntegerFields(),
                    maxQuantifiers,
                    "Quantifier Count");
            globalFieldAverageCount(m.getIntegerFields(),
                    averageQuantifierCount,
                    "Quantifier Count");

            containIfOneQuantifier = globalFieldContains(m.getIntegerFields(),
                    containIfOneQuantifier,
                    "ifOneQuantifier Count");
            containAtLeastOneQuantifier = globalFieldContains(m.getIntegerFields(),
                    containAtLeastOneQuantifier,
                    "atLeastOneQuantifier Count");
            containAnyQuantifier = globalFieldContains(m.getIntegerFields(),
                    containAnyQuantifier,
                    "anyQuantifier Count");

            //      Range Quantifiers
            containRangeQuantifier = globalFieldContains(m.getIntegerFields(),
                    containRangeQuantifier,
                    "rangeQuantifier Count");
            globalFieldAverageCount(m.getIntegerFields(),
                    averageRangeQuantifierCount,
                    "rangeQuantifier Count");
            maxQuantifierCount = globalFieldMax(m.getIntegerFields(),
                    maxQuantifierCount,
                    "rangeQuantifier Count");

            containBoundRangeCount = globalFieldContains(m.getIntegerFields(),
                    containBoundRangeCount,
                    "boundRangeQuantifier Count");
            maxBoundRangeQuantifierCount = globalFieldMax(m.getIntegerFields(),
                    maxBoundRangeQuantifierCount,
                    "boundRangeQuantifier Count");
            maxRangeNonInfBoundDif = globalFieldMax(m.getIntegerFields(),
                    maxRangeNonInfBoundDif,
                    "RangeNonInfBoundDif Max");
            minRangeMax = globalFieldMax(m.getIntegerFields(),
                    minRangeMax,
                    "minRange Max");
            minRangeMin = globalFieldMin(m.getIntegerFields(),
                    minRangeMin,
                    "minRange Min");
            globalFieldAverageAverage(m.getMeanFields(),
                    minRangeAverage,
                    "minRange Average");
            maxRangeMax = globalFieldMax(m.getIntegerFields(),
                    maxRangeMax,
                    "maxRange Max");
            maxRangeMin = globalFieldMin(m.getIntegerFields(),
                    maxRangeMin,
                    "maxRange Min");
            globalFieldAverageAverage(m.getMeanFields(),
                    maxRangeAverage,
                    "maxRange Average");

            containUnboundRangeCount = globalFieldContains(m.getIntegerFields(),
                    containUnboundRangeCount,
                    "UnboundRange Count");

            containExactRangeCount = globalFieldContains(m.getIntegerFields(),
                    containExactRangeCount,
                    "exactRange Count");
            minExactRange = globalFieldMin(m.getIntegerFields(),
                    minExactRange,
                    "exactRange Min");
            maxExactRange = globalFieldMax(m.getIntegerFields(),
                    maxExactRange,
                    "exactRange Max");
            globalFieldAverageAverage(m.getMeanFields(),
                    averageExactRange,
                    "exactRange Average");
            //TODO fix (min 1, max 4, average 102.509???)

            //      Quantifier Types
            containsPossessiveQuantifier = globalFieldContains(m.getIntegerFields(),
                    containsPossessiveQuantifier,
                    "possessiveQuantifierType Count");
            containsLazyQuantifier = globalFieldContains(m.getIntegerFields(),
                    containsLazyQuantifier,
                    "lazyQuantifierType Count");
            containsGreedyQuantifier = globalFieldContains(m.getIntegerFields(),
                    containsGreedyQuantifier,
                    "greedyQuantifierType Count");

            //Character Class
            containsCharacterClass = globalFieldContains(m.getIntegerFields(),
                    containsCharacterClass,
                    "characterClass Count");

            //Capture Count
            containsCapture = globalFieldContains(m.getIntegerFields(),
                    containsCapture,
                    "capture Count");
            maxCaptureCount = globalFieldMax(m.getIntegerFields(),
                    maxCaptureCount,
                    "capture Count");

            containsUnnamedGroups = globalFieldContains(m.getIntegerFields(),
                    containsUnnamedGroups,
                    "unnamedGroup Count");
            containsNamedGroups = globalFieldContains(m.getIntegerFields(),
                    containsNamedGroups,
                    "namedGroup Count");

            //Backreferences
            containsBackreferences = globalFieldContains(m.getIntegerFields(),
                    containsBackreferences,
                    "backreference Count");
            maxBackreferencesCount = globalFieldMax(m.getIntegerFields(),
                    maxBackreferencesCount,
                    "backreference Count");
            containsAbsoluteReferences = globalFieldContains(m.getIntegerFields(),
                    containsAbsoluteReferences,
                    "absoluteReferences Count");
            containsRelativeReferences = globalFieldContains(m.getIntegerFields(),
                    containsRelativeReferences,
                    "relativeReferences Count");

            //LookAround
            containsLookAround = globalFieldContains(m.getIntegerFields(),
                    containsLookAround,
                    "lookAround Count");

            containsLookAhead = globalFieldContains(m.getIntegerFields(),
                    containsLookAhead,
                    "lookAhead Count");
            containsPositiveLookAhead = globalFieldContains(m.getIntegerFields(),
                    containsPositiveLookAhead,
                    "positiveLookAhead Count");
            containsNegativeLookAhead = globalFieldContains(m.getIntegerFields(),
                    containsNegativeLookAhead,
                    "negativeLookAhead Count");

            containsLookBehind = globalFieldContains(m.getIntegerFields(),
                    containsLookBehind,
                    "LookBehind Count");
            containsPositiveLookBehind = globalFieldContains(m.getIntegerFields(),
                    containsPositiveLookBehind,
                    "positiveLookBehind Count");
            containsNegativeLookBehind = globalFieldContains(m.getIntegerFields(),
                    containsNegativeLookBehind,
                    "negativeLookBehind Count");

            containsSubroutineReference = globalFieldContains(m.getIntegerFields(),
                    containsSubroutineReference,
                    "subroutineReference Count");

        }


        ///////////////////////////////////////
        ///////////////Printing////////////////
        ///////////////////////////////////////

        //General
        System.out.println("General");
        System.out.println("\tmaxExprInAlternation: " + maxExprInAlternation);
        System.out.println("\tmaxExprCount: " + maxExprCount);
        System.out.println("\tmaxElementInExpr: " + maxElementInExpr);
        System.out.println("\tstartOfString: " + containStartOfString + " " + 100 * containStartOfString/ (float)analyser.ruleCount);
        System.out.println("\n\tignoreCase: " + containIgnoreCase + " " + 100 * containIgnoreCase/ (float)analyser.ruleCount);
        System.out.println("\tmultiline: " + containMultiline + " " + 100 * containMultiline/ (float)analyser.ruleCount);
        System.out.println("\tsFlag: " + contains_s_Flag + " " + 100 * contains_s_Flag/ (float)analyser.ruleCount);
        System.out.println("\tA flag: " + containsAFlag + " " + 100 * containsAFlag/ (float)analyser.ruleCount);
        System.out.println("\tE flag: " + containsEFlag + " " + 100 * containsEFlag/ (float)analyser.ruleCount);
        System.out.println("\tG flag: " + containsGFlag + " " + 100 * containsGFlag/ (float)analyser.ruleCount);
        System.out.println("\tRelative flag: " + containsRFlag + " " + 100 * containsRFlag/ (float)analyser.ruleCount);

        System.out.println();
        //Quantifiers
        System.out.println("Quantifiers");
        System.out.println("\tcontainQuantifier: " + containQuantifier);
        System.out.println("\taverageQuantifiers: " + averageQuantifierCount);
        System.out.println("\tmaxQuantifiers: " + maxQuantifiers);
        System.out.println();

        System.out.println("\tcontainIfOneQuantifier: " + containIfOneQuantifier);
        System.out.println("\tcontainAtLeastOneQuantifier: " + containAtLeastOneQuantifier);
        System.out.println("\tcontainAnyQuantifier: " + containAnyQuantifier);
        System.out.println();

        //      Range quantifiers
        System.out.println("\tRange quantifiers");
        System.out.println("\t\tcontainRangeQuantifier: " + containRangeQuantifier);
        System.out.println("\t\taverageRangeQuantifierCount: " + averageRangeQuantifierCount);
        System.out.println("\t\tmaxQuantifierCount: " + maxQuantifierCount);
        System.out.println();

        System.out.println("\t\tcontainBoundRangeCount: " + containBoundRangeCount);
        System.out.println("\t\tmaxBoundRangeQuantifierCount: " + maxBoundRangeQuantifierCount);
        System.out.println("\t\tmaxRangeNonInfBoundDif: " + maxRangeNonInfBoundDif);
        System.out.println("\t\tminRangeMax: " + minRangeMax);
        System.out.println("\t\tminRangeMin: " + minRangeMin);
        System.out.println("\t\tminRangeAverage: " + minRangeAverage);
        System.out.println("\t\tmaxRangeMax: " + maxRangeMax);
        System.out.println("\t\tmaxRangeMin: " + maxRangeMin);
        System.out.println("\t\tmaxRangeAverage: " + maxRangeAverage);
        System.out.println();

        System.out.println("\t\tcontainUnboundRangeCount: " + containUnboundRangeCount);
        System.out.println();

        System.out.println("\t\tcontainExactRangeCount: " + containExactRangeCount);
        System.out.println("\t\tminExactRange: " + minExactRange);
        System.out.println("\t\tmaxExactRange: " + maxExactRange);
        System.out.println("\t\taverageExactRange: " + averageExactRange);
        System.out.println();
        //         Quantifier Types
        System.out.println("\tQuantifier Types");
        System.out.println("\t\tcontainsPossessiveQuantifier: " + containsPossessiveQuantifier);
        System.out.println("\t\tcontainsLazyQuantifier: " + containsLazyQuantifier);
        System.out.println("\t\tcontainsGreedyQuantifier: " + containsGreedyQuantifier);
        System.out.println();
        //CharacterClass
        System.out.println("Character Class");
        System.out.println("\tcontainsCharacterClass: " + containsCharacterClass);
        System.out.println();
        //Capture Count
        System.out.println("Capture Count");
        System.out.println("\tcontainsCapture: " + containsCapture);
        System.out.println("\tmaxCaptureCount: " + maxCaptureCount);
        System.out.println("\tcontainsUnnamedGroup: " + containsUnnamedGroups);
        System.out.println("\tcontainsNamedGroup: " + containsNamedGroups);
        System.out.println();
        //Backreferences
        System.out.println("Backreferences");
        System.out.println("\tcontainsBackreferences: " + containsBackreferences);
        System.out.println("\tmaxBackreferencesCount: " + maxBackreferencesCount);
        System.out.println("\tcontainsAbsoluteReferences: " + containsAbsoluteReferences);
        System.out.println("\tcontainsRelativeReferences: " + containsRelativeReferences);
        System.out.println();
        //LookAround
        System.out.println("LookAround");
        System.out.println("\tcontainsLookAround: " + containsLookAround);
        System.out.println();
        System.out.println("\tLookAhead");
        System.out.println("\t\tcontainsLookAhead: " + containsLookAhead);
        System.out.println("\t\tcontainsPositiveLookAhead: " + containsPositiveLookAhead);
        System.out.println("\t\tcontainsNegativeLookAhead: " + containsNegativeLookAhead);
        System.out.println("\tLookBehind");
        System.out.println("\t\tcontainsLookBehind: " + containsLookBehind);
        System.out.println("\t\tcontainsPositiveLookBehind: " + containsPositiveLookBehind);
        System.out.println("\t\tcontainsNegativeLookBehind: " + containsNegativeLookBehind);

    }
}
