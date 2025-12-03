package V2.Services;


import V2.Entities.Money;
import V2.Entities.Notification.Observer;
import V2.Entities.Product;
import V2.Services.MachineStates.DispensingState;
import V2.Services.MachineStates.IdleState;
import V2.Services.MachineStates.TransactionState;
import V2.Services.MachineStates.VendingMachineState;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;


/*
* This object is like the  context for state design pattern
* */
public class VendingMachine implements VendingMachineState {
    private static volatile VendingMachine instance;
    private final InventoryService inventory;
    private List<Product> selectedProducts;
    private double addedAmount;
    private VendingMachineState currentState;
    private IdleState idleState;
    private TransactionState transactionState;
    private DispensingState dispensingState;

    private VendingMachine() {
        // this can be done via constructor injection
        inventory = new InventoryService();

        selectedProducts = new CopyOnWriteArrayList<>();
        addedAmount = 0 ;
        idleState = new IdleState(this);
        transactionState = new TransactionState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState;
    }

    public static VendingMachine getInstance(){
        if(instance == null){
            synchronized (VendingMachine.class){
                if(instance == null){
                    instance = new VendingMachine();
                }
            }
        }
        return instance;
    }

    @Override
    public void selectProduct(Product product) {
        currentState.selectProduct(product);
    }

    @Override
    public void deselectProduct(Product product) {
        currentState.deselectProduct(product);
    }

    @Override
    public void gotoPayment() {
        currentState.gotoPayment();
    }

    @Override
    public synchronized void addMoney(Money money) {
        currentState.addMoney(money);
    }

    @Override
    public synchronized void makePayment() {
        currentState.makePayment();
    }

    @Override
    public synchronized void dispenseProducts() {
        currentState.dispenseProducts();
    }

    public synchronized void reStock(Product product, int quant){
        inventory.reStock(product, quant);
    }

    public InventoryService getInventory() {
        return inventory;
    }

    public List<Product> getSelectedProducts() {
        return selectedProducts;
    }

    public void setSelectedProducts(List<Product> selectedProducts) {
        this.selectedProducts = selectedProducts;
    }

    public double getAddedAmount() {
        return addedAmount;
    }

    public synchronized void setAddedAmount(double addedAmount) {
        this.addedAmount = addedAmount;
    }

    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public IdleState getIdleState() {
        return idleState;
    }

    public void setIdleState(IdleState idleState) {
        this.idleState = idleState;
    }

    public TransactionState getTransactionState() {
        return transactionState;
    }

    public void setTransactionState(TransactionState transactionState) {
        this.transactionState = transactionState;
    }

    public DispensingState getDispensingState() {
        return dispensingState;
    }

    public void setDispensingState(DispensingState dispensingState) {
        this.dispensingState = dispensingState;
    }

    public boolean isAvailable(Product prod, int quant){
        return inventory.isAvailable(prod, quant) ;
    }

    public synchronized void updateQuantity(Product prod, int quant){
        inventory.updateQuantity(prod, quant);
    }

    public boolean contains(Product product){
        return selectedProducts.contains(product);
    }

    public synchronized void addProduct(Product product){
        selectedProducts.add(product);
    }

    public synchronized void removeProduct(Product product){
        selectedProducts.remove(product);
    }

    public synchronized void addWalletMoney(Money money){
        addedAmount += money.getAmount();
    }

    public void add(Observer observer) {
        inventory.add(observer);
    }

    public void remove(Observer observer) {
        inventory.remove(observer);
    }
}
