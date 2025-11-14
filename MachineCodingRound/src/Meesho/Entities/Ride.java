package Meesho.Entities;

import Meesho.Enums.RideStatus;

public class Ride {
    private final int id;
    private final User driver;

    private Route route;
    private double duration;
    private double distance;

    private RideStatus status;

    private User pasanger;

    public Ride(int id, User driver, Route route, double duration, double distance) {
        this.id = id;
        this.driver = driver;
        this.route = route;
        this.duration = duration;
        this.distance = distance;
        status = RideStatus.AVAILABLE;
        pasanger = null;
    }


    public void addPassanger(User user){
        if(status.equals(RideStatus.AVAILABLE)){
            System.out.println(user.getName() +" joined a ride along "+ driver.getName());
            pasanger = user;
        }

    }

    public void startRide(){
        if(pasanger == null) System.out.println("starting ride without a passanger");

        status = RideStatus.IN_PROGRESS;
    }

    public void completeRide(){
        status = RideStatus.COMPLETED;
        if(pasanger!= null){
            pasanger.updateFuelSaved(distance);
            pasanger.updateRidesTake(this);
        }

        driver.updateRidesOffered(this);


    }

    public int getId() {
        return id;
    }

    public User getDriver() {
        return driver;
    }

    public Route getRoute() {
        return route;
    }

    public void setRoute(Route route) {
        this.route = route;
    }

    public double getDuration() {
        return duration;
    }

    public void setDuration(double duration) {
        this.duration = duration;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    public RideStatus getStatus() {
        return status;
    }

    public void setStatus(RideStatus status) {
        this.status = status;
    }

    public User getPasanger() {
        return pasanger;
    }

    public void setPasanger(User pasanger) {
        this.pasanger = pasanger;
    }

    @Override
    public String toString() {
        return "Ride{" +
                "id=" + id +
                ", driver=" + driver.getName() +
                ", route=" + route +
                ", duration=" + duration +
                ", distance=" + distance +
                ", status=" + status +
             //   ", pasanger=" + pasanger.getName() +
                '}';
    }
}
