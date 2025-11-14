package Problems.HARD.Splitwise.Model;

import java.sql.Timestamp;

public class Transaction {
    private final String id;
    private final User sender;
    private final User reciever;
    private final double amount;
    private final Timestamp timestamp;

    public Transaction(String id, User sender, User reciever, double amount) {
        this.id = id;
        this.sender = sender;
        this.reciever = reciever;
        this.amount = amount;
        timestamp = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public User getSender() {
        return sender;
    }

    public User getReciever() {
        return reciever;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", sender=" + sender +
                ", reciever=" + reciever +
                ", amount=" + amount +
                ", timestamp=" + timestamp +
                '}';
    }
}
