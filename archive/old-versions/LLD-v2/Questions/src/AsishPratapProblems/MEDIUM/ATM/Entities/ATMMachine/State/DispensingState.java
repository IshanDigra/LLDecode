package AsishPratapProblems.MEDIUM.ATM.Entities.ATMMachine.State;

import AsishPratapProblems.MEDIUM.ATM.Entities.Card;

public class DispensingState implements State{
    private final ATM atm;

    public DispensingState(ATM atm) {
        this.atm = atm;
    }

    @Override
    public void authenticateCredentials(Card card, String pin) {

    }

    @Override
    public void viewBalance() {

    }

    @Override
    public void withdrawCash(double amount) {

    }

    @Override
    public void depositCash(double amount) {

    }


    @Override
    public void viewTransactionHistory() {

    }
}
