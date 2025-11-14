package LLD_Problems.EASY.StackOverFlow;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

public class Answer implements Commentable, Votable{

    private String content;
    private Question question;
    private int id;
    private User author;
    private boolean isAccepted;
    private final Date creationDate;
    private final List<Comment> comments;
    private final List<Vote> votes;


    public Answer(User author,Question question, String content) {
       comments = new ArrayList<>();
       votes = new ArrayList<>();
       creationDate = new Date(System.currentTimeMillis());
        isAccepted = false;
        this.author = author;
        id = UUID.randomUUID().hashCode();
        this.question = question;
        this.content = content;
    }

    @Override
    public Comment addComment(Comment comment) {

        comments.add(comment);
        return comment;
    }

    public void markAsAccepted() {
        if (isAccepted) {
            throw new IllegalStateException("This answer is already accepted");
        }
        isAccepted = true;
        author.updateReputation(15);  // +15 reputation for accepted answer
    }

    @Override
    public List<Comment> getComments() {

        return new ArrayList<>(comments);
    }

    @Override
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

    public Question getQuestion() {
        return question;
    }

    public int getId() {
        return id;
    }

    public User getAuthor() {
        return author;
    }

    public boolean isAccepted() {
        return isAccepted;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public List<Vote> getVotes() {
        return votes;
    }
}
