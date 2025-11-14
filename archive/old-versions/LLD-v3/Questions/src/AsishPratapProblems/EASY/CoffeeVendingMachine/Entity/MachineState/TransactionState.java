package AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.MachineState;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.Cash;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.CoffeeMachine;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CoffeeType;

public class TransactionState implements MachineState{
    private CoffeeMachine machine;

    public TransactionState(CoffeeMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectCoffee(CoffeeType coffee) {
        System.out.println("Coffee has already been selected");
    }

    @Override
    public void addCash(Cash cash, int quantity){
        double total  = cash.getValue()*quantity;
        machine.setTotal(total);
        System.out.println("Cash amount of "+total+" Rs has been added to digital wallet.");
    }

    @Override
    public void makePayment() {
        double requiredAmount = machine.getSelectedCoffee().getPrice() - machine.getTotal();
        if(requiredAmount>0){
            System.out.println("Insufficient Funds. Please add funds worth of "+requiredAmount+" Rs");
            return;
        }
        processPayment(requiredAmount);
    }
    private void processPayment(double requiredAmount){
        System.out.println("Payment has been processed. Please collect your change while we make your coffee");
        machine.getInventory().updateQuantity(machine.getSelectedCoffee().getRecipe());
        machine.setTotal(0.0);
        returnChange(requiredAmount);
    }
    private void returnChange(double amount){
        System.out.println("Cash amount of "+-1*amount+" Rs has been returned");
        machine.setCurrentState(machine.getDispenseState());
    }

    @Override
    public void dispenseCoffee() {
        System.out.println("Please make payment first");
    }
}
