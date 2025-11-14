package LLD_Problems.MEDIUM.ATM;

public class User {
    private String name;
    private final Card card;
    private Account account;

    public User(String name) {
        this.name = name;
       // account = new Account(this);
        card = new Card();
    }

    // getters
    public Account getAccount(){return account; }
    public Card getCard(){return card;}

    // setters

    // Business Logic
}
