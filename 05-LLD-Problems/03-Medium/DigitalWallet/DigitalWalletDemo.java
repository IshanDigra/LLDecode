package Problems.MEDIUM.DigitalWalletSystem;

import Problems.MEDIUM.DigitalWalletSystem.Constant.Currency;
import Problems.MEDIUM.DigitalWalletSystem.Model.*;
import Problems.MEDIUM.DigitalWalletSystem.Service.DigitalWallet;

import java.math.BigDecimal;
import java.util.List;

public class DigitalWalletDemo {
    public static void main(String[] args) {
        DigitalWallet digitalWallet = DigitalWallet.getInstance();

        // create user
        User user1 = new User("U001", "John Doe", "john@example.com", "password123");
        User user2 = new User("U002", "Jane Smith", "jane@example.com", "password456");
        digitalWallet.createUser(user1);
        digitalWallet.createUser(user2);

        // create account
        Account account1 = new Account("A001", user1, "1234567890", Currency.USD);
        Account account2 = new Account("A002", user2, "9876543210", Currency.EUR);
        digitalWallet.createAccount(account1);
        digitalWallet.createAccount(account2);

        // Add payment methods
        PaymentMethod creditCard = new CreditCardPayment("PM001", user1, "1234567890123456", "12/25", "123");
        PaymentMethod bankAccount = new BankTransferPayment("PM002", user2, "9876543210", "987654321");
        digitalWallet.addPaymentMethod(creditCard);
        digitalWallet.addPaymentMethod(bankAccount);

        // add funds in both accounts
        account1.addFunds(1000);
        account2.addFunds(500);

        // transfer funds -- insufficent
        digitalWallet.transferFunds(account2, account1, 1000, Currency.USD);

        digitalWallet.transferFunds(account2, account1, 100, Currency.USD);

        // Get transaction history
        List<Transaction> transactionHistory1 = digitalWallet.getTransactionHistory(account1);
        List<Transaction> transactionHistory2 = digitalWallet.getTransactionHistory(account2);

        // Print transaction history
        System.out.println("Transaction History for Account 1:");
        for (Transaction transaction : transactionHistory1) {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Amount: " + transaction.getAmount() + " " + transaction.getCurrency());
            System.out.println("Timestamp: " + transaction.getTime());
            System.out.println();
        }

        System.out.println("Transaction History for Account 2:");
        for (Transaction transaction : transactionHistory2) {
            System.out.println("Transaction ID: " + transaction.getId());
            System.out.println("Amount: " + transaction.getAmount() + " " + transaction.getCurrency());
            System.out.println("Timestamp: " + transaction.getTime());
            System.out.println();
        }

        System.out.println("Final Funds in each account" );
        System.out.println("Account1 balance : "+ account1.getBalance());
        System.out.println("Account2 balance : "+ account2.getBalance());
    }
}
