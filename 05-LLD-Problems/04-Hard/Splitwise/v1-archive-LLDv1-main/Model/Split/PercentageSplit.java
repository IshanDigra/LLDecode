package Problems.HARD.Splitwise.Model.Split;

import Problems.HARD.Splitwise.Model.User;

public class PercentageSplit extends Split {
    private final double percent;

    public PercentageSplit(User user, double percent) {
        super(user);
        this.percent = percent;
    }

    @Override
    public double getAmount() {
        return amount;
    }

    public double getPercent() {
        return percent;
    }
}
