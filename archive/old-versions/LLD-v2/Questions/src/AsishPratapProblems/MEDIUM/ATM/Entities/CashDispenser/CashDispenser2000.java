package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

import AsishPratapProblems.MEDIUM.ATM.Enums.CashDenomination;

public class CashDispenser2000 extends Handler{

    public CashDispenser2000() {
        super();
        denomination = CashDenomination.TWO_THOUSAND;
    }


    @Override
    protected void dispenseCash(int amount) {
        super.dispenseCash(amount);
    }
}
