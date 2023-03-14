package CodeGenerator.OldDecoder;

import CodeGenerator.Options.CodeGeneratorOptions;
import FABuilder.Edge;
import FABuilder.FAGraph;
import FABuilder.Vertex;

import java.io.StringWriter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class DecoderComposer {
    CodeGeneratorOptions options;

    DecoderMatrix reducedMatrix;
    FAGraph graph;

    public DecoderComposer(FAGraph graph, CodeGeneratorOptions options) {
        this.options = options;
        this.graph = graph;
        //create matrix
        DecoderMatrix decoderMatrix = new DecoderMatrix();
        ArrayList<Vertex> vertices = new ArrayList<>(graph.vertexSet());
        for (int i = 0; i < vertices.size(); i++){
            Set<Edge> outgoing = graph.outgoingEdgesOf(vertices.get(i));

            for (Edge e : outgoing){
                CharacterClassPresence ccp = new CharacterClassPresence(i);


                if(e.conditions.size() == 1){
                    int[] startStop = Edge.parseCondition(e.conditions.get(0));
                    if(startStop[0] == startStop[1]){ //to not pollute cc field
                        decoderMatrix.updateEntry((char)startStop[0], i);
                    }
                    else{
                        for (int j = startStop[0]; j <= startStop[1]; j++){
                            decoderMatrix.updateEntry((char)j, i, ccp);
                        }
                    }
                }
                else {
                    for (String condition : e.conditions){
                        int[] startStop = Edge.parseCondition(condition);
                        for (int j = startStop[0]; j <= startStop[1]; j++){
                            decoderMatrix.updateEntry((char)j, i, ccp);
                        }
                    }
                }
            }
        }

        //reduce clusters
        reducedMatrix = new DecoderMatrix();
        while (decoderMatrix.matrix.size() > 0){
            DecoderEntry currEntry = null;

            Set<DecoderEntry> mergedEntries = new HashSet<>();
            for (DecoderEntry e : decoderMatrix.matrix){
                if(currEntry == null){
                    currEntry = e;
                    mergedEntries.add(currEntry);
                }
                else{
                    //check if compatible
                    if(currEntry.compatible(e)){
                        //merge
                        currEntry.characterSet.addAll(e.characterSet);
                        currEntry.presenceSet.addAll(e.presenceSet);
                        currEntry.ccPresenceSet.addAll(e.ccPresenceSet); //TODO check for the love of god

                        //delete merged
                        mergedEntries.add(e); //mark for deletion
                        //decoderMatrix.removeEntry(e);
                    }


                }
            }

            //add to reduced set
            reducedMatrix.addEntry(currEntry);

            //remove entries marked for deletion
            for (DecoderEntry entry : mergedEntries){
                decoderMatrix.removeEntry(entry);
            }
        }

        //finished clustering
    }

    public int getDecoding(char c){
        return reducedMatrix.getIndexOf(c);
    }

    public String exportDeclaration(int ruleID){
        StringWriter stringWriter = new StringWriter();

        String returnType = options.softwareCompile? "int" : ("ap_uint<%d>").formatted(reducedMatrix.getSize());

        stringWriter.write("%s rule%dDecoder(unsigned char input);\n\n".formatted(returnType, ruleID));

        return stringWriter.toString();
    }

    public String exportImplementation(int ruleId){
        StringWriter stringWriter = new StringWriter();

        String returnType = options.softwareCompile? "int" : ("ap_uint<%d>").formatted(reducedMatrix.getSize());

        stringWriter.write(returnType + " rule" + ruleId + "Decoder(unsigned char input){\n");

        stringWriter.write("\t" + returnType + " res = 0;\n");

        stringWriter.write("\tswitch (input){\n");
        for (int i = 0; i < reducedMatrix.matrix.size(); i++) {
            DecoderEntry entry = reducedMatrix.matrix.get(i);

            for (char c : entry.characterSet){
                stringWriter.write("\t\tcase " + (int) c+ ":\n");
            }
            if(options.softwareCompile)
                stringWriter.write("\t\t\tres |= 1 << %d;\n".formatted(i));
            else
                stringWriter.write("\t\t\tres.set_bit(%d, true);\n".formatted(i));
            stringWriter.write("\t\t\tbreak;\n");
        }
        stringWriter.write("\t}\n");

        //return result

        stringWriter.write("\treturn res;\n");
        stringWriter.write("}\n\n");

        return stringWriter.toString();
    }
}
