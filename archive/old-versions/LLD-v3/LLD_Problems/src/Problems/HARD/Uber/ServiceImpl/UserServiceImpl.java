package Problems.HARD.Uber.ServiceImpl;

import Problems.HARD.Uber.Model.Driver;
import Problems.HARD.Uber.Model.Passenger;
import Problems.HARD.Uber.Service.UserService;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserServiceImpl implements UserService {
    private final Map<String, Passenger> passengers;
    private final Map<String, Driver> drivers;

    public UserServiceImpl() {
        passengers = new ConcurrentHashMap<>();
        drivers = new ConcurrentHashMap<>();
    }

    @Override
    public void addPassenger(Passenger passenger) {
        passengers.put(passenger.getId(), passenger);
    }

    @Override
    public void addDriver(Driver driver) {
        drivers.put(driver.getId(), driver);
    }

    @Override
    public Passenger getPassenger(String id) {
        return passengers.get(id);
    }

    @Override
    public Driver getDriver(String id) {
        return drivers.get(id);
    }

    @Override
    public List<Driver> getDrivers() {
        return drivers.values().stream().toList();
    }
}
