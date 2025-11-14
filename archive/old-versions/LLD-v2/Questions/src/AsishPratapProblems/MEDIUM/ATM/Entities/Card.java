package AsishPratapProblems.MEDIUM.ATM.Entities;

public class Card {
    private final String cardNumber;
    private final String cvv;
    private final String expiryDate;
    private final String userName;

    public Card(String cardNumber, String cvv, String expiryDate, String userName) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.expiryDate = expiryDate;
        this.userName = userName;
    }
}
