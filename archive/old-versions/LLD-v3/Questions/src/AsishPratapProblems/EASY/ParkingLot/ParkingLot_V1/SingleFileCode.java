package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V1;

/*
* #Requirement:
The parking lot should have multiple levels, each level with a certain number of parking spots.
The parking lot should support different types of vehicles, such as cars, motorcycles, and trucks.
Each parking spot should be able to accommodate a specific type of vehicle.
The system should assign a parking spot to a vehicle upon entry and release it when the vehicle exits.
The system should track the availability of parking spots and provide real-time information to customers.
The system should handle multiple entry and exit points and support concurrent access.




Entities: parkingSpot: {Two wheeler, fourwheller, 8 wheller }, ParkingLevel, Vehicles:, ParkingSpotManager
Enums: vehicleType, parkingStatus
Exceptions:
Core Functionalities: findParkingSpace, parkVehicle, unparkVehicle


=> ParkingSpot: id, vehicle, vehicleType, status
parkVehicle, unparkVehicle, displayInfo

=> ParkingLevel: id, list<parkingSpot>,
findParkingSpace, parkVehicle, unparkVehicle, CRUD operations related to parking spot.

=> vehicle: vehicleType, numberPlate
*
* */


import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class SingleFileCode {

// => making exceptions
// => making Enums
    public enum VehicleType{ TWO_WHELLER, FOUR_WHELLER};
    public enum ParkingStatus{AVAILABLE, UNAVAILABLE};

// => making the entities;

    public static class Vehicle{
         private final String numberPlate;
         private VehicleType type;
         public Vehicle(String numberPlate, VehicleType type){
             this.numberPlate = numberPlate;
             this.type = type;
         }

         // getters & setters

        public String getNumberPlate() {
            return numberPlate;
        }

        public VehicleType getType() {
            return type;
        }

        public void setType(VehicleType type) {
            this.type = type;
        }

        @Override
        public String toString() {
            return "Vehicle{" +
                    "numberPlate='" + numberPlate + '\'' +
                    ", type=" + type +
                    '}';
        }
    };

    public static class ParkingSpot{
        private final String id;
        private VehicleType type ;
        private ParkingStatus status;
        private Vehicle vehicle;

        public ParkingSpot(String id, VehicleType type) {
            this.id = id;
            this.type = type;
            status = ParkingStatus.AVAILABLE;
            vehicle = null;
        }

        public boolean parkVehicle(Vehicle vehicle){
            // the below two checks needs to be done once the main code is up and running
            // even the printing part can be done in last. first checks can be done using the toString method. only .
            if(this.vehicle != null || status.equals(ParkingStatus.UNAVAILABLE)){
                System.out.println("Space already occupied");
                return false;
            }
            else if(!type.equals(vehicle.type)){
                System.out.println("Particular vehicle not suited for this parking spot!");
                return false;
            }
            else{
                this.vehicle = vehicle;
                status = ParkingStatus.UNAVAILABLE;
            }
            return true;
        }

        public void unParkVehicle(){
            vehicle = null;
            status = ParkingStatus.AVAILABLE;
        }

        public String getId() {
            return id;
        }

        public VehicleType getType() {
            return type;
        }

        public void setType(VehicleType type) {
            this.type = type;
        }

        public ParkingStatus getStatus() {
            return status;
        }

        public void setStatus(ParkingStatus status) {
            this.status = status;
        }

        public Vehicle getVehicle() {
            return vehicle;
        }

        public void setVehicle(Vehicle vehicle) {
            this.vehicle = vehicle;
        }

        @Override
        public String toString() {
            return "ParkingSpot{" +
                    "id='" + id + '\'' +
                    ", type=" + type +
                    ", status=" + status +
                    ", vehicle=" + vehicle +
                    '}';
        }
    };


    public static class ParkingLevel{
        private final String id;
        private List<ParkingSpot> parkingSpots;
        Map<String, ParkingSpot> parkedVehicles;

        public ParkingLevel(String id) {
            this.id = id;
            parkingSpots = new ArrayList<>();
            parkedVehicles = new ConcurrentHashMap<>();
        }

        public ParkingSpot findParkingSpot(VehicleType type){
            Optional<ParkingSpot> freeSpot =   parkingSpots.stream().filter(r->r.getType().equals(type) && r.getStatus().equals(ParkingStatus.AVAILABLE)).findAny();
            return freeSpot.orElse(null);
        };
        public boolean parkVehicle(Vehicle vehicle){
            ParkingSpot freeSpot = findParkingSpot(vehicle.type);
            if(freeSpot == null) return false;
            parkedVehicles.put(vehicle.numberPlate, freeSpot);
            return freeSpot.parkVehicle(vehicle);
        };
        public void unParkVehicle(Vehicle vehicle){
            ParkingSpot spot = parkedVehicles.getOrDefault(vehicle.getNumberPlate(),null);
            if(spot !=null){
                spot.unParkVehicle();
                parkedVehicles.remove(vehicle.getNumberPlate());
            }
        }

        public void addParkingSpot(ParkingSpot spot){
            parkingSpots.add(spot);
        }

        @Override
        public String toString() {
            return "ParkingLevel{" +
                    "id='" + id + '\'' +
                    ", parkingSpots=" + parkingSpots +
                    '}';
        }

        // CRUD actions related to parking spots;
    };

    public static class ParkingSpotManager{
        private List<ParkingLevel> levels;


        public ParkingSpotManager(List<ParkingLevel> levels) {
            this.levels = levels;
        }

        public boolean parkVehicle(Vehicle vehicle){
            for(ParkingLevel level : levels){
                if(level.findParkingSpot(vehicle.getType())!=null){
                    level.parkVehicle(vehicle);
                }
            }
            return false ;
        }

        public void unParkVehicle(Vehicle vehicle){
            for(ParkingLevel level : levels){
                level.unParkVehicle(vehicle);
            }
        }
    };

    public static void main(String[] args) {
        Vehicle v1 = new Vehicle("ishan's car",VehicleType.FOUR_WHELLER);
        Vehicle v2 = new Vehicle("pallav's car",VehicleType.FOUR_WHELLER);
        Vehicle v3 = new Vehicle("ishan's bike",VehicleType.TWO_WHELLER);

        ParkingSpot p1 = new ParkingSpot("p1", VehicleType.TWO_WHELLER);
        ParkingSpot p2 = new ParkingSpot("p2", VehicleType.TWO_WHELLER);
        ParkingSpot p3 = new ParkingSpot("p3", VehicleType.FOUR_WHELLER);
        ParkingSpot p4 = new ParkingSpot("p4", VehicleType.FOUR_WHELLER);

        ParkingLevel l1 = new ParkingLevel("1");
        l1.addParkingSpot(p1);
        l1.addParkingSpot(p2);
        ParkingLevel l2 = new ParkingLevel("2");
        l2.addParkingSpot(p4);
        l2.addParkingSpot(p3);

        System.out.println("Displaying the parking lot's Initial State");
        System.out.println(l1);
        System.out.println(l2);
        List<ParkingLevel> levels = new ArrayList<>();
        levels.add(l1);
        levels.add(l2);
        ParkingSpotManager pm = new ParkingSpotManager(levels);
        System.out.println("Adding vehicles");
        pm.parkVehicle(v1);
        pm.parkVehicle(v2);
        pm.parkVehicle(v3);

        System.out.println(l1);
        System.out.println(l2);

        System.out.println("unParking some of the vehicles.");
        pm.unParkVehicle(v1);

        System.out.println(l1);
        System.out.println(l2);
    }

}

