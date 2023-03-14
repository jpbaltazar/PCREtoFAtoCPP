package CodeGenerator.OldDecoder;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class DecoderEntry{
    Set<Character> characterSet = new TreeSet<>();
    Set<Integer> presenceSet = new TreeSet<>();
    Set<CharacterClassPresence> ccPresenceSet = new HashSet<>();

    DecoderEntry(char c, int presence){
        characterSet.add(c);
        presenceSet.add(presence);
    }

    DecoderEntry(char c, int presence, CharacterClassPresence ccp){
        this(c, presence);
        ccPresenceSet.add(ccp);
    }

    DecoderEntry(Set<Character> characterSet, Set<Integer> presenceSet){
        this.characterSet = characterSet;
        this.presenceSet = presenceSet;
    }

    //ccPresence no longer matters
    void Merge(DecoderEntry entry){
        characterSet.addAll(entry.characterSet);
        presenceSet.addAll(entry.presenceSet);
    }

    boolean compatible(DecoderEntry entry){
        for (int presence : entry.presenceSet){
            if(presenceSet.contains(presence)){
                boolean inSameCC = false;
                if(entry.ccPresenceSet.size() > 0){
                   for (CharacterClassPresence ccp : entry.ccPresenceSet){
                       if(ccp.state == presence && ccPresenceSet.contains(ccp)){
                           inSameCC = true;
                           break;
                       }
                   }
               }

               if(!inSameCC)
                   return false;
            }
            else
                return false;
        }

        return true;
    }

    @Override
    public String toString() {
        return "(/" +  characterSet + "/ , " + presenceSet + " , " + ccPresenceSet + ")";
    }
}
