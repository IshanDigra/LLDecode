package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

import AsishPratapProblems.MEDIUM.ATM.Enums.CashDenomination;

public class CashDispenser1 extends Handler{

    public CashDispenser1() {
        super();
        denomination = CashDenomination.ONE;
    }

    @Override
    protected void dispenseCash(int amount) {
        super.dispenseCash(amount);
    }
}
