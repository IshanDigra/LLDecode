package AsishPratapProblems.EASY.VendingMachine.V1.Models.States;

import AsishPratapProblems.EASY.VendingMachine.V1.Models.Cash;

public interface VendingMachineState {
    public void selectProduct(String id);
    public void resetProduct();
    public void addCash(Cash cash, int quantity);
    public void makePayment();

    public void dispenseProduct();
}
