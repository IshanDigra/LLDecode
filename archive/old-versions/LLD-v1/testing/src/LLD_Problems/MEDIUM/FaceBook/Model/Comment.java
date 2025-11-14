package LLD_Problems.MEDIUM.FaceBook.Model;

public class Comment {
    private final String id;
    private String content;
    private final User author;

    public Comment(String id, String content, User author) {
        this.id = id;
        this.content = content;
        this.author = author;
    }

    public String getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }
}
