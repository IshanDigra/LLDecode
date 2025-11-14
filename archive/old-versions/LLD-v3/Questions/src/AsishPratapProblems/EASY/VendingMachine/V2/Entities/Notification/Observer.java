package AsishPratapProblems.EASY.VendingMachine.V2.Entities.Notification;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Product;

public interface Observer {
    void update(Product product);
}
