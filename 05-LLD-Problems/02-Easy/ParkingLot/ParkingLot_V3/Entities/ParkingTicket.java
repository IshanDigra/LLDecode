package ParkingLot_V3.Entities;


import ParkingLot_V3.Enums.PaymentStatus;
import ParkingLot_V3.Util.IdGeneratorUtil;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class ParkingTicket {
    private final String id;
    private final Vehicle vehicle;
    private final ParkingSpot spot;

    private final LocalDateTime time;
    private PaymentStatus status;

    public ParkingTicket(Vehicle vehicle, ParkingSpot spot, LocalDateTime time) {
        id = IdGeneratorUtil.generateTicketId();
        this.vehicle = vehicle;
        this.spot = spot;
        this.time = time;
        status = PaymentStatus.PENDING;

    }

    public String getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public ParkingSpot getSpot() {
        return spot;
    }



    public LocalDateTime getTime() {
        return time;
    }

    public PaymentStatus getStatus() {
        return status;
    }

    public void setStatus(PaymentStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "ParkingTicket{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", spot=" + spot +
                ", time=" + time +
                ", status=" + status +
                '}';
    }
}
