package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Entities;

import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.VehicleType;

public class Vehicle {

    private final VehicleType type;
    private final String numberPlate;


    public Vehicle(VehicleType type, String numberPlate) {
        this.type = type;
        this.numberPlate = numberPlate;
    }

    public VehicleType getType() {
        return type;
    }

    public String getNumberPlate() {
        return numberPlate;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "type=" + type +
                ", numberPlate='" + numberPlate + '\'' +
                '}';
    }
}
