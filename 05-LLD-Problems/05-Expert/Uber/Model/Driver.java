package Problems.HARD.Uber.Model;

import Problems.HARD.Uber.Constant.DriverStatus;

public class Driver {
    private final String id;
    private final String name;
    private final String contact;
    private final String namePlate;
    private Location location;
    private DriverStatus status;

    public Driver(String id, String name, String contact, String namePlate, Location location) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.namePlate = namePlate;
        this.location = location;
        status = DriverStatus.AVAILABLE;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContact() {
        return contact;
    }

    public String getNamePlate() {
        return namePlate;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public DriverStatus getStatus() {
        return status;
    }

    public void setStatus(DriverStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", namePlate='" + namePlate + '\'' +
                ", location=" + location +
                ", status=" + status +
                '}';
    }
}
