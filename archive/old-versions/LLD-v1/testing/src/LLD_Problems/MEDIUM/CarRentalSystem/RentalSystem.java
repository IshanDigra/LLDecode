package LLD_Problems.MEDIUM.CarRentalSystem;

import LLD_Problems.MEDIUM.CarRentalSystem.Payments.CreditCardProcessing;
import LLD_Problems.MEDIUM.CarRentalSystem.Payments.PaymentProcessing;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class RentalSystem {
    private Map<String,Car> availableCars;
    private Map<String, Reservation> reservations;
    private PaymentProcessing paymentProcessor;

    private static RentalSystem rentalSystem;

    private RentalSystem(){
        availableCars = new ConcurrentHashMap<>();
        reservations = new ConcurrentHashMap<>();
        paymentProcessor = new CreditCardProcessing();
    }
    public static synchronized RentalSystem getInstance(){
        if(rentalSystem == null){
            rentalSystem = new RentalSystem();
        }
        return rentalSystem;
    }

    public void addCar(Car car){
        availableCars.put(car.getLiscensePlate(), car);
    }
    public void removeCar(String liscensePlate){
        availableCars.remove(liscensePlate);
    }
    public Reservation makeReservation(Customer customer, Car car, LocalDate startDate, LocalDate endDate){
        if(isCarAvailable(car, startDate, endDate)){
           // availableCars.remove(car.getLiscensePlate());
            Reservation carreservation = new Reservation(car, customer, startDate, endDate);
            reservations.put(carreservation.getId(), carreservation);
            return carreservation;
        }
        return null;
    }

    private boolean isCarAvailable(Car car, LocalDate startDate, LocalDate endDate){
        for( Reservation reservation : reservations.values()){
            if(reservation.getCar().equals(car)){
                if(endDate.isBefore(reservation.getStartDate())|| startDate.isAfter(reservation.getEndDate())){
                    return true;
                }
                else return false ;
            }
        }

        return availableCars.containsKey(car.getLiscensePlate()) ;
    }

    public void deleteReservation(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        reservations.remove(reservationId);
        if(reservation!=null){
            availableCars.put(reservation.getCar().getLiscensePlate(), reservation.getCar());
        }
    }

    public List<Car> searchCars(String make, String model, LocalDate startDate, LocalDate endDate){
        List<Car> cars = new ArrayList<>();
        for(Car car : availableCars.values()){
            if(car.getMake().equals(make) && car.getModel().equals(model) && isCarAvailable(car, startDate, endDate)){
                cars.add(car);
            }
        }
        return cars;
    }

    public boolean processPayment(Reservation reservation) {
        return paymentProcessor.processPayment(reservation.getTotalPrice());
    }

}
