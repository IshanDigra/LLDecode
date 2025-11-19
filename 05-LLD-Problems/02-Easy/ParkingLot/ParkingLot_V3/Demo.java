package ParkingLot_V3;


import ParkingLot_V3.Entities.ParkingLevel;
import ParkingLot_V3.Entities.ParkingSpot;
import ParkingLot_V3.Entities.ParkingTicket;
import ParkingLot_V3.Entities.Vehicle;
import ParkingLot_V3.Enums.VehicleType;
import ParkingLot_V3.Services.ParkingLot;
import ParkingLot_V3.Services.Payment.CashPayment;
import ParkingLot_V3.Services.TicketFareStrategy.FixedFare;
import ParkingLot_V3.Services.TicketFareStrategy.HourlyFare;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class Demo {

    public static void main(String[] args) {
        Logger logger = Logger.getLogger("Main");
        ParkingLot pl = ParkingLot.getInstace();
        pl.addLevel(new ParkingLevel(Arrays.asList(new ParkingSpot( VehicleType.TWO_WHEELER)
        ,new ParkingSpot(VehicleType.FOUR_WHEELER),
                new ParkingSpot(VehicleType.FOUR_WHEELER))));




        Vehicle v1 = new Vehicle(VehicleType.FOUR_WHEELER,"Ishan's car");
        Vehicle v2 = new Vehicle(VehicleType.TWO_WHEELER,"Ishan's bike");
        Vehicle v3 = new Vehicle(VehicleType.SIX_WHEELER,"Ishan's truck");

        List<ParkingSpot> spots = pl.getParkingSpots(VehicleType.FOUR_WHEELER);
        if(spots.size()!=0){
            logger.info("Free Four Wheeler Spots");
            spots.forEach(s-> logger.info("Spot ID: "+ s.getId()));
        }
        ParkingTicket t1 = pl.parkVehicle(v1);
        ParkingTicket t2 = pl.parkVehicle(v2);
        logger.info(t1.toString());
        logger.info(t2.toString());
        pl.parkVehicle(v3);


        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double fare = pl.getTicketFare(new FixedFare(), t1,  Map.of(VehicleType.TWO_WHEELER, 50.0, VehicleType.FOUR_WHEELER, 100.0));
        double fare2 = pl.getTicketFare(new HourlyFare(),t2,Map.of(VehicleType.TWO_WHEELER, 50.0, VehicleType.FOUR_WHEELER, 100.0));
        logger.info(""+fare);
        logger.info(""+fare2);

        pl.makePayment(new CashPayment(),7.0, fare, t1);
        pl.makePayment(new CashPayment(),100.0, fare, t1);
        logger.info(t1.toString());

    }
}
