package LLD_Problems.MEDIUM.ATM.Banks;

import LLD_Problems.MEDIUM.ATM.Account;
import LLD_Problems.MEDIUM.ATM.Card;
import LLD_Problems.MEDIUM.ATM.Transactions.Transaction;
import LLD_Problems.MEDIUM.ATM.User;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class Bank {
    private String name;
    Map<String, Account> accounts;

    public Bank(String name) {
        this.name = name;
        this.accounts = new ConcurrentHashMap<>();
    }

    public abstract boolean validation(Card card);
    public abstract double getBalance(String accountNumber);
//    public abstract void deposit(Account account, double amount);
//    public abstract void withdraw(Account account, double amount);
    public abstract void processTransaction(Transaction transaction);
    public abstract Account getAccount(String accountNumber);

    public abstract Account  createAccount(User user);
}
