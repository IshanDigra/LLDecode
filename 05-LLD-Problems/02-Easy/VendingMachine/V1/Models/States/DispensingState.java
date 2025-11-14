package AsishPratapProblems.EASY.VendingMachine.V1.Models.States;

import AsishPratapProblems.EASY.VendingMachine.V1.Models.Cash;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.VendingMachine;



public class DispensingState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public DispensingState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String id) {
        System.out.println("Payment has been made please collect your product");
    }

    @Override
    public void resetProduct() {
        System.out.println("Invalid Action");
    }

    @Override
    public void addCash(Cash cash, int quantity) {
        System.out.println("Invalid Action");
    }

    @Override
    public void makePayment() {
        System.out.println("Invalid Action");
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Product Dispensed. Please collect it");
        vendingMachine.getInventory().updateQuantity(vendingMachine.getSelectedProduct().getId(),1);
        vendingMachine.setSelectedProduct(null);
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
    }
}
