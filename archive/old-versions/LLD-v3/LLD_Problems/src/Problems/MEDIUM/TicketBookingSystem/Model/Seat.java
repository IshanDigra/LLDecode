package Problems.MEDIUM.TicketBookingSystem.Model;

import Problems.MEDIUM.TicketBookingSystem.Constants.SeatStatus;
import Problems.MEDIUM.TicketBookingSystem.Constants.SeatType;

public class Seat {
    private final String id;
    private final String number;
    private final SeatType type;
    private final double price;
    private SeatStatus status;

    public Seat(String id, String number, SeatType type, double price) {
        this.id = id;
        this.number = number;
        this.type = type;
        this.price = price;
        status = SeatStatus.AVAILABLE;
    }

    public void bookSeat(){
        if(status == SeatStatus.AVAILABLE){
            status = SeatStatus.BOOKED;
            System.out.println("seat with number "+ number+ " Booked" );
        }
        else System.out.println("Seat is not available for booking");
    }

    public void releaseSeat(){
        if(status == SeatStatus.BOOKED){
            status = SeatStatus.AVAILABLE;
            System.out.println("seat with number "+ number+ " Available for booking" );
        }
    }

    public String getId() {
        return id;
    }

    public String getNumber() {
        return number;
    }

    public SeatType getType() {
        return type;
    }

    public double getPrice() {
        return price;
    }

    public SeatStatus getStatus() {
        return status;
    }

    public void setStatus(SeatStatus status) {
        this.status = status;
    }
}
