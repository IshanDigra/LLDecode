package Problems.HARD.Splitwise.Model;

import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class User {
    private final String id;
    private  String name;
    private  String email;

    private final Map<User,Double> balances;

    public User(String name, String email, String id) {
        this.name = name;
        this.email = email;
        balances = new ConcurrentHashMap<>();
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public Map<User, Double> getBalances() {
        return balances;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", balances=" + balances +
                '}';
    }
}
