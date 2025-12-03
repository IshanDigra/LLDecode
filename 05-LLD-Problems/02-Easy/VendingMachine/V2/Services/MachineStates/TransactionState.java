package V2.Services.MachineStates;

import V2.Entities.Money;
import V2.Entities.Product;
import V2.Services.VendingMachine;

import java.util.logging.Logger;

public class TransactionState implements VendingMachineState{
    private final VendingMachine machine;
    private static final Logger logger = Logger.getLogger(TransactionState.class.getName());

    public TransactionState(VendingMachine machine) {
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
        machine.addWalletMoney(money);
    }

    @Override
    public synchronized void makePayment() {
        double amount = machine.getSelectedProducts().stream().map(p->p.getPrice()).reduce(0.0,(a,b)->a+b);
        double change = amount-machine.getAddedAmount();
        if(machine.getAddedAmount() < amount){
            logger.warning("Please add atleast "+ (change)+ "$ to procced ahead");
            return;
        }
        logger.info("Payment amount of "+ amount+" has been processed. Please collect your change of "+ -1*change);
        logger.info("******** Dispensing Products **********");
        machine.setCurrentState(machine.getDispensingState());
    }

    @Override
    public void dispenseProducts() {
        logger.warning("Invalid Action");
    }
}
