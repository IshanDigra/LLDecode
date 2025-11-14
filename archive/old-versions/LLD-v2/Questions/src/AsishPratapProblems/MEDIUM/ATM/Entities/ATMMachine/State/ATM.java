package AsishPratapProblems.MEDIUM.ATM.Entities.ATMMachine.State;

import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.Bank;
import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.UserAccount;
import AsishPratapProblems.MEDIUM.ATM.Entities.Card;
import AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser.CashDispenser;

public class ATM implements State {
    // CashDispenser handles cash withdrawal (Chain of Responsibility)
    protected CashDispenser cashDispenser;
    // Bank server for account validation and transactions
    protected Bank bankServer;
    // Current state of the ATM (Idle or Running)
    protected State currentState;
    protected State idleState;
    protected State runningState;
    // Currently authenticated user account
    protected UserAccount account;

    /* ideally speaking bank and cashDispenser are independent
    Objects that are passed to the ATM constructor
    */

    public ATM(CashDispenser cashDispenser, Bank bankServer) {
        this.cashDispenser = cashDispenser;
        this.bankServer = bankServer;
        idleState = new IdleState(this);
        runningState = new RunningState(this);
        currentState = idleState;
    }

    @Override
    public void authenticateCredentials(Card card, String pin) {
        currentState.authenticateCredentials(card, pin);
    }

    @Override
    public void viewBalance() {
        currentState.viewBalance();
    }

    @Override
    public void withdrawCash(double amount) {
        currentState.withdrawCash(amount);
    }

    @Override
    public void depositCash(double amount) {
        currentState.depositCash(amount);
    }


    @Override
    public void viewTransactionHistory() {
        currentState.viewTransactionHistory();
    }

    protected CashDispenser getCashDispenser() {
        return cashDispenser;
    }

    protected Bank getBankServer() {
        return bankServer;
    }

    protected UserAccount getAccount() {
        return account;
    }

    protected void setAccount(UserAccount account) {
        this.account = account;
    }

    protected void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    protected State getIdleState() {
        return idleState;
    }

    protected State getRunningState() {
        return runningState;
    }
}
