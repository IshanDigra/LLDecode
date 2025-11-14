package Problems.HARD.StockBrokingSystem.Service;

import Problems.HARD.StockBrokingSystem.Constants.OrderStatus;
import Problems.HARD.StockBrokingSystem.Models.Account;
import Problems.HARD.StockBrokingSystem.Models.Stock;

public abstract class Order {
    protected final String id;
    protected final Account account;
    protected final Stock stock;
    protected final int quantity;
    protected final double price;
    protected OrderStatus status;

    public Order(String id, Account account, Stock stock, int quantity, double price) {
        this.id = id;
        this.account = account;
        this.stock = stock;
        this.quantity = quantity;
        this.price = price;
        status = OrderStatus.PENDING;
    }

    public abstract void  execute();

    public String getId() {
        return id;
    }

    public Account getAccount() {
        return account;
    }

    public Stock getStock() {
        return stock;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    @Override
    public abstract String toString() ;



}
