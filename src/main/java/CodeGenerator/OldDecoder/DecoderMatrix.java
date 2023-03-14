package CodeGenerator.OldDecoder;

import java.util.ArrayList;
import java.util.List;

public class DecoderMatrix {
    public final List<DecoderEntry> matrix;

    public DecoderMatrix(){
        matrix = new ArrayList<>();
    }

    void addEntry(DecoderEntry e){
        matrix.add(e);
    }

    void updateEntry(char c, int presence){
        int index = getIndexOf(c);
        if(index == -1) //new character
            addEntry(new DecoderEntry(c, presence));
        else
            matrix.get(index).presenceSet.add(presence);
    }

    void updateEntry(char c, int presence, CharacterClassPresence ccp){
        int index = getIndexOf(c);
        if(index == -1)
            addEntry(new DecoderEntry(c, presence, ccp));
        else {
            matrix.get(index).presenceSet.add(presence);
            matrix.get(index).ccPresenceSet.add(ccp);
        }
    }

    void removeEntry(DecoderEntry e){
        matrix.remove(e);
    }

    public int getIndexOf(char c){
        for (int i = 0; i < matrix.size(); i++) {
            if(matrix.get(i).characterSet.contains(c))
                return i;
        }

        return -1;
    }

    public int getSize(){
        return matrix.size();
    }
}
