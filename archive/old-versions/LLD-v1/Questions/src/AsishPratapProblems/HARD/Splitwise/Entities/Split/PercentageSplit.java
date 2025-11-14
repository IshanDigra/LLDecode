package AsishPratapProblems.HARD.Splitwise.Entities.Split;

import AsishPratapProblems.HARD.Splitwise.Entities.BalanceSheet;
import AsishPratapProblems.HARD.Splitwise.Entities.IndividualExpense;
import AsishPratapProblems.HARD.Splitwise.Entities.User;

import java.util.List;
import java.util.Map;

public class PercentageSplit implements SplitStrategy{
    @Override
    public void updateBalanceSheet(User user, List<IndividualExpense> expenses, Map<User, BalanceSheet> balanceSheetMap, double amount) {

    }
}
