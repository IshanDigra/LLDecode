package LLD_Problems.MEDIUM.AirlineManagementSystem.Model;

import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.BookingStatus;

public class Booking {
    private final String bookingID;
    private Flight flight;
    private Passanger passanger;
    private Seat selectedSeat;
    private BookingStatus bookingStatus;
    private double price;

    public Booking(String bookingID, Flight flight, Passanger passanger, Seat selectedSeat, double price) {
        this.bookingID = bookingID;
        this.flight = flight;
        this.passanger = passanger;
        this.selectedSeat = selectedSeat;
        this.bookingStatus = BookingStatus.PENDING;
        this.price = price;
    }

    // logic
    public void cancelBooking(){
        bookingStatus = BookingStatus.CANCELLED;
    }
    public void makeBooking(){
        bookingStatus = BookingStatus.APPROVED;
    }

    public String getBookingID() {
        return bookingID;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Passanger getPassanger() {
        return passanger;
    }

    public void setPassanger(Passanger passanger) {
        this.passanger = passanger;
    }

    public Seat getSelectedSeat() {
        return selectedSeat;
    }

    public void setSelectedSeat(Seat selectedSeat) {
        this.selectedSeat = selectedSeat;
    }

    public BookingStatus getBookingStatus() {
        return bookingStatus;
    }

    public void setBookingStatus(BookingStatus bookingStatus) {
        this.bookingStatus = bookingStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
