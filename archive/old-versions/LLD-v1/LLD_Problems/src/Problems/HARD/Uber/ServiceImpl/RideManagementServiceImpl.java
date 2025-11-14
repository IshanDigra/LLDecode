package Problems.HARD.Uber.ServiceImpl;

import Problems.HARD.Uber.Constant.DriverStatus;
import Problems.HARD.Uber.Constant.RideStatus;
import Problems.HARD.Uber.Model.Driver;
import Problems.HARD.Uber.Model.Location;
import Problems.HARD.Uber.Model.Passenger;
import Problems.HARD.Uber.Model.Ride;
import Problems.HARD.Uber.Service.NotificationService;
import Problems.HARD.Uber.Service.PaymentService;
import Problems.HARD.Uber.Service.RideManagementService;
import Problems.HARD.Uber.Service.UserService;

import java.util.Map;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentLinkedQueue;

public class RideManagementServiceImpl implements RideManagementService {
    private static RideManagementServiceImpl instance;
    private final Map<String, Ride> rides;
    private final Queue<Ride> requestedRides;
    private final NotificationService notificationService;
    private final UserService userService;
    private final PaymentService paymentService;

    private RideManagementServiceImpl() {
        rides = new ConcurrentHashMap<>();
        requestedRides = new ConcurrentLinkedQueue<>();
        notificationService = new NotificationServiceImpl();
        userService = new UserServiceImpl();
        paymentService = new PaymentServiceImpl();
    }

    public static synchronized RideManagementServiceImpl getInstance() {
        if (instance == null) {
            instance = new RideManagementServiceImpl();
        }
        return instance;
    }



    @Override
    public void requestRide(Passenger passenger, Location source, Location destination) {
        Ride ride = new Ride(generateRideId(),passenger,null,source, destination, 0.0);
        requestedRides.offer(ride);
        rides.put(ride.getId(),ride);
        for(Driver driver : userService.getDrivers()){
            if(driver.getStatus()== DriverStatus.AVAILABLE){
                double distance = calculateDistance(driver.getLocation(), ride.getSource());
                if(distance <=5.0){
                    notificationService.notifyDrivers(ride, driver);
                }
            }
        }
    }

    @Override
    public void acceptRide(Driver driver, Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED) {
            ride.setDriver(driver);
            ride.setStatus(RideStatus.ACCEPTED);
            driver.setStatus(DriverStatus.BUSY);
            notificationService.notifyPassenger(ride);
        }
    }

    @Override
    public void startRide(Ride ride) {
        if (ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.IN_PROGRESS);
            notificationService.notifyPassenger(ride);
        }
    }

    @Override
    public void completeRide(Ride ride) {
        if (ride.getStatus() == RideStatus.IN_PROGRESS) {
            ride.setStatus(RideStatus.COMPLETED);
            ride.getDriver().setStatus(DriverStatus.AVAILABLE);
            double fare = calculateFare(ride);
            ride.setFare(fare);
            paymentService.processPayment(ride);
            notificationService.notifyPassenger(ride);
            notificationService.notifyDriver(ride);
        }
    }

    @Override
    public void cancelRide(Ride ride) {
        if (ride.getStatus() == RideStatus.REQUESTED || ride.getStatus() == RideStatus.ACCEPTED) {
            ride.setStatus(RideStatus.CANCELLED);
            if (ride.getDriver() != null) {
                ride.getDriver().setStatus(DriverStatus.AVAILABLE);
            }
            notificationService.notifyPassenger(ride);
            notificationService.notifyDriver(ride);
        }
    }

    private String generateRideId(){
        return "Ride"+ UUID.randomUUID().toString();
    }

    private double calculateDistance(Location source, Location Destination) {
        // Calculate the distance between two locations using a distance formula (e.g., Haversine formula)
        // For simplicity, let's assume a random distance between 1 and 20 km
        return Math.random() * 20 + 1;
    }

    private double calculateDuration(Location source, Location destination) {
        // Calculate the estimated duration between two locations based on distance and average speed
        // For simplicity, let's assume an average speed of 30 km/h
        double distance = calculateDistance(source, destination);
        return (distance / 30) * 60; // Convert hours to minutes
    }

    private double calculateFare(Ride ride) {
        double baseFare = 2.0;
        double perKmFare = 1.5;
        double perMinuteFare = 0.25;

        double distance = calculateDistance(ride.getSource(), ride.getDestination());
        double duration = calculateDuration(ride.getSource(), ride.getDestination());

        double fare = baseFare + (distance * perKmFare) + (duration * perMinuteFare);
        return Math.round(fare * 100.0) / 100.0; // Round to 2 decimal places
    }


    }
