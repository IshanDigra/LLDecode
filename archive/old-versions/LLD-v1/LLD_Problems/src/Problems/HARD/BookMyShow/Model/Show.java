package Problems.HARD.BookMyShow.Model;

import java.time.LocalDateTime;
import java.util.Map;

public class Show {
    private final String id;
    private final Movie movie;
    private final Theatre theatre;
    private final LocalDateTime startTime;
    private final LocalDateTime endTime;
    /*we have included seats in show model because the
    show decides the price of a seat and everything else.*/
    private final Map<String, Seat> seats;

    public Show(String id, Movie movie, Theatre theatre, LocalDateTime startTime, LocalDateTime endTime, Map<String, Seat> seats) {
        this.id = id;
        this.movie = movie;
        this.theatre = theatre;
        this.startTime = startTime;
        this.endTime = endTime;
        this.seats = seats;
    }

    public String getId() {
        return id;
    }

    public Movie getMovie() {
        return movie;
    }

    public Theatre getTheatre() {
        return theatre;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public LocalDateTime getEndTime() {
        return endTime;
    }

    public Map<String, Seat> getSeats() {
        return seats;
    }

}
