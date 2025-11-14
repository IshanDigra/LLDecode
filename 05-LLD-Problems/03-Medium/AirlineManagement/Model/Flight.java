package LLD_Problems.MEDIUM.AirlineManagementSystem.Model;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Flight {
    private final String flightCode;
    private String sourceAirport;
    private String destinationAirport;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private List<Seat> seatList;

    public Flight(String flightCode, String sourceAirport, String destinationAirport, LocalDateTime departureTime, LocalDateTime arrivalTime) {
        this.flightCode = flightCode;
        this.sourceAirport = sourceAirport;
        this.destinationAirport = destinationAirport;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.seatList = new CopyOnWriteArrayList<>();
    }

    // logic

    // getter

    public String getFlightCode() {
        return flightCode;
    }

    public String getSourceAirport() {
        return sourceAirport;
    }

    public String getDestinationAirport() {
        return destinationAirport;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public List<Seat> getSeatList() {
        return seatList;
    }

    // setters


    public void setSourceAirport(String sourceAirport) {
        this.sourceAirport = sourceAirport;
    }

    public void setDestinationAirport(String destinationAirport) {
        this.destinationAirport = destinationAirport;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public void setSeatList(List<Seat> seatList) {
        this.seatList = seatList;
    }
}
