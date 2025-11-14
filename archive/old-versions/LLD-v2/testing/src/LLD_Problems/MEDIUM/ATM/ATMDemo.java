package LLD_Problems.MEDIUM.ATM;

import LLD_Problems.MEDIUM.ATM.Banks.Bank;
import LLD_Problems.MEDIUM.ATM.Banks.SBIBank;

public class ATMDemo {
    public static void main(String[] args){
        Bank bankingService = new SBIBank("SBI Dinanagar");
        Dispenser cashDispenser = new Dispenser(10000);
        ATM atm = new ATM(cashDispenser, bankingService);

        // create a user
        User user1 = new User("Ishan");
        User user2 = new User("Gargi");


        // Create sample accounts
        Account acount1 = bankingService.createAccount(user1);
        Account acount2 = bankingService.createAccount(user2);


        // Perform ATM operations
        Card card = new Card();
        atm.authenticateUser(card);


        try{
            atm.withdraw(acount2.getAccountNumber(), 20);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        atm.deposit(acount2.getAccountNumber(), 20);
        atm.deposit(acount1.getAccountNumber(), 10000);
        double balance = atm.getBalance(acount2.getAccountNumber());
        System.out.println("Account balance: " + balance);

        atm.withdraw(acount2.getAccountNumber(), 20);

        balance = atm.getBalance(acount2.getAccountNumber());
        System.out.println("Updated account balance: " + balance);
    }
}
