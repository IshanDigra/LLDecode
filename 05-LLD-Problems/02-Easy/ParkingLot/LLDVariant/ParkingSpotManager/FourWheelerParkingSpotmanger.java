package LLD_Problems.ParkingLot.ParkingSpotManager;

import LLD_Problems.ParkingLot.ParkingSpot;
import LLD_Problems.ParkingLot.ParkingStrategy.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;

public class FourWheelerParkingSpotmanger extends ParkingSpotManager{
    public FourWheelerParkingSpotmanger(ParkingStrategy strategy, List<ParkingSpot> spots) {
        super(strategy, spots);
    }
}
