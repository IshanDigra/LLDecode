package LLD_Problems.MEDIUM.HotelManagement.Payment;

public class CreditCardPayment implements Payment{

    @Override
    public boolean processPayment(double amount) {
        return true;
    }
}
