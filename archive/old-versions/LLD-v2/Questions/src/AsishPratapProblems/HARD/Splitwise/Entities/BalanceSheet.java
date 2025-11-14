package AsishPratapProblems.HARD.Splitwise.Entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BalanceSheet {
    private final User user;
    private Map<User, Double> balances;

    public BalanceSheet(User user) {
        this.user = user;
        balances = new ConcurrentHashMap<>();
    }

    public void updateBalanceSheet(User user, double amount){
        double currentamount = balances.getOrDefault(user, 0.0);
        balances.put(user, currentamount+amount);
    }

    public User getUser() {
        return user;
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

    public void setBalances(Map<User, Double> balances) {
        this.balances = balances;
    }

    @Override
    public String toString() {
        return "BalanceSheet{" +
                "user=" + user +
                ", balances=" + balances +
                '}';
    }
}
