package AsishPratapProblems.HARD.Splitwise.Entities;

import AsishPratapProblems.HARD.Splitwise.Entities.Split.SplitFactory;
import AsishPratapProblems.HARD.Splitwise.Entities.Split.SplitStrategy;
import AsishPratapProblems.HARD.Splitwise.Enums.SplitType;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class SplitWise {
    private static SplitWise instance;
    private SplitFactory factory;
    private Map<String, User> users;
    private Map<User, List<Transaction>> transactionList;
    private List<Group> groups;
    private Map<User, BalanceSheet> balanceSheets;


    private SplitWise(){
        factory = new SplitFactory();
        users = new ConcurrentHashMap<>();
        transactionList = new ConcurrentHashMap<>();
        groups = new ArrayList<>();
        balanceSheets = new ConcurrentHashMap<>();
    }
    public static synchronized SplitWise getInstance(){
        if(instance==null){
            instance = new SplitWise();
        }
        return instance;
    }

    public void addUser(User user){
        users.put(user.getId(), user);
    }
    public Group createGroup(String id,User user, List<User> userList){
        Group group = new Group(id) ;
        group.addUser(user);
        for(User users : userList){
            group.addUser(users);
        }

        groups.add(group);
        return group;
    }

    public Expense addNormalExpense(User user, List<IndividualExpense> expenses, double amount, SplitType type) {
        Expense expense= new Expense(generateExpenseId(), user, expenses, amount, type);
        SplitStrategy strategy = factory.getStrategy(type);
        // equalSplit or the other two.
        strategy.updateBalanceSheet(user, expenses, balanceSheets, amount);
        return expense;
    }

    public Expense addGroupExpense(Group group, User user, List<IndividualExpense> expenses, double amount, SplitType type) {
        Expense expense= new Expense(generateExpenseId(), user, expenses, amount, type);
        SplitStrategy strategy = factory.getStrategy(type);
        // equalSplit or the other two.
        strategy.updateBalanceSheet(user, expenses, balanceSheets, amount);
        group.addExpense(expense);
        return expense;
    }

    public void settleUp(User user1, User user2, double amount){
        Transaction tr = new Transaction(generateTransactionId(),user1, user2, amount);
        List<Transaction> currList = transactionList.getOrDefault(user1, new ArrayList<>());
        currList.add(tr);
        List<Transaction> currList2 = transactionList.getOrDefault(user2, new ArrayList<>());
        currList2.add(tr);
        transactionList.put(user1,currList);
        transactionList.put(user2,currList2);
        BalanceSheet b1 = balanceSheets.getOrDefault(user1, new BalanceSheet(user1));
        BalanceSheet b2 = balanceSheets.getOrDefault(user2, new BalanceSheet(user2));
        b1.updateBalanceSheet(user2,-1*amount);
        b2.updateBalanceSheet(user1, amount);
    }

    public List<Transaction> viewTransactionHistory(User user){
        return transactionList.getOrDefault(user, new ArrayList<>());
    }

    public void viewGroupExpense(Group group){
        List<Expense> expenses = group.getExpenses();
        expenses.stream().forEach(r-> System.out.println(r));

    }


    private String generateExpenseId(){
        return "Exp"+UUID.randomUUID().toString();
    }
    private String generateTransactionId(){
        return "TRN"+UUID.randomUUID().toString();
    }

    public Map<User, BalanceSheet> getBalanceSheets() {
        return balanceSheets;
    }
}
