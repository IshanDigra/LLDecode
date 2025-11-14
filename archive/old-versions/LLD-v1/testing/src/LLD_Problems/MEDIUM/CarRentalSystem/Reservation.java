package LLD_Problems.MEDIUM.CarRentalSystem;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.UUID;

public class Reservation {
    private String id ;
    private Car car;
    private Customer customer;
    private LocalDate startDate;
    private LocalDate endDate;
    private double totalPrice;

    public Reservation(Car car, Customer customer, LocalDate startDate, LocalDate endDate){
        this.car = car;
        this.customer = customer;
        this.startDate = startDate;
        this.endDate = endDate;
        totalPrice = getTotalPrice();
        id = UUID.randomUUID().toString();
    }

    public double getTotalPrice(){
        long days = ChronoUnit.DAYS.between(startDate, endDate) + 1;
        return days*(car.getRentalPricePerDay());
    }

    public String getId(){
        return id;
    }

    public Car getCar(){
        return car;
    }

    public LocalDate getStartDate(){
        return startDate;
    }

    public LocalDate getEndDate(){
        return endDate;
    }

}
