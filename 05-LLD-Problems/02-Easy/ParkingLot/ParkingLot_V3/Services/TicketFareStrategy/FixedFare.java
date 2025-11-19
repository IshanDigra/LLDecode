package ParkingLot_V3.Services.TicketFareStrategy;

import ParkingLot_V3.Entities.ParkingTicket;
import ParkingLot_V3.Enums.VehicleType;

import java.util.Map;

public class FixedFare implements FareStrategy{

    @Override
    public double getTicketFare(ParkingTicket ticket, Map<VehicleType, Double> fare) {
        // check for the type should exist.
        if(!fare.containsKey(ticket.getVehicle().getType())){
            throw new RuntimeException("fare for the mentioned vehicle type not provided");
        }
        return fare.get(ticket.getVehicle().getType());
    }
}
