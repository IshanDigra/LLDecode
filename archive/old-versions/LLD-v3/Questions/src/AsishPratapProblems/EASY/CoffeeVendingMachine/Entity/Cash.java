package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CashType;

public class Cash {
    private final CashType type;
    private double value;

    public Cash(CashType type, double value) {
        this.type = type;
        this.value = value;
    }

    public CashType getType() {
        return type;
    }

    public double getValue() {
        return value;
    }

    public void setValue(double value) {
        this.value = value;
    }


}
