package Problems.MEDIUM.DigitalWalletSystem.Model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private final String id;
    private String name;
    private String email;
    private String password;
    private List<Account> accounts;

    public User(String id, String name, String email, String password) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.password = password;
        this.accounts = new CopyOnWriteArrayList<>();
    }

    // business logic
    public void addAccount(Account account){
        accounts.add(account);
    }
    public void removeAccount(Account account){
        accounts.remove(account);
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Account> getAccounts() {
        return accounts;
    }

    public void setAccounts(List<Account> accounts) {
        this.accounts = accounts;
    }
}
