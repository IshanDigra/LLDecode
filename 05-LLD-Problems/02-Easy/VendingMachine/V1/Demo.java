package AsishPratapProblems.EASY.VendingMachine.V1;
/*
#Requirement
The vending machine should support multiple products with different prices and quantities.
The machine should accept coins and notes of different denominations.
The machine should dispense the selected product and return change if necessary.
The machine should keep track of the available products and their quantities.
The machine should handle multiple transactions concurrently and ensure data consistency.
The machine should provide an interface for restocking products and collecting money.
The machine should handle exceptional scenarios, such as insufficient funds or out-of-stock products.
*/

import AsishPratapProblems.EASY.VendingMachine.V1.Enums.CashType;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.Cash;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.Product;
import AsishPratapProblems.EASY.VendingMachine.V1.Models.VendingMachine;

public class Demo {
    public static void main(String[] args) {
        Product p1 = new Product("1", "Kukure", 20.0);
        Product p2 = new Product("2", "Chips", 20.0);
        Product p3 = new Product("3", "Pringles", 50.0);
        VendingMachine vendingMachine = VendingMachine.getInstance();
        vendingMachine.restockProduct(p1,2);
        vendingMachine.restockProduct(p2,2);
        vendingMachine.restockProduct(p3,1);

        vendingMachine.displayProduct();

        vendingMachine.selectProduct("1");

        vendingMachine.makePayment();
        vendingMachine.addCash(new Cash(CashType.COIN, 5), 18);
        vendingMachine.resetProduct();
        vendingMachine.selectProduct("3");
        vendingMachine.makePayment();
        vendingMachine.dispenseProduct();
        vendingMachine.selectProduct("3");


    }
}
