package LLD_Problems.MEDIUM.AirlineManagementSystem.Service;

import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Flight;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public class FlightSearch {
    private List<Flight> flights;
    public FlightSearch(List<Flight> flights){
        this.flights = flights;
    }

    public List<Flight> getFlights(String src, String dest, LocalDate date) {

        return flights.stream()
                .filter(v->v.getSourceAirport().equals(src)
                && v.getDestinationAirport().equals(dest)
                && v.getDepartureTime().toLocalDate().equals(date))
                .collect(Collectors.toList());
    }

    public List<Flight> getFlights(){
        return flights;
    }

}
