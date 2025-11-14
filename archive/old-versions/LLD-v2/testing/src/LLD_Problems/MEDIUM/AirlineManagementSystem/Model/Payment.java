package LLD_Problems.MEDIUM.AirlineManagementSystem.Model;

import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.PaymentMethod;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.PaymentStatus;

public class Payment {
    private final String id;
    private PaymentMethod method;
    private double amount;
    private PaymentStatus status;

    public Payment(String id, PaymentMethod method, double amount) {
        this.id = id;
        this.method = method;
        this.amount = amount;
        status = PaymentStatus.PENDING;
    }

    public void processPayment() {
        // processing payment logic
        // for payment related stuff interface should be used

        status = PaymentStatus.COMPLETED;
    }

    public String getId() {
        return id;
    }

    public PaymentMethod getMethod() {
        return method;
    }

    public void setMethod(PaymentMethod method) {
        this.method = method;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }
}
