package AsishPratapProblems.EASY.StackOverflow.V2.Entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Answer implements  Commentable, Votable{
    private final int id;
    private final String body ;
    private final Question question;
    private final User postedBy;
    private final Timestamp time;
    private final List<User> upVotes;
    private final List<User> downVotes;
    private final List<Comment> commentList;

    public Answer(int id, String body, Question question, User postedBy) {
        this.id = id;
        this.body = body;
        this.question = question;
        this.postedBy = postedBy;
        upVotes = new CopyOnWriteArrayList<>();
        downVotes = new CopyOnWriteArrayList<>();
        commentList = new CopyOnWriteArrayList<>();
        time = new Timestamp(System.currentTimeMillis());
    }

    @Override
    public synchronized void postComment(Comment comment) {
        System.out.println("A new Comment has been posted by "+ comment.getPostedBy().getName()+ " on "+postedBy.getName()+"'s Answer!");
        commentList.add(comment);
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

    public String getBody() {
        return body;
    }

    public Question getQuestion() {
        return question;
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

    public List<Comment> getCommentList() {
        return commentList;
    }

    @Override
    public String toString() {
        return "Answer{" +

                ", body='" + body + '\'' +
                ", postedBy=" + postedBy.getName() +
                ", time=" + time +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                ", commentList=" + commentList +
                '}';
    }
}
