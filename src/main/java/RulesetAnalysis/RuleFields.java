package RulesetAnalysis;

import java.util.HashMap;
import java.util.Map;

public class RuleFields {
    Map<String, Integer> integerFields;
    Map<String, Mean> meanFields;

    RuleFields(){
        integerFields = new HashMap<>();
        meanFields = new HashMap<>();
    }

    RuleFields(Map<String, Integer> integerFields, Map<String, Mean> meanFields){
        this.integerFields = integerFields;
        this.meanFields = meanFields;
    }

    public Map<String, Integer> getIntegerFields() {
        return integerFields;
    }

    public Map<String, Mean> getMeanFields() {
        return meanFields;
    }
}
