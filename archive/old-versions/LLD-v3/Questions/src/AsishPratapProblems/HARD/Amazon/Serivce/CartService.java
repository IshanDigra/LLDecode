package AsishPratapProblems.HARD.Amazon.Serivce;

import AsishPratapProblems.HARD.Amazon.Entities.Cart;
import AsishPratapProblems.HARD.Amazon.Entities.Product;
import AsishPratapProblems.HARD.Amazon.Entities.User;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class CartService {
    private Map<User, Cart> userCarts;

    public CartService() {
        userCarts = new ConcurrentHashMap<>();
    }

    public synchronized  void addToCart(User user, Product product, int quantity){
        Cart cart = userCarts.getOrDefault(user, new Cart(idGenerator(), user));
        cart.addToCart();
    }

    public synchronized void clearCart(User user){
        Cart cart = userCarts.getOrDefault(user, new Cart(idGenerator(), user));
        cart.clearCart();
    }

    public Map<Product, Integer> getCartItems(User user){
        return userCarts.getOrDefault(user, new Cart(idGenerator(), user)).getItems();
    }

    private String idGenerator(){
        return UUID.randomUUID().toString();
    }
}
