package Problems.HARD.StockBrokingSystem.Models;

import Problems.HARD.StockBrokingSystem.Constants.OrderStatus;
import Problems.HARD.StockBrokingSystem.Exceptions.InsufficientStockException;
import Problems.HARD.StockBrokingSystem.Service.Order;

public class SellOrder extends Order {

    public SellOrder(String id, Account account, Stock stock, int quantity, double price) {
        super(id, account, stock, quantity, price);
    }


    @Override
    public void execute() {
        if(account.getPortfolio().getHoldings().containsKey(stock.getSymbol())){
            int currentQuantity = account.getPortfolio().getHoldings().getOrDefault(stock.getSymbol(),0);
            if(quantity <= currentQuantity){
                double funds = price*quantity;
                account.deposit(funds);
                account.getPortfolio().removeStocks(stock,quantity);
                status = OrderStatus.COMPLETED;
            }
            else{
                status = OrderStatus.CANCELLED;
                throw new InsufficientStockException("asked quantity of stocks not present in account.");
            }
        }
        else{
            status = OrderStatus.CANCELLED;
            throw new InsufficientStockException("Stock not present in Account.");
        }
    }

    @Override
    public String toString() {
        return "SellOrder{" +
                "id='" + id + '\'' +
   //             ", account=" + account +
                ", stock=" + stock +
                ", quantity=" + quantity +
                ", price=" + price +
                ", status=" + status +
                '}';
    }
}
