package Problems.HARD.Uber.Service;

import Problems.HARD.Uber.Model.Ride;

public interface PaymentService {
    boolean processPayment(Ride ride);
}
