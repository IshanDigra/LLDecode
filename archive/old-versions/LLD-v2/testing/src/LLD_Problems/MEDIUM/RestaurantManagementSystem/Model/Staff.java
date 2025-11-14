package LLD_Problems.MEDIUM.RestaurantManagementSystem.Model;

import java.util.HashMap;
import java.util.Map;

public class Staff {
    private int id; // Unique identifier for the staff member
    private String name; // Name of the staff member
    private String role; // Role of the staff member (e.g., Chef, Manager)
    private String schedule; // Work schedule of the staff member
    private Map<String, Double> performanceMetrics; // Performance metrics for the staff member

    public Staff(int id, String name, String role, String schedule) {
        this.id = id;
        this.name = name;
        this.role = role;
        this.schedule = schedule;
        this.performanceMetrics = new HashMap<>();
    }

    @Override
    public String toString() {
        return "Staff{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", role='" + role + '\'' +
                ", schedule='" + schedule + '\'' +
                ", performanceMetrics=" + performanceMetrics +
                '}';
    }
}
