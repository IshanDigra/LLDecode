package AsishPratapProblems.EASY.StackOverflow.V2.Entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Comment implements  Votable {
    private final int id;
    private final String content;
    private final User postedBy;
    private final Timestamp time;
    private final List<User> upVotes;
    private final List<User> downVotes;


    public Comment(int id, String content, User postedBy) {
        this.id = id;
        this.content = content;
        this.postedBy = postedBy;
        time = new Timestamp(System.currentTimeMillis());
        upVotes = new CopyOnWriteArrayList<>();
        downVotes = new CopyOnWriteArrayList<>();

    }

    @Override
    public synchronized void upVote(User user) {
        if(downVotes.contains(user)){
            downVotes.remove(user);
            postedBy.updateReputation(Constants.UPVOTE);
        }

        if(upVotes.contains(user)){
            postedBy.updateReputation(Constants.DOWNVOTE);
            upVotes.remove(user);
        }
        else {
            upVotes.add(user);
            postedBy.updateReputation(Constants.UPVOTE);
        }

    }

    @Override
    public synchronized void downVote(User user) {
        if(upVotes.contains(user)){
            upVotes.remove(user);
            postedBy.updateReputation(Constants.DOWNVOTE);
        }

        if(downVotes.contains(user)){
            downVotes.remove(user);
            postedBy.updateReputation(Constants.UPVOTE);
        }
        else {
            downVotes.add(user);
            postedBy.updateReputation(Constants.DOWNVOTE);
        }
    }




    public int getId() {
        return id;
    }

    public String getContent() {
        return content;
    }

    public User getPostedBy() {
        return postedBy;
    }

    public Timestamp getTime() {
        return time;
    }

    public List<User> getUpVotes() {
        return upVotes;
    }

    public List<User> getDownVotes() {
        return downVotes;
    }

    @Override
    public String toString() {
        return "Comment{" +
                ", content='" + content + '\'' +
                ", postedBy=" + postedBy.getName() +
                ", time=" + time +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                '}';
    }
}
