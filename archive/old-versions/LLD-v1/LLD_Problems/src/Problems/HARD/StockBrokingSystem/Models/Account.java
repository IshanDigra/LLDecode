package Problems.HARD.StockBrokingSystem.Models;

import Problems.HARD.StockBrokingSystem.Exceptions.InsufficientFundsException;
import Problems.HARD.StockBrokingSystem.Service.Order;

import java.util.ArrayList;
import java.util.List;

public class Account {
    private final String id;
    private final User user;
    private final Portfolio portfolio;
    private double balance;
    private final List<Order> orders;

    public Account(String id, User user, double initialBalance) {
        this.id = id;
        this.user = user;
        portfolio = new Portfolio(this);
        balance = initialBalance ;
        orders = new ArrayList<>();
    }


    public void addOrder(Order order){
        orders.add(order);
    }

    public void deposit(double funds){
        balance += funds;
    }

    public void withdraw(double funds){
        if(funds<=balance){
            balance -= funds;
        }
//      add exceptions and everything
        else{
            throw new InsufficientFundsException("Insufficient funds in aacount!");
        }
    }

    public List<Order> getOrders() {
        return orders;
    }

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Portfolio getPortfolio() {
        return portfolio;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id='" + id + '\'' +
                ", user=" + user +
                ", portfolio=" + portfolio +
                ", balance=" + balance +
                '}';
    }
}
