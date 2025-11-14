package AsishPratapProblems.EASY.ParkingLot.ParkingLot_V2;

public class IdGeneratorUtil {
    private static int ps;
    private static int t;
    private static int pl;
    private static int v;
    static {
        ps = 0 ;
        t = 0 ;
        pl = 0 ;
        v = 0 ;
    }
    public static int getParkingSpotId(){
        return ps++;
    }
    public static int getTicketId(){
        return t++;
    }
    public static int getParkingLevelId(){
        return pl++;
    }
    public static int getVehicleId(){
        return v++;
    }
}
