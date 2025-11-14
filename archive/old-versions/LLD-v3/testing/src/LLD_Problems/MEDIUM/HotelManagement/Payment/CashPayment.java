package LLD_Problems.MEDIUM.HotelManagement.Payment;

public class CashPayment implements Payment{
    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
