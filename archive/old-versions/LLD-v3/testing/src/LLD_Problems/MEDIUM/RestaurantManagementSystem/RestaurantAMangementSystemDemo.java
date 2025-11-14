package LLD_Problems.MEDIUM.RestaurantManagementSystem;

import LLD_Problems.MEDIUM.RestaurantManagementSystem.Model.*;
import LLD_Problems.MEDIUM.RestaurantManagementSystem.Service.Restaurant;

import java.sql.Timestamp;
import java.util.Date;

public class RestaurantAMangementSystemDemo {
    public static void main(String[] args) {
        Restaurant restaurant = Restaurant.getInstance();

        // Create and add menu items
        MenuItem pizza = new MenuItem(1, "Pizza",  12.99, "Cheese burst pizza");
        MenuItem pasta = new MenuItem(2, "Pasta",  9.99, "Creamy white sauce pasta");
        restaurant.addMenuItem(pizza);
        restaurant.addMenuItem(pasta);

        // Create and add an order
        Order order = new Order(101);
        order.addItem(pizza);
        order.addItem(pasta);
        restaurant.createOrder(order);

        // Create and add a reservation
        Reservation reservation = new Reservation(201, new Timestamp(System.currentTimeMillis()), 4,"John Doe", "123-456-7890" );
        restaurant.makeReservation(reservation);

        // Manage inventory
        InventoryItem cheese = new InventoryItem(301, 5,"Cheese");
        cheese.updateQuantity(-1); // Use 1.5 Kg
        restaurant.updateInventory(cheese);

        // Add staff
        Staff chef = new Staff(501, "Alice", "Chef", "9 AM - 5 PM");
        restaurant.addStaff(chef);

        // Generate a report
        Report salesReport = new Report(601, "Sales", "Total Sales: $1000");
        restaurant.generateReport(salesReport);

        System.out.println(restaurant);
    }
}
