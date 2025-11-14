package Problems.MEDIUM.TicketBookingSystem.Service;

import Problems.MEDIUM.TicketBookingSystem.Constants.SeatStatus;
import Problems.MEDIUM.TicketBookingSystem.Model.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

import static Problems.MEDIUM.TicketBookingSystem.Service.PaymentProcessor.processPayment;

public class ConcertBookingSystem {
    private static ConcertBookingSystem concertInstance;
    private ConcertSearchService concertSearchService;
    private final List<Concert> concerts;
    private final Map<String, Booking> bookings;


    private ConcertBookingSystem() {
        concerts = new CopyOnWriteArrayList<>();
        bookings = new ConcurrentHashMap<>();
        concertSearchService = new ConcertSearchService(concerts);

    }

    public static synchronized ConcertBookingSystem getInstance(){
        if(concertInstance == null){
            concertInstance = new ConcertBookingSystem();
        }
        return concertInstance;
    }

    public void addConcert(Concert concert) {
        concerts.add(concert);
    }



    public List<Concert> searchConcerts(String artist, String venue, LocalDateTime dateTime) {
        return concertSearchService.searchConcerts(artist,venue,dateTime);
    }

    public Booking bookTickets(User user, Concert concert, List<Seat> seats) {

        for(Seat seat : seats){
            if (seat.getStatus()!= SeatStatus.AVAILABLE){
                concert.getWaitList().addToWaitlist(user);
            }
            else{
                seat.bookSeat();
            }

        }


        // Create booking - if waitlist seats done then money returned/
        String bookingId = generateBookingId();
        Booking booking = new Booking(bookingId, concert, user, seats);
        bookings.put(bookingId, booking);

        // Process payment
        processPayment();

        // Confirm booking
        booking.confirmBooking();

        System.out.println("Booking " + booking.getId() + " - " + booking.getSeats().size() + " seats booked");

        return booking;
    }

    public void cancelBooking(String bookingId) {
        Booking booking = bookings.get(bookingId);
        if (booking != null) {
            booking.cancelBooking();
            bookings.remove(bookingId);
        }
    }

    private String generateBookingId(){
        return "BKG"+ UUID.randomUUID().toString();
    }
}
