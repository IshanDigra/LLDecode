package LLD_Problems.MEDIUM.RestaurantManagementSystem.Model;

import java.util.Date;

public class Report {
    private int id; // Unique identifier for the report
    private String type; // Type of the report (e.g., Sales, Inventory)
    private Date generatedOn; // Date when the report was generated
    private String data; // Data contained in the report

    public Report(int id, String type, String data) {
        this.id = id;
        this.type = type;
        this.generatedOn = new Date();
        this.data = data;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", generatedOn=" + generatedOn +
                ", data='" + data + '\'' +
                '}';
    }
}
