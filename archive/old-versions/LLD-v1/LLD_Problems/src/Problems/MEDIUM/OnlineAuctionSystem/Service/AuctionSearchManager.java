package Problems.MEDIUM.OnlineAuctionSystem.Service;

import Problems.MEDIUM.OnlineAuctionSystem.Model.AuctionListing;

import java.util.List;
import java.util.stream.Collectors;

public class AuctionSearchManager {
    private List<AuctionListing> auctionListings;

    public AuctionSearchManager(List<AuctionListing> auctionListings) {
        this.auctionListings = auctionListings;
    }

    public List<AuctionListing> searchAuctionListing(String keyword){
        return auctionListings.stream()
                .filter((n)->n.getItemName().contains(keyword)
                || n.getDescription().contains(keyword)
                || n.getCategories().contains(keyword))
                .collect(Collectors.toList());
    }
}
