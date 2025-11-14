package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

import AsishPratapProblems.MEDIUM.ATM.Enums.CashDenomination;

public class CashDispenser500 extends Handler{

    public CashDispenser500() {
        super();
        denomination = CashDenomination.FIVE_HUNDRED;
    }

    @Override
    protected void dispenseCash(int amount) {
        super.dispenseCash(amount);
    }
}
