package CodeGenerator.OldDecoder;

import CodeGenerator.CodeGenerator;

public class CharacterClassPresence {
    public int state;
    CharacterClassPresence(int state){
        this.state = state;
    }

    @Override
    public String toString() {
        return "" + state;
    }
}
