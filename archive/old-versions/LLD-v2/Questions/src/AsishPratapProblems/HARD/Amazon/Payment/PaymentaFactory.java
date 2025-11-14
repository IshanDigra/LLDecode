package AsishPratapProblems.HARD.Amazon.Payment;

import AsishPratapProblems.HARD.Amazon.Enums.PaymentType;

public class PaymentaFactory {
    public PaymentStrategy getPaymentStrategy(PaymentType type){
        if(type.equals(PaymentType.CARD)) return new CardPayment();
        else return new UpiPayment();
    }
}
