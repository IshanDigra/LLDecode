package LLD_Problems.MEDIUM.ATM.Transactions;

import LLD_Problems.MEDIUM.ATM.Account;

public class WithdrawTransaction extends Transaction{
    public WithdrawTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }


    public void execute(){
        account.debitMoney(amount);
    };
}
