package LLD_Problems.MEDIUM.HotelManagement;

import LLD_Problems.MEDIUM.HotelManagement.Constants.ReservationStatus;

import java.time.LocalDate;
import java.util.Date;

public class Reservation {
    private final String id;
    private Room room;
    private LocalDate startDate;
    private LocalDate endDate;
    private Guest guest;
    private ReservationStatus status;

    public Reservation(Room room, LocalDate startDate, LocalDate endDate, Guest guest, String id) {
        this.room = room;
        this.startDate = startDate;
        this.endDate = endDate;
        this.guest = guest;
        this.id = id;
        status = ReservationStatus.CONFIRMED;
    }

    // getters

    public String getId() {
        return id;
    }

    public Room getRoom() {
        return room;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public Guest getGuest() {
        return guest;
    }

    public ReservationStatus getStatus() {
        return status;
    }

    // setters

    public void setRoom(Room room) {
        this.room = room;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public void setGuest(Guest guest) {
        this.guest = guest;
    }

    public void setStatus(ReservationStatus status) {
        this.status = status;
    }

    // business logic
    public void cancelReservation() {
        if(status.equals(ReservationStatus.CONFIRMED)){
            status = ReservationStatus.CANCELLED;
            room.checkOut();
        }
        else{
            throw new IllegalArgumentException("Reservation is not CONFIRMED");
        }
    }
}
