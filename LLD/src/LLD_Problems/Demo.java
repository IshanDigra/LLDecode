package LLD_Problems;

import LLD_Problems.ParkingLot.*;
import LLD_Problems.ParkingLot.CostComputationStrategy.DefaultStrategy;
import LLD_Problems.ParkingLot.CostComputationStrategy.HourlyBasisStrategy;

import java.util.ArrayList;
import java.util.List;

public class Demo {
    public static void main(String[] args) throws Exception {
        ParkingSpot s1 = new TwoWheelerParkingSpot(1,100);
        ParkingSpot s2 = new TwoWheelerParkingSpot(2,100);
        ParkingSpot s3 = new FourWheelerParkingSpot(3,200);

        List<ParkingSpot> twoWhellerSpots = new ArrayList<>();
        List<ParkingSpot> fourWhellerSpots = new ArrayList<>();
        twoWhellerSpots.add(s1);
        twoWhellerSpots.add(s2);

        fourWhellerSpots.add(s3);

        Vehicle car = new Vehicle("Ishan's Car", VehicleType.FOUR_WHEELER);
        Vehicle bike = new Vehicle("Gajri's scooty", VehicleType.TWO_WHEELER);

        ParkingSportManagerFactory factory = new ParkingSportManagerFactory();
        EntranceGate gate = new EntranceGate(factory);
        ExitGate gate1 = new ExitGate(factory);

            Ticket t1 = gate.bookSpot(car,fourWhellerSpots);
            System.out.println(t1);
            System.out.println(fourWhellerSpots);

            Ticket t2 = gate.bookSpot(bike,twoWhellerSpots);
            System.out.println(t2);
            System.out.println(twoWhellerSpots);

        System.out.println(gate1.getPrice(t1, new DefaultStrategy()));
        System.out.println(gate1.getPrice(t2, new HourlyBasisStrategy()));

        gate1.freeSpace(t1,fourWhellerSpots);
        System.out.println(fourWhellerSpots);

        gate1.freeSpace(t2,twoWhellerSpots);
        System.out.println(twoWhellerSpots);
    }
}
