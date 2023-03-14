package FABuilder;

import FABuilder.Loops.IterationCountVar;
import FABuilder.Loops.LoopInteraction;
import FABuilder.Loops.VarInteraction;
import FABuilder.NewDisambiguator.NewDisambiguator;
import gen.PCREGrammarBaseListener;
import gen.PCREGrammarParser;

import java.io.IOException;
import java.util.*;

public class FABuilder extends PCREGrammarBaseListener {
    ArrayList<FAGraph> faGraphs;
    FAGraph currGraph;

    Stack<String> captureGroupStack;
    int currCaptureNumber;

    Stack<QueuableSubGraph> stack;

    //handle EndOfSubjectOrLine

    public ArrayList<FAGraph> getFaGraphs(){
        return faGraphs;
    }

    //Setup for simplifying the creation of vertices and edges
    Vertex createVertex(){
        Vertex v = new Vertex();
        currGraph.addVertex(v);

        return v;
    }

    Edge createEdge(Vertex source, Vertex destination){
        Edge e = new Edge();
        e.captureGroups.addAll(captureGroupStack);
        currGraph.addEdge(source, destination, e);

        return e;
    }

    Edge createEdge(Vertex source, Vertex destination, String condition){
        Edge e = createEdge(source, destination);
        e.conditions.add(condition);
        e.negativeConditions = false;

        return e;
    }

    /*Edge createEdge(Vertex source, Vertex destination, ArrayList<String> conditions, boolean negativeConditions){
        Edge e = createEdge(source, destination);
        e.conditions.addAll(conditions);
        e.negativeConditions = negativeConditions;

        return e;
    }*/

    Edge createEdge(Vertex source, Vertex destination, Edge edge){ //from copy constructor
        Edge e = new Edge(edge);
        currGraph.addEdge(source, destination, e);

        return e;
    }

    void repeatQueuedSubGraph(int copies){
        QueuableSubGraph original = stack.peek();

        Vertex start = original.start;
        Vertex stop = original.stop;

        Set<Vertex> subgraphVertices = new HashSet<>();
        Set<Edge> subgraphEdges = new HashSet<>();

        Stack<Vertex> visitStack = new Stack<>();

        visitStack.add(start);

        while (!visitStack.isEmpty()){
            Vertex currVertex = visitStack.pop();

            for (Edge out : currGraph.outgoingEdgesOf(currVertex)){
                subgraphVertices.add(currVertex);
                subgraphEdges.add(out);

                visitStack.add(currGraph.getEdgeTarget(out));
            }
        }

        Map<Vertex, ArrayList<Vertex>> correspondenceMap = new HashMap<>();

        for (Vertex v : subgraphVertices){
            ArrayList<Vertex> vertexCopies = new ArrayList<>();
            correspondenceMap.put(v, vertexCopies);

            for (int i = 0; i < copies; i++) {
                vertexCopies.add(new Vertex(v));
            }
        }

        for (Edge e : subgraphEdges){
            Vertex source = currGraph.getEdgeSource(e);
            Vertex target = currGraph.getEdgeTarget(e);

            for (int i = 0; i < copies; i++) {
                currGraph.addEdge(
                        correspondenceMap.get(source).get(i),
                        correspondenceMap.get(target).get(i),
                        new Edge(e));
            }
        }

        for (int i = 0; i < copies; i++) {
            stack.push(new QueuableSubGraph(
                    correspondenceMap.get(start).get(i),
                    correspondenceMap.get(stop).get(i),
                    original.type,
                    original.context));
        }
    }

    //Parse Tree Listener overloads
    //start of file
    @Override
    public void enterParse(PCREGrammarParser.ParseContext ctx) {
        faGraphs = new ArrayList<>();
        currGraph = null;

        stack = new Stack<>();
        captureGroupStack = new Stack<>();
        currCaptureNumber = 0;
    }

    @Override
    public void enterSingleRule(PCREGrammarParser.SingleRuleContext ctx) {
        currGraph = new FAGraph();
        faGraphs.add(currGraph);

        currGraph.rule = ctx.getText();

        if(ctx.directives() != null)
            currGraph.flags = new RegexFlags(ctx.directives().getText());
        else
            currGraph.flags = new RegexFlags("");

        if(ctx.Caret() != null || currGraph.flags.A)
            currGraph.flags.startOfString = true;

        System.out.printf("Generating DFA for rule: %s\n", currGraph.rule);
    }


    @Override
    public void exitSingleRule(PCREGrammarParser.SingleRuleContext ctx) {
        //Or just apply simplifier?

        //Remove transitions that go to terminal vertices through condition-less branches.
        Set<Vertex> verticesToRemove = new HashSet<>();
        for (Vertex v : currGraph.vertexSet()){
            if(currGraph.outDegreeOf(v) == 0 && currGraph.inDegreeOf(v) > 0){
                boolean allEpsilonConditions = true;
                for(Edge e : currGraph.incomingEdgesOf(v)){
                    if(e.conditions.size() != 0){
                        allEpsilonConditions = false;
                        break;
                    }
                }

                if(allEpsilonConditions){
                    for (Edge e : currGraph.incomingEdgesOf(v)){
                        currGraph.getEdgeSource(e).isTerminalVertex = true;
                    }
                    verticesToRemove.add(v);
                }

            }
        }
        currGraph.removeAllVertices(verticesToRemove);

        QueuableSubGraph sequence = stack.pop();
        currGraph.root = sequence.start; //just gets the root

        if(currGraph.flags.startOfString){
            Vertex errorVertex = new Vertex();
            currGraph.addVertex(errorVertex);
            currGraph.errorVertex = errorVertex;

            Edge errorRestartEdge = new Edge("\\x00");
            if(currGraph.getFlags().m)
                errorRestartEdge.conditions.add("\n");
            currGraph.addEdge(currGraph.errorVertex, currGraph.root, new Edge(errorRestartEdge));
        }
        else {
            for (Vertex v : currGraph.vertexSet()){
                if(v != currGraph.root){
                    for (Edge out : currGraph.outgoingEdgesOf(currGraph.root)){
                        currGraph.addEdge(v, currGraph.getEdgeTarget(out), new Edge(out));
                    }
                }
            }
        }

        new NewDisambiguator(currGraph);
    }

    //alternation
    @Override
    public void exitAlternation(PCREGrammarParser.AlternationContext ctx) {
        //make alternatives of all expressions
        QueuableSubGraph sequence = stack.pop();
        Vertex start = sequence.start;
        Vertex stop = sequence.stop;

        Vertex literalStop = null;
        Vertex epsilonStop = null;

        //multiple incoming edges always means an alternation (all epsilon transitions to the end NOT TRUE)
        boolean allEpsilonIncoming = true;
        for (Edge e : currGraph.incomingEdgesOf(stop)){
            if(e.conditions.size() > 0){
                allEpsilonIncoming = false;
                break;
            }
        }

        if(allEpsilonIncoming)
            epsilonStop = stop;
        else
            literalStop = stop;

        //if there is more than one expression
        while (stack.size() > 0 && stack.peek().type == QueuableSubGraph.Type.expr){
            sequence = stack.pop();
            Vertex newStart = sequence.start;
            Vertex newStop = sequence.stop;

            currGraph.mergeVertexBInToA(start, newStart);

            allEpsilonIncoming = true;
            for (Edge e : currGraph.incomingEdgesOf(newStop)){
                if(e.conditions.size() > 0){
                    allEpsilonIncoming = false;
                    break;
                }
            }

            if(allEpsilonIncoming){
                if(epsilonStop == null){
                    literalStop.isTerminalVertex = false;
                    epsilonStop = newStop;
                    createEdge(literalStop, epsilonStop); //epsilon transition
                }
                else
                    currGraph.mergeVertexBInToA(epsilonStop, newStop);
            }
            else{
                if(literalStop == null){
                    literalStop = newStop;
                    literalStop.isTerminalVertex = false;
                    createEdge(literalStop, epsilonStop);
                }
                else
                    currGraph.mergeVertexBInToA(literalStop, newStop);
            }
        }

        //
        stack.push(new QueuableSubGraph(
                start,
                epsilonStop == null? literalStop : epsilonStop,
                QueuableSubGraph.Type.alternation,
                ctx.getText()
        ));
    }

    //Expr
    @Override
    public void enterExpr(PCREGrammarParser.ExprContext ctx) {
        //to solve recursiveness in the stack between alternations
        stack.push(new QueuableSubGraph(
                null,
                null,
                QueuableSubGraph.Type.SEPARATOR,
                ""
        ));
    }

    @Override
    public void exitExpr(PCREGrammarParser.ExprContext ctx) {
        //Concatenate all atoms

        Vertex start;
        Vertex stop;

        if(stack.peek().type != QueuableSubGraph.Type.SEPARATOR){
            QueuableSubGraph sequence = stack.pop();
            start = sequence.start;
            stop = sequence.stop; //permanent

            while (stack.size() > 0
                    && stack.peek().type == QueuableSubGraph.Type.atom){
                sequence = stack.pop();

                Vertex newStart = sequence.start;
                Vertex newStop = sequence.stop;

                //currGraph.mergeVertexBInToA(newStop, start);

                Set<Edge> newStopInEdges = currGraph.incomingEdgesOf(newStop);
                boolean allEmptyIn = true;
                for(Edge e : newStopInEdges){
                    allEmptyIn = allEmptyIn && e.conditions.size() == 0;
                }

                if(allEmptyIn){ //skippable
                    Set<Edge> startOutEdges = currGraph.outgoingEdgesOf(start);

                    for (Edge inEdge: newStopInEdges){
                        Vertex inVertex = currGraph.getEdgeSource(inEdge);

                        for (Edge outEdge : startOutEdges){
                            Vertex outVertex = currGraph.getEdgeTarget(outEdge);
                            createEdge(inVertex, outVertex, outEdge);
                        }
                    }

                    currGraph.removeVertex(newStop);
                    currGraph.removeVertex(start);
                }
                else //simple merge
                    currGraph.mergeVertexBInToA(start, newStop);

                start = newStart;
            }
        }
        else{
            start = createVertex();
            stop = createVertex();
            stop.isTerminalVertex = true;

            createEdge(start, stop); //epsilon
        }

        if(stack.size() != 0 && stack.peek().type == QueuableSubGraph.Type.SEPARATOR)
            stack.pop();

        stack.push(new QueuableSubGraph(
                start,
                stop,
                QueuableSubGraph.Type.expr,
                ctx.getText()
        ));
    }

    //Atom
    @Override
    public void exitAtom(PCREGrammarParser.AtomContext ctx) {
        //convert literals and others into atoms
        if (ctx.getChild(0).getChildCount() != 0){
            stack.peek().type = QueuableSubGraph.Type.atom;
        }
        else { //if the atom has no subrules (token)

            Vertex start = createVertex();
            Vertex stop = createVertex();
            stop.isTerminalVertex = true;
            Edge e = createEdge(start, stop);

            switch (ctx.getText()){
                case ".":
                    e.negativeConditions = true;
                    if(!currGraph.flags.m)
                        e.conditions.add("\\x0a"); //new line
                    break;

                //TODO handle boundaries?
                /*case "\\B": //non wordBoundary
                    e.negativeConditions = true;
                case "\\b": //word boundary
                    e.conditions.addAll(Arrays.asList(
                            "a-z",
                            "A-Z",
                            "0-9",
                            ""
                    ));
                    break;*/
                case "$": //end of subject or line
                    stop.isEndOfSubject = true;
                    e.conditions.add("" + (char)0);
                    if(currGraph.flags.m)
                        e.conditions.add("\n");
                    break;
                default: //handle most cases
                    e.conditions.add(ctx.getText());
                    break;
            }

            //can be picked up by:
            //expr

            stack.push(new QueuableSubGraph(
                    start,
                    stop,
                    QueuableSubGraph.Type.atom,
                    ctx.getText()
            ));
        }
    }

    //capture groups
    @Override
    public void enterCapture(PCREGrammarParser.CaptureContext ctx) {
        //push capture name/number to stack
        int childCount = ctx.getChildCount();
        if(childCount == 3){ //'(' alternation ')'
            currCaptureNumber++; //1, 2, 3, 4, ...
            captureGroupStack.push("" + currCaptureNumber);
        }
        else{ //'(' '?' '<' name '>' alternation ')'
            captureGroupStack.push(ctx.getChild(3).getText());
        }
    }

    @Override
    public void exitCapture(PCREGrammarParser.CaptureContext ctx) {
        //pop capture name/number to stack
        captureGroupStack.pop();
    }

    //backref
    @Override
    public void exitBackreference(PCREGrammarParser.BackreferenceContext ctx) {
        String ref = "";

        if(ctx.backreference_or_octal() != null){
            ref = ctx.backreference_or_octal().digit().getText();
        }
        else{
            if(ctx.number() != null)
                ref = ctx.number().getText();
            else if (ctx.name() != null)
                ref = ctx.name().getText();
        }

        if(!ref.equals(""))
            currGraph.referencesUsed.add(ref);

        Vertex start = createVertex();
        Vertex stop = createVertex();

        Edge backRef = createEdge(start, stop, ref);
        backRef.isBackreference = true;
        createEdge(stop, stop, backRef);

        Vertex epsilonStop = createVertex();
        epsilonStop.isTerminalVertex = true;

        createEdge(start, epsilonStop);
        createEdge(stop, epsilonStop);

        stack.push(new QueuableSubGraph(
                start,
                epsilonStop,
                QueuableSubGraph.Type.atom,
                ctx.getText()
        ));
    }

    //character class
    @Override
    public void exitCharacter_class(PCREGrammarParser.Character_classContext ctx) {
        Vertex charStart = createVertex();
        Vertex charStop = createVertex();
        charStop.isTerminalVertex = true;

        Edge e = createEdge(charStart, charStop);

        //After some testing, I don't think the special cases need to be considered as
        //e.g. "[]-]" gets evaluated into '[' cc_atom cc_atom ']
        //e.g. "[]-b]" gets evaluated into '[' cc_atom ']'

        Stack<Edge> cc_atomStack = new Stack<>();
        while (stack.size() > 0 && stack.peek().type == QueuableSubGraph.Type.cc_atom){
            //V1 --condition--> V2
            QueuableSubGraph cc_atom = stack.pop();
            Edge copy = new Edge(currGraph.getEdge(cc_atom.start, cc_atom.stop));

            currGraph.removeVertex(cc_atom.start);
            currGraph.removeVertex(cc_atom.stop);

            cc_atomStack.push(copy); //only one edge exists
        }

        if(ctx.getChildCount() > 1 && ctx.getChild(1).getText().equals("^")) //check for negative conditions
            e.negativeConditions = true;

        while(cc_atomStack.size() > 0){
            e.conditions.addAll(cc_atomStack.pop().conditions); //only one should come in
        }

        stack.push(new QueuableSubGraph(
                charStart,
                charStop,
                QueuableSubGraph.Type.atom,
                ctx.getText()
        ));
    }

    //cc_atom
    @Override
    public void exitCc_atom(PCREGrammarParser.Cc_atomContext ctx) {
        //has either:
        // 1 child:
        //  shared_atom
        //  cc_literal
        //  backreference_or_octal //doesn't happen in snort
        // 3 children:
        //  cc_literal '-' cc_literal

        if(ctx.getChildCount() == 1){
            stack.peek().type = QueuableSubGraph.Type.cc_atom;
        }
        else if(ctx.getChildCount() == 3){ // 3 children
            //form: 'a-c'
            //in Stack: 'a', 'c'
            QueuableSubGraph sequence1;
            if(ctx.getChild(0).getChild(0).getChildCount() > 0){
                sequence1 = stack.pop();
            }
            else {
                Vertex cc_literalStart = createVertex();
                Vertex cc_literalStop = createVertex();
                Edge e = createEdge(cc_literalStart, cc_literalStop);
                e.conditions.add(ctx.getChild(0).getText());
                sequence1 = new QueuableSubGraph(
                        cc_literalStart,
                        cc_literalStop,
                        QueuableSubGraph.Type.cc_atom,
                        ctx.getChild(0).getText()
                );
            }
            Edge stopLiteral = currGraph.getEdge(sequence1.start, sequence1.stop);

            QueuableSubGraph sequence2;
            if(ctx.getChild(2).getChild(0).getChildCount() > 0){
                sequence2 = stack.pop();
            }
            else {
                Vertex cc_literalStart = createVertex();
                Vertex cc_literalStop = createVertex();
                Edge e = createEdge(cc_literalStart, cc_literalStop);
                e.conditions.add(ctx.getChild(2).getText());
                sequence2 = new QueuableSubGraph(
                        cc_literalStart,
                        cc_literalStop,
                        QueuableSubGraph.Type.cc_atom,
                        ctx.getChild(2).getText()
                );
            }
            Edge startLiteral = currGraph.getEdge(sequence2.start, sequence2.stop);

            Vertex newLiteralStart = createVertex();
            Vertex newLiteralStop = createVertex();
            newLiteralStop.isTerminalVertex = true;

            Edge newEdge = createEdge(newLiteralStart, newLiteralStop,
                    startLiteral.conditions.get(0)
                    + "-"
                    + stopLiteral.conditions.get(0));

            if(currGraph.flags.i){
                //calculate intersection
                int[] startStopStart = Edge.parseCondition(startLiteral.conditions.get(0)); //one literal only
                int[] startStopStop = Edge.parseCondition(stopLiteral.conditions.get(0)); //one literal only

                int start = startStopStart[0];
                int stop = startStopStop[0];

                boolean needsSimplify = false;

                //check if it needs uppercase
                if(!((start < 'a' && stop < 'a') || (start > 'z' && stop > 'z'))){
                    int uppercaseStart = Character.toUpperCase(Math.max('a', start));
                    int uppercaseStop = Character.toUpperCase(Math.min('z', stop));

                    newEdge.conditions.add(Edge.getConditionStr(uppercaseStart, uppercaseStart) + "-" + Edge.getConditionStr(uppercaseStop, uppercaseStop));

                    needsSimplify = true;
                }

                //check if it needs lowercase
                if(!((start < 'A' && stop < 'A') || (start > 'Z' && stop > 'Z'))){
                    int lowercaseStart = Character.toLowerCase(Math.max('A', start));
                    int lowerCaseStop = Character.toLowerCase(Math.min('Z', stop));

                    newEdge.conditions.add(Edge.getConditionStr(lowercaseStart, lowercaseStart) + "-" + Edge.getConditionStr(lowerCaseStop, lowerCaseStop));

                    needsSimplify = true;
                }

                if(needsSimplify)
                    newEdge.simplifyConditions();
            }

            //remove unused vertices from graph (edges also disappear)
            currGraph.removeVertex(sequence1.start);
            currGraph.removeVertex(sequence1.stop);

            currGraph.removeVertex(sequence2.start);
            currGraph.removeVertex(sequence2.stop);

            stack.push(new QueuableSubGraph(
                    newLiteralStart,
                    newLiteralStop,
                    QueuableSubGraph.Type.cc_atom,
                    ctx.getText()
            ));
        }
    }

    //shared_atom
    @SuppressWarnings("DuplicateBranchesInSwitch")
    @Override
    public void enterShared_atom(PCREGrammarParser.Shared_atomContext ctx) {
        Vertex literalStart = createVertex();
        Vertex literalStop = createVertex();
        literalStop.isTerminalVertex = true;

        Edge literal = createEdge(literalStart, literalStop);

        switch (ctx.getText()){ //covers all that happen in the SNORT ruleset
            case "\\D": //not decimal digit
                literal.negativeConditions = true;
            case "\\d": //decimal digit
                literal.conditions.add("0-9");
                break;
            case "\\N": // not new line
                literal.negativeConditions = true;
                literal.conditions.add("\\x0A");
                break;
            case "\\W": // not word char
                literal.negativeConditions = true;
            case "\\w"://word char
                literal.conditions.addAll(Arrays.asList(
                        "a-z", //lowercase
                        "A-Z", //uppercase
                        "0-9", //decimal digit
                        "_" //underscore
                ));
                break;
            case "\\S"://not whitespace
                literal.negativeConditions = true;
            case "\\s"://whitespace
                literal.conditions.addAll(Arrays.asList(
                        " ", //space
                        "\\x0C", // form feed
                        "\\x0A", //new line
                        "\\x0D", //carriage return
                        "\\x09", // horizontal tab
                        "\\x0B" // vertical tab
                ));
                break;
        }

        stack.push(new QueuableSubGraph(
                literalStart,
                literalStop,
                QueuableSubGraph.Type.atom,
                ctx.getText()
        ));

    }

    //Literal
    @Override
    public void exitLiteral(PCREGrammarParser.LiteralContext ctx) {
        if(ctx.getChild(0).getChildCount() == 0){ //unshared Literal
            Vertex start = createVertex();
            Vertex stop = createVertex();
            stop.isTerminalVertex = true;

            createEdge(start, stop, ctx.getText());

            //can be picked up by:
            //atom

            stack.push(new QueuableSubGraph(
                    start,
                    stop,
                    QueuableSubGraph.Type.literal,
                    ctx.getText()
            ));
        }
    }

    //Shared Literal
    //a bit more complicated because of the weird cases
    @Override
    public void exitShared_literal(PCREGrammarParser.Shared_literalContext ctx) {

        Vertex start = createVertex();
        Vertex stop = createVertex();
        stop.isTerminalVertex = true;

        Edge e = createEdge(start, stop);

        switch (ctx.getText()) {
            //BellChar
            case "\\a" -> e.conditions.add("\\x07");
            //escapeChar
            case "\\e" -> e.conditions.add("\\x1B");
            case "\\f" -> e.conditions.add("\\x0C");
            case "\\n" -> e.conditions.add("\\x0A");
            case "\\r" -> e.conditions.add("\\x0D");
            case "\\t" -> e.conditions.add("\\x09");
            //covers any others + sub-rule cases
            default -> {
                String txt = ctx.getText();
                if (txt.charAt(0) == '\\' && !Character.isLetterOrDigit(txt.charAt(1))
                        && txt.length() == 2) {
                    if(currGraph.flags.i && Character.isLetter(txt.charAt(1))){
                        e.conditions.add(("" + txt.charAt(1)).toLowerCase());
                        e.conditions.add(("" + txt.charAt(1)).toUpperCase());
                    }
                    else
                        e.conditions.add("" + txt.charAt(1)); //should cover most characters
                } else {
                    //for sure only one letter
                    if(currGraph.flags.i && Character.isLetter(txt.charAt(0))){
                        e.conditions.add(txt.toLowerCase());
                        e.conditions.add(txt.toUpperCase());
                    }
                    else
                        e.conditions.add(txt); //should cover most characters

                    //e.conditions.add(ctx.getText());
                }
            }
        }

        //can be picked up by:
        //literal
        //cc_literal

        stack.push(new QueuableSubGraph(
                start,
                stop,
                QueuableSubGraph.Type.literal,
                ctx.getText()
        ));
    }

    @Override
    public void exitQuantifier(PCREGrammarParser.QuantifierContext ctx) {
        QueuableSubGraph sequence = stack.pop();

        Vertex atomStart = sequence.start;
        Vertex atomStop = sequence.stop;

        String modifier = ctx.getChild(0).getText();

        //E.G. :
        // (a)<-\
        //  |    |<L>{1,3}
        // \_/   |
        // (b)--/
        //  |
        // \_/ <E>
        // ( )
        switch (modifier) { //These modifiers produce empty transitions that are simplified away on the expr concatenation
            case "?" -> {
                Vertex newStop = createVertex();
                createEdge(atomStop, newStop); //epsilon transition
                atomStop.isTerminalVertex = false;
                newStop.isTerminalVertex = true;
                createEdge(atomStart, newStop); //epsilon transition

                stack.add(new QueuableSubGraph(
                        atomStart,
                        newStop,
                        QueuableSubGraph.Type.atom,
                        sequence.context + ctx.getText()
                ));
            }
            case "+" -> {
                //  optimization: instead of an empty transition to the beginning,
                //                just copy the transitions to the next state
                for (Edge e : currGraph.outgoingEdgesOf(atomStart)){
                    createEdge(atomStop, currGraph.getEdgeTarget(e), e); //from the end to the beginning
                }

                stack.add(new QueuableSubGraph(
                        atomStart,
                        atomStop,
                        QueuableSubGraph.Type.atom,
                        sequence.context + ctx.getText()
                ));
            }
            // '*' quantifier
            //     ---------------->
            //  O  --> O -a-> O -b-> O
            //           <----------
            //
            case "*" -> {
                Vertex anyStop = createVertex();
                createEdge(atomStop, anyStop); //finalize skip

                atomStop.isTerminalVertex = false;
                anyStop.isTerminalVertex = true;

                Set<Edge> outgoingAtomStart = currGraph.outgoingEdgesOf(atomStart);
                for (Edge e : outgoingAtomStart){
                    createEdge(atomStop, currGraph.getEdgeTarget(e), e);
                }

                createEdge(atomStart, anyStop);//skip branch

                stack.add(new QueuableSubGraph(
                        atomStart,
                        anyStop,
                        QueuableSubGraph.Type.atom,
                        sequence.context + ctx.getText()
                ));

            }
            case "{" -> {
                int childCount = ctx.getChildCount();

                int minimumRepetitions = Integer.parseInt(ctx.getChild(1).getText());

                int maximumRepetitions = switch (childCount) {
                    case 5 -> -1; //no defined maximum
                    case 6 -> Integer.parseInt(ctx.getChild(3).getText());
                    default -> minimumRepetitions; //same maximum as minimum
                };
                //Loop identified by target state and capture groups
                //so (a{2,3}){4,5}
                //
                //  would refer to variables:
                //
                //  repS[State 'a' transition]_1
                //  repS[State 'a' transition]_1_2

                //TODO expansion alternative

                IterationCountVar loopVar = new IterationCountVar(
                        new ArrayList<>(captureGroupStack),
                        minimumRepetitions,
                        maximumRepetitions
                );

                //add var++ to start
                for (Edge out : currGraph.outgoingEdgesOf(atomStart)){
                    out.varInteractions.add(new VarInteraction(loopVar, VarInteraction.InteractionType.add, 1));
                }

                Vertex incompleteLoopVertex = createVertex();
                Vertex completeLoopVertex = createVertex();

                Edge incompleteLoopEdge = new Edge();
                incompleteLoopEdge.loopInteractions.add(
                        new LoopInteraction(loopVar, LoopInteraction.InteractionType.incomplete));

                Edge completeLoopEdge = new Edge();
                completeLoopEdge.loopInteractions.add(
                        new LoopInteraction(loopVar, LoopInteraction.InteractionType.complete));

                createEdge(atomStop, incompleteLoopVertex, incompleteLoopEdge);
                createEdge(atomStop, completeLoopVertex, completeLoopEdge);


                //loopBackEdges
                createEdge(incompleteLoopVertex, atomStart);
                if(minimumRepetitions != maximumRepetitions){
                    createEdge(completeLoopVertex, atomStart);
                }

                atomStop.isTerminalVertex = false;
                completeLoopVertex.isTerminalVertex = true;

                try {
                    new DOTFAExporter(currGraph, "debug.dot");
                }
                catch (IOException e){
                    System.err.println(e.getMessage());
                }

                SuperSetCreator s = new SuperSetCreator(currGraph, atomStart);
                Vertex newStart = s.getNewStart();
                Vertex newStop = s.getNewStop();

                boolean allEmpty = true;
                for (Edge e : currGraph.incomingEdgesOf(newStop)){
                    if(e.conditions.size() != 0){
                        allEmpty = false;
                        break;
                    }
                }

                Vertex newNewStop = newStop;
                if(!allEmpty){
                    newNewStop = createVertex();//epsilon transition so it plays nice with exitAlternation
                    newStop.isTerminalVertex = false;
                    newNewStop.isTerminalVertex = true;
                    createEdge(newStop, newNewStop);
                }

                //check if sequence is skippable
                if(loopVar.getMin() == 0){
                    createEdge(newStart, newNewStop);
                }

                loopVar.setAtomStart(newStart);

                try {
                    new DOTFAExporter(currGraph, "debug.dot");
                }
                catch (IOException e){
                    System.err.println(e.getMessage());
                }

                //add var = 0 to start
                for (Edge out : currGraph.outgoingEdgesOf(newStart)){
                    out.varInteractions.add(0, new VarInteraction(loopVar, VarInteraction.InteractionType.set, 0));
                    out.simplifyVarInteractions();
                }

                try {
                    new DOTFAExporter(currGraph, "debug.dot");
                }
                catch (IOException e){
                    System.err.println(e.getMessage());
                }

                //fix inaccessible transitions like:
                // i = 1  i < 2 -> certain
                // i = 1  i >= 2 -> impossible
                // into
                // i = 1 -> certain
                List<Edge> edgesToRemove = new ArrayList<>();
                for (Edge out : currGraph.outgoingEdgesOf(newStart)){
                    for (VarInteraction vI : out.varInteractions) {
                        if (vI.interactionType == VarInteraction.InteractionType.set){ //var = value
                            List<LoopInteraction> loopInteractionsToRemove = new ArrayList<>();
                            for (LoopInteraction loopInteraction : out.loopInteractions) {
                                if (loopInteraction.getVar() == vI.var) {
                                    if (loopInteraction.getInteractionType() == LoopInteraction.InteractionType.incomplete) {
                                        if(vI.value >= vI.var.getMin()) //works for all
                                            edgesToRemove.add(out);
                                        else
                                            loopInteractionsToRemove.add(loopInteraction);
                                    } else { //complete min <= i <= max
                                        if(vI.value < vI.var.getMin()){
                                            edgesToRemove.add(out);
                                        }
                                        else {
                                            switch (vI.var.getVarType()){
                                                case exact:
                                                    loopInteractionsToRemove.add(loopInteraction);
                                                    break;
                                                case bound:
                                                    if(vI.value < vI.var.getMax())
                                                        loopInteractionsToRemove.add(loopInteraction);
                                                    break;
                                                //var set values don't check for var.valid and only value
                                                //ideally we would check if valid or the value is >= min and slap on
                                                //valid = true and value = 0
                                            }
                                        }
                                    }
                                }
                            }

                            out.loopInteractions.removeAll(loopInteractionsToRemove);
                        }
                    }
                }
                currGraph.removeAllEdges(edgesToRemove);


                try {
                    new DOTFAExporter(currGraph, "debug.dot");
                }
                catch (IOException e){
                    System.err.println(e.getMessage());
                }

                stack.add(new QueuableSubGraph( //ship it back
                        newStart,
                        newNewStop,
                        QueuableSubGraph.Type.atom,
                        sequence.context + ctx.getText()
                ));

            }
        }
    }
}
