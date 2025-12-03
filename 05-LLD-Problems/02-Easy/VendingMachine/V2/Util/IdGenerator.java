package V2.Util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong k = new AtomicLong(0);

    public static String generateId(){
        return "P-"+k.incrementAndGet();
    }
}
