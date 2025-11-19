package ParkingLot_V3.Services;


import ParkingLot_V3.Entities.ParkingLevel;
import ParkingLot_V3.Entities.ParkingSpot;
import ParkingLot_V3.Entities.ParkingTicket;
import ParkingLot_V3.Entities.Vehicle;
import ParkingLot_V3.Enums.ParkingStatus;
import ParkingLot_V3.Enums.PaymentStatus;
import ParkingLot_V3.Enums.VehicleType;
import ParkingLot_V3.Services.Payment.PaymentStrategy;
import ParkingLot_V3.Services.TicketFareStrategy.FareStrategy;

import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class ParkingLot {
    private static volatile ParkingLot instance;
    private static final Logger logger = Logger.getLogger(ParkingLot.class.getName());
    List<ParkingLevel> levels;

    private ParkingLot() {
        levels = new CopyOnWriteArrayList<>();
    }

    public static ParkingLot getInstace(){
        if(instance==null){
            synchronized (ParkingLot.class){
                if(instance == null){
                    instance  = new ParkingLot();
                }
            }
        }
        return instance;
    }

    public void addLevel(ParkingLevel p){
        if(p.equals(null)) throw new RuntimeException("Invalid Input");
        levels.add(p);
    }


    public List<ParkingSpot> getParkingSpots(VehicleType type){
        List<ParkingSpot> s =  levels.stream().flatMap(l->l.getParkingSpots(type).stream())
                .filter(l -> l.getStatus().equals(ParkingStatus.UNOCCUPIED)).collect(Collectors.toList());
        if(s.size()==0){
            logger.info("No available spots at the moment");
        }
        return s;
    }

    public synchronized ParkingTicket parkVehicle(Vehicle vehicle){
        List<ParkingSpot> freeSpots = getParkingSpots(vehicle.getType());
        if(freeSpots.size()==0){
            logger.info("No available spots at the moment for "+vehicle);
            return null;
        }

        ParkingSpot spot = freeSpots.get(0);
        spot.parkVehicle(vehicle);

        ParkingTicket ticket = new ParkingTicket(vehicle, spot, LocalDateTime.now());

        return ticket;
    }

    public Double getTicketFare(FareStrategy fareStrategy, ParkingTicket ticket, Map<VehicleType, Double> fare){
        return fareStrategy.getTicketFare(ticket,fare);
    }

    public synchronized void makePayment(PaymentStrategy paymentStrategy, double amount, double fare, ParkingTicket ticket){
        if(ticket.getStatus().equals(PaymentStatus.COMPLETED)){
            logger.info("the Payment has already been made!");
            return ;
        }

        if(amount < fare){
            logger.warning("please pay the quoted amount: $"+fare);
            return;
        }

        else{
            if(paymentStrategy.makePayment(amount)){
                ticket.setStatus(PaymentStatus.COMPLETED);
                double change = amount-fare;
                logger.info("Please collect your change: $"+change);
                unparkVehicle(ticket);
            }
            else{
                logger.warning("payment failed");
            }

        }
    }

    public synchronized void unparkVehicle(ParkingTicket ticket){
        ticket.getSpot().unParkVehicle();
        logger.info("vehicle has been unparked.");
    }
}
