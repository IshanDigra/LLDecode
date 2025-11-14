package AsishPratapProblems.EASY.StackOverflow.V2.Entities;

import java.sql.Timestamp;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class Question implements Commentable, Votable{
    private final int id;
    private final String body ;
    private final User postedBy;
    private final List<String> tags;
    private final Timestamp time;
    private final List<User> upVotes;
    private final List<User> downVotes;
    private final List<Comment> commentList;
    private final List<Answer> answerList;

    public Question(int id, String body, User postedBy, List<String> tags) {
        this.id = id;
        this.body = body;

        this.postedBy = postedBy;
        this.tags = tags;
        time = new Timestamp(System.currentTimeMillis());
        upVotes = new CopyOnWriteArrayList<>();
        downVotes = new CopyOnWriteArrayList<>();
        commentList = new CopyOnWriteArrayList<>();
        answerList = new CopyOnWriteArrayList<>();
    }

    @Override
    public synchronized void postComment(Comment comment) {
        System.out.println("A new Comment has been posted by "+ comment.getPostedBy().getName()+ " on "+postedBy.getName()+"'s Question!");
        commentList.add(comment);
    }

    public synchronized void postAnswer(Answer answer){
        System.out.println("A new Answer has been posted by "+ answer.getPostedBy().getName()+ " on "+postedBy.getName()+"'s Question!");
        answerList.add(answer);
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



    public User getPostedBy() {
        return postedBy;
    }

    public List<String> getTags() {
        return tags;
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

    public List<Answer> getAnswerList() {
        return answerList;
    }

    @Override
    public String toString() {
        return "Question{" +

                ", body='" + body + '\'' +
                ", postedBy=" + postedBy.getName() +
                ", time=" + time +
                ", upVotes=" + upVotes +
                ", downVotes=" + downVotes +
                '}';
    }
}
