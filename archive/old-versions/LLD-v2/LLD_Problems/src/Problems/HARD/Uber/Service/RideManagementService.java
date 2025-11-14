package Problems.HARD.Uber.Service;

import Problems.HARD.Uber.Model.Driver;
import Problems.HARD.Uber.Model.Location;
import Problems.HARD.Uber.Model.Passenger;
import Problems.HARD.Uber.Model.Ride;

public interface RideManagementService {
    void requestRide(Passenger passenger, Location source, Location destination);
    void acceptRide(Driver driver, Ride ride);
    void startRide(Ride ride);
    void completeRide(Ride ride);
    void cancelRide(Ride ride);
}
