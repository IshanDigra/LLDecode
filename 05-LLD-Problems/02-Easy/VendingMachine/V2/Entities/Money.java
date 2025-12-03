package V2.Entities;


import V2.Enums.MoneyType;

public class Money {
    private final MoneyType type;
    private final double amount;

    public Money(MoneyType type, double amount) {
        this.type = type;
        this.amount = amount;
    }

    public MoneyType getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }
}
