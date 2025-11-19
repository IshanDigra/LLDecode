package ParkingLot_V3.Entities;


import ParkingLot_V3.Enums.ParkingStatus;
import ParkingLot_V3.Enums.VehicleType;
import ParkingLot_V3.Util.IdGeneratorUtil;

import java.util.logging.Level;
import java.util.logging.Logger;

public class ParkingSpot {
    private final String id;
    private final VehicleType type;
    private ParkingStatus status;


    private  static final  Logger logger = Logger.getLogger(ParkingSpot.class.getName());

    public ParkingSpot(VehicleType type) {
        this.id = IdGeneratorUtil.generateSpotId();
        this.type = type;
        status = ParkingStatus.UNOCCUPIED;
    }

    public synchronized void parkVehicle(Vehicle vehicle){
        if(status.equals(ParkingStatus.OCCUPIED)){
            throw new RuntimeException("Spot Already Booked");
        }
        if(!vehicle.getType().equals(type)){
            throw new RuntimeException("Vehicle Type is not compatible");
        }
        logger.info("Vehicle Parked");

        status = ParkingStatus.OCCUPIED;
    }

    public synchronized void unParkVehicle(){
        if(status.equals(ParkingStatus.UNOCCUPIED)){
            throw new RuntimeException("Parking spot is already unoccupied");
        }
        status = ParkingStatus.UNOCCUPIED;
    }

    public String getId() {
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
