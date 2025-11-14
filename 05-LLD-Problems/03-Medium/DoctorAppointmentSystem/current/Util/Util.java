package Meesho.Util;

import java.util.UUID;

public class Util {
    public static String generateDocId(){
        return "DOC"+UUID.randomUUID().toString();
    }

    public static String generateBookingId(){
        return "Book"+UUID.randomUUID().toString();
    }
}
