package V2.Service.MachineState;

import V2.Entity.*;
import V2.Enum.*;
import V2.Service.CoffeeMachine;
import java.util.*;
import java.util.logging.Logger;

// select coffee, make Payment, dispense coffee, return change,
public interface MachineState {
    public void selectCoffee(CoffeeType coffee);
    public void addCash(Cash cash, int quantity);
    public void makePayment();
    public void dispenseCoffee();
}
