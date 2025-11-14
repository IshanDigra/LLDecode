package LLD_Problems.EASY.StackOverFlow;

import java.util.List;

public interface Commentable {
    public Comment addComment(Comment comment);
    List<Comment> getComments();
}
