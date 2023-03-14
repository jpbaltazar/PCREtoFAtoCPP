package FABuilder;

import FABuilder.Loops.LoopInteraction;
import FABuilder.Loops.VarInteraction;
import org.jgrapht.graph.DefaultEdge;

import java.util.*;

public class Edge extends DefaultEdge implements Comparable{
    public ArrayList<String> conditions;
    public boolean negativeConditions;

    public TreeSet<String> captureGroups;

    public boolean isBackreference;

    public List<VarInteraction> varInteractions = new LinkedList<>();
    public ArrayList<LoopInteraction> loopInteractions = new ArrayList<>();

    public Edge(){
        conditions = new ArrayList<>();
        negativeConditions = false;
        captureGroups = new TreeSet<>();
        isBackreference = false;
    }

    public Edge(String condition){
        this();

        if(!condition.equals(""))
            conditions.add(condition);
    }

    public Edge(ArrayList<String> conditions){
        this();

        this.conditions = conditions;
    }

    public Edge(Edge e){
        this();
        this.negativeConditions = e.negativeConditions;
        this.conditions.addAll(e.conditions);
        this.captureGroups.addAll(e.captureGroups);
        this.isBackreference = e.isBackreference;

        this.varInteractions.addAll(e.varInteractions);
        this.loopInteractions.addAll(e.loopInteractions);
    }

    public static String getConditionStr(int start, int stop){
        String str;

        if(start >= 33 && start <= 126) //all readable chars
            str = "" + (char)start;
        else{
            str = String.format("\\x%02X", start);
        }

        if(start != stop){
            str +=  "-" + ((stop >= 33 && stop <= 126)? "" +  (char)stop : String.format("\\x%02X", stop));
        }

        return str;
    }

    public static int parseCc_literal(String literal){
        if(literal.length() == 1) // 'a'
            return literal.charAt(0);
        else // '\x00'
            return Integer.parseInt(literal.substring(2, 4),16);

    }

    public static int[] parseCondition(String condition){
        //only supports hexa and ASCII characters
        String[] parts;
        if(condition.equals("-")){
            parts = new String[]{condition};
        }
        else if(condition.startsWith("-") || condition.endsWith("-")){
            parts = new String[]{"", ""};

            String[] split = condition.split("-");

            if(condition.startsWith("-")){
                parts[0] = "-";
                parts[1] = split[split.length - 1];
            }

            if(condition.endsWith("-")){
                parts[1] = "-";

                if(parts[0].equals(""))
                    parts[0] = split[0];
            }
        }
        else{
            parts = condition.split("-");
        }


        if(parts.length == 1)
            return new int[]{parseCc_literal(parts[0]), parseCc_literal(parts[0])};
        else
            return new int[]{parseCc_literal(parts[0]), parseCc_literal(parts[1])};
    }

    public void invertConditionNaming(){
        simplifyConditions();//guarantees order in the conditions
        ArrayList<String> newConditions = new ArrayList<>();
        int start = 0, stop;
        for (String condition : conditions){
            int[] startStop = parseCondition(condition);
            if(startStop[0] > start){
                stop = startStop[0]-1;

                newConditions.add(getConditionStr(start, stop));
            }
            start = startStop[1]+1; //will never try to get values outside
        }
        if(start < 256){
            stop = 255;
            newConditions.add(getConditionStr(start, stop));
        }

        negativeConditions = !negativeConditions; //invert polarity
        conditions = newConditions;
    }

    public void simplifyConditions(){ //TODO fix
        if(conditions.size() == 0 || conditions.size() == 1)
            return;

        TreeSet<String> set = new TreeSet<>(conditions);
        conditions.clear();
        TreeSet<String> removed = new TreeSet<>(); //exists to remove later

        for (String condition : set){
            if(!removed.contains(condition)){
                //get start/stop of condition
                int[] conditionStartStop = parseCondition(condition);
                int conditionStart = conditionStartStop[0];
                int conditionStop = conditionStartStop[1];

                removed.add(condition);

                for (String condition2 : set){
                    if(!removed.contains(condition2)){
                        int[] condition2StartStop = parseCondition(condition2);
                        int condition2Start = condition2StartStop[0];
                        int condition2Stop = condition2StartStop[1];

                        if(!(((conditionStart < condition2Start) && (conditionStop+1 < condition2Start)) ||
                                ((conditionStart-1 > condition2Stop) && (conditionStop > condition2Stop)))){
                            removed.add(condition2);

                            conditionStart = Math.min(conditionStart, condition2Start);
                            conditionStop = Math.max(conditionStop, condition2Stop);
                        }
                    }
                }
                conditions.add(getConditionStr(conditionStart, conditionStop));
            }
        }
    }

        @Override
    public String toString() {
        StringBuilder representation = new StringBuilder();

        if(captureGroups.size() > 0){
            representation.append(" (");

            String first = null;
            for (String group : captureGroups){
                if (first == null){
                    first = group;
                }
                else
                    representation.append(", ");

                representation.append(group);
            }

            representation.append(") ");
        }

        if(isBackreference){
            representation.append("BackRef: (").append(conditions.get(0)).append(")"); //can only have one
        }
        else{
            switch (conditions.size()){
                case 0 -> representation.append(" ");
                case 1 -> representation.append(negativeConditions ? "^/" : "/").append(conditions.get(0)).append("/");
                default -> {
                    representation.append(negativeConditions ? "[^" : "[");
                    for (String c : conditions){
                        representation.append(c);
                    }
                    representation.append("]");
                }
            }


        }

        if(loopInteractions.size()>0){
            for (LoopInteraction l : loopInteractions){
                representation.append(" ").append(l.toString());
            }
        }

        if(varInteractions.size() > 0){
            simplifyVarInteractions();

            for (VarInteraction i : varInteractions){
                representation.append(" ").append(i.var.toString()).append(i.toString());
            }
        }

        return representation.toString();
    }

    public String varInteractionsToString(){
        StringBuilder representation = new StringBuilder();

        if(varInteractions.size() > 0){
            simplifyVarInteractions();

            for (VarInteraction i : varInteractions){
                representation.append(" ").append(i.toString());//.append(i."++");
            }
        }

        return representation.toString();
    }

    public boolean isSimilar(Edge e){
        if(negativeConditions)
            invertConditionNaming();

        if(e.negativeConditions)
            e.invertConditionNaming();

        return conditions.equals(e.conditions) && loopInteractions.equals(e.loopInteractions) && varInteractions.equals(e.varInteractions);
    }

    public static ArrayList<String> intersectionConditions(ArrayList<String> c1, ArrayList<String> c2){
        Set<Character> c1Set = new TreeSet<>(), c2Set = new TreeSet<>();

        Set<Character> intersection = new TreeSet<>();

        for (String condition : c1){
            int[] startStop = parseCondition(condition);

            for (int i = startStop[0]; i <= startStop[1]; i++)
                c1Set.add((char)i);
        }

        for (String condition : c2){
            int[] startStop = parseCondition(condition);

            for (int i = startStop[0]; i <= startStop[1]; i++)
                c2Set.add((char)i);
        }

        Set<Character> biggerSet, smallerSet;

        if(c1Set.size() < c2Set.size()){
            biggerSet = c2Set;
            smallerSet = c1Set;
        }
        else{
            biggerSet = c1Set;
            smallerSet = c2Set;
        }

        for (Character c : smallerSet){
            if(biggerSet.contains(c))
                intersection.add(c);

        }

        ArrayList<String> intersectionConditions = new ArrayList<>();

        int start = -1;
        int stop = start;
        for (int i = 0; i < intersection.size(); i++){
            if(start == -1){
                start = (char)intersection.toArray()[i];
                stop = start;
            }

            if((i+1 == intersection.size()) || (char)intersection.toArray()[i+1] != ((char)(intersection.toArray()[i])+1)){
                intersectionConditions.add(Edge.getConditionStr(start, stop));

                start = -1;
                stop = start;
            }
            else
                stop++;
        }

        return intersectionConditions;
    }

    public boolean containsConditionsOf(Edge e){
        //If any conditions with intersections
        Set<Character> characterSet = new TreeSet<>(), eCharacterSet = new TreeSet<>();

        for (String condition : conditions){
            int[] startStop = parseCondition(condition);

            for (int i = startStop[0]; i <= startStop[1]; i++)
                characterSet.add((char)i);
        }

        for (String condition : e.conditions){
            int[] startStop = parseCondition(condition);

            for (int i = startStop[0]; i <= startStop[1]; i++)
                eCharacterSet.add((char)i);
        }

        Set<Character> biggerSet, smallerSet;

        if(characterSet.size() < eCharacterSet.size()){
            biggerSet = eCharacterSet;
            smallerSet = characterSet;
        }
        else{
            biggerSet = characterSet;
            smallerSet = eCharacterSet;
        }

        for (Character c : smallerSet){
            if(!biggerSet.contains(c))
                return false;
        }

        return true;
    }

    public boolean conditionsContainCharacter(Character c){
        boolean contained = false;

        for (String condition : conditions){
            int[] parsedCondition = Edge.parseCondition(condition);

            if(c >= parsedCondition[0] && c <= parsedCondition[1]){
               contained = true;
               break;
            }
        }

        return contained;
    }

    public void simplifyVarInteractions(){
        List<VarInteraction> varInteractionsList = new LinkedList<>();

        for (VarInteraction vI : varInteractions){
            VarInteraction existing = null;
            for (VarInteraction vI2 : varInteractionsList){
                if(vI2.var == vI.var){
                    existing = vI2;
                break;
                }
            }

            if(existing == null){
                varInteractionsList.add(vI);
            }
            else{
                if(vI.interactionType == VarInteraction.InteractionType.set){
                    varInteractionsList.remove(existing);
                    varInteractionsList.add(vI);
                }
                else{ //add
                    existing.value += vI.value;
                }
            }
        }

        varInteractions.clear();
        varInteractions.addAll(varInteractionsList);
    }

    @Override
    public int compareTo(Object o) {

        Edge other = (Edge) o;
        //supposedly useless, but just in case this is used
        //just compares the condition texts
        if(negativeConditions)
            this.invertConditionNaming();

        if(other.negativeConditions)
            this.invertConditionNaming();

        if(conditions.size() < other.conditions.size())
            return -1;
        else if(conditions.size() > other.conditions.size()){
            return 1;
        }
        else{
            for (int i = 0; i < conditions.size(); i++) {
                int comp = conditions.get(i).compareTo(other.conditions.get(i));
                if(comp != 0){
                    return comp;
                }
            }
        }

        //actually useful
        if(this.loopInteractions.size() < other.loopInteractions.size())
            return -1;
        else if(this.loopInteractions.size() > other.loopInteractions.size())
            return 1;
        else {
            boolean thisInteractions =
                    this.loopInteractions.get(this.loopInteractions.size()-1).getInteractionType()
                            == LoopInteraction.InteractionType.incomplete;
            boolean otherInteractions =
                    other.loopInteractions.get(other.loopInteractions.size()-1).getInteractionType()
                            == LoopInteraction.InteractionType.incomplete;

            if(thisInteractions && !otherInteractions){
                return -1;
            }
            else if(!thisInteractions && otherInteractions)
                return 1;
            else
                return 0;
        }
    }
}
