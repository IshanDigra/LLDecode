package LLD_Problems.EASY.StackOverFlow;

import java.util.Date;
import java.util.UUID;

public class Comment {
    private String content;
    private final User author;
    private final Date creationDate;
    private final int id;

    public Comment(String content, User author) {
        this.content = content;
        this.author = author;
        this.creationDate = new Date(System.currentTimeMillis());
        id = UUID.randomUUID().hashCode();
    }

    public String getContent() {
        return content;
    }

//  Can be used for editing the content
    public void setContent(String content) {
        this.content = content;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public int getId() {
        return id;
    }
}
