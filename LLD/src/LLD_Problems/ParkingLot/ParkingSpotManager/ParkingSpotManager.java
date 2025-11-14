package LLD_Problems.ParkingLot.ParkingSpotManager;

import LLD_Problems.ParkingLot.ParkingSpot;
import LLD_Problems.ParkingLot.ParkingStrategy.ParkingStrategy;
import LLD_Problems.ParkingLot.Vehicle;
import LLD_Problems.ParkingLot.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/*List<ParkingSpots>,
addParkingSpot, removeParkingSpot, assignParkingSpot, unassignParkingSpot, findParkingSpot
Note: Here in find Parking space, we could implement various strategies. like the first free or the closest to entrance.

*/
public class ParkingSpotManager {
    private List<ParkingSpot> parkingSpots;
    private ParkingStrategy parkingStrategy;

    public ParkingSpotManager(ParkingStrategy strategy, List<ParkingSpot> spots) {
        parkingSpots = spots;
        parkingStrategy = strategy;
    }

    public void addParkingSpot(ParkingSpot spot){
        parkingSpots.add(spot);
    }
    public void removeParkingSpot(ParkingSpot spot){
        parkingSpots.remove(spot);
    }

    public void assignParkingSpot(ParkingSpot spot, Vehicle vehicle) throws Exception {
        spot.addVehicle(vehicle);
    }

    public void unassignParkingSpot(ParkingSpot spot){
        spot.removeVehicle();
    }

    public ParkingSpot findParkingSpot() throws Exception {
        try{
            return parkingStrategy.findSpot(parkingSpots);
        }
        catch (Exception e){
            System.out.println(e);
        }
         return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParkingSpotManager that)) return false;
        return Objects.equals(parkingSpots, that.parkingSpots) && Objects.equals(parkingStrategy, that.parkingStrategy);
    }

    @Override
    public int hashCode() {
        return Objects.hash(parkingSpots, parkingStrategy);
    }
}
