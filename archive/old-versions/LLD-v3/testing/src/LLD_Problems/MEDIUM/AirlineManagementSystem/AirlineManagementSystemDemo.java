package LLD_Problems.MEDIUM.AirlineManagementSystem;

import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.SeatStatus;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Constants.SeatType;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Booking;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Flight;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Passanger;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Model.Seat;
import LLD_Problems.MEDIUM.AirlineManagementSystem.Service.FlightManagementSystem;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

public class AirlineManagementSystemDemo {
    public static void main(String[] args) {
        // Create users
        Passanger passenger1 = new Passanger("U001", "John Doe", "john@example.com");

        // Create flights
        LocalDateTime departureTime1 = LocalDateTime.now().plusDays(1);
        LocalDateTime arrivalTime1 = departureTime1.plusHours(2);
        Flight flight1 = new Flight("F001", "New York", "London", departureTime1, arrivalTime1);

        LocalDateTime departureTime2 = LocalDateTime.now().plusDays(3);
        LocalDateTime arrivalTime2 = departureTime2.plusHours(5);
        Flight flight2 = new Flight("F002", "Paris", "Tokyo", departureTime2, arrivalTime2);

        FlightManagementSystem flightManagementSystem = FlightManagementSystem.getInstance();

        flightManagementSystem.addFlight(flight1);
        flightManagementSystem.addFlight(flight2);


        // Search flights
        List<Flight> searchResults = flightManagementSystem.searchFlights("New York", "London", LocalDate.now().plusDays(1));

        System.out.println("Search Results:");
        for (Flight flight : searchResults) {
            System.out.println("Flight: " + flight.getFlightCode() + " - " + flight.getSourceAirport()+ " to " + flight.getDestinationAirport());
        }

        Seat seat = new Seat(1, SeatType.ECONOMY, SeatStatus.AVAILABLE);

        // Book a flight
        Booking booking = flightManagementSystem.bookFlight(flight1, passenger1, seat, 100);
        if (booking != null) {
            System.out.println("Booking successful. Booking ID: " + booking.getBookingID());
        } else {
            System.out.println("Booking failed.");
        }

        // Cancel a booking
        flightManagementSystem.cancelBooking(booking);
        System.out.println("Booking cancelled.");
    }
}
