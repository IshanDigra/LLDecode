package AsishPratapProblems.HARD.Amazon.Serivce;

import AsishPratapProblems.EASY.VendingMachine.V1.Models.Product;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class ProductService {
    private Map<Product, Integer> products;

    public ProductService() {
        products = new ConcurrentHashMap<>();
    }

    //

    public synchronized void addProduct(Product product, int quantity){
        int currentQuantity = products.getOrDefault(product, 0);
        products.put(product, currentQuantity+quantity);
    }

    public synchronized  int getProductStock(Product product){
        return products.getOrDefault(product, 0);
    }

    // take care of the checks
    public synchronized void updateStock(Product product, int quantity){
        int currentQuantity = products.getOrDefault(product, 0);
        products.put(product, currentQuantity-quantity);
    }

    // based on certain criterias
    //public List<Product> getProducts();
}
