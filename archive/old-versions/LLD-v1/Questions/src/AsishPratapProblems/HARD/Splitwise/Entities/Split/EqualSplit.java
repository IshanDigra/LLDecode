package AsishPratapProblems.HARD.Splitwise.Entities.Split;

import AsishPratapProblems.HARD.Splitwise.Entities.BalanceSheet;
import AsishPratapProblems.HARD.Splitwise.Entities.IndividualExpense;
import AsishPratapProblems.HARD.Splitwise.Entities.User;

import java.util.List;
import java.util.Map;

public class EqualSplit implements SplitStrategy{
    @Override
    public void updateBalanceSheet(User user1, List<IndividualExpense> expenses, Map<User, BalanceSheet> balanceSheetMap, double amount) {
        int userCount = 1+ expenses.size();
        double individualAmount = amount/userCount;
        BalanceSheet balanceSheet1 = balanceSheetMap.getOrDefault(user1, new BalanceSheet(user1));

        for(IndividualExpense indExp: expenses){
            User user2 = indExp.getUser();
            BalanceSheet balanceSheet2 = balanceSheetMap.getOrDefault(user2, new BalanceSheet(user2));

            balanceSheet1.updateBalanceSheet(user2, -1*individualAmount);
            balanceSheet2.updateBalanceSheet(user1, individualAmount);
            balanceSheetMap.put(user2,balanceSheet2);
        }
        balanceSheetMap.put(user1,balanceSheet1);
    }
}
