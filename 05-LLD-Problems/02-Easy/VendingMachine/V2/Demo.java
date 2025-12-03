package V2;


import V2.Entities.Money;
import V2.Entities.Notification.Admin;
import V2.Entities.Notification.Observer;
import V2.Entities.Product;
import V2.Enums.MoneyType;
import V2.Enums.ProductType;
import V2.Services.VendingMachine;

import java.util.Map;
import java.util.logging.Logger;

public class Demo {
    public static void main(String[] args) {
        VendingMachine machine = VendingMachine.getInstance();
        Logger logger = Logger.getLogger("Main");
        Observer ishan = new Admin("ishan");
        machine.add(ishan);
        Product p1 = new Product("Kurkure", ProductType.CHIPS, 20.0);
        Product p2 = new Product( "ParleG", ProductType.COOKIE, 10.0);
        Product p3 = new Product( "Soda", ProductType.DRINK, 20.0);
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
            logger.info(e.getKey()+" : "+e.getValue());
        }
    }
}
