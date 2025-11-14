package AsishPratapProblems.HARD.Amazon.Entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Cart {
    private final String id;
    private final User user;
    private Map<Product, Integer> items;

    public Cart(String id, User user) {
        this.id = id;
        this.user = user;
        items = new ConcurrentHashMap<>() ;
    }

    public double getTotal(){
        return items.entrySet().stream().mapToDouble(e->(e.getKey().getPrice())*e.getValue()).sum();
    }
    public void addToCart(){

    }
    public void removerFromCart(){

    }
    public void clearCart(){

    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Map<Product, Integer> getItems() {
        return items;
    }

    public void setItems(Map<Product, Integer> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", items=" + items +
                '}';
    }
}
