package AsishPratapProblems.HARD.Amazon.Payment;

public class CardPayment implements PaymentStrategy{
    @Override
    public boolean processPayment(double total) {
        return true;
    }
}
