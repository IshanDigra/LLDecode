package Meesho.Entities;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class User {
    private final int id;
    private final String name;
    private List<Ride> ridesOffered;
    private List<Ride> ridesTaken;

    private double fuelSaved;

    public User(int id, String name) {
        this.id = id;
        this.name = name;
        ridesOffered = new CopyOnWriteArrayList<>();
        ridesTaken = new CopyOnWriteArrayList<>();
        fuelSaved = 0.0 ;
    }

    public int getId() {
        return id;
    }

    public void updateRidesTake(Ride ride){
        ridesTaken.add(ride);
    }

    public void updateRidesOffered(Ride ride){
        ridesOffered.add(ride);
    }
    public void updateFuelSaved(double x){
        fuelSaved += x;
    }

    public String getName() {

        return name;
    }

    public List<Ride> getRidesOffered() {
        return ridesOffered;
    }

    public void setRidesOffered(List<Ride> ridesOffered) {
        this.ridesOffered = ridesOffered;
    }

    public List<Ride> getRidesTaken() {
        return ridesTaken;
    }

    public void setRidesTaken(List<Ride> ridesTaken) {
        this.ridesTaken = ridesTaken;
    }

    public double getFuelSaved() {
        return fuelSaved;
    }

    public void setFuelSaved(double fuelSaved) {
        this.fuelSaved = fuelSaved;
    }
}
