package Meesho.Util;

import java.util.concurrent.atomic.AtomicInteger;

public class Util {
    private static int id1;
    private static int id2;

    static{
        id1 = 0;
        id2 = 0;
    }

    public static int generateUserId(){
        id1++;
        return id1;
    }
    public static int generateRideId(){
        id2++;
        return id2;
    }
}
