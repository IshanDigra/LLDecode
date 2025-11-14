package Problems.HARD.Spotify.Model;

import java.util.List;
import java.util.stream.Collectors;

public class Album {

    private final String id;
    private final String title;
    private final List<Song> songs;
    private final Artist artist;

    public Album(String id, String title, List<Song> songs, Artist artist) {
        this.id = id;
        this.title = title;
        this.songs = songs;
        this.artist = artist;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public Artist getArtist() {
        return artist;
    }

    @Override
    public String toString() {
        return "Album{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", songs=" + songs.stream().map(n->n.getTitle()).collect(Collectors.joining(", "))+ '\'' +
                ", artist=" + artist.getName() +
                '}';
    }
}
