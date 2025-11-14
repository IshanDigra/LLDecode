package Problems.HARD.StockBrokingSystem.Models;

import Problems.HARD.StockBrokingSystem.Constants.OrderStatus;
import Problems.HARD.StockBrokingSystem.Exceptions.InsufficientFundsException;
import Problems.HARD.StockBrokingSystem.Service.Order;

public class BuyOrder extends Order {


    public BuyOrder(String id, Account account, Stock stock, int quantity, double price) {
        super(id, account, stock, quantity, price);
    }

    @Override
    public void execute() {
        double amount = price*quantity;
        if(account.getBalance()>=amount){
            account.withdraw(amount);
            account.getPortfolio().addStocks(stock,quantity);
            status = OrderStatus.COMPLETED;
        }
        else{
            status = OrderStatus.CANCELLED;
            throw new InsufficientFundsException("Insufficient funds to execute the buy order.");
        }
    }

    @Override
    public String toString() {
        return "SellOrder{" +
                "id='" + id + '\'' +
//                ", account=" + account +
                ", stock=" + stock +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                '}';
    }


}
