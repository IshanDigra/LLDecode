package LLD_Problems.MEDIUM.ATM.Transactions;

import LLD_Problems.MEDIUM.ATM.Account;

public class DepositTransaction extends Transaction{
    public DepositTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }


    public void execute(){
        account.creditMoney(amount);
    };
}
