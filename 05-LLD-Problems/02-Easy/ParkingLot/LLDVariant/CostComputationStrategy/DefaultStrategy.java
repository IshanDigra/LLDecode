package LLD_Problems.ParkingLot.CostComputationStrategy;

import LLD_Problems.ParkingLot.Ticket;

public class DefaultStrategy implements CostComputationStrategy{
    @Override
    public double getPrice(Ticket ticket) {
        return 100;
    }
}
