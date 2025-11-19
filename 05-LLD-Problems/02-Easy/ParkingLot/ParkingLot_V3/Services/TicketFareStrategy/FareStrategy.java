package ParkingLot_V3.Services.TicketFareStrategy;

import ParkingLot_V3.Entities.ParkingTicket;
import ParkingLot_V3.Entities.Vehicle;
import ParkingLot_V3.Enums.VehicleType;
import ParkingLot_V3.Services.ParkingLot;

import java.util.Map;
import java.util.logging.Logger;

public interface FareStrategy {
    public double getTicketFare(ParkingTicket ticket, Map<VehicleType, Double> fare);
}
