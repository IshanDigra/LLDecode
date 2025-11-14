package LLD_Problems.MEDIUM.CarRentalSystem;

public class Car {
    private String make;
    private String model ;
    private int year;
    private String liscensePlate;
    private double rentalPricePerDay;
    public Boolean isAvailable;

    public Car(String make, String model, int year, String LiscensePlate, Double rentalPricePerDay){
        this.make = make;
        this.model = model;
        this.year = year;
        this.liscensePlate = LiscensePlate;

        this.rentalPricePerDay = rentalPricePerDay;
        isAvailable = true;
    }

    // getters
    public boolean getAvailable(){
        return isAvailable;
    }

    public String getLiscensePlate(){
        return liscensePlate;
    }

    public Double getRentalPricePerDay(){
        return rentalPricePerDay;
    }

    public String getModel(){
        return model ;
    }

    // setter
    public void setAvailable(Boolean available){
        this.isAvailable = available;
    }

    public String getMake(){
        return make;
    }

    @Override
    public String toString() {
        return "Car{" +
                "make='" + make + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                ", liscensePlate='" + liscensePlate + '\'' +
                ", rentalPricePerDay=" + rentalPricePerDay +
                ", isAvailable=" + isAvailable +
                '}';
    }
}
