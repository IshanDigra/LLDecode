package LLD_Problems.ParkingLot;

import LLD_Problems.ParkingLot.ParkingSpotManager.FourWheelerParkingSpotmanger;
import LLD_Problems.ParkingLot.ParkingSpotManager.ParkingSpotManager;
import LLD_Problems.ParkingLot.ParkingSpotManager.TwoWheelerParkingSpotManager;
import LLD_Problems.ParkingLot.ParkingStrategy.DefaultStrategy;

import java.util.ArrayList;
import java.util.List;

public class ParkingSportManagerFactory {
    public ParkingSpotManager getParkingSpotManager(VehicleType type, List<ParkingSpot> spots){
        if(type.equals(VehicleType.TWO_WHEELER)){
            return new TwoWheelerParkingSpotManager(new DefaultStrategy(), spots);
        }
        else {
            return new FourWheelerParkingSpotmanger(new DefaultStrategy(), spots);
        }
    }
}
