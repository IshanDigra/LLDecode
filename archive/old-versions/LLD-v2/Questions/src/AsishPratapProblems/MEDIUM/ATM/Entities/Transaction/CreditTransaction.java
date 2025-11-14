package AsishPratapProblems.MEDIUM.ATM.Entities.Transaction;

import AsishPratapProblems.MEDIUM.ATM.Enums.TransactionType;
import AsishPratapProblems.MEDIUM.ATM.Entities.Bank.UserAccount;

public class CreditTransaction extends Transaction{


    public CreditTransaction(int transactionId, double amount, UserAccount account) {
        super(transactionId, amount, account, TransactionType.CREDIT);
    }
}
