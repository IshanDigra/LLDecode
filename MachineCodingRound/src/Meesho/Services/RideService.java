package Meesho.Services;

import Meesho.Entities.Ride;
import Meesho.Entities.User;
import Meesho.Enums.RideStatus;
import Meesho.Enums.RideStrategy;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class RideService {
    private List<Ride> activeRides;

    public RideService() {
        activeRides = new CopyOnWriteArrayList<>();
    }

    public void offerRide(Ride ride){
        if(ride == null) return ;
        activeRides.add(ride);
        Thread th = new Thread(()->{
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            startRide(ride);
        });
    }

    public void takeRide(Ride ride, User user){
        if(ride == null || user==null) return ;
        ride.addPassanger(user);
        startRide(ride);
    }
    public void startRide(Ride ride){
        if(ride == null) return ;
        ride.startRide();
    }

    public void completeRide(Ride ride){
        if(ride == null) return ;
        ride.completeRide();
        activeRides.remove(ride);
    }

    public List<Ride> getAvailableRides(String source, String Destination, RideStrategy strategy){
        return activeRides.stream()
                .filter(r-> r.getRoute().getSource().equalsIgnoreCase(source)
                        && r.getRoute().getDestination().equalsIgnoreCase(Destination)).toList();
    }
}
