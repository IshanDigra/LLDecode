package Problems.HARD.Uber.Model;

public class Passenger {
    private final String id ;
    private final String name ;
    private final String contact;
    private Location location;

    public Passenger(String id, String name, String contact, Location location) {
        this.id = id;
        this.name = name;
        this.contact = contact;
        this.location = location;
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

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", contact='" + contact + '\'' +
                ", location=" + location +
                '}';
    }
}
