package LLD_Problems.EASY.StackOverFlow;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StackOverFlow {
    Map<Integer,Answer> answers;
    Map<Integer, Question> questions;
    Map<Integer, Tag> tags;
    Map<Integer, User> users;

    public StackOverFlow(){
        answers = new HashMap<>();
        questions = new HashMap<>();
        tags = new HashMap<>();
        users = new HashMap<>();
    }

    public User createUser(String name, String email){
        User user = new User(name, email);
        users.put(user.getId(), user);
        return user;
    }

    public Question askQuestion(User user, String title, String content, List<Tag> tags){
        Question question = new Question(user, tags, title, content);
        user.askQuestion(title,content, tags);
        for(Tag tag : tags){
            this.tags.putIfAbsent(tag.getId(), tag);
        }
        return question;
    }
    public Answer answerQuestion(User user, Question question, String content) {
        Answer answer = user.answerQuestion(question, content);
        answers.put(answer.getId(), answer);
        return answer;
    }

    public Comment addComment(User user, Commentable commentable, String content) {
         return user.addComment(commentable, content);

    }

    public void voteQuestion(User user, Question question, int value) {
        question.vote(user, value);
    }

    public void voteAnswer(User user, Answer answer, int value) {
        answer.vote(user, value);
    }

    public void acceptAnswer(Answer answer) {
        answer.markAsAccepted();
    }

    public List<Question> getQuestionsbyUser(User user){
        return user.getQuestions();
    }

    public List<Answer> getAnswersbyUser(User user){
        return user.getAnswers();
    }

    public List<Question> searchQuestions(String query) {
        return questions.values().stream()
                .filter(q -> q.getTitle().toLowerCase().contains(query.toLowerCase()) ||
                        q.getContent().toLowerCase().contains(query.toLowerCase()) ||
                        q.getTags().stream().anyMatch(t -> t.getName().equalsIgnoreCase(query)))
                .collect(Collectors.toList());
    }



}
