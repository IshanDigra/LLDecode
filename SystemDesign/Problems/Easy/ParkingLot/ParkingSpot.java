package SystemDesign.Problems.Easy.ParkingLot;

import SystemDesign.Problems.Easy.ParkingLot.Vehicle.Vehicle;
import SystemDesign.Problems.Easy.ParkingLot.Vehicle.VehicleType;

public class ParkingSpot {
    private int spotNumber;
    private VehicleType type;

    public Vehicle vehicle;

    public ParkingSpot(int spotNumber, VehicleType type) {
        this.spotNumber = spotNumber;
        this.type = type;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public VehicleType getType() {
        return type;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public synchronized boolean isAvailable(){
        return vehicle == null;
    }

    public synchronized boolean parkVehicle(Vehicle vehicle){
        if(isAvailable()&& (vehicle.getType()==type)){
            this.vehicle = vehicle;
            return  true;
        }
        return false;
    }

    public synchronized boolean unParkVehicle(Vehicle vehicle){
        if(!isAvailable()&& (this.vehicle.equals(vehicle))){
            this.vehicle = null;
            return true;
        }
        return false;
    }
}
