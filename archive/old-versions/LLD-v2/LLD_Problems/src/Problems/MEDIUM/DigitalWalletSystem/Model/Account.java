package Problems.MEDIUM.DigitalWalletSystem.Model;

import Problems.MEDIUM.DigitalWalletSystem.Constant.Currency;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Account {
    private final String id;
    private  final User user;
    private  final String accountNumber;
    private Currency currency;
    private double balance;
    private List<Transaction> transactions;

    public Account(String id, User user, String accountNumber, Currency currency) {
        this.id = id;
        this.user = user;
        this.accountNumber = accountNumber;
        this.currency = currency;
        this.balance = 0.0;
        transactions = new CopyOnWriteArrayList<>();
    }

    // business logic
    public double addFunds(double val){
        balance += val;
        return balance;
    }

    public boolean withdraw(double val) throws Exception {
        if(val>balance){
            throw new Exception("Insuffiecient Funds!");

        }
        else{
            balance -= val;
            return true;
        }

    }

    public synchronized void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }


    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }

    public void setTransactions(List<Transaction> transactions) {
        this.transactions = transactions;
    }
}
