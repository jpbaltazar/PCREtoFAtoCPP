package FABuilder.Loops;

public class VarInteraction {
    public enum InteractionType {
        add,
        set
    }

    public IterationCountVar var;
    public InteractionType interactionType;
    public int value;

    public VarInteraction(IterationCountVar var, InteractionType interactionType, int value) {
        this.var = var;
        this.interactionType = interactionType;
        this.value = value;
    }

    public VarInteraction(VarInteraction varInteraction) {
        this.var = varInteraction.var;
        this.interactionType = varInteraction.interactionType;
        this.value = varInteraction.value;
    }

    @Override
    public String toString() {
        StringBuilder representation = new StringBuilder();
        if(interactionType == VarInteraction.InteractionType.set){
            representation.append(" = %d".formatted(value));
        }
        else{
            if(value != 1)
                representation.append(" += %d".formatted(value));
            else
                representation.append("++");
        }

        return representation.toString();
    }
}
