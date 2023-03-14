package CodeGenerator;

import CodeGenerator.NewDecoder.Decoder;
//import CodeGenerator.NewNewDecoder.Decoder;
import CodeGenerator.Options.CodeGeneratorOptions;
import FABuilder.DOTFAExporter;
import FABuilder.Edge;
import FABuilder.FAGraph;
import FABuilder.Loops.*;
import FABuilder.NewDisambiguator.NewDisambiguator;
import FABuilder.Vertex;

import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.*;

public class CodeGenerator {
    CodeGeneratorOptions options;

    CodeHelper codeHelper;

    FAGraph graph;
    ArrayList<FAGraph> graphs;

    FileWriter cppWriter;
    FileWriter hppWriter;

    Decoder decoder;

    ArrayList<Vertex> states;

    Map<IterationCountVar, String> repMap;
    Map<String, String> varTypeMap;
    int repNumber;


    public CodeGenerator(ArrayList<FAGraph> graphs, CodeGeneratorOptions options) throws  IOException{
        this.options = options;

        codeHelper = new CodeHelper(options);

        this.graphs = graphs;

        //write file
        cppWriter = new FileWriter(options.filename + ".cpp");
        hppWriter = new FileWriter(options.filename + ".hpp");
        //write include guard

        writePreprocessorStuff();

        writeCounterDef();

        writeArbitrarySize();

        cppWriter.write("enum matchingActions{\n\tNOT_ACCEPT = 0,\n\tACCEPT = 1};\n\n");

        int currRuleID = 0;
        for (FAGraph currGraph : graphs){
            graph = currGraph;
            System.out.printf("Generating engine for rule (%d/%d): %s\n", currRuleID + 1, graphs.size(), graph.getRule());
            states = new ArrayList<>();

            //
            repMap = new HashMap<>();
            repNumber = 0;

            varTypeMap = new HashMap<>();


            //new DOTFAExporter(graph, "file2.dot");

            //depth first vertex search
            Stack<Vertex> vertexVisitStack = new Stack<>();

            if(options.createDecoder && options.decoderOptions.preDisambiguationDecoder){
                if(graph.getFlags().startOfString){
                    Vertex hack1 = new Vertex(), hack2 = new Vertex();
                    graph.addVertex(hack1);
                    graph.addVertex(hack2);
                    Edge hack = new Edge();
                    hack.conditions.add("\\x00");
                    if(graph.getFlags().m)
                        hack.conditions.add("\n");
                    graph.addEdge(hack1, hack2, hack);

                    decoder = new Decoder(currGraph, options, currRuleID);

                    graph.removeAllVertices(Arrays.asList(hack1, hack2));
                }
                else
                    decoder = new Decoder(currGraph, options, currRuleID);
            }

            new DOTFAExporter(graph, "rule%d.dot".formatted(currRuleID));

            Vertex root = graph.getRoot();
            states.add(root);
            vertexVisitStack.push(root);
            while (vertexVisitStack.size() > 0){
                Vertex currState = vertexVisitStack.pop();

                //non terminal state
                if(graph.outDegreeOf(currState) > 0){
                    //get all outward connections
                    Set<Edge> outEdges = graph.outgoingEdgesOf(currState);
                    for (Edge e : outEdges){
                        //get properties from edge

                        Vertex targetState = graph.getEdgeTarget(e);

                        if(!states.contains(targetState)){
                            states.add(targetState);
                            vertexVisitStack.push(targetState);
                        }
                    }
                }
            }

            if(graph.errorVertex != null)
                states.add(graph.errorVertex);

            writeStates(currRuleID);
            writeStateAction(currRuleID);


            if(options.createDecoder){
                if(!options.decoderOptions.preDisambiguationDecoder)
                    decoder = new Decoder(currGraph, options, currRuleID);

                if(options.decoderOptions.functionSwitchDecoder)
                    hppWriter.write(decoder.exportDeclaration());

                cppWriter.write(decoder.exportImplementation());
            }

            writeNextState(currRuleID);

            currRuleID++;
        }

        hppWriter.write("\n"); //formatting

        writeRunDFAs();

        //writeMainFunc(currRuleID);

        if(!options.softwareCompile)
            writeMainHardware(currRuleID);
            //writeMain(currRuleID);
        else
            writeMainSoftware(currRuleID);

        hppWriter.write("\n\n#endif\n");

        hppWriter.close();
        cppWriter.close();

        if (options.createDefaultTestbench)
            exportTestBench();
    }

    public CodeGenerator(FAGraph graph, CodeGeneratorOptions options) throws IOException{
        this(new ArrayList<>(List.of(graph)), options);
    }

    void writePreprocessorStuff() throws IOException {
        hppWriter.write("#ifndef __RUN_DFA_H__\n#define __RUN_DFA_H__\n\n");

        hppWriter.write("#include <stdint.h>\n\n");
        if(!options.softwareCompile){
            hppWriter.write("#include <ap_int.h>\n");
            hppWriter.write("#include <hls_stream.h>\n\n");
        }
        else{
            //
        }


        hppWriter.write("#define SIZE %d\n\n".formatted(options.payloadSize));

        hppWriter.write("#define REFBUFFERSIZE %d\n\n".formatted(options.dfaOptions.backrefBufferSize));

        cppWriter.write("#include \"%s.%s\"\n\n".formatted(options.filename,"hpp"));
    }

    void writeStates(int ruleID) throws IOException{
        cppWriter.write("enum dfaStates_%d{\n".formatted(ruleID));
        //cppWriter.write("\tERR_%d = 0".formatted(ruleID));

        for (Vertex state : states){
            int stateIndex = states.indexOf(state);
            if(state != graph.errorVertex){
                cppWriter.write(("\tS%d_%d = %d,\n").formatted(stateIndex, ruleID, stateIndex));
            }
            else {
                cppWriter.write("\tERR_%d = %d,\n".formatted(ruleID, stateIndex));
            }
        }

        cppWriter.write("};\n\n");
    }

    void writeStateAction(int ruleID) throws IOException {
        if(!options.stateActionOptions.internalStateAction){
            if(options.stateActionOptions.functionStateAction){
                String inputType = codeHelper.getAP_UINTMaxCapacity(states.size() - 1);

                String returnType = codeHelper.getAP_UINTExact(1);

                String prototype = "%s action_%d(%s state)".formatted(returnType, ruleID, inputType);
                hppWriter.write("%s;\n".formatted(prototype));

                ArrayList<Vertex> terminalStates = new ArrayList<>();

                for (Vertex state : states){
                    if(state.isTerminalVertex) terminalStates.add(state);
                }

                cppWriter.write("%s{\n".formatted(prototype));
                cppWriter.write("\tif(");
                boolean first = true;
                for (Vertex state : terminalStates){
                    if(first){
                        first = false;
                    }
                    else {
                        cppWriter.write("\n\t\t|| ");
                    }
                    cppWriter.write("state == %s".formatted(state == graph.errorVertex?
                            "ERR_%d".formatted(ruleID) :
                            "S%d_%d".formatted(states.indexOf(state), ruleID)));
                }
                cppWriter.write(")");
                cppWriter.write("\n\t\treturn ACCEPT;\n");
                cppWriter.write("\telse\n");
                cppWriter.write("\t\treturn NOT_ACCEPT;\n");
                cppWriter.write("}\n\n");
            }
            else {
                cppWriter.write("static const int action_%d[] = {\n".formatted(ruleID));

                for (int i = 1; i < states.size(); i++) {
                    cppWriter.write("\t%s, \n".formatted(states.get(i).isTerminalVertex? "ACCEPT" : "NOT_ACCEPT"));
                }
                cppWriter.write("};\n\n");
            }
        }
    }

    String repType(IterationCountVar var){
        if(var.getMax() == -1){ //{3, -1}
            return "UnboundCounter<%s>".formatted(codeHelper.getAP_UINTMaxCapacity(var.getMin()));
        }
        else{ //both {3,3} and {3} types
            return codeHelper.getAP_UINTMaxCapacity(var.getMax());
        }
    }

    String nameRep(IterationCountVar var){
        repNumber++;
        return "rep" + repNumber + var.variableNameSuffix();
    }

    String getRepName(IterationCountVar var){
        if(!repMap.containsKey(var)){
            String varName = nameRep(var);
            repMap.put(var, varName);
            varTypeMap.put(varName, repType(var));
        }

        return repMap.get(var);
    }


    void writeCounterDef() throws IOException {
        hppWriter.write("""
                template <typename T>
                class UnboundCounter{
                public:
                    T value;
                    bool valid;
                                
                    UnboundCounter(){
                        value = 0;
                        valid = false;
                    }
                                
                    T& operator=(const T& other){
                        value = other;
                        return value;
                    }
                                
                    T operator++(int){
                        value++;
                        return value;
                    }
                   
                    bool operator==(const T& other){
                        return value == other;
                    }
                   
                    bool operator<=(const T& other){
                        return value <= other;
                    }
                   
                    bool operator<(const T& other){
                        return value < other;
                    }
                };
                                
                """);
    }

    void writeArbitrarySize() throws IOException {
        hppWriter.write("""
                template<int size>
                class ByteArray{
                private:
                    uint8_t bytes[size];
                public:
                    uint8_t get_bit(unsigned int pos){
                        return (bytes[pos/8] & 0x01<<(pos%8)) >> (pos%8);
                    }
                                
                    void set_bit(unsigned int pos, bool value){
                        bytes[pos/8] &= ~(0x01 << (pos%8));
                        bytes[pos/8] |= (value << (pos%8));
                    }
                    
                    void set_bit(unsigned int pos, uint8_t value){
                        bytes[pos/8] &= ~(0x01 << (pos%8));
                        bytes[pos/8] |= ((value & 0x01) << (pos%8));
                    }
                                
                    uint8_t *getArray(){
                        return bytes;
                    }
                };
                
                """);
    }

    RangedQuantifierBranch edgePairing(PriorityQueue<Edge> edges){

        Stack<Edge> reverser = new Stack<>();
        for (Edge e: edges)
            reverser.push(e);

        //get the most complex loop condition
        Edge mostComplex = reverser.pop();

        RangedQuantifierBranch rootBranch = new RangedQuantifierBranch();
        RangedQuantifierBranch currBranch = rootBranch;

        for (LoopInteraction loopInteraction : mostComplex.loopInteractions) {
            currBranch.var = loopInteraction.getVar();
            currBranch.incompleteBranch = new RangedQuantifierBranch();
        }

        for (Edge e : edges){
            Iterator<LoopInteraction> edgeLoopIntIter = e.loopInteractions.iterator();

            currBranch = rootBranch;

            while (edgeLoopIntIter.hasNext()){
                LoopInteraction currInter = edgeLoopIntIter.next();
                if(currInter.getInteractionType() == LoopInteraction.InteractionType.incomplete){
                    currBranch.completeBranch = new RangedQuantifierBranch();
                    currBranch.completeBranch.edge = e;
                    break; //if a complete branch is found, it's the end of the iterator
                }
                else if(!edgeLoopIntIter.hasNext()){
                    currBranch.incompleteBranch.edge = e;
                }

                currBranch = currBranch.incompleteBranch;
            }
        }

        return rootBranch;
    }

    void recursiveLoopWriter(int ruleID, StringBuilder matching, RangedQuantifierBranch rootBranch, int indentation){

        String varName = getRepName(rootBranch.var);

        StringBuilder top = new StringBuilder();
        StringBuilder bottom = new StringBuilder();

        if(rootBranch.var.getVarType() == IterationCountVar.varType.exact) { //{3}

            top.append("\t".repeat(indentation));

            if (rootBranch.completeBranch != null) {
                top.append("if (%s < %d){\n".formatted(varName, rootBranch.var.getMin()));
                for (VarInteraction varInteraction : rootBranch.completeBranch.edge.varInteractions){
                    top.append("\t".repeat(indentation+1))
                            .append("%s%s;\n".formatted(getRepName(varInteraction.var), varInteraction.toString()));
                }
                top.append("\t".repeat(indentation + 1))
                        .append("current_state = S%d_%d;\n".formatted(
                                states.indexOf(graph.getEdgeTarget(rootBranch.completeBranch.edge)),
                                ruleID));

                if(options.stateActionOptions.internalStateAction){
                    top.append("\t".repeat(indentation+1))
                            .append("out = %s;\n".formatted(
                                    graph.getEdgeTarget(rootBranch.completeBranch.edge).isTerminalVertex?
                                        "ACCEPT" : "NOT_ACCEPT"));
                }

                top.append("\t".repeat(indentation))
                        .append("}else ");
            }

            top.append("if(%s == %d){\n".formatted(varName, rootBranch.var.getMax()));
            bottom.append("\t".repeat(indentation))
                    .append("}else{\n");

            bottom.append("\t".repeat(indentation + 1))
                    .append("current_state = %s_%d;\n".formatted(graph.getFlags().startOfString? "ERR" : "S%d"
                            .formatted(states.indexOf(graph.root)), ruleID));
            if(options.stateActionOptions.internalStateAction){
                bottom.append("\t".repeat(indentation+1))
                        .append("out = NOT_ACCEPT;\n");
            }
            bottom.append("\t".repeat(indentation))
                    .append("}\n");
        }
        //if(var < min){
        //  ---
        //}else if(var >= min && var <= max){
        //  --- (recursive)
        //}else
        //  return ERR;
        //
        else if(rootBranch.var.getVarType() == IterationCountVar.varType.bound){ //{3,6}
            top.append("\t".repeat(indentation));

            if (rootBranch.completeBranch != null) {
                top.append("if (%s < %d){\n".formatted(varName, rootBranch.var.getMin()));
                for (VarInteraction varInteraction : rootBranch.completeBranch.edge.varInteractions){
                    top.append("\t".repeat(indentation+1))
                            .append("%s%s;\n".formatted(getRepName(varInteraction.var), varInteraction.toString()));
                }
                top.append("\t".repeat(indentation + 1))
                        .append("current_state = S%d_%d;\n".formatted(
                                states.indexOf(graph.getEdgeTarget(rootBranch.completeBranch.edge)),
                                ruleID));
                if(options.stateActionOptions.internalStateAction){
                    top.append("\t".repeat(indentation+1))
                            .append("out = %s;\n".formatted(
                                    graph.getEdgeTarget(rootBranch.completeBranch.edge).isTerminalVertex?
                                            "ACCEPT" : "NOT_ACCEPT"));
                }
                top.append("\t".repeat(indentation))
                        .append("}else ");
            }

            top.append(("if(%s >= %d && %s <= %d){\n").formatted(varName, rootBranch.var.getMin(), varName, rootBranch.var.getMax()));

            bottom.append("\t".repeat(indentation))
                    .append("}else{\n");
            bottom.append("\t".repeat(indentation + 1))
                    .append("current_state = %s_%d;\n".formatted(graph.getFlags().startOfString? "ERR" : "S%d"
                            .formatted(states.indexOf(graph.root)), ruleID));
            if(options.stateActionOptions.internalStateAction){
                bottom.append("\t".repeat(indentation+1))
                        .append("out = NOT_ACCEPT;\n");
            }
            bottom.append("\t".repeat(indentation))
                    .append("}\n");
        }
        //if(!rootBranch.var.valid && rootBranch.var.value < min){
        //  current_state = S%d_%d; //incomplete
        //}else{ //valid || rootBranch.var.value >= min
        //  --recursive--
        //}

        //OR if no incomplete:

        //if(rootBranch.var.valid || rootBranch.var.value >= min){
        //  rootBranch.var.valid = true;
        //  rootBranch.var.value = 0;
        //   --recursive--
        //} else
        //     current_state = ERR_0;

        else { //max = -1 case (no upper bound) //{3,}

            if (rootBranch.completeBranch != null) {
                top.append("\t".repeat(indentation))
                        .append("if(!%s.valid && %s.value < %d){\n".formatted(varName, varName, rootBranch.var.getMin()));
                for (VarInteraction varInteraction : rootBranch.completeBranch.edge.varInteractions){
                    top.append("\t".repeat(indentation+1))
                            .append("%s%s;\n".formatted(getRepName(varInteraction.var), varInteraction.toString()));
                }
                top.append("\t".repeat(indentation+1))
                        .append("current_state = S%d_%d;\n".formatted(
                                states.indexOf(graph.getEdgeTarget(rootBranch.completeBranch.edge)),
                                ruleID));
                if(options.stateActionOptions.internalStateAction){
                    top.append("\t".repeat(indentation+1))
                            .append("\t\t\t\tout = %s;\n".formatted(
                                    graph.getEdgeTarget(rootBranch.completeBranch.edge).isTerminalVertex?
                                            "ACCEPT" : "NOT_ACCEPT"));
                }

                top.append("\t".repeat(indentation))
                        .append("}else {\n"); //valid || value >= min
                top.append("\t".repeat(indentation+1))
                        .append("%s.valid = true;\n".formatted(getRepName(rootBranch.var)));
                bottom.append("\t".repeat(indentation))
                        .append("}\n");

            }
            else {
                top.append("\t".repeat(indentation))
                        .append("if(%s.valid || %s.value >= %d){\n".formatted(varName, varName, rootBranch.var.getMin()));
                top.append("\t".repeat(indentation+1))
                        .append("%s.valid = true;\n");
                top.append("\t".repeat(indentation+1))
                        .append("%s.value = 0;\n");

                bottom.append("\t".repeat(indentation))
                        .append("}\n");
            }
        }

        matching.append(top);
        if(rootBranch.incompleteBranch.edge != null){
            for (VarInteraction varInteraction : rootBranch.incompleteBranch.edge.varInteractions){
                matching.append("\t".repeat(indentation+1))
                        .append("%s%s;\n".formatted(getRepName(varInteraction.var), varInteraction.toString()));
            }
            matching.append("\t".repeat(indentation+1))
                    .append("current_state = S%d_%d;\n".formatted(
                            states.indexOf(graph.getEdgeTarget(rootBranch.incompleteBranch.edge)),
                            ruleID));
            if(options.stateActionOptions.internalStateAction){
                matching.append("\t".repeat(indentation+1))
                        .append("out = %s;\n".formatted(
                                graph.getEdgeTarget(rootBranch.incompleteBranch.edge).isTerminalVertex?
                                        "ACCEPT" : "NOT_ACCEPT"));
            }
        }
        else
            recursiveLoopWriter(ruleID, matching, rootBranch.incompleteBranch, indentation+1);

        matching.append(bottom);
    }

    Set<Edge> loopInteractions(int ruleID, StringBuilder matching, Edge edge) {
        if(edge.negativeConditions)
            edge.invertConditionNaming();

        Vertex root = graph.getEdgeSource(edge);
        Set<Edge> sameConditionLoopEdges = new HashSet<>();
        for (Edge out : graph.outgoingEdgesOf(root)){
            if(out.negativeConditions)
                edge.invertConditionNaming();

            if(out.conditions.equals(edge.conditions) && out.negativeConditions == edge.negativeConditions){
                sameConditionLoopEdges.add(out);
            }
        }
        Set<Edge> visitedEdges = new HashSet<>(sameConditionLoopEdges);

        PriorityQueue<Edge> edgePriorityQueue = new PriorityQueue<>(sameConditionLoopEdges);

        RangedQuantifierBranch rootBranch = edgePairing(edgePriorityQueue);
        recursiveLoopWriter(ruleID, matching, rootBranch, 4);

        return visitedEdges;
    }


    String writeVarInteractions(int indentation, Edge e){
        StringBuilder res = new StringBuilder();
        for (VarInteraction i : e.varInteractions){
            res.append("\t".repeat(indentation))
                    .append(getRepName(i.var))
                    .append(i.toString())
                    .append(";\n");
        }

        return res.toString();
    }


    void writeInputParsingSwitch(int ruleID, StringBuilder matching, Vertex vertex) {
        matching.append("\t\t\tswitch(input){\n");

        Set<Edge> visitedEdges = new HashSet<>();

        for (Edge edge : graph.outgoingEdgesOf(vertex)){
            if(!visitedEdges.contains(edge)){ //skip if visited by loop investigator
                for (String condition : edge.conditions){
                    int[] startStop = Edge.parseCondition(condition);
                    for (int j = startStop[0]; j <= startStop[1]; j++){
                        matching.append("\t\t\t\tcase %d:\n".formatted(j));
                    }
                }

                if(edge.loopInteractions.size() == 0) { //normal edge
                    matching.append("\t\t\t\t\tcurrent_state = S%d_%d;\n".formatted(states.indexOf(graph.getEdgeTarget(edge)), ruleID));
                    if(options.stateActionOptions.functionStateAction){
                        matching.append("\t\t\t\t\tout = NOT_ACCEPT;\n");
                    }
                    visitedEdges.add(edge);
                }
                else{//handle loops here
                    visitedEdges.addAll(loopInteractions(ruleID, matching, edge));
                }

                matching.append("\t\t\t\t\tbreak;\n");
            }
        }

        matching.append("\t\t\t\tdefault:\n");
        matching.append("\t\t\t\t\tcurrent_state = %s_%d;\n".formatted(graph.getFlags().startOfString? "ERR" : "S%d"
                            .formatted(states.indexOf(graph.root)), ruleID));
        if(options.stateActionOptions.functionStateAction){
            matching.append("\t\t\t\t\tout = NOT_ACCEPT;\n");
        }
        matching.append("\t\t\t\t\tbreak;\n");
        matching.append("\t\t\t}\n");

    }

    void writeInputParsingSwitch(int ruleID, Decoder decoder, StringBuilder matching, Vertex vertex){
        matching.append("\t\t\tswitch(input){\n");

        Set<Edge> visitedEdges = new HashSet<>();

        for (Edge edge : graph.outgoingEdgesOf(vertex)){
            if(!visitedEdges.contains(edge)){ //skip if visited by loop investigator
                Set<Integer> lines = new HashSet<>();

                for (String condition : edge.conditions){
                    int[] startStop = Edge.parseCondition(condition);
                    for (int j = startStop[0]; j <= startStop[1]; j++){
                        lines.add(decoder.getDecoding((char)j));
                    }
                }
                for (int line : lines){
                    matching.append("\t\t\t\tcase %d:\n".formatted(line));
                }

                if(edge.loopInteractions.size() == 0) { //normal edge
                    matching.append("\t\t\t\t\tcurrent_state = S%d_%d;\n".formatted(states.indexOf(graph.getEdgeTarget(edge)), ruleID));
                    if(options.stateActionOptions.functionStateAction){
                        matching.append("\t\t\t\t\tout = %s;\n".formatted(
                                graph.getEdgeTarget(edge).isTerminalVertex?
                                        "ACCEPT" : "NOT_ACCEPT"));
                    }
                    visitedEdges.add(edge);
                }
                else{//handle loops here
                    visitedEdges.addAll(loopInteractions(ruleID, matching, edge));
                }

                matching.append("\t\t\t\t\tbreak;\n");

            }
        }

        matching.append("\t\t\t\tdefault:\n");
        matching.append("\t\t\t\t\tcurrent_state = %s_%d;\n".formatted(graph.getFlags().startOfString? "ERR" : "S%d"
                            .formatted(states.indexOf(graph.root)), ruleID));
        if(options.stateActionOptions.functionStateAction){
            matching.append("\t\t\t\t\tout = NOT_ACCEPT;\n");
        }
        matching.append("\t\t\t\t\tbreak;\n");
        matching.append("\t\t\t}\n");
    }

    void writeInputParsingIfElse(int ruleID, StringBuilder matching, Vertex vertex){
        Set<Edge> visitedEdges = new HashSet<>();

        if(graph.outgoingEdgesOf(vertex).size() > 0){
            List<String> backRefNames = new ArrayList<>();
            for (Edge e : graph.outgoingEdgesOf(vertex)){
                if(e.isBackreference)
                    backRefNames.add(e.conditions.get(0));
            }


            boolean first = true;
            for (Edge edge : graph.outgoingEdgesOf(vertex)){
                if(!visitedEdges.contains(edge)){ //skip if visited by loop investigator
                    if(first){
                        matching.append("\t\t\tif(");
                        first = false;
                    }
                    else {
                        matching.append("\t\t\t}\n");
                        matching.append("\t\t\telse if(");
                    }


                    if(backRefNames.size() > 0){
                        for (String name : backRefNames){
                            if(!edge.isBackreference || !name.equals(edge.conditions.get(0)))
                                matching.append("ref_%s.empty() && ".formatted(name));
                        }
                    }


                    if(edge.isBackreference){
                        matching.append("!ref_%s.empty()".formatted(edge.conditions.get(0)));

                        matching.append(")){\n");

                        matching.append("\t\t\t\tif(c == ref_%s.read()){\n".formatted(edge.conditions.get(0)));
                        matching.append(writeVarInteractions(5, edge));
                        matching.append("\t\t\t\t\tcurrent_state = S%d_%d;\n".formatted(
                                states.indexOf(graph.getEdgeTarget(edge)),
                                ruleID));
                        if(options.stateActionOptions.functionStateAction){
                            matching.append("\t\t\t\t\tout = %s;\n".formatted(
                                    graph.getEdgeTarget(edge).isTerminalVertex?
                                            "ACCEPT" : "NOT_ACCEPT"));
                        }
                        matching.append("\t\t\t\t}\n");

                        visitedEdges.add(edge);


                    }
                    else{
                        if(options.createDecoder){
                            matching.append(decoder.getDecoding(edge.conditions));
                        }
                        else {
                            boolean firstCondition = true;
                            for (String condition : edge.conditions){
                                if(firstCondition){
                                    firstCondition = false;
                                }
                                else
                                    matching.append(" || ");

                                int[] startStop = Edge.parseCondition(condition);
                                if(startStop[0] == startStop[1]){ //i.e. "a"
                                    matching.append("c == ").append(startStop[0]);
                                }
                                else {
                                    matching.append("(c >= ")
                                            .append(startStop[0])
                                            .append(" && ")
                                            .append("c <= ")
                                            .append(startStop[1])
                                            .append(")");
                                }
                            }
                        }

                        matching.append("){\n");

                        for (String group : edge.captureGroups){ //looped edges have the same capture groups
                            if(graph.getReferencesUsed().contains(group)){
                                matching.append("\t\t\t\tref_%s.write(c);\n".formatted(group));
                            }
                        }

                        if(edge.loopInteractions.size() == 0){//normal edge
                            matching.append(writeVarInteractions(4, edge));
                            matching.append("\t\t\t\tcurrent_state = S%d_%d;\n".formatted(
                                    states.indexOf(graph.getEdgeTarget(edge)),
                                    ruleID));

                            if(options.stateActionOptions.functionStateAction){
                                matching.append("\t\t\t\tout = %s;\n".formatted(
                                        graph.getEdgeTarget(edge).isTerminalVertex?
                                                "ACCEPT" : "NOT_ACCEPT"));
                            }

                            visitedEdges.add(edge);
                        }
                        else{//handle loops here
                            visitedEdges.addAll(loopInteractions(ruleID, matching, edge));
                        }
                    }


                }
            }

            matching.append("\t\t\t}\n");
            matching.append("\t\t\telse{\n");
            matching.append("\t\t\t\tcurrent_state = %s_%d;\n".formatted(graph.getFlags().startOfString? "ERR" : "S%d"
                            .formatted(states.indexOf(graph.root)), ruleID));
            if(options.stateActionOptions.functionStateAction){
                matching.append("\t\t\t\tout = NOT_ACCEPT;\n");
            }
            //TODO clear stream here?
            if(backRefNames.size() > 0){ //if any backreferences were used:
                for(String refName : backRefNames)
                    matching.append("\t\t\t\twhile(!ref_%s.empty()) ref_%s.read();\n".formatted(refName, refName));
            }
            matching.append("\t\t\t}\n");
        }
        else{
            matching.append("\t\t\tcurrent_state = %s_%d;\n".formatted(graph.getFlags().startOfString? "ERR" : "S%d"
                    .formatted(states.indexOf(graph.root)), ruleID));
            if(options.stateActionOptions.functionStateAction){
                matching.append("\t\t\tout = NOT_ACCEPT;\n");
            }
        }


    }

    void writeNextState(int ruleID) throws IOException{
        String prototype;
        if(options.stateActionOptions.internalStateAction){
            prototype = "void next_state_%d(unsigned char c, %s &out)".formatted(
                    ruleID,
                    codeHelper.getAP_UINTExact(1));
        }
        else {
            prototype = "void next_state_%d(unsigned char c, %s state)".formatted(
                    ruleID,
                    codeHelper.getAP_UINTMaxCapacity(states.size()-1));
        }

        hppWriter.write(prototype + ";\n");



        String repDeclarations = prototype + "{\n";
        repDeclarations += "#pragma HLS INLINE off\n";
        repDeclarations += "\tstatic %s current_state = 0;\n\n".formatted(
                codeHelper.getAP_UINTMaxCapacity(states.size()-1));

        if(options.createDecoder){
            String decoderType = codeHelper.getAP_UINTExact(decoder.getWidth());

            repDeclarations += "\t%s input = rule%dDecoder%sc%s;\n".formatted(decoderType, ruleID,
                    options.decoderOptions.functionDecoder? "(" : "[",
                    options.decoderOptions.functionDecoder? ")" : "]"
            );
        }

        for (String usedRef : graph.getReferencesUsed()){
            varTypeMap.put("ref_%s".formatted(usedRef), "hls::stream<unsigned char, %d>".formatted(
                    options.dfaOptions.backrefBufferSize));
        }

        StringBuilder matching = new StringBuilder("\tswitch(current_state){\n");

        for (int i = 0; i < states.size(); i++) {
            Vertex vertex = states.get(i);
            if(vertex == graph.errorVertex) //is always the first
                matching.append(("\t\tcase ERR_%d:\n").formatted(ruleID));
            else
                matching.append(("\t\tcase S%d_%d:\n").formatted(i, ruleID));

            if(options.ifElseORSwitch){ //one for both (options.createDecoder is checked)
                writeInputParsingIfElse(ruleID, matching, vertex);
            }
            else{
                if(options.createDecoder)
                    writeInputParsingSwitch(ruleID, decoder, matching, vertex);
                else
                    writeInputParsingSwitch(ruleID, matching, vertex);
            }


            matching.append("\t\t\tbreak;\n");
        }

        matching.append("\t\tdefault:\n");
        matching.append("\t\t\tcurrent_state = %s_%d;\n".formatted(graph.getFlags().startOfString? "ERR" : "S%d"
                .formatted(states.indexOf(graph.root)), ruleID));
        if (options.stateActionOptions.internalStateAction)
            matching.append("\t\t\tout = NOT_ACCEPT;\n");
        matching.append("\t\t\tbreak;\n");


        matching.append("\t}\n\n");//close switch statement
        if(!options.stateActionOptions.internalStateAction)
            matching.append("\tstate = current_state;\n");
        matching.append("}\n\n");//close function

        cppWriter.write(repDeclarations);

        for (String var : varTypeMap.keySet()){
            if(var.contains("ref_")){
                cppWriter.write("\tstatic %s %s;\n".formatted(varTypeMap.get(var), var));
            }
            else
                cppWriter.write("\tstatic %s %s%s;\n".formatted(varTypeMap.get(var), var, varTypeMap.get(var).contains("UnboundCounter")? "" : " = 0"));
        }

        cppWriter.write(matching.toString());
    }

    void writeRunDFAs() throws IOException{
        for (int i = 0; i < graphs.size(); i++) {
            String prototype =
                    "void runDFA%d(unsigned char input, %s& output)".formatted(
                            i,
                            codeHelper.getAP_UINTExact(1)
                    );

            hppWriter.write(prototype + ";\n");
            cppWriter.write(
                    prototype + "{\n" +
                    "\tnext_state_%d(input, output);\n".formatted(i) +
                    "}\n"
            );
        }

        cppWriter.write("\n\n");
        hppWriter.write("\n");
    }

    void writeMainFunc(int numberOfRules) throws IOException {
        String prototype = "void runDFA(unsigned char input[SIZE], int output[SIZE])";
        hppWriter.write(prototype + ";\n");
        cppWriter.write(prototype + "{\n");
        for (int i = 0; i < numberOfRules; i++) {
            cppWriter.write("\tint current_state_" + i + " = S1_" + i + ";\n");
        }
        cppWriter.write("\nrunDFA_label0:"); //label
        cppWriter.write("\tfor(int i = 0; i < SIZE; i++){\n");
        for (int i = 0; i < numberOfRules; i++){
            cppWriter.write("\t\tnext_state_%d(&current_state_%d, input[i]);\n".formatted(i, i));
            cppWriter.write("\t\toutput[i] = action_%d%scurrent_state_%d%s;\n\n".formatted(
                    i,
                    options.functionStateAction? "(" : "[",
                    i,
                    options.functionStateAction? ")" : "]"));
        }

        cppWriter.write("\t}\n"); //close for loop
        cppWriter.write("}\n");//close function
    }

    /*void writeOutputDefine() throws IOException {
        StringWriter stringWriter = new StringWriter();
        stringWriter.write("struct LabeledOut{\n");
        stringWriter.write("\t%s out;\n".formatted(codeHelper.getAP_UINTMaxCapacity(graphs.size())));
        stringWriter.write("\t%s cycle;\n".formatted(codeHelper.getAP_UINTExact(options.counterBitSize)));
        stringWriter.write("};\n\n");

        cppWriter.write(stringWriter.toString());
    }*/

    void writeMain(int numberOfRules) throws IOException{
        //creates a pipeline connected:
        //      input reader;
        //      match_computer;
        //      output writer;

        int tripCount = 1024;

        ////////////////////////////////////////////////////
        //input reading
        cppWriter.write("""
                void read_input(unsigned char* input, hls::stream<unsigned char> &inputStream, int size){
                    for (int i = 0; i < size; i++) {
                """
                +"\t\t" +  writePragma(new String[]{"PIPELINE II=1"})
                + "\n\t\t" + writePragma(new String[]{
                    "LOOP_TRIPCOUNT",
                    "min=%d".formatted(tripCount),
                    "max=%d".formatted(tripCount)}) +
                """
                     
                    	inputStream << input[i];
                    }
                }
                
                """);

        ////////////////////////////////////////////////////
        //match_calculator (not too keen on the name)

        String outputType = codeHelper.getAP_UINTExact(graphs.size());

        cppWriter.write(
                "void compute(hls::stream<unsigned char> &inputStream, hls::stream<%s> &outputStream, int size){\n"
                        .formatted(outputType));

        cppWriter.write("\t" + codeHelper.getAP_UINTExact(1) + "\n");
        for (int i = 0; i < graphs.size(); i++) {
            if(i != 0){
                cppWriter.write(",\n");
            }
            cppWriter.write("\t\tout%d".formatted(i));
        }
        cppWriter.write(";\n\n");

        cppWriter.write("\tfor (int i = 0; i < size; i++) {\n");
        cppWriter.write("\t\t" + writePragma(new String[]{
                "PIPELINE",
                "II=1"}));

        cppWriter.write("\n\t\t" + writePragma(new String[]{
                "LOOP_TRIPCOUNT",
                "min=%d".formatted(tripCount),
                "max=%d".formatted(tripCount)}));

        cppWriter.write("\n\t\tunsigned char input = inputStream.read();\n\n");

        for (int i = 0; i < graphs.size(); i++) {
            cppWriter.write("\t\trunDFA%d(input, out%d);\n".formatted(i, i));
        }

        cppWriter.write("\n\t\t%s out = (\n".formatted(outputType));
        for (int i = 0; i < graphs.size(); i++) {
            if(i != 0)
                cppWriter.write(",\n");
            cppWriter.write("\t\t\tout%d".formatted(i));
        }
        cppWriter.write(");\n\n");

        cppWriter.write("\t\toutputStream << out;\n");

        cppWriter.write("\t}\n");
        cppWriter.write("}\n\n");

        ////////////////////////////////////////////////////
        //output writing

        cppWriter.write("""
                void write_output("""
                + outputType +
                """
                * output, hls::stream<"""
                + outputType +
                """
                > &outputStream, int size){
                    for (int i = 0; i < size; i++) {
                """
                    +"\t\t" +  writePragma(new String[]{"PIPELINE II=1"})
                    + "\n\t\t" + writePragma(new String[]{
                    "LOOP_TRIPCOUNT",
                    "min=%d".formatted(tripCount),
                    "max=%d".formatted(tripCount)}) +
                """
                        
                        output[i] = outputStream.read();
                    }
                }
                
                """);

        ////////////////////////////////////////////////////
        //actual main function
        String prototype = "void runDFAEngine(unsigned char* input, %s *output, int size)".formatted(outputType);

        hppWriter.write("extern \"C\"{\n\n");
        hppWriter.write(prototype + ";\n");
        hppWriter.write("}//extern \"C\"\n\n");

        cppWriter.write("extern \"C\"{\n\n");
        cppWriter.write(prototype + """
                {
                	static hls::stream<unsigned char,2> inputStream("internal_input_stream");
                	static hls::stream<"""
                + outputType +
                """
                , 2> outputStream("internal_output_stream");
                """
                + writePragma(new String[]{"DATAFLOW"}) +
                """
                
                	read_input(input, inputStream, size);
                	compute(inputStream, outputStream, size);
                	write_output(output, outputStream, size);
                }
                
                """);

        cppWriter.write("}//extern \"C\"\n\n");

    }

    void writeMainHardware(int numberOfRules) throws IOException{
        //creates a pipeline connected:
        //      input reader;
        //      input staging;
        //      match_computer;
        //      //output staging;
        //      output writer;

        int tripCount = 1024;

        ////////////////////////////////////////////////////
        //input reading
        ////////////////////////////////////////////////////
        cppWriter.write("""
                void read_input(ap_uint<512>* input, hls::stream<ap_uint<512>> &inputStream, int size){
                    for(int i = 0; i < size/64; i++){
                #pragma HLS PIPELINE II=1
                #pragma HLS LOOP_TRIPCOUNT min=1024 max=1024
                        inputStream << input[i];
                    }
                }
                
                """);

        ////////////////////////////////////////////////////
        //input staging
        ////////////////////////////////////////////////////
        cppWriter.write("""
                void stage_input(hls::stream<ap_uint<512>> &inputStream, hls::stream<unsigned char> &characterStream, int size){
                    for(int i = 0; i < size/64; i++){
                #pragma HLS PIPELINE II=1
                #pragma HLS LOOP_TRIPCOUNT min=(1024/64) max=(1024/64)
                        ap_uint<512> tmp = inputStream.read();
                                
                        for(int j = 0; j < 64; j++){
                #pragma HLS unroll
                            characterStream << tmp.range(7 + j, j);
                        }
                    }
                }
                
                """);

        ////////////////////////////////////////////////////
        //match_calculator (not too keen on the name)
        ////////////////////////////////////////////////////
        String outputType = codeHelper.getAP_UINTExact(graphs.size());

        cppWriter.write(
                "void compute(hls::stream<unsigned char> &inputStream, hls::stream<%s> &outputStream, int size){\n"
                        .formatted(outputType));

        cppWriter.write("\t" + codeHelper.getAP_UINTExact(1) + "\n");
        for (int i = 0; i < graphs.size(); i++) {
            if(i != 0){
                cppWriter.write(",\n");
            }
            cppWriter.write("\t\tout%d".formatted(i));
        }
        cppWriter.write(";\n\n");

        cppWriter.write("\tfor (int i = 0; i < size; i++) {\n");
        cppWriter.write("\t\t" + writePragma(new String[]{
                "PIPELINE",
                "II=1"}));

        cppWriter.write("\n\t\t" + writePragma(new String[]{
                "LOOP_TRIPCOUNT",
                "min=%d".formatted(tripCount),
                "max=%d".formatted(tripCount)}));

        cppWriter.write("\n\t\tunsigned char input = inputStream.read();\n\n");

        for (int i = 0; i < graphs.size(); i++) {
            cppWriter.write("\t\trunDFA%d(input, out%d);\n".formatted(i, i));
        }

        cppWriter.write("\n\t\t%s out = (\n".formatted(outputType));
        for (int i = 0; i < graphs.size(); i++) {
            if(i != 0)
                cppWriter.write(",\n");
            cppWriter.write("\t\t\tout%d".formatted(i));
        }
        cppWriter.write(");\n\n");

        cppWriter.write("\t\toutputStream << out;\n");

        cppWriter.write("\t}\n");
        cppWriter.write("}\n\n");

        ////////////////////////////////////////////////////
        //output writing

        cppWriter.write("""
                void write_output("""
                + outputType +
                """
                * output, hls::stream<"""
                + outputType +
                """
                > &outputStream, int size){
                    for (int i = 0; i < size; i++) {
                """
                +"\t\t" +  writePragma(new String[]{"PIPELINE II=1"})
                + "\n\t\t" + writePragma(new String[]{
                "LOOP_TRIPCOUNT",
                "min=%d".formatted(tripCount),
                "max=%d".formatted(tripCount)}) +
                """
                        
                        output[i] = outputStream.read();
                    }
                }
                
                """);

        ////////////////////////////////////////////////////
        //actual main function
        String prototype = "void runDFAEngine(unsigned char* input, %s *output, int size)".formatted(outputType);

        hppWriter.write("extern \"C\"{\n");
        hppWriter.write("\t" + prototype + ";\n");
        hppWriter.write("}//extern \"C\"\n\n");

        cppWriter.write("extern \"C\"{\n");
        cppWriter.write("\t" + prototype + """
                /**/
                    {
                        static hls::stream<ap_uint<512>, 2> inputStream("internal_input_stream");
                        static hls::stream<unsigned char, 128> stagingInputStream("staging_input_stream");
                        static hls::stream<"""
                + outputType +
                """
                , 64> outputStream("internal_output_stream");
                """
                + writePragma(new String[]{"DATAFLOW"}) +
                """
                
                	    read_input(input, inputStream, size);
                	    stage_input(inputStream, stagingInputStream, size);
                	    compute(stagingInputStream, outputStream, size);
                	    write_output(output, outputStream, size);
                    }
                """);

        cppWriter.write("}//extern \"C\"\n");

    }

    void writeMainSoftware(int numberOfRules) throws IOException{
        String outputType = codeHelper.getAP_UINTExactSOFTWARE(numberOfRules);

        String prototype = "void runDFAEngine(unsigned char* input, %s *output, int size)".formatted(outputType);

        hppWriter.write("extern \"C\"{\n");
        hppWriter.write(prototype + ";\n");
        hppWriter.write("}//extern \"C\"\n\n");


        cppWriter.write("extern \"C\"{\n\n");
        cppWriter.write(prototype + "{\n");


        cppWriter.write("\t" + outputType + " out;\n\n");
        cppWriter.write("\tuint8_t tmp;\n\n");


        cppWriter.write("\tfor (int i = 0; i < size; i++) {\n");

        cppWriter.write("\t\tunsigned char inputC = input[i];\n\n");

        for (int i = 0; i < graphs.size(); i++) {
            cppWriter.write("\t\trunDFA%d(inputC, tmp);\n".formatted(i));
            cppWriter.write("\t\tout.set_bit(%d, tmp);\n\n".formatted(i));
        }

        cppWriter.write("\t\toutput[i] = out;\n");

        cppWriter.write("\t}\n");
        cppWriter.write("}\n\n");

        cppWriter.write("}//extern \"C\"\n\n");

    }

    void exportTestBench() throws IOException {
        String extension = "cpp";
        FileWriter testbench = new FileWriter("%s_test.%s".formatted(options.filename, extension));

        String headerExtension = "hpp";
        testbench.write("#include \"%s.%s\"\n\n".formatted(options.filename, headerExtension));

        testbench.write("int main(){\n");


        testbench.write("\tunsigned char input[] = {\n");
        testbench.write("\t\t");
        char[] charArray = options.testbenchSettings.testString.toCharArray();
        int boundary = options.testbenchSettings.fitToSize?
                options.testbenchSettings.testbenchStringSize : charArray.length;
        for (int i = 0; i < boundary; i++){
            testbench.write("%d,\t".formatted(charArray.length > i? (int)charArray[i] : 0));
            if((i+1) % 8 == 0)
                testbench.write("\n\t\t");
        }
        testbench.write("\n\t};\n\n");

        testbench.write("\t%s output[] = {\n".formatted(
                codeHelper.getAP_UINTExact(graphs.size())));
        testbench.write("\t\t");
        for (int i = 0; i < boundary; i++){
            testbench.write("0,\t");
            if((i+1) % 8 == 0)
                testbench.write("\n\t\t");
        }
        testbench.write("\n\t};\n\n");

        testbench.write("\t%s expectedOutput[] = {\n".formatted(
                codeHelper.getAP_UINTExact(graphs.size())));
        testbench.write("\t\t");
        for (int i = 0; i < boundary; i++){
            testbench.write("0,\t");
            if((i+1) % 8 == 0)
                testbench.write("\n\t\t");
        }
        testbench.write("\n\t};\n\n");

        testbench.write("\trunDFAEngine(input, output, %d);\n".formatted(options.testbenchSettings.fitToSize?
                options.testbenchSettings.testbenchStringSize : charArray.length));
        testbench.write("\tfor(int i = 0; i < %d; i++){\n".formatted(boundary));
        testbench.write("\t\tprintf(\"Output: %d, Expected %d\\n\", expectedOutput[i], output[i]);\n");
        testbench.write("\t\t//assert(output[i] == expectedOutput[i]);\n");
        testbench.write("\t}\n\n");
        testbench.write("\treturn 0;\n");
        testbench.write("}\n");

        testbench.close();
    }

    String writePragma(String[] strings){
        StringBuilder b = new StringBuilder("#pragma HLS ");
        for (String s : strings)
            b.append("%s ".formatted(s));
        return b.toString();
    }

}
