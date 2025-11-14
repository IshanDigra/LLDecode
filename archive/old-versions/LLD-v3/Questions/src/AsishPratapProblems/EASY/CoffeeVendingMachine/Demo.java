package AsishPratapProblems.EASY.CoffeeVendingMachine;

import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.Admin;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.Cash;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Entity.CoffeeMachine;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CashType;
import AsishPratapProblems.EASY.CoffeeVendingMachine.Enum.CoffeeType;

public class Demo {
    public static void main(String[] args) {
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
