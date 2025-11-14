package Problems.HARD.Amazon;

import Problems.HARD.Amazon.Constants.ProductCategory;
import Problems.HARD.Amazon.Models.Cart;
import Problems.HARD.Amazon.Models.Order;
import Problems.HARD.Amazon.Models.Product;
import Problems.HARD.Amazon.Models.User;
import Problems.HARD.Amazon.ServiceImpl.Amazon;
import Problems.HARD.Amazon.ServiceImpl.CreditCardPayment;
import Problems.HARD.Amazon.Services.Payment;

import java.util.List;

public class AmazonDemo {
    public static void main(String[] args) {
        Amazon shoppingService = Amazon.getInstance();

        // Register users
        User user1 = new User("U001", "John Doe", "john@example.com", "password123");
        User user2 = new User("U002", "Jane Smith", "jane@example.com", "password456");
        shoppingService.registerUser(user1);
        shoppingService.registerUser(user2);

        // Add products
        Product product1 = new Product("P001", "Smartphone", "High-end smartphone", 999.99, ProductCategory.ELECTRONIC);
        Product product2 = new Product("P002", "Laptop", "Powerful gaming laptop", 1999.99, ProductCategory.ELECTRONIC);
        shoppingService.addProduct(product1,10);
        shoppingService.addProduct(product2,5);

        // User 1 adds products to cart and places an order
        Cart cart1 = new Cart("1");
        cart1.addItem(product1, 2);
        cart1.addItem(product2, 1);
        Payment payment1 = new CreditCardPayment();
        System.out.println(cart1);
        Order order1 = shoppingService.placeOrder(user1, cart1, payment1);
        System.out.println("Order placed: " + order1.getId());


        // User 2 searches for products and adds to cart
        List<Product> searchResults = shoppingService.searchProducts("laptop");
        System.out.println("Search Results:");
        for (Product product : searchResults) {
            System.out.println(product.getName());
        }

        Cart cart2 = new Cart("2");
        cart2.addItem(searchResults.get(0), 1);
        Payment payment2 = new CreditCardPayment();
        System.out.println(cart2);
        Order order2 = shoppingService.placeOrder(user2, cart2, payment2);
        System.out.println("Order placed: " + order2.getId());

        // User 1 views order history
        List<Order> userOrders = user1.getOrders();
        System.out.println("User 1 Order History:");
        for (Order order : userOrders) {
            System.out.println("Order ID: " + order.getId());
            System.out.println("Total Amount: $" + order.getTotalAmount());
            System.out.println("Status: " + order.getStatus());
        }
    }
}
