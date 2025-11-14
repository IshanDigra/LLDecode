package Meesho.Services;

import Meesho.Entities.Ride;
import Meesho.Entities.RideStrategy.RideFactory;
import Meesho.Entities.RideStrategy.RideStrategyInterface;
import Meesho.Entities.Route;
import Meesho.Entities.User;
import Meesho.Entities.Vehicle;
import Meesho.Enums.RideStrategy;
import Meesho.Util.Util;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class CarPoolService {
    private static CarPoolService instance;
    private RideFactory factory;
    private Map<User, Vehicle> userVehicleMapping; ;
    private RideService service;
    private CarPoolService(){
        factory = new RideFactory();
        service = new RideService();
        userVehicleMapping = new ConcurrentHashMap<>();
    }

    public static synchronized CarPoolService getInstance(){
        if(instance == null){
            instance = new CarPoolService();
        }
        return instance;
    }

    public void registerUser(User user, Vehicle vehicle){
        if(userVehicleMapping.containsKey(user)){
            System.out.println("User already registered");
            return;
        }
        userVehicleMapping.put(user, vehicle);
    }

    public Ride offerRide(User user, String source, String destination, double distance, double time){
        Ride ride = new Ride(Util.generateRideId(), user, new Route(source, destination), time, distance);
        service.offerRide(ride);
        return ride;
    }
    public Ride takeRide(User user,List<Ride> rides, RideStrategy strategy){

        RideStrategyInterface rStrategy = factory.getRideStrategy(strategy);

        Ride ride =  rStrategy.getRide(rides, strategy);
        if(ride != null) service.takeRide(ride,user);

        return ride;
    }

    public void startRide(Ride ride){
        if(ride == null) return ;
        service.startRide(ride);
    }
    public void completeRide(Ride ride){
        if(ride == null) return ;
        service.completeRide(ride);
    }

    public List<Ride> getRides(User user, String source, String destination, RideStrategy strategy){
        List<Ride> rides = service.getAvailableRides(source, destination, strategy);
        if(rides.size()==0){
            System.out.println("No available rides at the moment");
        }
        return rides;
    }

    public List<Ride> totalRidesTaken(User user){
        return user.getRidesTaken();
    }
    public List<Ride> totalRidesOffered(User user){
        return user.getRidesOffered();
    }
    public double totalFuelSaved(User user){
        return user.getFuelSaved();
    }

}
