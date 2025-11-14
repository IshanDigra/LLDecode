package AsishPratapProblems.HARD.LinkedIn.Entities;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SecurityService {
    Map<String, UserAccount> accounts;

    public SecurityService(Map<String, UserAccount> accounts) {
        this.accounts = accounts;
    }

    public void registerUser(String email, String password, String name){
        // add check if the account is already registered.

        UserAccount account = new UserAccount(name, email, password);
        // since email is a unique identifier
        accounts.put(email, account);
        System.out.println("Your account has been registered please login");
    }

    public UserAccount logIn(String email, String password){
        UserAccount account = accounts.getOrDefault(email,null);
        if(account == null){
            System.out.println("This email is not registered.");
            return null;
        }
        if(account.getPassword().equals(password)){
            System.out.println("Wrong password. Please try again");
            return null;
        }
        System.out.println("You have been successfully logged In");
        return account;
    }
}
