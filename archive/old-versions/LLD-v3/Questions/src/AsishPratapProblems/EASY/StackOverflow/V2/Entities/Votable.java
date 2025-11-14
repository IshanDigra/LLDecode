package AsishPratapProblems.EASY.StackOverflow.V2.Entities;

import java.util.List;

public interface Votable {
    public void upVote(User user);
    public void downVote(User user);

    public List<User> getUpVotes();
    public List<User> getDownVotes();
}
