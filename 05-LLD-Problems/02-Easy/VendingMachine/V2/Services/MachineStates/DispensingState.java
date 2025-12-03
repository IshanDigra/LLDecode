package V2.Services.MachineStates;


import V2.Entities.Money;
import V2.Entities.Product;
import V2.Services.VendingMachine;

import java.util.List;
import java.util.logging.Logger;

public class DispensingState implements VendingMachineState{
    private final VendingMachine machine;
    private static final Logger logger = Logger.getLogger(DispensingState.class.getName());

    public DispensingState(VendingMachine machine) {
        this.machine = machine;
    }

    @Override
    public void selectProduct(Product product) {
        logger.warning("Invalid Action");
    }

    @Override
    public void deselectProduct(Product product) {
        logger.warning("Invalid Action");
    }

    @Override
    public void gotoPayment() {
        logger.warning("Invalid Action");
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
        List<Product> products = machine.getSelectedProducts();
        products.forEach(p->machine.updateQuantity(p,1));
        logger.info("Products dispensed");
        logger.info(products.toString());
        machine.getSelectedProducts().clear();
        machine.setAddedAmount(0);
        logger.info("******** Process Finished - going to idle state **********");
        machine.setCurrentState(machine.getIdleState());
    }
}
