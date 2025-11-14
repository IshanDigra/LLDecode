package LLD_Problems.MEDIUM.ATM;

public class Dispenser {
    private double availableCash;

    public Dispenser(double initialCash) {
        this.availableCash = initialCash;
    }

    public void dispense(double amount) throws Exception {
        if(availableCash >= amount){
            availableCash -= amount;
            System.out.println("Dispensing " + amount + " cash");
        }
        else{
            throw new IllegalArgumentException("The available balance of atm is low!");
        }
    }
}
