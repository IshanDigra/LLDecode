package Problems.HARD.Spotify.Services;

import Problems.HARD.Spotify.Model.Album;
import Problems.HARD.Spotify.Model.Artist;
import Problems.HARD.Spotify.Model.Song;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

public class SongLibrary {
//    V: Map<Artist>, Map<Album>, Map<Song>
//    M: addSong, addAlbum, addArtist, searchSong
    private static SongLibrary instance;
    private final Map<String, Song> songs;
    private final Map<String, Album> albums;
    private final Map<String, Artist> artists;


    private SongLibrary() {
        this.songs = new ConcurrentHashMap<>();
        this.albums = new ConcurrentHashMap<>();
        this.artists = new ConcurrentHashMap<>();
    }

    public static synchronized SongLibrary getInstance(){
        if(instance == null) instance = new SongLibrary();
        return instance;
    }

    public void addSong(Song song){
        songs.put(song.getId(),song) ;
    }

    public void addAlbum(Album album){
        albums.put(album.getId(), album) ;
        for(Song song : album.getSongs()){
            songs.put(song.getId(),song);
        }
    }

    public void addArtist(Artist artist) {
        artists.put(artist.getId(), artist);
        for (Album album : artist.getAlbums()) {
            addAlbum(album);
        }
    }

    public Song getSong(String songId) {
        return songs.get(songId);
    }

    public Album getAlbum(String albumId) {
        return albums.get(albumId);
    }

    public Artist getArtist(String artistId) {
        return artists.get(artistId);
    }

    public List<Song> searchSong(String keyword){
        return songs.values().stream().filter(n->n.getTitle().contains(keyword)||
                n.getArtist().getName().contains(keyword)||
                n.getAlbum().getTitle().contains(keyword)).collect(Collectors.toList());
    }



    public Map<String, Song> getSongs() {
        return songs;
    }

    public Map<String, Album> getAlbums() {
        return albums;
    }

    public Map<String, Artist> getArtists() {
        return artists;
    }
}
