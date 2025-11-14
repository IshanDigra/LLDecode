package LLD_Problems.MEDIUM.HotelManagement;

import LLD_Problems.MEDIUM.HotelManagement.Constants.ReservationStatus;
import LLD_Problems.MEDIUM.HotelManagement.Constants.RoomStatus;
import LLD_Problems.MEDIUM.HotelManagement.Payment.Payment;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class HotelManagement {
    private Map<String, Guest> guests;
    private Map<String, Room> rooms;
    private Map<String, Reservation> reservations;
    private static HotelManagement hotelManagement;

    private HotelManagement(){
        guests = new HashMap<>();
        rooms = new HashMap<>();
        reservations = new HashMap<>();
    }

    public static synchronized HotelManagement getInstance(){
        if(hotelManagement == null){
            hotelManagement = new HotelManagement();
        }
        return hotelManagement;
    }

    public Room getRoom(String roomId){
        return rooms.get(roomId);
    }
    public Guest getGuest(String guestId){
        return guests.get(guestId);
    }


    public void addGuest(Guest guest){
        guests.put(guest.getId(), guest);
    }
    public void addRoom(Room room){
        rooms.put(room.getId(), room);
    }

    private String generateId(){
        return "RES"+ UUID.randomUUID().toString();
    }

    public Reservation makeReservation(Guest guest, Room room,  LocalDate startDate, LocalDate endDate){
        if(room.getStatus().equals(RoomStatus.AVAILABLE)){
            room.bookRoom();
            String reservationId = generateId();
            Reservation reservation = new Reservation(room,startDate,endDate,guest, reservationId);
            reservations.put(reservationId, reservation);
            return reservation;
        }
        System.out.println("Selected room not available");
        return null;
    }

    public void cancelReservation(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null){
            reservation.cancelReservation();
            reservations.remove(reservationId);
        }
    }

    public void checkin(String reservationId){
        Reservation reservation = reservations.get(reservationId);
        if(reservation != null && reservation.getStatus().equals(ReservationStatus.CONFIRMED)){
            reservation.getRoom().checkIn();
        }
        else throw new RuntimeException("Reservation not available");
    }
    public void checkOut(String reservationId, Payment payment){
        Reservation reservation = reservations.get(reservationId);
        double amount = reservation.getRoom().getPrice()* ChronoUnit.DAYS.between(reservation.getStartDate(), reservation.getEndDate());
        if(payment.processPayment(amount)){
            reservation.getRoom().checkOut();
            reservations.remove(reservationId);
        }
        else throw new RuntimeException("Payment not available");
    }
}
