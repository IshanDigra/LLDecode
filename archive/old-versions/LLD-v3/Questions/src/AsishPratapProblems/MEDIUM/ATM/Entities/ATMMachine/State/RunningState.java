package AsishPratapProblems.MEDIUM.ATM.Entities.ATMMachine.State;

import AsishPratapProblems.MEDIUM.ATM.Entities.Card;
import AsishPratapProblems.MEDIUM.ATM.Entities.Transaction.CreditTransaction;
import AsishPratapProblems.MEDIUM.ATM.Entities.Transaction.DebitTransaction;
import AsishPratapProblems.MEDIUM.ATM.Entities.Transaction.Transaction;
import AsishPratapProblems.MEDIUM.ATM.Utils.IdGenerator;

import java.sql.SQLOutput;
import java.util.List;

public class RunningState implements State{
    private final ATM atm;

    public RunningState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void authenticateCredentials(Card card, String pin) {
        System.out.println("Already authenticated. You can perform transactions.");
    }

    @Override
    public void viewBalance() {
        double amount = atm.getBankServer().getBalance(atm.account);
        System.out.println("Your current Balance is : Rs."+ amount);
    }

    @Override
    public void withdrawCash(double amount) {
        Transaction transaction = new DebitTransaction(IdGenerator.generateId(), amount, atm.getAccount());
        boolean check = atm.getBankServer().debitTransaction(atm.getAccount(), transaction);
        if (check) {
            System.out.println("Please collect your cash: Rs." + amount);
            dispenseCash((int)amount);
        }
        atm.setAccount(null);
        atm.setCurrentState(atm.getIdleState());
    }

    @Override
    public void depositCash(double amount) {
        Transaction transaction = new CreditTransaction(IdGenerator.generateId(), amount, atm.getAccount());
        atm.getBankServer().creditTransaction(atm.getAccount(), transaction);
        atm.setAccount(null);
        atm.setCurrentState(atm.getIdleState());

    }


    public void dispenseCash(int amount) {
        atm.getCashDispenser().dispenseCash(amount);
    }

    @Override
    public void viewTransactionHistory() {
        List<Transaction> transactions = atm.getBankServer().getTransactionHistory(atm.getAccount());
        // ideally we should return the transaction list from here. because
        // you need to think interms of backend system interacting with UI.
        // So we need to return the transaction list.
        transactions.forEach(r-> System.out.println(r.toString()));
    }
}
