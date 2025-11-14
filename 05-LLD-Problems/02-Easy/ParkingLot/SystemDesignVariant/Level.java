package SystemDesign.Problems.Easy.ParkingLot;

import SystemDesign.Problems.Easy.ParkingLot.Vehicle.Vehicle;
import SystemDesign.Problems.Easy.ParkingLot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private int floor;
    private List<ParkingSpot> parkingSpots;
    private int cntc, cntt, cntm;

    public Level(int floor, int spotCnt){
        this.floor = floor;
        parkingSpots = new ArrayList<ParkingSpot>();
        cntm = (int)(spotCnt*(0.5));
        cntc = (int)(spotCnt*(0.4));
        cntt = spotCnt - (cntc+cntm);

        for(int i = 0 ; i<spotCnt; i++){
            if(i >= cntc+cntm){
                parkingSpots.add(new ParkingSpot(i, VehicleType.truck));
            }
            else if(i >= cntm){
                parkingSpots.add(new ParkingSpot(i, VehicleType.car));
            }
            else{
                parkingSpots.add(new ParkingSpot(i, VehicleType.motorcycle));
            }
        }
    }

    public boolean parkVehicle(Vehicle vehicle){
        for (ParkingSpot ps : parkingSpots){
            if(ps.parkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public boolean unParkVehicle(Vehicle vehicle){
        for (ParkingSpot ps : parkingSpots){
            if(ps.unParkVehicle(vehicle)){
                return true;
            }
        }
        return false;
    }

    public void displayAvailability(){
        System.out.println("Level "+floor+" availability:");
        for(ParkingSpot ps : parkingSpots){
            System.out.println("Spot "+ ps.getSpotNumber() + ": " +(ps.isAvailable()? "Available for " : "Occupied by ")+ ps.getType());
        }
    }
}
