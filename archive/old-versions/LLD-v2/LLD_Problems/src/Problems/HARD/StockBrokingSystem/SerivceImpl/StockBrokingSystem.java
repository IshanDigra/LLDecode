package Problems.HARD.StockBrokingSystem.SerivceImpl;

import Problems.HARD.StockBrokingSystem.Exceptions.InsufficientFundsException;
import Problems.HARD.StockBrokingSystem.Exceptions.InsufficientStockException;
import Problems.HARD.StockBrokingSystem.Models.Account;
import Problems.HARD.StockBrokingSystem.Models.Stock;
import Problems.HARD.StockBrokingSystem.Models.User;
import Problems.HARD.StockBrokingSystem.Service.Order;

import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicInteger;

public class StockBrokingSystem {
    private static StockBrokingSystem instance;
    private final Map<String, Stock> listedStocks;
    private final Map<String, Account> accounts;
    private final Queue<Order> orders;
    private final AtomicInteger accountIdCounter;

    private StockBrokingSystem() {
        listedStocks = new ConcurrentHashMap<>();
        accounts = new ConcurrentHashMap<>();
        orders = new ConcurrentLinkedQueue<>();
        accountIdCounter = new AtomicInteger(1);
    }

    public static synchronized StockBrokingSystem getInstance(){
        if(instance==null){
            instance = new StockBrokingSystem();
        }
        return instance;
    }

    public Account createAccount(User user, double initialBalance) {
        String accountId = generateAccountId();
        Account account = new Account(accountId, user, initialBalance);
        accounts.put(accountId, account);
        return account;
    }

    public Account getAccount(String accountId) {
        return accounts.get(accountId);
    }

    public void addStock(Stock stock) {
        listedStocks.put(stock.getSymbol(), stock);
    }

    public Stock getStock(String symbol) {
        return listedStocks.get(symbol);
    }

    public void placeOrder(Order order) {
        orders.offer(order);
        order.getAccount().addOrder(order);
        processOrders();
    }
    private void processOrders(){
        while (!orders.isEmpty()){
            Order order = orders.poll();
            try {
                order.execute();
            }
            catch (InsufficientFundsException | InsufficientStockException e){
                System.out.println("Order failed: " + e.getMessage());
            }
        }
    }

    private String generateAccountId(){
        int accountId = accountIdCounter.getAndIncrement();
        return "A"+ Integer.toString(accountId);
    }

}
