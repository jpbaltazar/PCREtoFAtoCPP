package RulesetAnalysis;

public class Mean {
    double totalValue;
    int count;

    Mean(){
        totalValue = 0;
        count = 0;
    }

    Mean(int value){
        totalValue = value;
        count = 1;
    }

    public void add(double value){
        totalValue += value;
        count++;
    }

    public void add(int value){
        totalValue += value;
        count++;
    }

    public double getMean(){
        if(count != 0)
            return totalValue/count;
        return 0;
    }

    @Override
    public String toString() {
        return "%.3f".formatted(getMean());
    }
}
