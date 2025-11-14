package AsishPratapProblems.EASY.VendingMachine.V2.Entities.Notification;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Product;

public class Admin implements Observer{
    private final String name;

    public Admin(String name) {
        this.name = name;
    }

    // here we could add queue of items that needs to be restocked.
    // admins we could keep centralized and from various vending machines we could update those
    // requests and using multithreading we could cater those requests. via admins.

    @Override
    public void update(Product product) {
        System.out.println(name + " has recieved the low inventory request for "+ product.getName());
    }
}
