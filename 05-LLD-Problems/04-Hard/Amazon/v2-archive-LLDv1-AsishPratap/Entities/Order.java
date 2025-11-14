package AsishPratapProblems.HARD.Amazon.Entities;

import AsishPratapProblems.HARD.Amazon.Enums.OrderStatus;

import java.sql.Timestamp;
import java.util.Map;

public class Order {
    private final String id;
    private final User placedBy;
    private Map<Product, Integer> items;
    private final Timestamp placedOn;
    private OrderStatus status;
    private double totalAmount;

    // could add the order total as well.

    public Order(String id, User placedBy, Map<Product, Integer> items) {
        this.id = id;
        this.placedBy = placedBy;
        this.items = items;
        placedOn = new Timestamp(System.currentTimeMillis());
        status = OrderStatus.PENDING;

    }

    public String getId() {
        return id;
    }

    public User getPlacedBy() {
        return placedBy;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }

    public Timestamp getPlacedOn() {
        return placedOn;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", placedBy=" + placedBy +
                ", items=" + items +
                ", placedOn=" + placedOn +
                '}';
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(double totalAmount) {
        this.totalAmount = totalAmount;
    }
}
