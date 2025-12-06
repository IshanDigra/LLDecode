package V2.Util;

import V2.Entities.User;

import java.util.concurrent.atomic.AtomicLong;

public class Utility {
    private static final AtomicLong userId = new AtomicLong(0);
    private static final AtomicLong questionId = new AtomicLong(0);
    private static final AtomicLong answerId = new AtomicLong(0);
    private static final AtomicLong commentId = new AtomicLong(0);

    public static String UserId(){
        return "USR_" + userId.incrementAndGet();
    }

    public static String QuestionId(){
        return "QS_" + questionId.incrementAndGet();
    }
    public static String AnswerId(){
        return "AS_" + answerId.incrementAndGet();
    }
    public static String CommentId(){
        return "CMT_" + commentId.incrementAndGet();
    }

    public static void updateReputation(User user, Long reputationScore){
        user.updateReputation(reputationScore);
    }
}
