package Problems.HARD.StockBrokingSystem.Models;

import Problems.HARD.StockBrokingSystem.Exceptions.InsufficientStockException;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Portfolio {
    private final Account account;
    private final Map<String, Integer> holdings;

    public Portfolio(Account account) {
        this.account = account;
        holdings = new ConcurrentHashMap<>();
    }

    public void addStocks(Stock stock, int quantity){
        int currentQuantity = holdings.getOrDefault(stock.getSymbol(),0);
        currentQuantity += quantity;
        holdings.put(stock.getSymbol(),quantity);
    }

    public void removeStocks(Stock stock, int quantity){
       if(holdings.containsKey(stock.getSymbol())){
           int currentQuantity = holdings.getOrDefault(stock.getSymbol(),0);
           if(quantity<= currentQuantity){
                currentQuantity -= quantity;
                holdings.put(stock.getSymbol(),currentQuantity);
           }
           else throw new InsufficientStockException("Insufficient stock quantity in the portfolio.");
       }
       else throw new InsufficientStockException("Stock Not found in portfolio.");
    }


    public Account getAccount() {
        return account;
    }

    public Map<String, Integer> getHoldings() {
        return holdings;
    }

    @Override
    public String toString() {
        return "Portfolio{" +
                "account=" + account +
                ", holdings=" + holdings +
                '}';
    }
}
