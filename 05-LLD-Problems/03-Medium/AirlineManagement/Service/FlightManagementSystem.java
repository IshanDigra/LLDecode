package LLD_Problems.MEDIUM.AirlineManagementSystem.Service;

import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.PaymentMethod;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CopyOnWriteArrayList;

public class FlightManagementSystem {
    private List<Flight> flights;
    private BookingManager bookingManager;
    private PaymentProcessor paymentProcessor;
    private FlightSearch flightSearch;

    private static FlightManagementSystem instance;
    private FlightManagementSystem(){
        flights = new CopyOnWriteArrayList<>();
        bookingManager = BookingManager.getInstance();
        paymentProcessor = PaymentProcessor.getInstance();
        flightSearch = new FlightSearch(flights);
    }
    public static synchronized FlightManagementSystem getInstance(){
        if(instance == null){
            instance = new FlightManagementSystem();
        }
        return instance;
    }

//  flights

    public void addFlight(Flight flight){
        flights.add(flight);
    }

    public void removeFlight(Flight flight){
        flights.remove(flight);
    }

    public List<Flight> searchFlights(String src, String dest, LocalDate date){
        return flightSearch.getFlights(src, dest, date);
    }
// bookings

    public Booking bookFlight(Flight flight, Passanger passenger, Seat seat, double price) {
        return bookingManager.createBooking(flight, passenger, seat, price);
       // Payment payment= new Payment(generatePaymentId(), PaymentMethod.CREDITCARD,price);
       // processPayment(payment);
    }

    public void cancelBooking(Booking booking) {
        bookingManager.cancelBooking(booking);
    }

    public void processPayment(Payment payment) {
        paymentProcessor.processPayment(payment);
    }

    public String generatePaymentId(){
        return "PMT"+ UUID.randomUUID().toString();
    }
}
