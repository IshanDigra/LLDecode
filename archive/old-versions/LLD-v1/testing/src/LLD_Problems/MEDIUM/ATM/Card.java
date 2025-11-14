package LLD_Problems.MEDIUM.ATM;

import java.util.UUID;

public class Card {
    private final String cardNumber;
    private int pin;

    public Card() {
        this.cardNumber = UUID.randomUUID().toString();
        this.pin = UUID.randomUUID().hashCode();
    }

    // getters
    public String getCardNumber() {
        return cardNumber;
    }

    public int getPin() {
        return pin;
    }

    // setter
    public void setPin(int pin) {
        this.pin = pin;
    }
}
