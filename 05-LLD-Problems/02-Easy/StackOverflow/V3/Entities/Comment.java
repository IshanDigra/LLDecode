package V2.Entities;

import V2.Util.Utility;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Comment implements  Votable {
    private final String id;
    private final String content;
    private final User postedBy;
    private final Timestamp time;
    private final List<User> upVotes;
    private final List<User> downVotes;


    public Comment(String content, User postedBy) {
        this.id = Utility.CommentId();
        this.content = content;
        this.postedBy = postedBy;
        time = new Timestamp(System.currentTimeMillis());
        upVotes = new CopyOnWriteArrayList<>();
        downVotes = new CopyOnWriteArrayList<>();

    }

    @Override
    public synchronized void upVote(User user) {
        // removed the contribution of user from downvotes
        if(downVotes.contains(user)){
            downVotes.remove(user);
            Utility.updateReputation(postedBy, Constants.UPVOTE);
        }

        // clicking on upvote for second time hence removing the contribution
        if(upVotes.contains(user)){
            upVotes.remove(user);
            Utility.updateReputation(postedBy, Constants.DOWNVOTE);
        }
        else {
            upVotes.add(user);
            Utility.updateReputation(postedBy, Constants.UPVOTE);
        }

    }

    @Override
    public synchronized void downVote(User user) {
        // removed the contribution of user from upvotes
        if(upVotes.contains(user)){
            upVotes.remove(user);
            Utility.updateReputation(postedBy, Constants.DOWNVOTE);
        }
//      second click
        if(downVotes.contains(user)){
            downVotes.remove(user);
            Utility.updateReputation(postedBy, Constants.UPVOTE);
        }
        else {
            downVotes.add(user);
            Utility.updateReputation(postedBy, Constants.DOWNVOTE);
        }
    }




    public String getId() {
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
