package Problems.HARD.Amazon.ServiceImpl;

import Problems.HARD.Amazon.Models.Product;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Inventory {
    private final Map<Product, Integer> products;

    public Inventory() {
        products = new ConcurrentHashMap<>();
    }

    public List<Product> searchProducts(String keyword){
        return products.keySet().stream().filter(n->n.getName().toLowerCase().contains(keyword.toLowerCase())).toList();
    }
    public void addProduct(Product product, int quantity){
        products.put(product,quantity);
    }

    public void removeProduct(Product product){
        products.remove(product);
    }

    public void updateQuantity(Product product, int quantity){
        int currentQuantity = products.getOrDefault(product,0);
        currentQuantity += quantity;
        products.put(product,currentQuantity);
    }

    public boolean isAvailable(Product product, int quantity){
        return products.get(product)>=quantity;
    }



    @Override
    public String toString() {
        return "Inventory{" +
                "products=" + products +
                '}';
    }
}
