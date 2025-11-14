package Problems.HARD.Amazon.ServiceImpl;

import Problems.HARD.Amazon.Services.Payment;

public class CreditCardPayment implements Payment {
    @Override
    public boolean processPayment(double amount) {
        // Payment processing logic
        return true;
    }
}
