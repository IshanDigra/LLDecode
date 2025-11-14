package Problems.HARD.Spotify.Model;

import java.util.List;
import java.util.stream.Collectors;

public class Artist {

    private final String id;
    private final String name;
    private final List<Album> albums;

    public Artist(String id, String name, List<Album> albums) {
        this.id = id;
        this.name = name;
        this.albums = albums;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Album> getAlbums() {
        return albums;
    }

    @Override
    public String toString() {
        return "Artist{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", albums=" + albums.stream().map(Album::getTitle).collect(Collectors.joining(", ")) + '\'' +
                '}';
    }
}
