package FABuilder.Loops;

import FABuilder.Edge;

public class RangedQuantifierBranch {
    public Edge edge;
    public IterationCountVar var;
    public RangedQuantifierBranch incompleteBranch = null;
    public RangedQuantifierBranch completeBranch = null;

    public RangedQuantifierBranch(){
    }
}
