package LLD_Problems.EASY.StackOverFlow;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private String name;
    private int id;
    private int reputation;
    private String email;
    private List<Question> questions;;
    private List<Answer> answers;
    private List<Comment> comments;

    private static final int QUESTION_REPUTATION = 5;
    private static final int ANSWER_REPUTATION = 10;
    private static final int COMMENT_REPUTATION = 2;

    public User(String name, String email) {
        this.name = name;
        id = UUID.randomUUID().hashCode();
        reputation = 0;
        this.email = email;
        questions = new ArrayList<>();
        answers = new ArrayList<>();
        comments = new ArrayList<>();
    }

    public Question askQuestion(String title, String content, List<Tag> tags) {
        Question question = new Question(this, tags, title, content);
        questions.add(question);
        updateReputation(QUESTION_REPUTATION);
        return question;

    }
    public Answer answerQuestion(Question question, String content) {
        Answer answer = new Answer(this, question, content);
        question.addAnswer(answer);
        answers.add(answer);
        updateReputation(ANSWER_REPUTATION);
        return answer;
    }

    public Comment addComment(Commentable commentable, String content) {
        Comment comment = new Comment(content, this);
        comments.add(comment);
        updateReputation(COMMENT_REPUTATION);
        commentable.addComment(comment);
        return comment;
    }

    public void updateReputation(int value) {
        reputation += value;
        if (reputation <0){
            reputation = 0;
        }

    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }

    public int getReputation() {
        return reputation;
    }

    public String getEmail() {
        return email;
    }

    public List<Question> getQuestions() {
        return questions;
    }

    public List<Answer> getAnswers() {
        return answers;
    }

    public List<Comment> getComments() {
        return comments;
    }
}
