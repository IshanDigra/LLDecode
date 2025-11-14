package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Entities;

import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.ParkingStatus;
import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.PaymentStatus;
import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.Enums.VehicleType;
import AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2.IdGeneratorUtil;

import java.sql.Timestamp;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class ParkingLot {
    private static ParkingLot instance;
    List<ParkingLevel> levels;
    Map<VehicleType, Double> fare;
    private ParkingLot() {
        levels = new CopyOnWriteArrayList<>();
        fare = new HashMap<>();
    }

    public void addLevel(ParkingLevel p){
        if(p.equals(null)) throw new RuntimeException("Invalid Input");
        levels.add(p);
    }

    public void setFare(Map<VehicleType, Double> fare){
        this.fare = fare;
    }
    public static synchronized ParkingLot getInstace(){
        if(instance==null){
            instance  = new ParkingLot();
        }
        return instance;
    }

    public List<ParkingSpot> getParkingSpots(VehicleType type){
        List<ParkingSpot> s =  levels.stream().flatMap(l->l.getParkingSpots(type).stream())
                .filter(l -> l.getStatus().equals(ParkingStatus.UNOCCUPIED)).collect(Collectors.toList());
        if(s.size()==0){
            System.out.println("No available spots at the moment");
        }
        return s;
    }

    public synchronized Ticket parkVehicle(Vehicle vehicle){
        List<ParkingSpot> freeSpots = getParkingSpots(vehicle.getType());
        if(freeSpots.size()==0){
            return null;
        }

        ParkingSpot spot = freeSpots.get(0);
        Ticket ticket = new Ticket(IdGeneratorUtil.getTicketId(),vehicle,spot,new Timestamp(System.currentTimeMillis()));
        spot.parkVehicle(vehicle);
        return ticket;
    }

    // unparking and making the payment is pending.

    public double getTicketFare(Ticket ticket){
        double price = fare.get(ticket.getVehicle().getType());
        long seconds = (new Timestamp(System.currentTimeMillis()).getTime() - ticket.getTime().getTime())/(1000);
        return seconds*price;
    }

    public void makePayment(double amount, Ticket ticket){
        if(ticket.getStatus().equals(PaymentStatus.COMPLETED)){
            System.out.println("the Payment has already been made!");
            return ;
        }
        double fare = getTicketFare(ticket);
        if(amount < fare){
            System.out.println("please pay the quoted amount: $"+fare);
        }

        else{
            ticket.setStatus(PaymentStatus.COMPLETED);
            double change = amount-fare;
            System.out.println(" Payment is successfull please collect your change: $"+change);
            unparkVehicle(ticket);
        }
    }

    public void unparkVehicle(Ticket ticket){
        ticket.getSpot().unParkVehicle();
        System.out.println("vehicle has been unparked.");
    }
}
