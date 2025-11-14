package AsishPratapProblems.MEDIUM.ATM.Entities.Bank;

import AsishPratapProblems.MEDIUM.ATM.Entities.Card;

public class UserAccount {
    private final String userName;
    private String pin;
    private final Card card;
    private double balance;

    public UserAccount(String userName, String pin, Card card) {
        this.userName = userName;
        this.pin = pin;
        this.card = card;
        this.balance = 0.0; // Initial balance is set to 0
    }

    protected void setPin(String pin) {
        this.pin = pin;
    }

    protected void makeDeposit(double amount){
        this.balance += amount;
        System.out.println("Deposit of Rs." + amount+ " Successful!");
    }

    protected void makeWithdraw(double amount){
        if(amount <= balance){
            balance -= amount;
            System.out.println("Withdrawal of Rs." + amount + " Successful!");
        }
        else{
            System.out.println("Insufficient balance!");
        }
    }

    protected Card getCard(){
        return card;
    }

    protected String getPin(){
        return pin;
    }

    protected double getBalance() {
        return balance;
    }

    public String getUserName() {
        return userName;
    }


}
