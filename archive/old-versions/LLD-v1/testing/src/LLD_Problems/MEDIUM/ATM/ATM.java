package LLD_Problems.MEDIUM.ATM;

import LLD_Problems.MEDIUM.ATM.Banks.Bank;
import LLD_Problems.MEDIUM.ATM.Transactions.DepositTransaction;
import LLD_Problems.MEDIUM.ATM.Transactions.Transaction;
import LLD_Problems.MEDIUM.ATM.Transactions.WithdrawalTransaction;

import java.util.UUID;

public class ATM {
    private Dispenser dispenser;
    private Bank bank;

    public ATM(Dispenser dispenser, Bank bank) {
        this.dispenser = dispenser;
        this.bank = bank;
    }

    public boolean authenticateUser(Card card){
       boolean check = bank.validation(card);
       if(!check){
           System.out.println("Invalid Pin");
       }
       return check;
    }

    public double getBalance(String accountNumber){
        return bank.getBalance(accountNumber);
    }

    public void withdraw(String accountNumber, double amount){
        Account account = bank.getAccount(accountNumber);
        if(account.getBalance() < amount){
            throw new IllegalArgumentException("Insufficient finds in bank account");
        }
        else{
            String transactionId = generateTransactionId();
            Transaction transaction = new WithdrawalTransaction(transactionId, account, amount);

            bank.processTransaction(transaction);
        }

    }

    public void deposit(String accountNumber, double amount){
        Account account = bank.getAccount(accountNumber);
        String transactionId = generateTransactionId();
        Transaction transaction = new DepositTransaction(transactionId, account, amount);
        bank.processTransaction(transaction);
    }

    private String generateTransactionId(){
        return UUID.randomUUID().toString();
    }
}
