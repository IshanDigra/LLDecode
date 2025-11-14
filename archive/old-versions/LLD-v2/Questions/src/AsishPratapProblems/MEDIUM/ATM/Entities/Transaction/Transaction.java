package AsishPratapProblems.MEDIUM.ATM.Entities.Transaction;

import AsishPratapProblems.MEDIUM.ATM.Enums.TransactionType;
import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.UserAccount;

import java.sql.Timestamp;

public abstract class Transaction {
    protected final int transactionId;
    protected final double amount;
    protected final UserAccount account;
    protected final Timestamp timestamp;
    protected final TransactionType type;

    protected Transaction(int transactionId, double amount, UserAccount account, TransactionType type) {
        this.transactionId = transactionId;
        this.amount = amount;
        this.account = account;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.type = type;
    }

    public int getTransactionId() {
        return transactionId;
    }

    public double getAmount() {
        return amount;
    }

    public UserAccount getAccount() {
        return account;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public TransactionType getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionId=" + transactionId +
                ", amount=" + amount +
                ", User=" + account.getUserName() +
                ", timestamp=" + timestamp +
                ", type=" + type +
                '}';
    }
}
