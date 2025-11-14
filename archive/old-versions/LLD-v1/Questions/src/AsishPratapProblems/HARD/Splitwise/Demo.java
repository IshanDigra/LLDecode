package AsishPratapProblems.HARD.Splitwise;


import AsishPratapProblems.HARD.Splitwise.Entities.Group;
import AsishPratapProblems.HARD.Splitwise.Entities.IndividualExpense;
import AsishPratapProblems.HARD.Splitwise.Entities.SplitWise;
import AsishPratapProblems.HARD.Splitwise.Entities.User;
import AsishPratapProblems.HARD.Splitwise.Enums.SplitType;

import java.util.Arrays;

public class Demo {
    public static void main(String[] args) {
        User user1 = new User("1", "ishan", "");
        User user2 = new User("2", "gargi", "");
        User user3 = new User("3", "pallav", "");
        User user4 = new User("4", "mehak", "");

        SplitWise sw = SplitWise.getInstance();
        Group family = sw.createGroup("Family", user1, Arrays.asList(user2,user3,user4));
      //  System.out.println(family);

        sw.addNormalExpense(user1, Arrays.asList(new IndividualExpense(user2)), 100.0, SplitType.EQUAL);

        sw.addGroupExpense(family,user1, Arrays.asList(new IndividualExpense(user2),new IndividualExpense(user3), new IndividualExpense(user4)), 100.0, SplitType.EQUAL );
        sw.settleUp(user2, user1, 75);
        System.out.println(sw.getBalanceSheets());
        System.out.println(sw.viewTransactionHistory(user2));
       // sw.viewGroupExpense(family);
        //System.out.println(sw.);
    }
}
