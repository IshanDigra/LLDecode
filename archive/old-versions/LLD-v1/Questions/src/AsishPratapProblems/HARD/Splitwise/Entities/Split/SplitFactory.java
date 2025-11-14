package AsishPratapProblems.HARD.Splitwise.Entities.Split;

import AsishPratapProblems.HARD.Splitwise.Enums.SplitType;

public class SplitFactory {
    public SplitStrategy getStrategy(SplitType type){
        if(type.equals(SplitType.EQUAL)){
            return new EqualSplit();
        }
        else if(type.equals(SplitType.UNEQUAL)){
            return new UnEqualSplit();
        }
        else return new PercentageSplit();
    }
}
