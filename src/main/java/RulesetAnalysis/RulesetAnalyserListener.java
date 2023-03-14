package RulesetAnalysis;

import FABuilder.Edge;
import FABuilder.RegexFlags;
import gen.PCREGrammarBaseListener;
import gen.PCREGrammarParser;
import org.jgrapht.util.MathUtil;

import java.math.MathContext;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class RulesetAnalyserListener extends PCREGrammarBaseListener {
    ArrayList<RuleFields> rulesetFields;
    //ArrayList<Map<String, Integer>> rulesetFields;
    int ruleCount = 0;
    Map<String, Integer> integerFields;
    Map<String, Mean>  meanFields;

    RulesetAnalyserListener(){
        super();
        rulesetFields = new ArrayList<>();
    }


    void fieldIncrement(String field){
        if(!integerFields.containsKey(field)){
            integerFields.put(field, 1);
        }
        else{
            integerFields.put(field,
                    integerFields.get(field) + 1);
        }
    }

    void fieldMax(String field, int value){
        if(!integerFields.containsKey(field)){
            integerFields.put(field, value);
        }
        else{

            integerFields.put(field,
                    Math.max(value,
                            integerFields.get(field)));
        }
    }

    void fieldMin(String field, int value){
        if(!integerFields.containsKey(field)){
            integerFields.put(field, value);
        }
        else{

            integerFields.put(field,
                    Math.min(value,
                            integerFields.get(field)));
        }
    }

    void fieldMean(String field, int value){
        if(!meanFields.containsKey(field)){
            meanFields.put(field, new Mean(value));
        }
        else{
            meanFields.get(field).add(value);
        }
    }

    @Override
    public void enterSingleRule(PCREGrammarParser.SingleRuleContext ctx) {
        integerFields = new HashMap<>();
        meanFields = new HashMap<>();
        rulesetFields.add(new RuleFields(integerFields, meanFields));
        ruleCount++;

        if(ctx.Caret() != null)
            fieldIncrement("startOfString");

        if(ctx.directives() != null){
            RegexFlags flags = new RegexFlags(ctx.directives().getText());
            if(flags.i)
                fieldIncrement("ignoreCase");
            if(flags.m)
                fieldIncrement("multiline");
            if(flags.s)
                fieldIncrement("s_flag");
            if(flags.A)
                fieldIncrement("A_flag");
            if(flags.E)
                fieldIncrement("E_flag");
            if(flags.R)
                fieldIncrement("Relative_flag");
        }

    }

    @Override
    public void enterAlternation(PCREGrammarParser.AlternationContext ctx) {
        int exprNum = 1 + ctx.getChildCount()/2; //expr ('|' expr)*

        fieldMax("maxExprInAlternation", exprNum);
    }

    @Override
    public void enterExpr(PCREGrammarParser.ExprContext ctx) {
        fieldIncrement("exprCount");

        fieldMax("maxElementInExpr", ctx.getChildCount());
    }

    @Override
    public void enterDirectives(PCREGrammarParser.DirectivesContext ctx) {

    }

    @Override
    public void enterQuantifier(PCREGrammarParser.QuantifierContext ctx) {
        //get which types of quantifiers
        String modifier = ctx.getChild(0).getText();
        fieldIncrement("Quantifier Count");
        switch (modifier) {
            case "?" -> fieldIncrement("ifOneQuantifier Count");
            case "+" -> fieldIncrement("atLeastOneQuantifier Count");
            case "*" -> fieldIncrement("anyQuantifier Count");
            case "{" -> {
                fieldIncrement("rangeQuantifier Count");
                String[] rangeNumbers = ctx.getText().substring(1).split("}");
                boolean containsComma = rangeNumbers[0].contains(",");
                rangeNumbers = rangeNumbers[0].split(",");
                if(rangeNumbers.length == 2){
                    fieldIncrement("boundRangeQuantifier Count");
                    fieldMax("RangeNonInfBoundDif Max",
                            Integer.parseInt(rangeNumbers[1]) -
                                    Integer.parseInt(rangeNumbers[0]));

                    fieldMax("maxRange Max", Integer.parseInt(rangeNumbers[1]));
                    fieldMin("maxRange Min", Integer.parseInt(rangeNumbers[1]));
                    fieldMean("maxRange Average", Integer.parseInt(rangeNumbers[1]));
                }
                else{
                    if(containsComma){
                        fieldIncrement("UnboundRange Count");
                    }
                    else{
                        fieldIncrement("exactRange Count");
                        fieldMin("exactRange Min", Integer.parseInt(rangeNumbers[0]));
                        fieldMax("exactRange Max", Integer.parseInt(rangeNumbers[0]));
                        fieldMean("exactRange Average", Integer.parseInt(rangeNumbers[0]));
                    }
                }
                fieldMax("minRange Max", Integer.parseInt(rangeNumbers[0]));
                fieldMin("minRange Min", Integer.parseInt(rangeNumbers[0]));
                fieldMean("minRange Average", Integer.parseInt(rangeNumbers[0]));

            }
        }

    }

    @Override
    public void enterQuantifier_type(PCREGrammarParser.Quantifier_typeContext ctx) {
        switch (ctx.getText()){
            case "+" -> fieldIncrement("possessiveQuantifierType Count");
            case "?" -> fieldIncrement("lazyQuantifierType Count");
            default -> fieldIncrement("greedyQuantifierType Count");
        }
    }

    @Override
    public void enterCharacter_class(PCREGrammarParser.Character_classContext ctx) {
        fieldIncrement("characterClass Count");
        //TODO: this one [ranges]

        if(ctx.getText().split("\\^").length == 2){
            fieldIncrement("negativeCharacterClass Count");
        }
        else
            fieldIncrement("positiveCharacterClass Count");


    }

    @Override
    public void enterCapture(PCREGrammarParser.CaptureContext ctx) {
        fieldIncrement("capture Count");
        //TODO capture length

        int childCount = ctx.getChildCount();
        if(childCount == 3) //unnamed capture
            fieldIncrement("unnamedGroup Count");
        else
            fieldIncrement("namedGroup Count");
    }

    @Override
    public void enterBackreference(PCREGrammarParser.BackreferenceContext ctx) {
        fieldIncrement("backreference Count");
        //TODO more analysis, distance to called, size of reference, reference to what capture id
        int childCount = ctx.getChildCount();
        switch (childCount) {
            // other cases, e.g. '\\g' '{' number '}'
            case 1, 2, 4 -> fieldIncrement("absoluteReferences Count");
            // '\\g' '{' '-' number '}' //special case for relative references
            case 5 -> fieldIncrement("relativeReferences Count");
        }
    }

    @Override
    public void enterLook_around(PCREGrammarParser.Look_aroundContext ctx) {
        fieldIncrement("lookAround Count");

        switch (ctx.getText().charAt(2)){
            case '=' -> {
                fieldIncrement("lookAhead Count");
                fieldIncrement("positiveLookAhead Count");
            }
            case '!' -> {
                fieldIncrement("lookAhead Count");
                fieldIncrement("negativeLookAhead Count");
            }
            case '<' -> {
                fieldIncrement("lookBehind Count");
                if (ctx.getText().charAt(3) == '=') {
                    fieldIncrement("positiveLookBehind Count");
                } else { // '!'
                    fieldIncrement("negativeLookBehind Count");
                }
            }
        }
        //TODO get look around size
    }

    @Override
    public void enterSubroutine_reference(PCREGrammarParser.Subroutine_referenceContext ctx) {
        fieldIncrement("subroutineReference Count");
    }
}
