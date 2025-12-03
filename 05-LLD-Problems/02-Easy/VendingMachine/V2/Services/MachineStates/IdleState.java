package V2.Services.MachineStates;


import V2.Entities.Money;
import V2.Entities.Product;
import V2.Services.VendingMachine;

import java.util.logging.Logger;

public class IdleState implements VendingMachineState{
    private final VendingMachine machine;
    private static final Logger logger = Logger.getLogger(IdleState.class.getName());

    public IdleState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public synchronized void selectProduct(Product product) {
        if(machine.contains(product)){
            logger.info(product.getName()+" has already been added to cart");
            return;
        }
        if(!machine.isAvailable(product,1)){
            logger.info(product.getName()+ "is currently out of stock");
            return;
        }
        machine.addProduct(product);
        logger.info(product.getName()+ " has been added to cart");
    }

    @Override
    public synchronized void deselectProduct(Product product) {
        if(!machine.contains(product)){
            logger.info(product.getName()+" is not present in cart");
            return;
        }

        machine.removeProduct(product);
        machine.reStock(product, 1);
        logger.info(product.getName()+ " has been removed from cart");
    }

    @Override
    public void gotoPayment() {
        logger.info("******Moving to the Payment Interface******");
        machine.setCurrentState(machine.getTransactionState());
    }

    @Override
    public void addMoney(Money money) {
        logger.warning("Invalid Action");
    }

    @Override
    public void makePayment() {
        logger.warning("Invalid Action");
    }

    @Override
    public void dispenseProducts() {
        logger.warning("Invalid Action");
    }
}
