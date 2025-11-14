package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.Cash;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.CoffeeMachine;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CoffeeType;

public class DispenseState implements MachineState{
    private CoffeeMachine machine;

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
