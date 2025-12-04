package V2.Service.MachineState;

import V2.Entity.*;
import V2.Enum.*;
import V2.Service.CoffeeMachine;
import java.util.*;
import java.util.logging.Logger;

public class DispenseState implements MachineState{
    private CoffeeMachine machine;
    private static final Logger logger = Logger.getLogger(DispenseState.class.getName());

    public DispenseState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectCoffee(CoffeeType coffee) {

    }

    @Override
    public void addCash(Cash cash, int quantity) {

    }

    @Override
    public void makePayment() {

    }

    @Override
    public void dispenseCoffee() {
        System.out.println("your "+machine.getSelectedCoffee().getType()+ " has been dispensed. Please collect it");
        machine.getInventory().updateQuantity(machine.getSelectedCoffee().getRecipe());
        machine.setSelectedCoffee(null);
        machine.setCurrentState(machine.getIdleState());
    }
}
