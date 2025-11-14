package Problems.HARD.Uber.Service;

import Problems.HARD.Uber.Model.Driver;
import Problems.HARD.Uber.Model.Passenger;

import java.util.List;

public interface UserService {
    void addPassenger(Passenger passenger);
    void addDriver(Driver driver);
    Passenger getPassenger(String id);
    Driver getDriver(String id);
    List<Driver> getDrivers();

}
