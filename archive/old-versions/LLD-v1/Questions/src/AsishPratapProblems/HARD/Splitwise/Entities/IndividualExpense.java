package AsishPratapProblems.HARD.Splitwise.Entities;

public class IndividualExpense {
    private User user;
    private double ratio;

    public IndividualExpense(User user) {
        this.user = user;
        ratio = 0;
    }

    public IndividualExpense(User user, double ratio) {
        this.user = user;
        this.ratio = ratio;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public double getRatio() {
        return ratio;
    }

    public void setRatio(double ratio) {
        this.ratio = ratio;
    }

    @Override
    public String toString() {
        return "IndividualExpense{" +
                "user=" + user +
                ", ratio=" + ratio +
                '}';
    }
}
