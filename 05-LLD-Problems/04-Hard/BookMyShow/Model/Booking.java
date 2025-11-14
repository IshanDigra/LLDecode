package Problems.HARD.BookMyShow.Model;

import Problems.HARD.BookMyShow.Constants.BookingStatus;

import java.util.List;

public class Booking {
    private final String id;
    private final User user;
    private final List<Seat> seats;
    private final Show show;
    private final double price;
    private BookingStatus status;

    public Booking(String id, User user, List<Seat> seats, Show show) {
        this.id = id;
        this.user = user;
        this.seats = seats;
        this.show = show;
        this.price = getTotalPrice();
        status = BookingStatus.PENDING;
    }

    public double getTotalPrice(){
        return seats.stream().mapToDouble(n->n.getPrice()).sum();
    }

//    public void confirmBooking(){
//        if(status == BookingStatus.PENDING){
//            status = BookingStatus.COMPLETED;
//            System.out.println("Booking Confirmed for User "+user.getName()+ " with booking id :" + id);
//        }
//    }
//
//    public void cancelBooking

    public String getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public Show getShow() {
        return show;
    }

    public double getPrice() {
        return price;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
