package Problems.HARD.Spotify.Model;

import Problems.HARD.Spotify.Constant.SongType;

public class Song {

    private final String id;
    private final String title;
    private final SongType genre;
    private final Album album;
    private final Artist artist;
    private final int duration;


    public Song(String id, String title, SongType genre, Album album, Artist artist, int duration) {
        this.id = id;
        this.title = title;
        this.genre = genre;
        this.album = album;
        this.artist = artist;
        this.duration = duration;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public SongType getGenre() {
        return genre;
    }

    public Album getAlbum() {
        return album;
    }

    public Artist getArtist() {
        return artist;
    }

    public int getDuration() {
        return duration;
    }

    @Override
    public String toString() {
        return "Song{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", genre=" + genre +
                ", album=" + album.getTitle()+
                ", artist=" + artist.getName() +
                ", duration=" + duration +
                '}';
    }
}
