package LLD_Problems.ParkingLot;

import LLD_Problems.ParkingLot.CostComputationStrategy.CostComputationStrategy;

import java.util.ArrayList;
import java.util.List;

/*->ExitGate
ticket,
costComputation: twowhellercostcomp, fourwheelercostcomp
Again we could have a strategy for cost computation. hourly basis, default or minutes basis.
again we could have a costcomputationfactory based on the vehicle.
priceCalc()
payment() based on the type of paymentmethod.
freeParkingSpot()*/
public class ExitGate {
    private ParkingSportManagerFactory factory;

    public ExitGate(ParkingSportManagerFactory factory) {
        this.factory = factory;
    }

    public double getPrice(Ticket ticket, CostComputationStrategy strategy){
        return strategy.getPrice(ticket);
    }

    public void freeSpace(Ticket ticket, List<ParkingSpot> spots){
        factory.getParkingSpotManager(ticket.getVehicle().getType(), spots).unassignParkingSpot(ticket.getParkingSpot());
    }
}
