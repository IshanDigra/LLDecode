package V2;


import V2.Entities.Answer;
import V2.Entities.Comment;
import V2.Entities.Question;
import V2.Entities.User;
import V2.Services.StackOverFlow;

import java.util.Arrays;
import java.util.List;

public class Demo {
    public static void main(String[] args) {
        StackOverFlow instance = StackOverFlow.getInstance();

        User ishan = new User("ishan");
        User pallav = new User( "Pallav");
        User Mehak = new User( "Mehak");

       Question q1 = instance.postQuestion(ishan, Arrays.asList("Science", "Philosophy", "Inner self"),"What is the purpose of life ?");
        Question q2 = instance.postQuestion(ishan, Arrays.asList("Science", "Philosophy", "health"),"What is Fun?");
       Answer a1 = instance.postAnswer(pallav,"It is to live life to the fullest", q1);
       Comment c1 = instance.postComment(Mehak, "lool",a1);
       instance.upVote(ishan,a1);
       instance.upVote(ishan,c1);
       instance.upVote(Mehak, q2);
       instance.downVote(pallav, c1);
        List<Question> questions = instance.searchQuestions("ishan");
        System.out.println("Question search based on name");
        questions.forEach(q-> System.out.println(q));

        List<Question> questions2 = instance.searchQuestions("health");
        System.out.println("Question search based on tag");
        questions2.forEach(q-> System.out.println(q));

        List<Question> questions3 = instance.searchQuestions("fun");
        System.out.println("Question search based on keyword");
        questions3.forEach(q-> System.out.println(q));

        System.out.println("Reputation of each user");
        System.out.println(ishan.getName() + " : "+ishan.getReputation());
        System.out.println(pallav.getName() + " : "+pallav.getReputation());
        System.out.println(Mehak.getName() + " : "+Mehak.getReputation());

        System.out.println(q1);
        q1.getAnswerList().forEach(System.out::println);

    }
}
