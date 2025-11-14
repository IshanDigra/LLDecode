package AsishPratapProblems.EASY.VendingMachine.V2.Entities.MachineStates;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Money;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Product;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.VendingMachine;

public class IdleState implements VendingMachineState{
    private VendingMachine machine;

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public synchronized void selectProduct(Product product) {
        if(machine.contains(product)){
            System.out.println(product.getName()+" has already been added to cart");
            return;
        }
        if(!machine.isAvailable(product,1)){
            System.out.println(product.getName()+ "is currently out of stock");
            return;
        }
        machine.addProduct(product);
        System.out.println(product.getName()+ " has been added to cart");
    }

    @Override
    public synchronized void deselectProduct(Product product) {
        if(!machine.contains(product)){
            System.out.println(product.getName()+" is not present in cart");
            return;
        }

        machine.removeProduct(product);
        machine.reStock(product, 1);
        System.out.println(product.getName()+ " has been removed from cart");
    }

    @Override
    public void gotoPayment() {
        System.out.println("******Moving to the Payment Interface******");
        machine.setCurrentState(machine.getTransactionState());
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
        System.err.println("Invalid Action");
    }
}
