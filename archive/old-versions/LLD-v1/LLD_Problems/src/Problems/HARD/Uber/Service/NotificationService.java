package Problems.HARD.Uber.Service;

import Problems.HARD.Uber.Model.Driver;
import Problems.HARD.Uber.Model.Ride;

public interface NotificationService {
    void notifyDrivers(Ride ride, Driver driver);
    void notifyPassenger(Ride ride);
    void notifyDriver(Ride ride);
}
