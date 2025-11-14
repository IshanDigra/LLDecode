package LLD_Problems.MEDIUM.FaceBook.Model;

import java.sql.Timestamp;
import java.util.List;

public class Post {
    private final String id;
    private String title;
    private String description;
    private List<String> photoUrl;
    private List<Comment> comments;
    private final List<String> videoUrls;
    private final Timestamp timestamp;
    private final List<String> likes;
    private User user;

    public Post(String id, String title, String description, List<String> photoUrl, List<Comment> comments, List<String> videoUrls, List<String> likes, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.photoUrl = photoUrl;
        this.comments = comments;
        this.videoUrls = videoUrls;
        this.timestamp = new Timestamp(System.currentTimeMillis());
        this.likes = likes;
        this.user = user;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<String> getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(List<String> photoUrl) {
        this.photoUrl = photoUrl;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }

    public List<String> getVideoUrls() {
        return videoUrls;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public List<String> getLikes() {
        return likes;
    }
}
