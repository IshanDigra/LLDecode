package Problems.HARD.Uber.Model;

import Problems.HARD.Uber.Constant.RideStatus;
import Problems.HARD.Uber.Constant.RideType;

public class Ride {
    private final String id ;
    private final Passenger passenger;
    private  Driver driver;
    private final Location source;
    private final Location destination;
    private  double fare;
    private RideStatus status;
    private RideType type;

    public Ride(String id, Passenger passenger, Driver driver, Location source, Location destination, double fare) {
        this.id = id;
        this.passenger = passenger;
        this.driver = driver;
        this.source = source;
        this.destination = destination;
        this.fare = fare;
        status = RideStatus.REQUESTED;
        type = RideType.REGULAR;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getId() {
        return id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Location getSource() {
        return source;
    }

    public Location getDestination() {
        return destination;
    }

    public double getFare() {
        return fare;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public RideType getType() {
        return type;
    }

    public void setType(RideType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id='" + id + '\'' +
                ", passenger=" + passenger +
                ", driver=" + driver +
                ", source=" + source +
                ", destination=" + destination +
                ", fare=" + fare +
                ", status=" + status +
                ", type=" + type +
                '}';
    }
}
