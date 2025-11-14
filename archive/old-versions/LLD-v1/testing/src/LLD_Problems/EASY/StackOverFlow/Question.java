package LLD_Problems.EASY.StackOverFlow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Question implements Commentable, Votable{

    private String content;
    private String title;
    private int id;
    private List<Tag> tags;
    private User author;
    private final Date creationDate;
    private final List<Answer> answers;
    private final List<Comment> comments;
    private final List<Vote> votes;

    public Question(User author, List<Tag> tags, String title, String content) {
        comments = new ArrayList<>();
        votes = new ArrayList<>();
        answers = new ArrayList<>();
        creationDate = new Date(System.currentTimeMillis());
        this.author = author;
        this.tags = tags;
        id = UUID.randomUUID().hashCode();
        this.title = title;
        this.content = content;
    }

    public void addAnswer(Answer answer) {
        answers.add(answer);
    }

    @Override
    public Comment addComment(Comment comment) {
        comments.add(comment);
        return comment;
    }


    @Override
    public List<Comment> getComments() {
        return new ArrayList<>(comments);
    }

    public void vote(User user, int Value) {
        if (Value != 1 && Value != -1) {
            throw new IllegalArgumentException("Vote value must be either 1 or -1");
        }
        votes.removeIf(v -> v.getUser().equals(user));

        votes.add(new Vote(Value, user));
        author.updateReputation(Value*5);
    }

    @Override
    public int getVoteCount() {
        int voteCount = 0;
        for(Vote vote : votes){
            // ideally it should be upvotes + downvotes as well not the net amount
            voteCount+= vote.getValue();
        };
        return voteCount;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }

    public int getId() {
        return id;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public User getAuthor() {
        return author;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
