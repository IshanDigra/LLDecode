package AsishPratapProblems.EASY.VendingMachine.V2.Entities.MachineStates;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Money;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Product;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.VendingMachine;

public class TransactionState implements VendingMachineState{
    private VendingMachine machine;

    public TransactionState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        System.err.println("Invalid Action");
    }

    @Override
    public void deselectProduct(Product product) {
        System.err.println("Invalid Action");
    }

    @Override
    public void gotoPayment() {
        System.err.println("Invalid Action");
    }

    @Override
    public void addMoney(Money money) {
        machine.addWalletMoney(money);
    }

    @Override
    public synchronized void makePayment() {
        double amount = machine.getSelectedProducts().stream().map(p->p.getPrice()).reduce(0.0,(a,b)->a+b);
        double change = amount-machine.getAddedAmount();
        if(machine.getAddedAmount() < amount){
            System.out.println("Please add atleast "+ (change)+ "$ to procced ahead");
            return;
        }
        System.out.println("Payment amount of "+ amount+" has been processed. Please collect your change of "+ -1*change);
        System.out.println("******** Dispensing Products **********");
        machine.setCurrentState(machine.getDispensingState());
    }

    @Override
    public void dispenseProducts() {
        System.err.println("Invalid Action");
    }
}
