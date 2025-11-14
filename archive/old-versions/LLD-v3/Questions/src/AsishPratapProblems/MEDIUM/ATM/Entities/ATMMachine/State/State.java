package AsishPratapProblems.MEDIUM.ATM.Entities.ATMMachine.State;

import AsishPratapProblems.MEDIUM.ATM.Entities.Card;

public interface State {
    public void authenticateCredentials(Card card, String pin);
    public void viewBalance();
    public void withdrawCash(double amount);
    public void depositCash(double amount);
    public void viewTransactionHistory();
}
