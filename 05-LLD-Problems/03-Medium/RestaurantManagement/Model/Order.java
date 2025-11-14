package LLD_Problems.MEDIUM.RestaurantManagementSystem.Model;

import LLD_Problems.MEDIUM.RestaurantManagementSystem.Constatns.OrderStatus;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class Order {
    private final int orderID;
    private OrderStatus status;
    private List<MenuItem> items;
    private double totalPrice;
    private final Timestamp timestamp;

    public Order(int orderID) {
        this.orderID = orderID;
        items = new ArrayList<>();
        status = OrderStatus.PENDING;
        timestamp = new Timestamp(System.currentTimeMillis());
        totalPrice = 0.0;
    }

    public void addItem(MenuItem item) {
        if(item.isAvailable()){
            items.add(item);
            calculateTotalPrice();
        }
        else System.out.println("Item is not available");
    }

    private void calculateTotalPrice() {
        totalPrice = items.stream().mapToDouble(MenuItem::getPrice).sum();
    }

    public int getOrderID() {
        return orderID;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public List<MenuItem> getItems() {
        return items;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderID=" + orderID +
                ", status=" + status +
                ", items=" + items +
                ", totalPrice=" + totalPrice +
                ", timestamp=" + timestamp +
                '}';
    }
}
