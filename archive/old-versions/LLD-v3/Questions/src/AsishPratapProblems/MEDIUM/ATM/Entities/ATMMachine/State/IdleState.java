package AsishPratapProblems.MEDIUM.ATM.Entities.ATMMachine.State;

import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.UserAccount;
import AsishPratapProblems.MEDIUM.ATM.Entities.Card;

public class IdleState implements State{
    private final ATM atm;

    public IdleState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void authenticateCredentials(Card card, String pin) {
        UserAccount account = atm.getBankServer().validateCredentials(card, pin);
        if (account != null) {
            atm.setAccount(account);
            atm.setCurrentState(atm.getRunningState());
            System.out.println("Authentication successful. Welcome " + account.getUserName());
        } else {
            System.out.println("Invalid credentials. Please try again.");
        }
    }

    @Override
    public void viewBalance() {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void withdrawCash(double amount) {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void depositCash(double amount) {
        System.out.println("Please authenticate first.");
    }


    public void dispenseCash() {
        System.out.println("Please authenticate first.");
    }

    @Override
    public void viewTransactionHistory() {
        System.out.println("Please authenticate first.");
    }
}
