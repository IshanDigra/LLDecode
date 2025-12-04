package V2.Service.MachineState;

import V2.Entity.*;
import V2.Enum.*;
import V2.Service.CoffeeMachine;
import java.util.*;
import java.util.logging.Logger;

public class IdleState implements MachineState{
    private CoffeeMachine machine;
    private static final Logger logger = Logger.getLogger(IdleState.class.getName());
    public IdleState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectCoffee(CoffeeType type) {
        Coffee coffee = machine.getCoffees().get(type);
        machine.setSelectedCoffee(coffee);
        System.out.println(type+" has been added to cart");
        machine.setCurrentState(machine.getTransactionState());
    }

    @Override
    public void addCash(Cash cash, int quantity) {
        System.out.println("Please first select a coffee");
    }

    @Override
    public void makePayment() {
        System.out.println("Please first select a coffee");
    }


    @Override
    public void dispenseCoffee() {
        System.out.println("Please first select a coffee");
    }
}
