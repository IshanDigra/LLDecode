package LLD_Problems.ParkingLot;



import LLD_Problems.ParkingLot.ParkingSpotManager.ParkingSpotManager;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/*ParkingSpotManager
Note: Now here we could have a factory design pattern to return the type of parkingspot manager based on the vehicle
type at entrance gate.

finsSpace(), bookSpot(), generateTicket,*/
public class EntranceGate {

    private ParkingSportManagerFactory factory;

    public EntranceGate(ParkingSportManagerFactory factory) {
        this.factory = factory;
    }

    public Ticket bookSpot(Vehicle vehicle, List<ParkingSpot> spots) throws Exception {
        ParkingSpotManager manager = factory.getParkingSpotManager(vehicle.getType(),spots);
        ParkingSpot spot = manager.findParkingSpot();
        manager.assignParkingSpot(spot, vehicle);
        return generateTicket(vehicle,spot);
    }

    private Ticket generateTicket(Vehicle vehicle, ParkingSpot spot){
        return new Ticket(idGenerator(),spot,vehicle);
    }

    private  int idGenerator(){
        return UUID.randomUUID().hashCode();
    }
}
