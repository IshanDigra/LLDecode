package Problems.MEDIUM.DigitalWalletSystem.Model;

import Problems.MEDIUM.DigitalWalletSystem.Constant.Currency;

import java.sql.Timestamp;

public class Transaction {
    private final String id;
    private  final Account srcAccount;
    private  final Account destAccount;
    private  final double amount;
    private  final Timestamp time;
    private  final Currency currency;

    public Transaction(String id, Account srcAccount, Account destAccount, double amount, Currency currency) {
        this.id = id;
        this.srcAccount = srcAccount;
        this.destAccount = destAccount;
        this.amount = amount;
        this.time = new Timestamp(System.currentTimeMillis());
        this.currency = currency;
    }

    public String getId() {
        return id;
    }

    public Account getSrcAccount() {
        return srcAccount;
    }

    public Account getDestAccount() {
        return destAccount;
    }

    public double getAmount() {
        return amount;
    }

    public Timestamp getTime() {
        return time;
    }

    public Currency getCurrency() {
        return currency;
    }
}
