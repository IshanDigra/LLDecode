package AsishPratapProblems.MEDIUM.ATM.Entities.Bank;

import AsishPratapProblems.MEDIUM.ATM.Entities.Card;
import AsishPratapProblems.MEDIUM.ATM.Entities.Transaction.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bank {
    List<UserAccount> userAccountList;
    Map<UserAccount, List<Transaction>> transactionHistory;

    public Bank() {
        userAccountList = new ArrayList<>();
        transactionHistory = new HashMap<>();
    }

    public void registerUserAccount(UserAccount userAccount) {
        userAccountList.add(userAccount);
        transactionHistory.put(userAccount, new ArrayList<>()); // Initialize transaction history for the new account

    }

    public UserAccount validateCredentials(Card card, String pin){
        for(UserAccount account : userAccountList){
            if(account.getCard().equals(card) && account.getPin().equals(pin)){
                return account;
            }
        }
        return null;
    }

    // once we have validated only then we can make the transaction
    public void creditTransaction(UserAccount account, Transaction transaction){
        account.makeDeposit(transaction.getAmount());
        transactionHistory.get(account).add(transaction);
    }

    public boolean debitTransaction(UserAccount account, Transaction transaction){
        if(transaction.getAmount() > account.getBalance()){
            System.out.println("Insufficient balance!");
            return false;
        }
        account.makeWithdraw(transaction.getAmount());
        transactionHistory.get(account).add(transaction);
        return true;
    }

    public double getBalance(UserAccount account){
        return account.getBalance();
    }

    public List<Transaction> getTransactionHistory(UserAccount account){
        return transactionHistory.getOrDefault(account, new ArrayList<>());
    }
}
