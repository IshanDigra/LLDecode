package Problems.HARD.Splitwise.Model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Group {
    private final String id;
    private String name;
    private List<User> members;
    private List<Expense> expenses;

    public Group(String id, String name) {
        this.id = id;
        this.name = name;
        members = new CopyOnWriteArrayList<>();
        expenses = new CopyOnWriteArrayList<>();
    }

//  logical functions
    public void addMember(User user){
        members.add(user);
    }

    public void removeMember(User user){
        members.remove(user);
    }

    public void addExpense(Expense expense){
        expenses.add(expense) ;

    }

// getters & setters

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<User> getMembers() {
        return members;
    }

    public void setMembers(List<User> members) {
        this.members = members;
    }

    public List<Expense> getExpenses() {
        return expenses;
    }

    public void setExpenses(List<Expense> expenses) {
        this.expenses = expenses;
    }

    @Override
    public String toString() {
        return "Group{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", members=" + members +
                ", expenses=" + expenses +
                '}';
    }
}
