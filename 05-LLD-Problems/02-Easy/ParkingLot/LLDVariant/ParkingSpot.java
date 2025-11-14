package LLD_Problems.ParkingLot;

public class ParkingSpot {
    /*id, vehicle, isEmpty, Price,
addVehicle(), removeVehicle()*/
    private final int id;
    private Vehicle vehicle;
    private boolean isEmpty;
    private int price;

    public ParkingSpot(int id, int price) {
        this.id = id;
        this.price = price;
        isEmpty = true;
    }


    public void addVehicle(Vehicle vehicle){
        this.vehicle = vehicle;
        isEmpty = false;
    }

    public void removeVehicle(){
        vehicle = null;
        isEmpty = true;
    }

    public int getId() {
        return id;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean empty) {
        isEmpty = empty;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "ParkingSpot{" +
                "id=" + id +
                ", vehicle=" + vehicle +
                ", isEmpty=" + isEmpty +
                ", price=" + price +
                '}';
    }
}
