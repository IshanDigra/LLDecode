package LLD_Problems.MEDIUM.ATM.Transactions;

import LLD_Problems.MEDIUM.ATM.Account;

public class WithdrawalTransaction extends Transaction{


    public WithdrawalTransaction(String transactionId, Account account, double amount) {
        super(transactionId, account, amount);
    }

    public void execute(){
        this.account.debitMoney(amount);
    };
}
