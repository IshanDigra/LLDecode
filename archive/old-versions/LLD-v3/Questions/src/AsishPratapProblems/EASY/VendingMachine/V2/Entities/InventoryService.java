package AsishPratapProblems.EASY.VendingMachine.V2.Entities;

import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Notification.Observable;
import AsishPratapProblems.EASY.VendingMachine.V2.Entities.Notification.Observer;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public class InventoryService implements Observable {
    private final Map<Product, Integer> products;
    private final List<Observer> observerList ;
    public InventoryService() {
        products = new ConcurrentHashMap<>();
        observerList = new CopyOnWriteArrayList<>();
    }

    /*
    * Assume two different threads are trying to update the quantity.
    * */
    public synchronized void reStock(Product prod, int quant){
        products.put(prod, quant+ products.getOrDefault(prod, 0));
    }

    public boolean isAvailable(Product prod, int quant){
        return products.getOrDefault(prod, 0)>= quant;
    }

    public synchronized void updateQuantity(Product prod, int quant){
        if(products.getOrDefault(prod, 0)-quant <= 0){
            notifyObservers(prod);
        }

        if(!isAvailable(prod,quant)){
            System.out.println("Product is out of stock");
            return;
        }

        products.put(prod, products.getOrDefault(prod, 0)-quant);
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    @Override
    public void add(Observer observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(Observer observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifyObservers(Product product) {
        observerList.forEach(o->o.update(product));
    }
}
