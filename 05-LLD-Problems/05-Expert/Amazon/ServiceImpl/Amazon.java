package Problems.HARD.Amazon.ServiceImpl;

import Problems.HARD.Amazon.Constants.OrderStatus;
import Problems.HARD.Amazon.Models.*;
import Problems.HARD.Amazon.Services.Payment;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class Amazon {
    private static Amazon instance;
    private final Map<String, User> users;
    private final Inventory inventory;
    private final Map<String, Order> orders;

    private Amazon() {
        users = new ConcurrentHashMap<>();
        inventory = new Inventory();
        orders = new ConcurrentHashMap<>();
    }

    public static synchronized Amazon getInstance(){
        if(instance == null){
            instance = new Amazon();
        }
        return instance;
    }

    public void registerUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    public void addProduct(Product product, int quantity) {
        inventory.addProduct(product,quantity);
    }


    public List<Product> searchProducts(String keyword) {
        return inventory.searchProducts(keyword);
    }


    public Order placeOrder(User user, Cart cart, Payment payment){
        List<OrderItem> orderItem = new ArrayList<>();
        for(OrderItem item: cart.getItems().values()){
            Product product = item.getProduct();
            int quantity = item.getQuantity();
            if(inventory.isAvailable(product,quantity)){
                inventory.updateQuantity(product,quantity);
                orderItem.add(item);
            }
        }
        if (orderItem.isEmpty()){
            System.out.println("No available products in the cart.");
        }
        else{
            Order order = new Order(generateOrderId(),user,orderItem);
            orders.put(order.getId(),order);
            user.addOrder(order);
            cart.clear();

            if(payment.processPayment(order.getTotalAmount())){
                order.setStatus(OrderStatus.COMPLETED);
            }
            else{
                order.setStatus(OrderStatus.CANCELLED);

                for(OrderItem itemss : orderItem){
                    Product product = itemss.getProduct();
                    int quantity = itemss.getQuantity();
                    inventory.addProduct(product,quantity);
                }

            }
            return order;
        }
        return null;
    }

    public Order getOrder(String orderId) {
        return orders.get(orderId);
    }

    private String generateOrderId() {
        return "ORDER" + UUID.randomUUID().toString().substring(0, 8).toUpperCase();
    }
}
