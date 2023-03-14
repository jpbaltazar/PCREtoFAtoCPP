package CodeGenerator.NewNewDecoder;

import FABuilder.Edge;

import java.util.ArrayList;
import java.util.TreeSet;

import static FABuilder.Edge.getConditionStr;
import static FABuilder.Edge.parseCondition;

public class Condition {
    boolean negativeConditions;
    ArrayList<String> conditions = new ArrayList<>();

    Condition(Edge e){
        negativeConditions = e.negativeConditions;
        conditions.addAll(e.conditions);
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
        TreeSet<String> removed = new TreeSet<>();

        for (String condition : set){
            if(!removed.contains(condition)){
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


    public ArrayList<String> getConditions() {
        return conditions;
    }

    public boolean isNegativeConditions() {
        return negativeConditions;
    }
}
