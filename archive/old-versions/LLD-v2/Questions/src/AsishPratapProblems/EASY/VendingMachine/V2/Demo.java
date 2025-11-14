package AsishPratapProblems.EASY.VendingMachine.V2;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Money;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Notification.Admin;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Notification.Observer;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Product;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.VendingMachine;
import AsishPratapProblems.EASY.VendingMachine.V2.Enums.MoneyType;
import AsishPratapProblems.EASY.VendingMachine.V2.Enums.ProductType;

import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getInstance();
        Observer ishan = new Admin("ishan");
        machine.add(ishan);
        Product p1 = new Product("1", "Kurkure", ProductType.CHIPS, 20.0);
        Product p2 = new Product("2", "ParleG", ProductType.COOKIE, 10.0);
        Product p3 = new Product("3", "Soda", ProductType.DRINK, 20.0);
        machine.reStock(p1,3);
        machine.reStock(p2,4);
        machine.reStock(p3,1);

        machine.selectProduct(p1);
        machine.selectProduct(p2);
        machine.deselectProduct(p2);
        machine.selectProduct(p3);

        machine.gotoPayment();
        machine.addMoney(new Money(MoneyType.CASH,10));
        machine.makePayment();
        machine.addMoney(new Money(MoneyType.CASH,100));
        machine.makePayment();
        machine.dispenseProducts();
        machine.selectProduct(p1);
        machine.selectProduct(p2);
        machine.selectProduct(p3);
        machine.gotoPayment();
        machine.addMoney(new Money(MoneyType.CASH,100));
        machine.makePayment();
        machine.dispenseProducts();
        for (Map.Entry<Product, Integer> e : machine.getInventory().getProducts().entrySet()){
            System.out.println(e.getKey()+" : "+e.getValue());
        }
    }
}
