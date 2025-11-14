package AsishPratapProblems.EASY.VendingMachine.V1.Models.States;

import AsishPratapProblems.EASY.VendingMachine.V1.Models.Cash;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.VendingMachine;

public class IdleState implements VendingMachineState{
    VendingMachine vendingMachine;

    public IdleState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String id) {
        vendingMachine.setSelectedProduct(vendingMachine.getInventory().getProduct(id));
        System.out.println(vendingMachine.getSelectedProduct().getName()+" has been added to cart.");
        vendingMachine.setCurrentState(vendingMachine.getTrasactionState());
    }

    @Override
    public void resetProduct() {
        System.out.println("Your cart is already empty");
    }

    @Override
    public void addCash(Cash cash, int quantity) {
        System.out.println("Please select a product first");
    }

    @Override
    public void makePayment() {
        System.out.println("Please select a product first");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please select a product first");
    }
}
