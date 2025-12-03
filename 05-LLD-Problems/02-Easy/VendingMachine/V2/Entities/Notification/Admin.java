package V2.Entities.Notification;


import V2.Entities.Product;

import java.util.logging.Logger;

public class Admin implements Observer{
    private final String name;
    private static final Logger logger = Logger.getLogger(Admin.class.getName());

    public Admin(String name) {
        this.name = name;
    }

    // here we could add queue of items that needs to be restocked.
    // admins we could keep centralized and from various vending machines we could update those
    // requests and using multithreading we could cater those requests. via admins.

    @Override
    public void update(Product product) {
        logger.info(name + " has recieved the low inventory request for "+ product.getName());
    }
}
