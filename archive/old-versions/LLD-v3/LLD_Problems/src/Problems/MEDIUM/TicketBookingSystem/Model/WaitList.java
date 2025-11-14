package Problems.MEDIUM.TicketBookingSystem.Model;

import java.util.LinkedList;
import java.util.Queue;

public class WaitList {
   // private final Concert concert;
    private final Queue<User> userQueue;

    public WaitList() {
     //   this.concert = concert;
        this.userQueue = new LinkedList<>();
    }

    public void addToWaitlist(User user) {
        userQueue.offer(user);
        System.out.println("User " + user.getName() + " added to waitlist for concert " );
    }

    public void notifyNextUser() {
        if (!userQueue.isEmpty()) {
            User nextUser = userQueue.poll();
            System.out.println("Notifying user " + nextUser + " about available seats.");
        }
    }
}
