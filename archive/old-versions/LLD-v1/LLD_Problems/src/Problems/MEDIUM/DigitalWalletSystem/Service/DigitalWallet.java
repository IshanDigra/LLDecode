package Problems.MEDIUM.DigitalWalletSystem.Service;

import Problems.MEDIUM.DigitalWalletSystem.Constant.Currency;
import Problems.MEDIUM.DigitalWalletSystem.Model.Account;
import Problems.MEDIUM.DigitalWalletSystem.Model.PaymentMethod;
import Problems.MEDIUM.DigitalWalletSystem.Model.Transaction;
import Problems.MEDIUM.DigitalWalletSystem.Model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class DigitalWallet {
    private static DigitalWallet digitalWallet;
    private final Map<String, User> users;
    private final Map<String, Account> accounts;
    private final Map<String, PaymentMethod> paymentMethods;
    private DigitalWallet(){
        users = new ConcurrentHashMap<>();
        accounts = new ConcurrentHashMap<>();
        paymentMethods = new ConcurrentHashMap<>();
    }

    public synchronized static DigitalWallet getInstance(){
        if(digitalWallet == null){
            digitalWallet = new DigitalWallet();
        }
        return digitalWallet;
    }

    // User related tasks
    public void createUser(User user) {
        users.put(user.getId(), user);
    }

    public User getUser(String userId) {
        return users.get(userId);
    }

    // account addition
    public void createAccount(Account account) {
        accounts.put(account.getId(), account);
        account.getUser().addAccount(account);
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void addPaymentMethod(PaymentMethod paymentMethod) {
        paymentMethods.put(paymentMethod.getId(), paymentMethod);
    }

    public PaymentMethod getPaymentMethod(String paymentMethodId) {
        return paymentMethods.get(paymentMethodId);
    }


    // funds stranfer
    public void transferFunds(Account sourceAccount, Account destinationAccount, double amount, Currency currency) {
        double amount1= amount, amount2=amount;
        if(!sourceAccount.getCurrency().equals(currency)){
            amount1 = CurrencyConverter.convert(amount, currency, sourceAccount.getCurrency());
        }
        try {
            sourceAccount.withdraw(amount1);
            if(destinationAccount.getCurrency()!=currency){
                amount2 = CurrencyConverter.convert(amount, currency, sourceAccount.getCurrency());
            }
            destinationAccount.addFunds(amount2);

            Transaction transaction = new Transaction(generateTransactionID(), sourceAccount,destinationAccount, amount,currency);
            sourceAccount.addTransaction(transaction);
            destinationAccount.addTransaction(transaction);
        } catch (Exception e) {
            System.out.println(e);
        }

    }


    private String generateTransactionID(){
        return "TRANS" + UUID.randomUUID().toString();
    }

    public List<Transaction> getTransactionHistory(Account account) {
        return account.getTransactions();
    }
}
