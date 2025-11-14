package Problems.HARD.Uber.ServiceImpl;

import Problems.HARD.Uber.Model.Ride;
import Problems.HARD.Uber.Service.PaymentService;

public class PaymentServiceImpl implements PaymentService {
    @Override
    public boolean processPayment(Ride ride) {
        System.out.println("Processing payment of $" + ride.getFare() + " from Passenger " + ride.getPassenger().getName() + " to Driver  " + ride.getDriver().getName());
        return true;
    }
}
