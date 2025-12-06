package V2.Services;

import V2.Entities.Answer;
import V2.Entities.Comment;
import V2.Entities.Question;
import V2.Entities.User;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class SearchService {
    private final List<Question> questions;
    private final Map<User, String> users;
    private final List<Answer> answers;
    private final List<Comment> comments ;

    public SearchService(List<Question> questions, Map<User, String> users, List<Answer> answers, List<Comment> comments) {
        this.questions = questions;
        this.users = users;
        this.answers = answers;
        this.comments = comments;
    }

    public List<Question> searchQuestions(String keyword){
        return questions.stream().filter(q->q.getBody().toLowerCase().contains(keyword.toLowerCase())
                || q.getTags().contains(keyword) || q.getPostedBy().getName().equalsIgnoreCase(keyword)
        ).collect(Collectors.toList());
    }
}
