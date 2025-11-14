package LLD_Problems.ParkingLot.CostComputationStrategy;

import LLD_Problems.ParkingLot.Ticket;

public class HourlyBasisStrategy implements CostComputationStrategy{

    @Override
    public double getPrice(Ticket ticket) {
        // implement the logic.
        return 200;
    }
}
