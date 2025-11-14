package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

import AsishPratapProblems.MEDIUM.ATM.Enums.CashDenomination;

public class CashDispenser50 extends Handler{

    public CashDispenser50() {
        super();
        denomination = CashDenomination.FIFTY;
    }

    @Override
    protected void dispenseCash(int amount) {
        super.dispenseCash(amount);
    }
}
