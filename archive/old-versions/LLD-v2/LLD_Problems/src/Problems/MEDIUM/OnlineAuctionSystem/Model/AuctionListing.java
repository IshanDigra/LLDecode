package Problems.MEDIUM.OnlineAuctionSystem.Model;

import Problems.MEDIUM.OnlineAuctionSystem.Constant.AuctionStatus;
import Problems.MEDIUM.OnlineAuctionSystem.Constant.ListingCategory;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class AuctionListing {
    private final String id;
    private final User seller;
    private final String itemName;
    private final String description;
    private final double startingPrice;
    private final long duration;
    private double currentHighestBid;
    private User currentHighestBidder;
    private final List<Bid> bids;
    private AuctionStatus status;
    private final List<ListingCategory> categories;

    public AuctionListing(String id, User seller, String itemName, String description, double startingPrice, long duration, List<ListingCategory> category) {
        this.id = id;
        this.seller = seller;
        this.itemName = itemName;
        this.description = description;
        this.startingPrice = startingPrice;
        this.duration = duration;
        bids = new CopyOnWriteArrayList<>();
        status = AuctionStatus.ACTIVE;
        this.categories = category;
    }

    public void placeBid(Bid bid){
        if(status == AuctionStatus.ACTIVE && bid.getBidAmount()>= currentHighestBid){
            currentHighestBidder = bid.getBidder();
            currentHighestBid = bid.getBidAmount();
            notifyObservers();
            bids.add(bid);
        }
    }

    public void closeAuction(){
        if(status == AuctionStatus.ACTIVE){
            status = AuctionStatus.CLOSED;
            notifyObservers();
        }
        System.out.println("AuctionListing for " + description + " Closed!");
    }

    public String getId() {
        return id;
    }
    public User getSeller() {
        return seller;
    }

    public String getItemName() {
        return itemName;
    }

    public String getDescription() {
        return description;
    }

    public double getStartingPrice() {
        return startingPrice;
    }

    public long getDuration() {
        return duration;
    }

    public double getCurrentHighestBid() {
        return currentHighestBid;
    }

    public void setCurrentHighestBid(double currentHighestBid) {
        this.currentHighestBid = currentHighestBid;
    }

    public User getCurrentHighestBidder() {
        return currentHighestBidder;
    }

    public void setCurrentHighestBidder(User currentHighestBidder) {
        this.currentHighestBidder = currentHighestBidder;
    }

    public List<Bid> getBids() {
        return bids;
    }

    public AuctionStatus getStatus() {
        return status;
    }

    public void setStatus(AuctionStatus status) {
        this.status = status;
    }

    public List<ListingCategory> getCategories() {
        return categories;
    }

    public void notifyObservers(){
        // // Notify observers (bidders) about the updated highest bid or auction closure
        //        // ...
    }


}
