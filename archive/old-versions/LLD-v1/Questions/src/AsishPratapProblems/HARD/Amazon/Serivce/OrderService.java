package AsishPratapProblems.HARD.Amazon.Serivce;

import AsishPratapProblems.HARD.Amazon.Entities.Cart;
import AsishPratapProblems.HARD.Amazon.Entities.Order;
import AsishPratapProblems.HARD.Amazon.Entities.Product;
import AsishPratapProblems.HARD.Amazon.Entities.User;
import AsishPratapProblems.HARD.Amazon.Enums.OrderStatus;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class OrderService {
    private Map<String, Order> orders;

    public OrderService() {
        orders = new ConcurrentHashMap<>();
    }

    public synchronized Order placeOrder(User user, Cart cart){
        double totalAmount = cart.getTotal();
        Order order = new Order(idGenerator(),user, cart.getItems());
        orders.put(order.getId(), order);
        return order;
    }

    public synchronized void confirmOrder(Order order){
        order.setStatus(OrderStatus.CONFIRMED);
    }

    public synchronized void cancelOrder(Order order){
        order.setStatus(OrderStatus.CANCELLED);
    }

    private String idGenerator(){
        return UUID.randomUUID().toString();
    }
}
