package Problems.MEDIUM.OnlineAuctionSystem;

import Problems.MEDIUM.OnlineAuctionSystem.Constant.ListingCategory;
import Problems.MEDIUM.OnlineAuctionSystem.Model.AuctionListing;
import Problems.MEDIUM.OnlineAuctionSystem.Model.Bid;
import Problems.MEDIUM.OnlineAuctionSystem.Model.User;
import Problems.MEDIUM.OnlineAuctionSystem.Service.AuctionSystem;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class AuctionSystemDemo {
    public static void main(String[] args) {
        // create an auction instance
        AuctionSystem auctionSystem = AuctionSystem.getInstance();

        // Create users
        User user1 = new User("1", "john@example.com", "John Doe", "123");
        User user2 = new User("2",  "jane@example.com","Jane Smith", "456");
        User user3 = new User("3",  "ishan@example.com","Ishan", "3405");

        // register users
        auctionSystem.registerUser(user1);
        auctionSystem.registerUser(user2);
        //auctionSystem.registerUser(user3);

        // login users
        auctionSystem.loginUser(user1);
        auctionSystem.loginUser(user2);
        auctionSystem.loginUser(user3);
        auctionSystem.registerUser(user3);

        // Create auction listings
        AuctionListing listing1 =
                new AuctionListing("1", user1, "Bajaj Housing Ipo", "BHF IPO", 20, 10,new ArrayList<ListingCategory>(List.of(ListingCategory.FINANCE)));

        AuctionListing listing2 =
                new AuctionListing("2", user2, "ITC Ipo", "ITC IPO", 30, 20,new ArrayList<ListingCategory>(List.of(ListingCategory.FINANCE, ListingCategory.MEDICAL)));

        auctionSystem.createAuctionListing(listing1);
        auctionSystem.createAuctionListing(listing2);

        // Search auction listings
        List<AuctionListing> searchResults = auctionSystem.searchAuctionListing("IPO");
        System.out.println("Search Results:");
        for (AuctionListing listing : searchResults) {
            System.out.println(listing.getItemName());
        }

        // place bids. by two users
        Bid bid1 = new Bid("1", user1, 150.0);
        Bid bid2 = new Bid("2", user3, 200.0);
        auctionSystem.placeBid(listing2, bid1);
        auctionSystem.placeBid(listing2, bid2);

        // print the winners
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule((Runnable) ()-> System.out.println("The winner is "+ listing2.getCurrentHighestBidder().getName() + " with bid amount : "+listing2.getCurrentHighestBid()),  25, TimeUnit.SECONDS);

    }
}
