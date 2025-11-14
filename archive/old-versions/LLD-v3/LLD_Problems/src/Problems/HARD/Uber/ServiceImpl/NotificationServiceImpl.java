package Problems.HARD.Uber.ServiceImpl;

import Problems.HARD.Uber.Constant.DriverStatus;
import Problems.HARD.Uber.Model.Driver;
import Problems.HARD.Uber.Model.Passenger;
import Problems.HARD.Uber.Model.Ride;
import Problems.HARD.Uber.Service.NotificationService;

public class NotificationServiceImpl implements NotificationService {


    @Override
    public void notifyDrivers(Ride ride, Driver driver) {
        System.out.println("Notifying driver: " + driver.getName() + " about ride request: " + ride.getId());
    }

    @Override
    public void notifyPassenger(Ride ride) {
        Passenger passenger = ride.getPassenger();
        String message = "";
        switch(ride.getStatus()){
            case REQUESTED :
                message = "Waiting for a driver to connect.";
                break;
            case ACCEPTED :
                message = "Your ride has been accepted by driver: " + ride.getDriver().getName();
                break;
            case IN_PROGRESS :
                message = "Your ride is in progress";
                break;
            case COMPLETED :
                message = "Your ride has been completed. Fare: $" + ride.getFare();
                break;
            case CANCELLED :
                message = "Your ride has been cancelled";
                break;
        }
        System.out.println("Notifying passenger: " + passenger.getName() + " - " + message);
    }

    @Override
    public void notifyDriver(Ride ride) {
        Driver driver = ride.getDriver();
        if (driver != null) {
            String message = "";
            switch (ride.getStatus()) {
                case COMPLETED:
                    message = "Ride completed. Fare: $" + ride.getFare();
                    break;
                case CANCELLED:
                    message = "Ride cancelled by passenger";
                    break;
            }
            // Send notification to the driver
            System.out.println("Notifying driver: " + driver.getName() + " - " + message);
        }
    }

}
