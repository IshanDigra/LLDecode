package ParkingLot_V3.Services.Payment;

import ParkingLot_V3.Services.ParkingLot;

import java.util.logging.Logger;

public class CashPayment implements PaymentStrategy{
    private static final Logger logger = Logger.getLogger(CashPayment.class.getName());
    @Override
    public synchronized Boolean makePayment(double amount) {
        // payment made
        logger.info("cash Payment Made");
        return true;
    }
}
