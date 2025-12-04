package V2.Entity;

import V2.Enum.*;
import java.util.*;

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
