package CodeGenerator;

import CodeGenerator.Options.CodeGeneratorOptions;
import FABuilder.Loops.IterationCountVar;
import FABuilder.Loops.LoopInteraction;

public class CodeHelper {
    CodeGeneratorOptions options;

    public CodeHelper(CodeGeneratorOptions options){
        this.options = options;
    }

    public String setBit(String var, int bit){
        if(!options.softwareCompile){
            return "%s.set_bit(%d, true)".formatted(var, bit);
        }
        else{
            if(bit == 0){
                return "%s.clear_bit(%d)".formatted(var, bit);
            }
            else{
                return "%s.set_bit(%d)".formatted(var, bit);
            }
            //return "%s |= (1 << %d)".formatted(var, bit);
        }
    }

    public String getBit(String var, int bit){
        return "%s.get_bit(%d)".formatted(var, bit);

        /*if(!options.softwareCompile){
            return "%s.get_bit(%d)".formatted(var, bit);
        }
        else{
            return "(%s & (1 << %d))".formatted(var, bit);
        }*/
    }

    //WIP
    public String varCondition(String repName, LoopInteraction loopInteraction){
        IterationCountVar var = loopInteraction.getVar();

        if(loopInteraction.getInteractionType() == LoopInteraction.InteractionType.incomplete){
            if(var.getVarType() == IterationCountVar.varType.exact ||
                    var.getVarType() == IterationCountVar.varType.bound){
                return "(%s < %d)".formatted(repName, var.getMin());
            }
            else{
                return "";
            }
        }
        else {
            return "";
        }

    }

    public String getAP_UINTExact(int exactBitNumber){
        if(options.softwareCompile){
            if(exactBitNumber < 8)
                return "uint8_t";
            else if(exactBitNumber < 16)
                return "uint16_t";
            else if(exactBitNumber < 32)
                return "uint32_t";
            else if(exactBitNumber < 64)
                return "uint64_t";
            return "ByteArray<%d>".formatted(1 + exactBitNumber/8);
        }
        else {
            return "ap_uint<%d>".formatted(exactBitNumber);
        }
    }

    public String getAP_UINTMaxCapacity(int max){
        int baseVal = 1;
        while ((Math.pow(2, baseVal) - 1) < max){
            baseVal++;
        }

        if(options.softwareCompile){
            if(baseVal < 8)
                return "uint8_t";
            else if(baseVal < 16)
                return "uint16_t";
            else if(baseVal < 32)
                return "uint32_t";
            else if(baseVal < 64)
                return "uint64_t";
            return "ByteArray<%d>".formatted(1 + baseVal/8);
        }
        else {
            return "ap_uint<%d>".formatted(baseVal);
        }
    }

    public String getAP_UINTExactSOFTWARE(int exactBitNumber){
        return "ByteArray<%d>".formatted(1 + exactBitNumber/8);
    }

    public String getAP_UINTMaxCapacitySOFTWARE(int max){
        int baseVal = 1;
        while ((Math.pow(2, baseVal) - 1) < max){
            baseVal++;
        }

        return "ByteArray<%d>".formatted(1 + baseVal/8);
    }
}
