package ParkingLot_V3.Services.Payment;

import java.util.logging.Logger;

public class UPIPayment implements PaymentStrategy{
    private static final Logger logger = Logger.getLogger(UPIPayment.class.getName());
    @Override
    public synchronized Boolean makePayment(double amount) {
        // payment made
        logger.info("UPI Payment Made");
        return true;
    }
}
