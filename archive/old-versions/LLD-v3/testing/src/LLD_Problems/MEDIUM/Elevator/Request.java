package LLD_Problems.MEDIUM.Elevator;

public class Request {
    private final int srcFloor;
    private final int destFloor;

    public Request(int srcFloor, int destFloor) {
        this.srcFloor = srcFloor;
        this.destFloor = destFloor;
    }

    public int getSrcFloor() {
        return srcFloor;
    }

    public int getDestFloor() {
        return destFloor;
    }
}
