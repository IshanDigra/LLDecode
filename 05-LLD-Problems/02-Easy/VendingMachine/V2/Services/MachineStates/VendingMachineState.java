package V2.Services.MachineStates;


import V2.Entities.Money;
import V2.Entities.Product;

public interface VendingMachineState {
    void selectProduct(Product product);
    void deselectProduct(Product product);
    void gotoPayment();
    void addMoney(Money money);
    void makePayment();
    void dispenseProducts();
}
