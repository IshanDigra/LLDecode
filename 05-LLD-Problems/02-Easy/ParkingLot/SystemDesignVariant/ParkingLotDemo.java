package SystemDesign.Problems.Easy.ParkingLot;

import SystemDesign.Problems.Easy.ParkingLot.Vehicle.Car;
import SystemDesign.Problems.Easy.ParkingLot.Vehicle.MotorCycle;
import SystemDesign.Problems.Easy.ParkingLot.Vehicle.Truck;
import SystemDesign.Problems.Easy.ParkingLot.Vehicle.Vehicle;

public class ParkingLotDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        parkingLot.addLevel(new Level(1, 10));
        parkingLot.addLevel(new Level(2, 5));

        Vehicle car = new Car("ABC123");
        Vehicle truck = new Truck("XYZ789");
        Vehicle motorcycle = new MotorCycle("M1234");

        // Park vehicles
        parkingLot.parkVehicle(car);
        parkingLot.parkVehicle(truck);
        parkingLot.parkVehicle(motorcycle);

        // Display availability
        parkingLot.displayAvailability();

        // Unpark vehicle
        parkingLot.unparkVehicle(motorcycle);

        // Display updated availability
        parkingLot.displayAvailability();
    }
}
