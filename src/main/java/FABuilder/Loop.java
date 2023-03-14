package FABuilder;

import java.util.ArrayList;
import java.util.Objects;
import java.util.TreeSet;

public class Loop {
    public int minimum;
    public int maximum;
    public Vertex loopRef;
    public TreeSet<String> captureGroups;
    public boolean isIterationAndNotExit;
    public Edge complementarEdge;

    Loop(int minimum, int maximum, Vertex loopRef, TreeSet<String> captureGroups, boolean isIterationAndNotExit){
        this.minimum  = minimum;
        this.maximum = maximum;

        this.loopRef = loopRef;
        this.captureGroups = (TreeSet<String>) captureGroups.clone();
        this.isIterationAndNotExit = isIterationAndNotExit;
    }
    Loop(int minimum, int maximum, Vertex loopRef, TreeSet<String> captureGroups, boolean isIterationAndNotExit, Edge complementarEdge){
        this(minimum, maximum, loopRef, captureGroups, isIterationAndNotExit);
        this.complementarEdge = complementarEdge;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Loop loop = (Loop) o;
        return minimum == loop.minimum && maximum == loop.maximum && isIterationAndNotExit == loop.isIterationAndNotExit && Objects.equals(loopRef, loop.loopRef);
    }

    @Override
    public int hashCode() {
        return Objects.hash(minimum, maximum, loopRef, isIterationAndNotExit);
    }
}
