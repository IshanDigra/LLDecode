package AsishPratapProblems.EASY.VendingMachine.V1.Models;

import AsishPratapProblems.EASY.VendingMachine.V1.Enums.CashType;

public class Cash {
    private CashType cashType;
    private int value;

    public Cash(CashType cashType, int value) {
        this.cashType = cashType;
        this.value = value;
    }

    public CashType getCashType() {
        return cashType;
    }

    public void setCashType(CashType cashType) {
        this.cashType = cashType;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }
}
