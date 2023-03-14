package FABuilder.Loops;

public class LoopInteraction {
    IterationCountVar var;
    public enum InteractionType{
        incomplete,
        complete
    }
    InteractionType interactionType;

    public LoopInteraction(IterationCountVar var, InteractionType interactionType){
        this.var = var;
        this.interactionType = interactionType;
    }

    public InteractionType getInteractionType() {
        return interactionType;
    }

    public IterationCountVar getVar() {
        return var;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder(var.toString());
        if(interactionType == InteractionType.incomplete)
            str.append("<").append(var.min);
        else{
            if(var.getVarType() == IterationCountVar.varType.exact)
                str.append("==").append(var.min);
            else if(var.getVarType() == IterationCountVar.varType.bound)
                str.append("<=").append(var.max);
            else
                str.append(">=").append(var.min);
        }

        return str.toString();
    }
}
