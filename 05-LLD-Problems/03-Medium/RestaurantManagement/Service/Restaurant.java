package LLD_Problems.MEDIUM.RestaurantManagementSystem.Service;

import LLD_Problems.MEDIUM.RestaurantManagementSystem.Model.*;

import java.util.ArrayList;
import java.util.List;

public class Restaurant {
    private static Restaurant instance; // Singleton instance
    private List<MenuItem> menu;
    private List<Order> orders;
    private List<Reservation> reservations;
    private List<InventoryItem> inventory;
    private List<Staff> staff;
    private List<Report> reports;

    private Restaurant() {
        menu = new ArrayList<>();
        orders = new ArrayList<>();
        reservations = new ArrayList<>();
        inventory = new ArrayList<>();
        staff = new ArrayList<>();
        reports = new ArrayList<>();
    }

    public static Restaurant getInstance() {
        if (instance == null) {
            instance = new Restaurant();
        }
        return instance;
    }

    public void addMenuItem(MenuItem item) {
        menu.add(item);
    }

    public void createOrder(Order order) {
        orders.add(order);
    }

    public void makeReservation(Reservation reservation) {
        reservations.add(reservation);
    }

    public void updateInventory(InventoryItem item) {
        inventory.add(item);
    }

    public void addStaff(Staff staffMember) {
        staff.add(staffMember);
    }

    public void generateReport(Report report) {
        reports.add(report);
    }

    @Override
    public String toString() {
        return "Restaurant{" +
                "menu=" + menu +
                ", orders=" + orders +
                ", reservations=" + reservations +
                ", inventory=" + inventory +
                ", staff=" + staff +
                ", reports=" + reports +
                '}';
    }
}
