package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2;

import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Entities.*;
import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Entities.*;

import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.VehicleType;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Demo {
    public static void main(String[] args) {
        ParkingLot pl = ParkingLot.getInstace();
        pl.addLevel(new ParkingLevel(IdGeneratorUtil.getParkingLevelId(), Arrays.asList(new ParkingSpot(IdGeneratorUtil.getParkingSpotId(), VehicleType.TWO_WHEELER)
        ,new ParkingSpot(IdGeneratorUtil.getParkingSpotId(), VehicleType.FOUR_WHEELER),
                new ParkingSpot(IdGeneratorUtil.getParkingSpotId(), VehicleType.FOUR_WHEELER))));

        pl.setFare(Map.of(VehicleType.TWO_WHEELER, 2.0, VehicleType.FOUR_WHEELER, 4.0));


        Vehicle v1 = new Vehicle(VehicleType.FOUR_WHEELER,"Ishan's car");
        Vehicle v2 = new Vehicle(VehicleType.TWO_WHEELER,"Ishan's bike");
        Vehicle v3 = new Vehicle(VehicleType.SIX_WHEELER,"Ishan's truck");

        List<ParkingSpot> spots = pl.getParkingSpots(VehicleType.FOUR_WHEELER);
        if(spots.size()!=0){
            System.out.println("Free Four Wheeler Spots");
            spots.forEach(s-> System.out.println("Spot ID: "+ s.getId()));
        }
        Ticket t1 = pl.parkVehicle(v1);
        Ticket t2 = pl.parkVehicle(v2);
        System.out.println(t1);
        System.out.println(t2);
        pl.parkVehicle(v3);


        try {
            Thread.sleep(2100);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        double fare = pl.getTicketFare(t1);
        double fare2 = pl.getTicketFare(t2);
        System.out.println(fare);
        System.out.println(fare2);

        pl.makePayment(7,t1);
        pl.makePayment(7,t2);
    }
}
