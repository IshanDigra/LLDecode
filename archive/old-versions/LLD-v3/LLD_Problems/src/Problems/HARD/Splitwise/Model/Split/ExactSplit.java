package Problems.HARD.Splitwise.Model.Split;

import Problems.HARD.Splitwise.Model.User;

public class ExactSplit extends Split {
    public ExactSplit(User user, double amount) {
        super(user);
        this.amount = amount;
    }

    @Override
    public double getAmount() {
        return amount;
    }
}
