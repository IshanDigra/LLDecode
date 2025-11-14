package AsishPratapProblems.EASY.StackOverflow.V2.Entities;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class StackOverFlow {
    private static StackOverFlow instance;
    private int id;
    private final List<Question> questions;
    private final Map<User, String> users;
    private final List<Answer> answers;
    private final List<Comment> comments ;

    private StackOverFlow() {
        id = 0 ;
        questions = new CopyOnWriteArrayList<>();
        answers = new CopyOnWriteArrayList<>();
        users = new ConcurrentHashMap<>();
        comments = new CopyOnWriteArrayList<>();
    }


    public static synchronized StackOverFlow getInstance(){
        if(instance == null){
            instance = new StackOverFlow();
        }
        return instance;
    }

    public Question postQuestion(User user, List<String> tags, String content){
        if(content==null || content=="") throw new RuntimeException("Please some content");
        Question question = new Question(idGenerator(),content,user, tags);
        System.out.println("A new Question has been posted by "+ user.getName()+"!");
        user.updateReputation(Constants.QUESTION);
        questions.add(question);
        return question ;
    }
    public Answer postAnswer(User user, String body, Question question){
        if(body==null || body == "") throw new RuntimeException("Please some content");
        Answer answer = new Answer(idGenerator(), body, question, user);
        answers.add(answer);
        user.updateReputation(Constants.ANSWER);
        question.postAnswer(answer);
        return answer;
    }
    public Comment postComment(User user, String body, Commentable commentable){
        if(body==null || body == "") throw new RuntimeException("Please some content");
        Comment comment = new Comment(idGenerator(), body, user);
        comments.add(comment);
        user.updateReputation(Constants.COMMENT);
        commentable.postComment(comment);
        return comment;
    }
    public synchronized void upVote(User user, Votable votable){
        votable.upVote(user);
    }
    public synchronized void downVote(User user, Votable votable){
        votable.downVote(user);
    }

    public List<User> getUpVotes(Votable votable){
        return votable.getUpVotes();
    }

    public List<User> getDownVotes(Votable votable){
        return votable.getDownVotes();
    }
    public List<Question> searchQuestions(String keyword){
         return questions.stream().filter(q->q.getBody().toLowerCase().contains(keyword.toLowerCase())
        || q.getTags().contains(keyword) || q.getPostedBy().getName().equalsIgnoreCase(keyword)
        ).collect(Collectors.toList());
    }



    private synchronized int idGenerator(){
        return id++;
    }

}
