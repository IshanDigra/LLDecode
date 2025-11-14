package AsishPratapProblems.EASY.StackOverflow.V1;

import java.sql.Timestamp;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

/*
Entities: User, Question, Answer, Comment, vote, tag, StackOverflow
enums:
Core Functionalities: PostQuestion, AswerQuestion, CommentQuestion, commentAnswer, searchQuestion, upvote, downvote, Reputation


=> User: id, name, email, List<Questions>, List<Answers>, List<Comments>, reputationScore
postQuestion, AswerQuestion, CommentQuestion, commentAnswer, updateReputation

=> Question: id, content, author, creationDate, List<tags>, List<answers>, List<comments>, voteCount
addAnswer, addComment, updateVote

=> Answer: id, content, author, postingDate, List<comments>, voteCount
addComment, updateVote

=> comment: id, Commentable(Q/A), author, voteCount

=> tag: id, title


=> StackOverFlow: Map<id, User>, Map<id, Questions>, Map<id, Answers>, Map<id, Tag>
 postQuestion, AswerQuestion, CommentQuestion, commentAnswer, search Question, upVote, downVote
* */
public class SingleFileCode {

//Interface
    public interface Commentable{
        public void addComment(Comment comment);
};


// Entities


    public static class Question implements  Commentable{
        // id, content, author, creationDate, List<tags>, List<answers>, List<comments>, voteCount
        private final String id;
        private String content ;
        private User author;
        private Timestamp creationDate;
        private List<Tag> tagList;
        private List<Answer> answerList;
        private List<Comment> commentList;
        private int voteCount;

        public Question(String id, String content, User author, List<Tag> tagList) {
            this.id = id;
            this.content = content;
            this.author = author;
            creationDate = new Timestamp(System.currentTimeMillis());
            this.tagList = tagList;
            answerList = new LinkedList<>();
            commentList = new LinkedList<>();
            voteCount = 0 ;
        }

        @Override
        public String toString() {
            return "Question{" +
                    "id='" + id + '\'' +
                    ", content='" + content + '\'' +
                    ", author=" + author.getName() +
                    ", creationDate=" + creationDate +
                    ", tagList=" + tagList.size() +
                    ", answerList=" + answerList.size() +
                    ", commentList=" + commentList.size() +
                    '}';
        }

        // addAnswer, addComment, updateVote
        public void addAnswer(Answer answer){
            answerList.add(answer);
        }
        public void updateVote(){}

        @Override
        public void addComment(Comment comment) {
            commentList.add(comment);
        }

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }

        public List<Tag> getTagList() {
            return tagList;
        }

        public void setTagList(List<Tag> tagList) {
            this.tagList = tagList;
        }

        public List<Answer> getAnswerList() {
            return answerList;
        }

        public void setAnswerList(List<Answer> answerList) {
            this.answerList = answerList;
        }

        public List<Comment> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<Comment> commentList) {
            this.commentList = commentList;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }
    };

    public static class Answer implements  Commentable{
        // id, content, author, postingDate, List<comments>, voteCount
        private final String id ;
        private String content ;
        private User author;
        private Timestamp creationDate;
        private List<Comment> commentList;
        private int voteCount;

        public Answer(String id, String content, User author) {
            this.id = id;
            this.content = content;
            this.author = author;
            creationDate = new Timestamp(System.currentTimeMillis());
            commentList = new LinkedList<>();
            voteCount = 0 ;
        }
        // addComment, updateVote


        public void updateVote(){}

        @Override
        public void addComment(Comment comment) {
            commentList.add(comment);
        }

        public String getId() {
            return id;
        }

        public String getContent() {
            return content;
        }

        public void setContent(String content) {
            this.content = content;
        }

        public User getAuthor() {
            return author;
        }

        public void setAuthor(User author) {
            this.author = author;
        }

        public Timestamp getCreationDate() {
            return creationDate;
        }

        public void setCreationDate(Timestamp creationDate) {
            this.creationDate = creationDate;
        }

        public List<Comment> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<Comment> commentList) {
            this.commentList = commentList;
        }

        public int getVoteCount() {
            return voteCount;
        }

        public void setVoteCount(int voteCount) {
            this.voteCount = voteCount;
        }
    };

    public static class Comment{
        // id, Commentable(Q/A), author, voteCount
        private final String id;
        private Commentable commentable;
        private User author;
        private int voteCount;

        public Comment(String id, Commentable commentable, User author) {
            this.id = id;
            this.commentable = commentable;
            this.author = author;
            voteCount = 0 ;
        }
    };

    public static class Tag{
        private final String name;
        private String desc;

        public Tag(String name, String desc) {
            this.name = name;
            this.desc = desc;
        }

        public String getName() {
            return name;
        }

        public String getDesc() {
            return desc;
        }

        public void setDesc(String desc) {
            this.desc = desc;
        }
    };
    public static class StackOverflow{
        // Map<id, User>, Map<id, Questions>, Map<id, Answers>, Map<id, Tag>
        private Map<String, User> users;
        private Map<String, Question> questions;
        private Map<String, Answer> answers;
        private Map<String, Tag> tags;

        public StackOverflow() {
            users = new ConcurrentHashMap<>();
            questions = new ConcurrentHashMap<>();
            answers = new ConcurrentHashMap<>();
            tags = new ConcurrentHashMap<>();
        }

        // postQuestion, AswerQuestion, CommentQuestion, commentAnswer, search Question, upVote, downVote
        public Question postQuestion(String id, String content, User author, List<Tag> tagList){
            Question question = author.postQuestion(id, content, tagList);
            questions.put(id, question);
            users.put(author.getId(), author);
            for(Tag tag : tagList){
                tags.put(tag.getName(), tag);
            }
            return question;
        }
        public Answer answerQuestion(String id, String content, Question question, User author){
            Answer answer = author.answerQuestion(id, content, question);
            answers.put(answer.getId(), answer);
            users.put(author.getId(), author);
            return answer;
        }
        public Comment addComment(String id, Commentable commentable, String content, User author){
            Comment comment = author.addComment(id, commentable,content);
            users.put(author.getId(), author);
            return comment;
        }
        public void upVote() {}
        public void downVote() {}
        public List<Question> searchQuestions(String keyword){
            List<Question> question = questions.values().stream().filter(q->q.getAuthor().getName().equalsIgnoreCase(keyword)||
                    q.getContent().contains(keyword.toLowerCase()) ||
                    q.getTagList().stream().anyMatch(t->t.getName().contains(keyword.toLowerCase())||
                            t.getDesc().contains(keyword.toLowerCase())
                            )
                    ).collect(Collectors.toList());
            return question;
        }
    };

    public static class User{
        // id, name, email, List<Questions>, List<Answers>, List<Comments>, reputationScore
        private final String id;
        private String name;
        private String email;
        private List<Question> questionList;
        private List<Answer> answerList;
        private List<Comment> commentList;
        private int reputationScore;

        public User(String id, String name, String email) {
            this.id = id;
            this.name = name;
            this.email = email;
            questionList = new LinkedList<>();
            answerList = new LinkedList<>();
            commentList = new LinkedList<>();
            reputationScore = 0 ;
        }
        // postQuestion, AswerQuestion, CommentQuestion, commentAnswer, updateReputation
        public Question postQuestion(String id, String content, List<Tag> tagList){
            Question question= new Question(id, content, this, tagList);
            System.out.println(name + " posted a new Question: "+ content);
            questionList.add(question);
            return question;
        }
        public Answer answerQuestion(String id, String content, Question question){
            Answer answer = new Answer(id, content, this);
            System.out.println(name+  " posted a new Answer: "+ content+" for Question: "+question.content);
            answerList.add(answer);
            question.addAnswer(answer);
            return answer;
        }
        public Comment addComment(String id, Commentable commentable, String content){
            Comment comment = new Comment(id, commentable, this);
            System.out.println(name+ " posted a new comment: "+content);
            commentList.add(comment);
            commentable.addComment(comment);
            return comment;
        }

        public void updateReputation(){}
        public void upVote() {}
        public void downVote() {}

        // getters setters

        public String getId() {
            return id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public List<Question> getQuestionList() {
            return questionList;
        }

        public void setQuestionList(List<Question> questionList) {
            this.questionList = questionList;
        }

        public List<Answer> getAnswerList() {
            return answerList;
        }

        public void setAnswerList(List<Answer> answerList) {
            this.answerList = answerList;
        }

        public List<Comment> getCommentList() {
            return commentList;
        }

        public void setCommentList(List<Comment> commentList) {
            this.commentList = commentList;
        }

        public int getReputationScore() {
            return reputationScore;
        }

        public void setReputationScore(int reputationScore) {
            this.reputationScore = reputationScore;
        }

        // to String
    };


    public static void main(String[] args) {
        StackOverflow system = new StackOverflow();
        User ishan = new User("1", "ishan","");
        User gajri = new User("2", "gargi", "");
        User joy = new User("3", "joy", "");
        Question q1 = system.postQuestion("1", "what is the purpose of life?", ishan, Arrays.asList(new Tag("Psychology", ""), new Tag("trending", "")));
        Answer a1 = system.answerQuestion("1", "It is to live life to the fullest and achieve your ultimte goal.", q1, gajri);
        Comment c1 = system.addComment("1", q1, "Good Question", joy);
        Comment c2 = system.addComment("2", a1, "I beg to differ. it is to lead a joyous life.", joy);

        List<Question> qq = system.searchQuestions("trend");
        for(Question q : qq){
            System.out.println(q);
        }
    }
}
