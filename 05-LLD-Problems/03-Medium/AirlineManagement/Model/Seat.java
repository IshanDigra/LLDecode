package LLD_Problems.MEDIUM.AirlineManagementSystem.Model;

import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.SeatStatus;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.SeatType;

public class Seat {
    private final int seatNumber;
    private SeatType seatType;
    private SeatStatus seatStatus;

    public Seat(int seatNumber, SeatType seatType, SeatStatus seatStatus) {
        this.seatNumber = seatNumber;
        this.seatType = seatType;
        this.seatStatus = seatStatus;
    }

    public int getSeatNumber() {
        return seatNumber;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public SeatStatus getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(SeatStatus seatStatus) {
        this.seatStatus = seatStatus;
    }
}
