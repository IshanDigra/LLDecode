package Problems.MEDIUM.OnlineAuctionSystem.Model;

import java.sql.Timestamp;

public class Bid {
    private final String id;
    private  final User bidder;
    private  final double bidAmount;
    private  final Timestamp time;

    public Bid(String id, User bidder, double bidAmount) {
        this.id = id;
        this.bidder = bidder;
        this.bidAmount = bidAmount;
        time = new Timestamp(System.currentTimeMillis());
    }

    public String getId() {
        return id;
    }

    public User getBidder() {
        return bidder;
    }

    public double getBidAmount() {
        return bidAmount;
    }

    public Timestamp getTime() {
        return time;
    }
}
