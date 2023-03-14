package CodeGenerator.NewNewDecoder;

import CodeGenerator.Options.CodeGeneratorOptions;
import CodeGenerator.CodeHelper;
import FABuilder.Edge;
import FABuilder.FAGraph;

import java.io.StringWriter;
import java.math.BigInteger;
import java.util.*;

public class Decoder {

    CodeGeneratorOptions options;
    int ruleID;
    CodeHelper codeHelper;
    BigInteger defaultValue = new BigInteger("0");

    BigInteger[] matrix = new BigInteger[256];
    int decoderWidth;
    int decoderComplexity; //measure of how many different characters it defines

    FAGraph graph;

    ArrayList<Condition> cataloguedConditions = new ArrayList<>();

    ArrayList<Set<Integer>> characterClassIndexes = new ArrayList<>();

    int log2(BigInteger val){ //approximation of behaviour for my purposes
        val = val.xor(defaultValue); //solves negative character class problems

        if(val.compareTo(BigInteger.valueOf(0)) == 0)
            return -2;

        int i = 0;
        while ((val.and(BigInteger.valueOf(1))).compareTo(BigInteger.valueOf(1)) != 0){ //0010
            val = val.shiftRight(1);//0001
            i++;
        }

        if(val.compareTo(BigInteger.valueOf(1)) == 0)
            return i;
        else
            return -1;
    }

    int numberOfSpecifiedChars(Condition c){
        int charNumber = 0;
        for (String condition : c.conditions){
            int[] interval = Edge.parseCondition(condition);
            charNumber += interval[1] - interval[0] + 1;
        }

        return charNumber;
    }

    public Decoder(FAGraph graph, CodeGeneratorOptions options, int ruleID){
        this.graph = graph;
        this.ruleID = ruleID;
        this.options = options;
        codeHelper = new CodeHelper(options);


        //make all conditions positive for comparison
        for (Edge e : graph.edgeSet()){
            if(!e.isBackreference){
                Condition condition = new Condition(e);

                if(numberOfSpecifiedChars(condition) > 128) { //half of the alphabet size
                    condition.invertConditionNaming();
                }

                if(!cataloguedConditions.contains(condition)){
                    cataloguedConditions.add(condition);
                }
            }
        }

        for (int i = 0; i < cataloguedConditions.size(); i++) { //result example:    default: return 001001;
            defaultValue = defaultValue.or(BigInteger.ONE.shiftLeft(i));
        }

        //create matrix
        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = new BigInteger("0");
        }

        //register conditions to a bit
        int i;
        for (i = 0; i < cataloguedConditions.size(); i++){
            Set<Integer> ccI = new TreeSet<>();
            characterClassIndexes.add(ccI);

            for (String condition : cataloguedConditions.get(i).conditions){
                int[] startStop = Edge.parseCondition(condition);
                for (int j = startStop[0]; j <= startStop[1]; j++) {
                    matrix[j] = matrix[j].or(BigInteger.ONE.shiftLeft(i));
                    ccI.add(j);
                }
            }
        }

        //pre disambiguation decoder:
        //      combinations of bits can exist          i.e. 0101
        //post disambiguation decoder:
        //      new bit for any combination of bits     i.e. 0101 -> 10000

        if(!options.decoderOptions.preDisambiguationDecoder){
            //i.e. 33 (32 + 1) -> bit 7
            //assign new bit if number on a matrix is not an exponential of 2
            Map<BigInteger, BigInteger> nonPure2BaseToNewBit = new HashMap<>();
            for (int j = 0; j < 256; j++) {
                if (log2(matrix[j]) == -1) {
                    if (!nonPure2BaseToNewBit.containsKey(matrix[j])) {
                        nonPure2BaseToNewBit.put(matrix[j], BigInteger.valueOf(1).shiftLeft(i));
                        i++;
                        characterClassIndexes.add(new TreeSet<>());
                    }

                    //TODO test
                    for(long bit : individualBits(matrix[j])){
                        characterClassIndexes.get((int) bit).remove(j);
                    }

                    characterClassIndexes.get(i-1).add(j);

                    matrix[j] = nonPure2BaseToNewBit.get(matrix[j]);
                }
            }


            //remove empty character classes
            List<Set<Integer>> toRemove = new ArrayList<>();
            for (Set<Integer> characterClass : characterClassIndexes){
                if (characterClass.size() == 0){
                    toRemove.add(characterClass);
                }
            }

            characterClassIndexes.removeAll(toRemove);
        }

        //decoderWidth = i;
        decoderWidth = characterClassIndexes.size();
        decoderComplexity = 0;
        for (Condition condition : cataloguedConditions){
            for (String individualGroup : condition.conditions){
                int[] interval = Edge.parseCondition(individualGroup);

                decoderComplexity += interval[1] - interval[0] + 1;
            }
        }
    }

    Set<Integer> individualBits(BigInteger val){
        Set<Integer> bits = new TreeSet<>();

        int i = 0;
        while (val.compareTo(BigInteger.valueOf(0)) != 0){
            if(val.and(BigInteger.ONE).compareTo(BigInteger.ONE) == 0) //  (val & 1) == 1
                bits.add(i);
            val = val.shiftRight(1);
            i++;
        }

        return bits;
    }

    Set<Integer> getNegativeBits(Set<Integer> bitSet, Set<Integer> indexes){
        Set<Integer> negativeBits = new TreeSet<>();

        for (int bit : bitSet) {
            for (int integer: characterClassIndexes.get(bit)){
                if(!indexes.contains(integer)){
                    for (Integer matrixBit : individualBits(matrix[integer])){
                        if(!bitSet.contains(matrixBit)){
                            negativeBits.add(matrixBit);
                        }
                    }
                }
            }
        }


        return negativeBits;
    }

    public List<Set<Integer>> bitConditions(ArrayList<String> conditions){
        Set<Integer> conditionIndexes = new TreeSet<>();

        Set<Integer> positiveBits = new TreeSet<>();
        Set<Integer> negativeBits = new TreeSet<>();

        boolean first = true;

        for (String c : conditions){
            int[] startStop = Edge.parseCondition(c);

            //add all used bits
            for (int i = startStop[0]; i <= startStop[1]; i++){
                conditionIndexes.add(i);
                Set<Integer> bits = individualBits(matrix[i]);
                if(options.decoderOptions.preDisambiguationDecoder){
                    if(first){
                        positiveBits.addAll(bits);
                        first = false;
                    }
                    else {
                        //intersect positive bits
                        List<Integer> toRemove = new ArrayList<>();

                        for (Integer positive : positiveBits){
                            if(!bits.contains(positive)){
                                toRemove.add(positive);
                            }
                        }

                        positiveBits.removeAll(toRemove);
                    }
                }
                else {
                    positiveBits.addAll(bits);
                }
            }
        }


        if(options.decoderOptions.preDisambiguationDecoder){
            if(positiveBits.size() > 1){
                int singleCondition = -1;
                for (int positiveBit : positiveBits){
                    if(conditionIndexes.containsAll(characterClassIndexes.get(positiveBit))){
                        singleCondition = positiveBit;
                    }
                }

                if(singleCondition != -1){
                    positiveBits.clear();
                    positiveBits.add(singleCondition);
                }
            }

            for (Integer integer : positiveBits){
                negativeBits.addAll(getNegativeBits(positiveBits, conditionIndexes));
            }
        }

        ArrayList<Set<Integer>> res = new ArrayList<>();
        res.add(positiveBits);
        res.add(negativeBits);

        return res;
    }

    public int getDecoding(char c){
        return log2(matrix[c]);
    }

    public String getDecoding(ArrayList<String> conditions){
        StringWriter decoding = new StringWriter();

        List<Set<Integer>> posNegBits = bitConditions(conditions);

        boolean first = true;
        for (int positiveBit : posNegBits.get(0)){ //or chains
            if(first)
                first = false;
            else
                decoding.write(" %s ".formatted(options.decoderOptions.preDisambiguationDecoder? "&&" : "||"));

            decoding.write(codeHelper.getBit("input", positiveBit));
        }

        //if post-disambiguation, no negative bits will exist
        //but just to be safe:
        if(options.decoderOptions.preDisambiguationDecoder){
            for (int negativeBit : posNegBits.get(1)){
                decoding.write(" && !%s".formatted(codeHelper.getBit("input", negativeBit)));
            }
        }

        return decoding.toString();
    }

    public int getWidth(){
        return decoderWidth;
    }

    public int getDecoderComplexity() {
        return decoderComplexity;
    }

    public String exportDeclaration(){
        String returnType = options.softwareCompile? "int" : ("ap_uint<%d>").formatted(decoderWidth);
        return "%s rule%dDecoder(unsigned char input);\n".formatted(returnType, ruleID);
    }

    public ArrayList<int[]> intIntervals(Set<Integer> intSet){
        ArrayList<int[]> intervals = new ArrayList<>();
        int start = -1;
        int stop = start;
        for (int i = 0; i < intSet.size(); i++){
            if(start == -1){
                start = (int)intSet.toArray()[i];
                stop = start;
            }

            if((i+1 == intSet.size()) || (int)intSet.toArray()[i+1] != ((int)(intSet.toArray()[i])+1)){
                intervals.add(new int[]{start, stop});

                start = -1;
                stop = start;
            }
            else
                stop++;
        }

        return intervals;
    }

    public String exportImplementation(){
        StringWriter str = new StringWriter();
        String returnType = options.softwareCompile? "int" : ("ap_uint<%d>").formatted(decoderWidth);

        if(options.decoderOptions.functionDecoder){
            str.write("%s rule%dDecoder(unsigned char input){\n".formatted(returnType, ruleID));
            str.write("\t%s res;\n".formatted(returnType));
            if(options.decoderOptions.functionSwitchDecoder){
                str.write("\tswitch(input){\n");

                Map<BigInteger, Set<Integer>> decoderValueToIndexMap = new HashMap<>();
                for (int i = 0; i < matrix.length; i++) {
                    if(matrix[i].compareTo(BigInteger.ZERO) != 0){ //matrix[i] != 0
                        if(!decoderValueToIndexMap.containsKey(matrix[i])){
                            decoderValueToIndexMap.put(matrix[i], new HashSet<>());
                        }
                        decoderValueToIndexMap.get(matrix[i]).add(i);
                    }
                }

                for (BigInteger val : decoderValueToIndexMap.keySet()){
                    Set<Integer> indexSet = decoderValueToIndexMap.get(val);

                    val = val.xor(defaultValue);

                    Set<Integer> bits = individualBits(val);

                    for (int index : indexSet){
                        str.write("\t\tcase %d:\n".formatted(index));
                    }
                    str.write("\t\t\tres = %s; //%s\n".formatted(
                            decoderWidth < 32 ?
                                    val.toString() :
                                    "%s(\"%d\", 10)".formatted(returnType, val), bits
                    ));
                    str.write("\t\t\tbreak;\n");
                }


                str.write("\t\tdefault:\n");
                str.write("\t\t\tres = %s;\n".formatted(
                        decoderWidth < 32 ?
                                defaultValue.toString() :
                                "%s(\"%d\", 10)".formatted(returnType, defaultValue)));
                str.write("\t\t\tbreak;\n");

                str.write("\t}\n");
            }
            else {//If else chain //TODO fix the rest of this mess
                for (int i = 0; i < characterClassIndexes.size(); i++){
                    if(!options.decoderOptions.setBitScheme){
                        str.write("\t%s bit%d = 0;\n".formatted(options.softwareCompile? "int" : "ap_uint<1>", i));
                    }
                    Set<Integer> intSet = characterClassIndexes.get(i);
                    str.write("\tif(");
                    ArrayList<int[]> integerIntervals = intIntervals(intSet);
                    boolean first = true;
                    for (int[] interval : integerIntervals){
                        if(first)
                            first = false;
                        else
                            str.write(" || ");

                        if(interval[0] == interval[1]){
                            str.write("input == %d".formatted(interval[0]));
                        }
                        else {
                            str.write("(input >= %d && input <= %d)".formatted(interval[0], interval[1]));
                        }
                    }
                    str.write(")\n");
                    if(options.decoderOptions.setBitScheme){
                        str.write("\t\t%s;\n".formatted(codeHelper.setBit("res", i)));
                    }
                    else {
                        str.write("\t\tbit%d = 1;\n".formatted(i));
                    }
                }

                if(!options.decoderOptions.setBitScheme){
                    if(options.softwareCompile){
                        str.write("\tres = (");
                        boolean first = true;
                        for (int i = characterClassIndexes.size()-1; i > 0; i--){
                            if(first)
                                first = false;
                            else
                                str.write(" | ");
                            str.write("(bit%d << %d)".formatted(i, i));
                        }
                        str.write(");\n");
                    }else {
                        str.write("\tres = (");
                        boolean first = true;
                        for (int i = characterClassIndexes.size()-1; i > 0; i--){
                            if(first)
                                first = false;
                            else
                                str.write(", ");
                            str.write("bit%d".formatted(i));
                        }
                        str.write(");\n");
                    }
                }



                //TODO write software version
            }

            str.write("\n\treturn res;\n");
            str.write("}\n\n");
        }
        else {
            str.write("static const %s rule%dDecoder[256]{\n\t".formatted(returnType, ruleID));

            for (int i = 0; i < matrix.length; i++){
                str.write("%d, ".formatted(matrix[i]));
                if((i+1) % 32 == 0)
                    str.write("\n\t");
            }

            str.write("\n};\n\n");

        }
        return str.toString();
    }
}