package V2;


import V2.Entity.Admin;
import V2.Entity.Cash;
import V2.Enum.CashType;
import V2.Enum.CoffeeType;
import V2.Service.CoffeeMachine;

import java.util.logging.Logger;

public class Demo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Main");
        CoffeeMachine machine = CoffeeMachine.getInstance();
        Admin admin = new Admin();
        machine.getInventory().add(admin);
        machine.selectCoffee(CoffeeType.LATTE);
        machine.makePayment();
        machine.addCash(new Cash(CashType.COIN,5.0),10);
        machine.makePayment();
        machine.dispenseCoffee();
    }
}
