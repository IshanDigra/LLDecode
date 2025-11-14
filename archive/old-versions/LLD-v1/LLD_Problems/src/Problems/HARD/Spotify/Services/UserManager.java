package Problems.HARD.Spotify.Services;

import Problems.HARD.Spotify.Model.Playlist;
import Problems.HARD.Spotify.Model.Song;
import Problems.HARD.Spotify.Model.User;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class UserManager {
    private static UserManager instance;
    private Map<String, User> users;


    private UserManager() {
        users = new ConcurrentHashMap<>();
    }

    public static synchronized UserManager getInstance(){
        if(instance == null) instance = new UserManager();
        return instance;
    }

    // addUser, authenticateUser, createPlaylist, addSongToPlaylist, removeSongFromPlaylist, deletePlaylist

    public void registerUser(User user){
        users.put(user.getId(), user);
    }

    public User authenticateUser(String email, String password){
        for(User user : users.values()){
            if(user.getEmail().equals(email) && user.getPassword().equals(password)) return user;
        }
        return null;
    }

    public Playlist createPlaylist(String id, String title, User user){
        Playlist playlist = new Playlist(id, title, user);
        user.createPlaylist(playlist);
        return playlist;
    }

    public void addSongToPlaylist(Playlist playlist, Song song){
        playlist.addSong(song);
    }

    public void removeSongFromPlaylist(Playlist playlist, Song song){
        playlist.remove(song);
    }
}
