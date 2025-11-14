package AsishPratapProblems.MEDIUM.ATM;


import AsishPratapProblems.MEDIUM.ATM.Entities.ATMMachine.State.ATM;
import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.Bank;
import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.UserAccount;
import AsishPratapProblems.MEDIUM.ATM.Entities.Card;
import AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser.CashDispenser;
import AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser.Notification.Amin;

public class Demo {
    public static void main(String[] args) {
        CashDispenser cashDispenser = new CashDispenser();
        Bank bank = new Bank();
        Amin admin = new Amin("Goku");
        cashDispenser.registerObserver(admin);
        Card card = new Card("1234-5678-9101-1121","222","11-10-2030", "Ishan");
        bank.registerUserAccount(new UserAccount("Ishan", "1234", card));
        ATM atm = new ATM(cashDispenser, bank);

        atm.depositCash(100);
        atm.authenticateCredentials(card, "1234");
        atm.viewBalance();
        atm.withdrawCash(50);
        atm.authenticateCredentials(card, "1234");
        atm.depositCash(2700);
        atm.authenticateCredentials(card, "1234");
        atm.withdrawCash(2661);
        atm.authenticateCredentials(card, "1234");

        atm.viewBalance();
        atm.viewTransactionHistory();

    }
}
