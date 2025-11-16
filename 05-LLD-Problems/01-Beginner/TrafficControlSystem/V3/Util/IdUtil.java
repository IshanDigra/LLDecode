package V2.Util;

import java.util.concurrent.atomic.AtomicLong;

public class IdUtil {
    private static final AtomicLong counter1 = new AtomicLong(0);
    private static final AtomicLong counter2 = new AtomicLong(0);

    public static String generateRoadId(){
        return "RID_"+counter1.incrementAndGet();
    }

    public static String generateTSId(){
        return "TSID_"+counter2.incrementAndGet();
    }
}
