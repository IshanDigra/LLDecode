package V2.Services;

import V2.Entities.*;
import V2.Util.Utility;

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.stream.Collectors;

public class StackOverFlow {
    private static volatile StackOverFlow instance;
    private final List<Question> questions;
    private final Map<User, String> users;
    private final List<Answer> answers;
    private final List<Comment> comments ;

    private final SearchService searchService;

    private StackOverFlow() {
        questions = new CopyOnWriteArrayList<>();
        answers = new CopyOnWriteArrayList<>();
        users = new ConcurrentHashMap<>();
        comments = new CopyOnWriteArrayList<>();
        searchService = new SearchService(questions, users, answers, comments);
    }


    public static synchronized StackOverFlow getInstance(){
        if(instance == null){
            synchronized (StackOverFlow.class){
                if(instance == null){
                    instance = new StackOverFlow();
                }
            }
        }
        return instance;
    }

    public synchronized Question postQuestion(User user, List<String> tags, String content){
        if(content==null || content=="") throw new RuntimeException("Please add some content");
        Question question = new Question(content,user, tags);
        System.out.println("A new Question has been posted by "+ user.getName()+"!");
        Utility.updateReputation(user, Constants.QUESTION);
        questions.add(question);
        return question ;
    }
    public synchronized Answer postAnswer(User user, String body, Question question){
        if(body==null || body == "") throw new RuntimeException("Please some content");
        Answer answer = new Answer(body, question, user);
        answers.add(answer);
        Utility.updateReputation(user, Constants.ANSWER);
        question.postAnswer(answer);
        return answer;
    }
    public synchronized Comment postComment(User user, String body, Commentable commentable){
        if(body==null || body == "") throw new RuntimeException("Please some content");
        Comment comment = new Comment(body, user);
        comments.add(comment);
        Utility.updateReputation(user, Constants.COMMENT);
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
         return searchService.searchQuestions(keyword);
    }

}
