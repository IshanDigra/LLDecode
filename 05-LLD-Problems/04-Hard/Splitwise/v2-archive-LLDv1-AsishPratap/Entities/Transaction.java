package AsishPratapProblems.HARD.Splitwise.Entities;

import java.sql.Timestamp;

public class Transaction {
    private final String id;
    private final User paidBy;
    private final User paidTo;
    private final double amount;
    private final Timestamp time;

    public Transaction(String id, User paidBy, User paidTo, double amount) {
        this.id = id;
        this.paidBy = paidBy;
        this.paidTo = paidTo;
        this.amount = amount;
        this.time = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public User getPaidBy() {
        return paidBy;
    }

    public User getPaidTo() {
        return paidTo;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", paidBy=" + paidBy +
                ", paidTo=" + paidTo +
                ", amount=" + amount +
                ", time=" + time +
                '}';
    }
}
