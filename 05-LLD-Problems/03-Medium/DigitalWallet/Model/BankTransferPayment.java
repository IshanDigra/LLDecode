package Problems.MEDIUM.DigitalWalletSystem.Model;

import Problems.MEDIUM.DigitalWalletSystem.Constant.Currency;

public class BankTransferPayment extends PaymentMethod{
    private final String accountNumber;
    private final String routingNumber;
    public BankTransferPayment(String id, User user, String accountNumber, String routingNumber) {
        super(id, user);
        this.accountNumber = accountNumber;
        this.routingNumber = routingNumber;
    }

    @Override
    public boolean processPayment(double amount, Currency currency) {
//      bank payment processing
        return true;
    }
}
