package AsishPratapProblems.EASY.VendingMachine.V2.Entities.MachineStates;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Money;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Product;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.VendingMachine;

import java.util.List;

public class DispensingState implements VendingMachineState{
    private VendingMachine machine;

    public DispensingState(VendingMachine machine) {
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
        System.err.println("Invalid Action");
    }

    @Override
    public void makePayment() {
        System.err.println("Invalid Action");
    }

    @Override
    public void dispenseProducts() {
        List<Product> products = machine.getSelectedProducts();
        products.forEach(p->machine.updateQuantity(p,1));
        System.out.println("Products dispensed");
        System.out.println(products);
        machine.getSelectedProducts().clear();
        machine.setAddedAmount(0);
        System.out.println("******** Process Finished - going to idle state **********");
        machine.setCurrentState(machine.getIdleState());
    }
}
