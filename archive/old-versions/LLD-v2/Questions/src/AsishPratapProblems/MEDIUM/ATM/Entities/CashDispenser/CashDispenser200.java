package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

import AsishPratapProblems.MEDIUM.ATM.Enums.CashDenomination;

public class CashDispenser200 extends Handler{

    public CashDispenser200() {
        super();
        denomination = CashDenomination.TWO_HUNDRED;
    }

    @Override
    protected void dispenseCash(int amount) {
        super.dispenseCash(amount);
    }
}
