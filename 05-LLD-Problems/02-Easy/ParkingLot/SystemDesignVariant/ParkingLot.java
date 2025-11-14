package SystemDesign.Problems.Easy.ParkingLot;

import SystemDesign.Problems.Easy.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;

public class ParkingLot {
    private List<Level> levels;
    private static ParkingLot parkingLot;

    private ParkingLot(){
        levels = new ArrayList<Level>();
    }

    public static synchronized ParkingLot getInstance(){
        if(parkingLot==null){
            return new ParkingLot();
        }
        return parkingLot;
    }
    public void addLevel(Level level){
        levels.add(level);
    }

    public boolean parkVehicle(Vehicle vehicle) {
        for(Level l: levels){
            if(l.parkVehicle(vehicle)){
                System.out.println(vehicle.getType()+ " parked successfully");
                return true;
            }
        }
        System.out.println("Could not park Vehicle");
        return false;
    }

    public boolean unparkVehicle(Vehicle vehicle) {
        for (Level level : levels) {
            if (level.unParkVehicle(vehicle)) {
                return true;
            }
        }
        return false;
    }

    public void displayAvailability() {
        for (Level level : levels) {
            level.displayAvailability();
        }
    }
}
