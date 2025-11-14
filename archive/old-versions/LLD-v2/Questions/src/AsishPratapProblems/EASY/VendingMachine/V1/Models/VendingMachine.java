package AsishPratapProblems.EASY.VendingMachine.V1.Models;

import AsishPratapProblems.EASY.VendingMachine.V1.Models.States.DispensingState;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.States.IdleState;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.States.TransactionState;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.States.VendingMachineState;

public class VendingMachine implements VendingMachineState {
    private static VendingMachine instance;
    private ProductInventory inventory;
    private VendingMachineState currentState;
    private VendingMachineState idleState;
    private VendingMachineState trasactionState;
    private VendingMachineState dispensingState;
    private Product selectedProduct;
    private double totalAmount;

    private VendingMachine(){
        inventory = new ProductInventory();
        selectedProduct = null;
        totalAmount = 0.0 ;
        idleState = new IdleState(this);
        trasactionState = new TransactionState(this);
        dispensingState = new DispensingState(this);
        currentState = idleState;
    }
    public static synchronized  VendingMachine getInstance(){
        if(instance == null){
            instance = new VendingMachine();
        }
        return instance;
    }

    public void restockProduct(Product product, int quantity){
        inventory.restockProduct(product,quantity);
    }

    @Override
    public void selectProduct(String id) {
        if(!inventory.isAvailable(id)){
            return;
        }
        currentState.selectProduct(id);
    }

    @Override
    public void resetProduct() {
        currentState.resetProduct();
    }

    @Override
    public void addCash(Cash cash, int quantity) {
        currentState.addCash(cash, quantity);
    }

    @Override
    public void makePayment() {
        currentState.makePayment();
    }

    @Override
    public void dispenseProduct() {
        currentState.dispenseProduct();
    }



    public VendingMachineState getCurrentState() {
        return currentState;
    }

    public void setCurrentState(VendingMachineState currentState) {
        this.currentState = currentState;
    }

    public VendingMachineState getIdleState() {
        return idleState;
    }

    public VendingMachineState getTrasactionState() {
        return trasactionState;
    }

    public VendingMachineState getDispensingState() {
        return dispensingState;
    }

    public Product getSelectedProduct() {
        return selectedProduct;
    }

    public void setSelectedProduct(Product selectedProduct) {
        this.selectedProduct = selectedProduct;
    }

    public ProductInventory getInventory() {
        return inventory;
    }

    public void setInventory(ProductInventory inventory) {
        this.inventory = inventory;
    }

    public static void setInstance(VendingMachine instance) {
        VendingMachine.instance = instance;
    }

    public void setIdleState(VendingMachineState idleState) {
        this.idleState = idleState;
    }

    public void setTrasactionState(VendingMachineState trasactionState) {
        this.trasactionState = trasactionState;
    }

    public void setDispensingState(VendingMachineState dispensingState) {
        this.dispensingState = dispensingState;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void displayProduct(){
        inventory.displayProduct();
    }
}
