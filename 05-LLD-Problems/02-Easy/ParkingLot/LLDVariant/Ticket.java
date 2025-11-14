package LLD_Problems.ParkingLot;

import java.sql.Timestamp;

public class Ticket {
    /*ticketId, ParkingSpot, vehicle, intime,*/

    private final int ticketId;
    private final ParkingSpot parkingSpot;
    private final Vehicle vehicle;
    private final Timestamp inTime;

    public Ticket(int ticketId, ParkingSpot parkingSpot, Vehicle vehicle) {
        this.ticketId = ticketId;
        this.parkingSpot = parkingSpot;
        this.vehicle = vehicle;
        inTime = new Timestamp(System.currentTimeMillis());
    }


    public int getTicketId() {
        return ticketId;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Timestamp getInTime() {
        return inTime;
    }


    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", parkingSpot=" + parkingSpot +
                ", vehicle=" + vehicle +
                ", inTime=" + inTime +
                '}';
    }
}
