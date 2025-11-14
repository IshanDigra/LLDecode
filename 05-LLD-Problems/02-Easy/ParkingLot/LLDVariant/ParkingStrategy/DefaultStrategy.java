package LLD_Problems.ParkingLot.ParkingStrategy;

import LLD_Problems.ParkingLot.ParkingSpot;

import java.util.List;

public class DefaultStrategy implements ParkingStrategy{

    @Override
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList) throws Exception {
        for(ParkingSpot spot : parkingSpotList){
            if(spot.isEmpty()) return spot;
        }

        throw new RuntimeException("No parking Spot available right Now");
    }
}
