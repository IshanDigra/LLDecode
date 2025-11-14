package Problems.HARD.FoodDeliverySystem.Model;

import Problems.HARD.FoodDeliverySystem.Constant.OrderStatus;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Order {
    private final String id;
    private Map<String, Integer> orderItems;
    private DeliveryAgent deliveryAgent;
    private final Customer customer;
    private final Restaurant restaurant;
    private OrderStatus status;

    public Order(String id, Customer customer, Restaurant restaurant) {
        this.id = id;
        this.customer = customer;
        this.restaurant = restaurant;
        orderItems = new ConcurrentHashMap<>();
        deliveryAgent = null;
        status = OrderStatus.PENDING;
    }

    public void assignAgent(DeliveryAgent agent){
        deliveryAgent = agent;
    }

    public String getId() {
        return id;
    }

    public Map<String, Integer> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Map<String, Integer> orderItems) {
        this.orderItems = orderItems;
    }

    public DeliveryAgent getDeliveryAgent() {
        return deliveryAgent;
    }

    public void setDeliveryAgent(DeliveryAgent deliveryAgent) {
        this.deliveryAgent = deliveryAgent;
    }

    public Customer getCustomer() {
        return customer;
    }

    public Restaurant getRestaurant() {
        return restaurant;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", orderItems=" + orderItems +
                ", deliveryAgent=" + deliveryAgent +
                ", customer=" + customer +
                ", restaurant=" + restaurant +
                ", status=" + status +
                '}';
    }
}
