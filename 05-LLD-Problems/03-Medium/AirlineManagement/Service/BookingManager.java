package LLD_Problems.MEDIUM.AirlineManagementSystem.Service;

import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Booking;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Flight;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Passanger;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Seat;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;

public class BookingManager {
    Map<String, Booking> bookings;
    private static BookingManager bookingManager;
    private BookingManager(){
        bookings = new ConcurrentHashMap<>();
    }
    public static synchronized BookingManager getInstance(){
        if(bookingManager == null){
            bookingManager = new BookingManager();
        }
        return bookingManager;
    }

    public Booking createBooking(Flight flight, Passanger passenger, Seat seat, double price){
        Booking booking = new Booking(generateBookingID(), flight, passenger, seat, price);
        bookings.put(booking.getBookingID(), booking);
        return booking;
    }

    public void cancelBooking(Booking booking){
        bookings.remove(booking.getBookingID());
    }

    private String generateBookingID(){
        return "BKG" + UUID.randomUUID().toString();
    }
}
