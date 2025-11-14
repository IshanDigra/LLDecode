package Problems.HARD.Amazon.Models;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;


public class Cart {
    private final String id;
    private Map<String, OrderItem> items;

    public Cart(String id) {
        this.id = id;
        items = new ConcurrentHashMap<>();
    }
    public void clear() {
        items.clear();
    }
    public void addItem(Product product,  int quantity){
        if(items.containsKey(product.getId())){
            quantity += items.get(product.getId()).getQuantity();
        }
        items.put(product.getId(), new OrderItem(product,quantity));
    }

    public void removeItem(Product product){
        items.remove(product.getId());
    }

    public void updateItem(Product product,  int quantity){
        OrderItem item = items.get(product.getId());
        if(item !=null){
            items.put(product.getId(), new OrderItem(product,quantity));
        }
    }


    public String getId() {
        return id;
    }


    public Map<String, OrderItem> getItems() {
        return items;
    }

    public void setItems(Map<String, OrderItem> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "id='" + id + '\'' +
                ", items=" + items.values() +
                '}';
    }
}
