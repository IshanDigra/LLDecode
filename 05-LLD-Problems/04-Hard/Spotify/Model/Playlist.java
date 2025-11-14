package Problems.HARD.Spotify.Model;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Playlist {

    private final String id;
    private final String title;
    private final User owner;
    private final List<Song> songs;

    public Playlist(String id, String title, User owner) {
        this.id = id;
        this.title = title;
        this.owner = owner;
        songs = new CopyOnWriteArrayList<>();
    }

    public void addSong(Song song){
        songs.add(song);
    }
    public void remove(Song song){
        songs.remove(song);
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public User getOwner() {
        return owner;
    }

    public List<Song> getSongs() {
        return songs;
    }

    @Override
    public String toString() {
        return "Playlist{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", owner=" + owner.getName() +
                ", songs=" + songs +
                '}';
    }
}
