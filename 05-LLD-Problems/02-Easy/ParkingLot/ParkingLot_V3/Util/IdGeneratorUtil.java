package ParkingLot_V3.Util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGeneratorUtil {
    private static final AtomicLong ps = new AtomicLong(0);
    private static final AtomicLong lvl = new AtomicLong(0);
    private static final AtomicLong tkt = new AtomicLong(0);

    public static String generateSpotId(){
        return "PS-"+ps.incrementAndGet();
    }

    public static String generateLevelId(){
        return "LVL-"+lvl.incrementAndGet();
    }
    public static String generateTicketId(){
        return "TKT-"+tkt.incrementAndGet();
    }
}
