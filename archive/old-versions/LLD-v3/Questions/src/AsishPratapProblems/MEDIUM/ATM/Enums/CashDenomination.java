package AsishPratapProblems.MEDIUM.ATM.Enums;

public enum CashDenomination {
    TWO_THOUSAND(2000), FIVE_HUNDRED(500),
    TWO_HUNDRED(200), ONE_HUNDRED(100),
    FIFTY(50), TEN(10), ONE(1);

    private int value;

    CashDenomination(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
