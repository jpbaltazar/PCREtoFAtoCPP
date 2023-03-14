package FABuilder.NewDisambiguator;

import FABuilder.Edge;
import FABuilder.Loops.IterationCountVar;
import FABuilder.Loops.LoopInteraction;
import FABuilder.Loops.VarInteraction;

import java.util.*;

public class Transition {
    public String condition;
    public boolean negativeConditions;

    public TreeSet<String> captureGroups = new TreeSet<>();

    public boolean isBackreference;

    public List<VarInteraction> varIncrements = new LinkedList<>();
    public ArrayList<LoopInteraction> loopInteractions = new ArrayList<>();


    //does not copy transitions
    private Transition(Edge e){
        negativeConditions = e.negativeConditions;
        captureGroups.addAll(e.captureGroups);
        isBackreference = e.isBackreference; //supposedly false
        if(isBackreference)
            condition = e.conditions.get(0);

        varIncrements.addAll(e.varInteractions);
        loopInteractions.addAll(e.loopInteractions);
    }

    Transition(Transition t){
        condition = t.condition;
        negativeConditions = t.negativeConditions;
        captureGroups.addAll(t.captureGroups);
        isBackreference = t.isBackreference;

        varIncrements.addAll(t.varIncrements);
        loopInteractions.addAll(t.loopInteractions);
    }

    Transition(Transition t, String condition){
        this.condition = condition;
        negativeConditions = t.negativeConditions;
        captureGroups.addAll(t.captureGroups);
        isBackreference = t.isBackreference;

        varIncrements.addAll(t.varIncrements);
        loopInteractions.addAll(t.loopInteractions);
    }

    boolean isStackableTo(Edge e){
        return e.loopInteractions.equals(this.loopInteractions) && e.varInteractions.equals(this.varIncrements) && !this.isBackreference && !e.isBackreference;
    }

    Edge toEdge(){
        Edge e = new Edge();
        e.conditions.add("" + condition);
        e.captureGroups.addAll(captureGroups);
        e.isBackreference = isBackreference;

        e.varInteractions.addAll(varIncrements);
        e.loopInteractions.addAll(loopInteractions);

        return e;
    }

    static Set<Transition> EdgeToTransitionSet(Edge e){
        Set<Transition> set = new HashSet<>();

        if(!e.isBackreference){
            if(e.negativeConditions)
                e.invertConditionNaming();

            Transition baseT = new Transition(e);
            ArrayList<String> conditions = e.conditions;

            for (String condition : conditions){
                int[] startStop = Edge.parseCondition(condition);

                for (int i = startStop[0]; i <= startStop[1]; i++) {
                    set.add(new Transition(baseT, "" + (char)i));
                }
            }
        }
        else
            set.add(new Transition(e));

        return set;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transition that = (Transition) o;
        //capture groups and varIncrements should not be compared and should be merged with edge, not sure how I'm gonna get the key tho
        return condition.equals(that.condition) && negativeConditions == that.negativeConditions && isBackreference == that.isBackreference && Objects.equals(loopInteractions, that.loopInteractions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(condition, negativeConditions, isBackreference, loopInteractions);
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

            representation.append(")\n");
        }

        if(isBackreference){
            representation.append("BackRef: (").append(condition).append(")"); //can only have one
        }
        else{
            representation.append(condition);
        }

        if(loopInteractions.size()>0){
            for (LoopInteraction l : loopInteractions){
                representation.append("\n").append(l.toString());
            }
        }

        if(varIncrements.size() > 0){
            for (VarInteraction i : varIncrements){
                representation.append("\n").append(i.toString());
            }
        }

        return representation.toString();
    }
}
