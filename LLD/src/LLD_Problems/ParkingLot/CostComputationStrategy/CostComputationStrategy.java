package LLD_Problems.ParkingLot.CostComputationStrategy;

import LLD_Problems.ParkingLot.Ticket;

public interface CostComputationStrategy {
    double getPrice(Ticket ticket);
}
