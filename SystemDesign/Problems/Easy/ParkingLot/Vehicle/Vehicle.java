package SystemDesign.Problems.Easy.ParkingLot.Vehicle;

public abstract class Vehicle {
    private String liscensePlate;
    private VehicleType type;

    public Vehicle(String liscensePlate, VehicleType type) {
        this.liscensePlate = liscensePlate;
        this.type = type;
    }

    public String getLiscensePlate() {
        return liscensePlate;
    }

    public void setLiscensePlate(String liscensePlate) {
        this.liscensePlate = liscensePlate;
    }

    public VehicleType getType() {
        return type;
    }

    public void setType(VehicleType type) {
        this.type = type;
    }
}
