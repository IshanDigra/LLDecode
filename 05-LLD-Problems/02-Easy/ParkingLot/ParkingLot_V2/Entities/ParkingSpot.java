package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Entities;

import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.ParkingStatus;
import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.VehicleType;

public class ParkingSpot {
    private final int id;
    private final VehicleType type;
    private ParkingStatus status;

    public ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
        status = ParkingStatus.UNOCCUPIED;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(!(vehicle.getType().equals(type))){
            throw new RuntimeException("Vehicle Type is not compatible");
        }
        if(status.equals(ParkingStatus.OCCUPIED)){
            throw new RuntimeException("Parking spot is already occupied");
        }

        status = ParkingStatus.OCCUPIED;
    }

    public synchronized void unParkVehicle(){
        if(status.equals(ParkingStatus.UNOCCUPIED)){
            throw new RuntimeException("Parking spot is already unoccupied");
        }
        status = ParkingStatus.UNOCCUPIED;
    }

    public int getId() {
        return id;
    }

    public VehicleType getType() {
        return type;
    }

    public ParkingStatus getStatus() {
        return status;
    }

    public void setStatus(ParkingStatus status) {
        this.status = status;
    }
}
