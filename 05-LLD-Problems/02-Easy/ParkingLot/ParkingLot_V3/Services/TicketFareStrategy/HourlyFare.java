package ParkingLot_V3.Services.TicketFareStrategy;

import ParkingLot_V3.Entities.ParkingTicket;
import ParkingLot_V3.Enums.VehicleType;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Map;

public class HourlyFare implements FareStrategy{
    @Override
    public double getTicketFare(ParkingTicket ticket, Map<VehicleType, Double> fare) {
        // for testing purpose adding seconds
        long hours = ChronoUnit.SECONDS.between(ticket.getTime(), LocalDateTime.now());
        if(!fare.containsKey(ticket.getVehicle().getType())){
            throw new RuntimeException("fare for the mentioned vehicle type not provided");
        }
        return fare.get(ticket.getVehicle().getType())*hours;
    }
}
