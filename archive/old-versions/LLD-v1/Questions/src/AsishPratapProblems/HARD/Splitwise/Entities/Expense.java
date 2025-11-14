package AsishPratapProblems.HARD.Splitwise.Entities;

import AsishPratapProblems.HARD.Splitwise.Enums.SplitType;

import java.util.List;
import java.util.Map;

public class Expense {
    private final String id;
    private final User paidBy;
    private final List<IndividualExpense> splitAmount;
    private final double totalAmount;
    private final SplitType splitType;

    public Expense(String id, User paidBy, List<IndividualExpense> splitAmount, double totalAmount, SplitType splitType) {
        this.id = id;
        this.paidBy = paidBy;
        this.splitAmount = splitAmount;
        this.totalAmount = totalAmount;
        this.splitType = splitType;
    }

    public String getId() {
        return id;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public List<IndividualExpense> getSplitAmount() {
        return splitAmount;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public SplitType getSplitType() {
        return splitType;
    }

    // make changes here
    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", paidBy=" + paidBy +
                ", splitAmount=" + splitAmount +
                ", totalAmount=" + totalAmount +
                ", splitType=" + splitType +
                '}';
    }
}
