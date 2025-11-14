package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.Cash;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CoffeeType;

// select coffee, make Payment, dispense coffee, return change,
public interface MachineState {
    public void selectCoffee(CoffeeType coffee);
    public void addCash(Cash cash, int quantity);
    public void makePayment();
    public void dispenseCoffee();
}
