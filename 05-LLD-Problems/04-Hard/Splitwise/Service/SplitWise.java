package Problems.HARD.Splitwise.Service;

import Problems.HARD.Splitwise.Model.Expense;
import Problems.HARD.Splitwise.Model.Group;
import Problems.HARD.Splitwise.Model.Split.EqualSplit;
import Problems.HARD.Splitwise.Model.Split.PercentageSplit;
import Problems.HARD.Splitwise.Model.Split.Split;
import Problems.HARD.Splitwise.Model.User;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SplitWise {
    private static SplitWise instance;
    private final Map<String, User> users;
    private final Map<String, Group> groups;

    private static final String TRANSACTION_ID_PREFIX = "TXN";


    private SplitWise() {
        users = new ConcurrentHashMap<>();
        groups = new ConcurrentHashMap<>();
    }

    public static synchronized SplitWise getInstance() {
        if (instance == null) {
            instance = new SplitWise();
        }
        return instance;
    }

    public void addUser(User user) {
        users.put(user.getId(), user);
    }

    public void addGroup(Group group) {
        groups.put(group.getId(), group);
    }

    public void addExpense(String groupId, Expense expense) {
        Group group = groups.get(groupId);
        if (group != null) {

            splitExpense(expense);
            updateBalances(expense);
            group.addExpense(expense);
        }
    }

    private void splitExpense(Expense expense) {
        double totalAmount = expense.getAmount();
        List<Split> splits = expense.getSplits();
        int totalSplits = splits.size();

        double splitAmount = totalAmount / totalSplits;
        for (Split split : splits) {
            if (split instanceof EqualSplit) {
                split.setAmount(splitAmount);
            } else if (split instanceof PercentageSplit percentSplit) {
                split.setAmount(totalAmount * percentSplit.getPercent() / 100.0);
            }
        }
    }

    private void updateBalances(Expense expense) {
        for (Split split : expense.getSplits()) {
            User paidBy = expense.getPaidBy();
            User user = split.getUser();
            double amount = split.getAmount();

            if (!paidBy.equals(user)) {
                updateBalance(paidBy, user, amount);
                updateBalance(user, paidBy, -amount);
            }
        }
    }

    private void updateBalance(User user1, User user2, double amount) {

        user1.getBalances().put(user2, user1.getBalances().getOrDefault(user2, 0.0) + amount);
    }
}
