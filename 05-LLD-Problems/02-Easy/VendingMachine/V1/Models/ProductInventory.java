package AsishPratapProblems.EASY.VendingMachine.V1.Models;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductInventory {
    private Map<String, Integer> products;
    private Map<String, Product> prodMapping;
    public ProductInventory() {
        products = new ConcurrentHashMap<>();
        prodMapping = new ConcurrentHashMap<>();
    }
    public void restockProduct(Product product, int quantity){
        int currentValue = products.getOrDefault(product.getId(), 0);
        products.put(product.getId(), currentValue+quantity);
        prodMapping.put(product.getId(),product);
    }
    public boolean isAvailable(String id){
        if(products.getOrDefault(id,0)>0){
            return true;
        }
        System.out.println("Product "+ prodMapping.get(id).getName()+" out of Stock");
        return false;
    }
    public Product getProduct(String id){
        if(isAvailable(id)) return prodMapping.get(id);
        return null;
    }

    public void updateQuantity(String id, int quantity){
        int currentValue = products.getOrDefault(id, 0);
        products.put(id, currentValue-quantity);
    }

    public void displayProduct(){
        products.entrySet().stream()
                .filter(r->r.getValue()>0)
                .forEach(r->
                System.out.println(prodMapping.get(r.getKey()).getName()+" : $"+prodMapping.get(r.getKey()).getPrice()));
    }
}
