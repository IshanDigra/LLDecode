package AsishPratapProblems.MEDIUM.ATM.Entities.Transaction;

import AsishPratapProblems.MEDIUM.ATM.Enums.TransactionType;
import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.UserAccount;

public class DebitTransaction extends Transaction{


    public DebitTransaction(int transactionId, double amount, UserAccount account) {
        super(transactionId, amount, account, TransactionType.DEBIT);
    }
}
