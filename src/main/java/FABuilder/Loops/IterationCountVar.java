package FABuilder.Loops;

import FABuilder.Vertex;

import java.util.ArrayList;
import java.util.Objects;

public class IterationCountVar {
    Vertex atomStart;
    ArrayList<String> captureGroups = new ArrayList<>();
    int min, max;

    public enum varType{
        exact, //{3}
        bound, //{3, 6}
        unbound//{3, }
    }

    public IterationCountVar(ArrayList<String> captureGroups, int min, int max){
        this.captureGroups.addAll(captureGroups);
        this.min = min;
        this.max = max;
    }

    public void setAtomStart(Vertex atomStart) {
        this.atomStart = atomStart;
    }

    public Vertex getAtomStart() {
        return atomStart;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        IterationCountVar that = (IterationCountVar) o;
        return Objects.equals(atomStart, that.atomStart)
                && Objects.equals(captureGroups, that.captureGroups)
                && Objects.equals(min, that.min)
                && Objects.equals(max, that.max);
    }

    @Override
    public String toString() {
        StringBuilder representation = new StringBuilder("rep");

        if(min == max){
            representation.append("{").append(min).append("}");
        }
        else if(max == -1){
            representation.append("{").append(min).append(",}");
        }
        else{
            representation.append("{").append(min).append(",").append(max).append("}");
        }

        /*if(captureGroups.size() > 0){
            representation.append("(");
            String first = null;
            for (String group : captureGroups){
                if(first == null)
                    first = group;
                else
                    representation.append(",");

                representation.append(group);
            }
            representation.append(")");
        }*/

        return representation.toString();
    }

    public String variableNameSuffix(){
        StringBuilder representation = new StringBuilder();

        if(min == max){
            representation.append("to").append(min);
        }
        else if(max == -1){
            representation.append("from").append(min);
        }
        else{
            representation.append("from").append(min).append("to").append(max);
        }

        for (String group : captureGroups){
            representation.append("_").append(group);
        }
        return representation.toString();
    }

    public int getMin() {
        return min;
    }

    public int getMax() {
        return max;
    }

    public varType getVarType(){
        if(getMax() == getMin())
            return varType.exact;
        else if(getMax() != -1)
            return varType.bound;
        else
            return varType.unbound;
    }
}
