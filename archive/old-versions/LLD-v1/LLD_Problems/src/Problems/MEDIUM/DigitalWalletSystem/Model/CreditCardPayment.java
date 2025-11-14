package Problems.MEDIUM.DigitalWalletSystem.Model;

import Problems.MEDIUM.DigitalWalletSystem.Constant.Currency;

public class CreditCardPayment extends PaymentMethod{
    private final String cardNumber;
    private final String expirationDate;
    private final String cvv;
    public CreditCardPayment(String id, User user, String cardNumber, String expirationDate, String cvv) {
        super(id, user);

        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }

    @Override
    public boolean processPayment(double amount, Currency currency) {
//      payment process logic
        return true;
    }
}
