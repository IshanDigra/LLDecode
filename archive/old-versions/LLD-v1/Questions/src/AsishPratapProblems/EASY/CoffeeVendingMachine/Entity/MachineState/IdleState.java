package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.Cash;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.Coffee;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.CoffeeMachine;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CoffeeType;

public class IdleState implements MachineState{
    private CoffeeMachine machine;

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
