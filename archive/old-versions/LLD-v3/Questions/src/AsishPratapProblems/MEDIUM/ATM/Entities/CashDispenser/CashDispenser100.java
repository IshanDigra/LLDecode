package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

import AsishPratapProblems.MEDIUM.ATM.Enums.CashDenomination;

public class CashDispenser100 extends Handler{


    public CashDispenser100() {
        super();
        denomination = CashDenomination.ONE_HUNDRED;
    }

    @Override
    protected void dispenseCash(int amount) {
        super.dispenseCash(amount);
    }
}
