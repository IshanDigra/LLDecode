package Problems.HARD.Splitwise.Model;

import Problems.HARD.Splitwise.Model.Split.Split;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Expense {
    private final String id;
    private String description;
    private User paidBy;
    private double amount;
    private final List<Split> splits;

    public Expense(String id, String description, User paidBy, double amount) {
        this.id = id;
        this.description = description;
        this.paidBy = paidBy;
        this.amount = amount;
        splits = new CopyOnWriteArrayList<>();

    }

    public void addSplit(Split split){
        splits.add(split);
    }

    public String getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public void setPaidBy(User paidBy) {
        this.paidBy = paidBy;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public List<Split> getSplits() {
        return splits;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "id='" + id + '\'' +
                ", description='" + description + '\'' +
                ", paidBy=" + paidBy +
                ", amount=" + amount +
                ", splits=" + splits +
                '}';
    }
}
