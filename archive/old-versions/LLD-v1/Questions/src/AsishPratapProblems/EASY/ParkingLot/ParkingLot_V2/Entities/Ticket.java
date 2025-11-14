package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Entities;

import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.PaymentStatus;

import java.sql.Timestamp;

public class Ticket {
    private final int id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;
    private final Timestamp time;
    private  PaymentStatus status;

    public Ticket(int id, Vehicle vehicle, ParkingSpot spot, Timestamp time) {
        this.id = id;
        this.vehicle = vehicle;
        this.spot = spot;
        this.time = time;
        status = PaymentStatus.PENDING;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }

    public Timestamp getTime() {
        return time;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", spot=" + spot +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}
