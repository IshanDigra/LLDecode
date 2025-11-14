package LLD_Problems.MEDIUM.ATM;

import java.util.UUID;

public class Account {
    private  String accountNumber;
    private final User user;
    //private final Card card;
    private double balance;

    public Account(User user) {
        this.user = user;
        accountNumber = UUID.randomUUID().toString();
        //card = new Card();
        balance = 0.0;
    }

    // getters
    public User getUser(){return user;}
    //public Card getCard(){return card; }
    public double getBalance(){return balance;}
    public String getAccountNumber(){return accountNumber; }

    // setters

    // Other functions
    public void debitMoney(double amount){
        balance -= amount;
    }

    public void creditMoney(double amount){
        balance += amount;
    }
}
