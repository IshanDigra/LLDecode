package LLD_Problems.MEDIUM.RestaurantManagementSystem.Model;

import LLD_Problems.MEDIUM.RestaurantManagementSystem.Constatns.PaymentMethod;
import LLD_Problems.MEDIUM.RestaurantManagementSystem.Constatns.PaymentStatus;

public class Payment {
    private int id; // Unique identifier for the payment
    private double amount; // Amount of the payment
    private PaymentMethod method; // Method of payment
    private PaymentStatus status; // Status of the payment

    public Payment(int id, double amount, PaymentMethod method) {
        this.id = id;
        this.amount = amount;
        this.method = method;
        this.status = PaymentStatus.PENDING;
    }

    public void completePayment() {
        // Mark the payment as completed
        this.status = PaymentStatus.COMPLETED;
    }

    @Override
    public String toString() {
        return "Payment{" +
                "id=" + id +
                ", amount=" + amount +
                ", method=" + method +
                ", status=" + status +
                '}';
    }
}
