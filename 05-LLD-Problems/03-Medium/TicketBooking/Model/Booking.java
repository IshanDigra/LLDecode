package Problems.MEDIUM.TicketBookingSystem.Model;

import Problems.MEDIUM.TicketBookingSystem.Constants.BookingStatus;

import java.util.List;

public class Booking {
    private final String id;
    private final Concert concert;
    private final User user;
    private final List<Seat> seats;
    private final double amount;
    private BookingStatus status;

    public Booking(String id, Concert concert, User user, List<Seat> seats) {
        this.id = id;
        this.concert = concert;
        this.user = user;
        this.seats = seats;
        this.amount = calculateTotal();
        status = BookingStatus.PENDING;
    }

    private double calculateTotal(){
        return seats.stream().mapToDouble((n)->n.getPrice()).sum();
    }

    public void confirmBooking(){
        if (status == BookingStatus.PENDING) {
            status = BookingStatus.BOOKED;
            // Send booking confirmation to the user
            // ...
        }
    }

    public void cancelBooking(){
        if (status == BookingStatus.BOOKED) {
            for(Seat seat : seats){
                seat.releaseSeat();
            }
            status = BookingStatus.CANCELLED;
            System.out.println("Booking canceled for User "+ user.getName() +" for concert "+ concert.getArtist());
        }
    }

    public String getId() {
        return id;
    }

    public Concert getConcert() {
        return concert;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public double getAmount() {
        return amount;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
