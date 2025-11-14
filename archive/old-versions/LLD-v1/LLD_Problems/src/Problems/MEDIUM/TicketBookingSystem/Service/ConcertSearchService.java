package Problems.MEDIUM.TicketBookingSystem.Service;

import Problems.MEDIUM.TicketBookingSystem.Model.Concert;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public class ConcertSearchService {
    private final List<Concert> concerts;

    public ConcertSearchService(List<Concert> concerts) {
        this.concerts = concerts;
    }

    public List<Concert> searchConcerts(String artist, String venue, LocalDateTime dateTime) {
        return concerts.stream()
                .filter(n-> n.getArtist().equalsIgnoreCase(artist) &&
                        n.getVenue().equalsIgnoreCase(venue) &&
                        n.getDateTime().toLocalDate().equals(dateTime.toLocalDate())
                )
                .collect(Collectors.toList());
    }
}
