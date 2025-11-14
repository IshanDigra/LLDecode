package AsishPratapProblems.HARD.Splitwise.Entities;

import java.util.LinkedList;
import java.util.List;

public class Group {
    private final String id;
    private List<User> users;
    private List<Expense> expenses;

    public Group(String id) {
        this.id = id;
        users = new LinkedList<>();
        expenses = new LinkedList<>();
    }

    public void addExpense(Expense e){
        expenses.add(e);
    }
    public void addUser(User user){
        users.add(user);
    }
    public void removeUser(User user){
        users.remove(user);
    }

    public void viewGroupExpense(){

    }

    public String getId() {
        return id;
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
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
                ", users=" + users +
                ", expenses=" + expenses +
                '}';
    }
}
