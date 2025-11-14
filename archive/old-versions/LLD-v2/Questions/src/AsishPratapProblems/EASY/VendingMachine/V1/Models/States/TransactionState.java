package AsishPratapProblems.EASY.VendingMachine.V1.Models.States;

import AsishPratapProblems.EASY.VendingMachine.V1.Models.Cash;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.VendingMachine;

public class TransactionState implements VendingMachineState{
    private VendingMachine vendingMachine;

    public TransactionState(VendingMachine vendingMachine) {
        this.vendingMachine = vendingMachine;
    }

    @Override
    public void selectProduct(String id) {
        System.out.println("The product is already selected");
    }

    @Override
    public void resetProduct() {
        vendingMachine.setCurrentState(vendingMachine.getIdleState());
        System.out.println("The selected product "+ vendingMachine.getSelectedProduct().getName() +" has been removed.");
    }

    @Override
    public void addCash(Cash cash, int quantity) {
        int amount = cash.getValue()*quantity;
        vendingMachine.setTotalAmount(amount);
        System.out.println("Cash Amount of "+amount+" has been added to your digitalWallet.");
    }

    @Override
    public void makePayment() {
        double amountRequired = vendingMachine.getSelectedProduct().getPrice() - vendingMachine.getTotalAmount();
        if(amountRequired>0){
            System.out.println("Insufficient Amount. Require atleast $"+amountRequired+" more");
            return ;
        }
        else{
            processPayment(amountRequired);
        }
    }

    private void processPayment(double amount){
        System.out.println("The payment has been processed.");
        returnChange(amount);
    }

    @Override
    public void dispenseProduct() {
        System.out.println("Please make payment first");
    }

    private void returnChange(double amount) {
        vendingMachine.setTotalAmount(0.0);
        System.out.println("Change amount of $"+-1*amount+" has been returned");
        vendingMachine.setCurrentState(vendingMachine.getDispensingState());
    }
}
