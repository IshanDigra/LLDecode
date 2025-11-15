package TaskManagementSystem_V2.Util;

import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
    private static final AtomicLong counter = new AtomicLong(0);

    public static String generateNextId() {
        return "ID-" + counter.incrementAndGet();
    }
}
