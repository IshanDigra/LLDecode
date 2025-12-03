package V2.Entities.Notification;


import V2.Entities.Product;

public interface Observer {
    void update(Product product);
}
