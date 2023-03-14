package FABuilder.Loops;

import FABuilder.Edge;

public class IterationCountEdgePair {
    IterationCountVar var;
    Edge incomplete;
    Edge complete;

    public IterationCountEdgePair(IterationCountVar var, Edge incomplete, Edge complete){
        this.var = var;
        this.incomplete = incomplete;
        this.complete = complete;
    }

    public IterationCountVar getVar() {
        return var;
    }

    public Edge getIncomplete() {
        return incomplete;
    }

    public Edge getComplete() {
        return complete;
    }
}
