package LLD_Problems.MEDIUM.ATM.Banks;

import LLD_Problems.MEDIUM.ATM.Account;
import LLD_Problems.MEDIUM.ATM.Card;
import LLD_Problems.MEDIUM.ATM.Transactions.Transaction;
import LLD_Problems.MEDIUM.ATM.User;

import java.util.HashMap;
import java.util.Map;

public class SBIBank extends Bank{
    private String name;
    private Map<String, Account> accounts;

    public SBIBank(String name) {
        super(name);
        accounts = new HashMap<>();
    }

    // how
    @Override
    public boolean validation(Card card) {
        return true;
    }

    @Override
    public double getBalance(String accountNumber) {
        return accounts.get(accountNumber).getBalance();
    }

    @Override
    public void processTransaction(Transaction transaction) {
        transaction.execute();
    }

    @Override
    public Account getAccount(String accountNumber) {
        return accounts.get(accountNumber);
    }

    @Override
    public Account createAccount(User user) {
        Account account = new Account(user);
        accounts.put(account.getAccountNumber(), account);
        return account;
    }
}
