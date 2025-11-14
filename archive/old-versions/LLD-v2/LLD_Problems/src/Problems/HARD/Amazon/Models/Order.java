package Problems.HARD.Amazon.Models;

import Problems.HARD.Amazon.Constants.OrderStatus;

import java.util.List;

public class Order {
    private final String id;
    private final User user;
    private final List<OrderItem> items;
    private final double totalAmount;
    private OrderStatus status;

    public Order(String id, User user, List<OrderItem> items) {
        this.id = id;
        this.user = user;
        this.items = items;
        totalAmount = getAmount();
        status = OrderStatus.PENDING;
    }
    private double getAmount(){
        return items.stream().mapToDouble(n->n.getQuantity()*n.getProduct().getPrice()).sum();
    }

    public double getTotalAmount() {
        return totalAmount;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<OrderItem> getItems() {
        return items;
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
                ", user=" + user +
                ", items=" + items +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }
}
