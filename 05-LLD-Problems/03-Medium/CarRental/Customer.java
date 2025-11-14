package LLD_Problems.MEDIUM.CarRentalSystem;

public class Customer {
    private final String name;
    private final String contactInfo;
    private final String liscense;

    public Customer(String name, String contactInfo, String liscense){
        this.name = name;
        this.contactInfo = contactInfo;
        this.liscense = liscense;
    }

    // getters method

    public String getName(){
        return name;
    }

    public String getLiscense(){
        return liscense;
    }
}
