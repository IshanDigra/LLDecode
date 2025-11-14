package LLD_Problems.ParkingLot.ParkingStrategy;

import LLD_Problems.ParkingLot.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot findSpot(List<ParkingSpot> parkingSpotList) throws Exception;
}
