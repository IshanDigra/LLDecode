package Problems.MEDIUM.OnlineAuctionSystem.Service;

import Problems.MEDIUM.OnlineAuctionSystem.Constant.AuctionStatus;
import Problems.MEDIUM.OnlineAuctionSystem.Model.Account;
import Problems.MEDIUM.OnlineAuctionSystem.Model.AuctionListing;
import Problems.MEDIUM.OnlineAuctionSystem.Model.Bid;
import Problems.MEDIUM.OnlineAuctionSystem.Model.User;

import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.*;

public class AuctionSystem {
    private static AuctionSystem instance;
    private Map<String, Account> accounts;
    private List<AuctionListing> listings;
    private AuctionSearchManager searchManager;

    private AuctionSystem() {
        accounts = new ConcurrentHashMap<>();
        listings = new CopyOnWriteArrayList<>();
        searchManager = new AuctionSearchManager(listings);
    }

    public static synchronized AuctionSystem getInstance(){
        if(instance == null){
            instance = new AuctionSystem();
        }
        return instance;
    }

    public void registerUser(User user) {
        Account account = new Account(accountIdGenerator(),user);
        accounts.put(account.getId(),account);
    }

    public boolean loginUser(User user){
        for(Account account : accounts.values()){
            if(account.getUser().getEmail().equals(user.getEmail()) && account.getUser().getPassword().equals(user.getPassword())) {
                System.out.println("login Successful for the User : " + user.getName());
                return true;
            }
        }
        System.out.println("Please register!");
        return false;
    }

    public void createAuctionListing(AuctionListing auctionListing){
        listings.add(auctionListing);
        startAuctionTimer(auctionListing);
    }

    public List<AuctionListing> searchAuctionListing(String keyword){
        return searchManager.searchAuctionListing(keyword);
    }

    public void placeBid(AuctionListing auctionListing, Bid bid){
        auctionListing.placeBid(bid);
    }

    private void startAuctionTimer(AuctionListing auctionListing){
        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        service.schedule(auctionListing::closeAuction,auctionListing.getDuration(), TimeUnit.SECONDS);

    }

    // Id generator
    private String accountIdGenerator(){
        return "ACC"+ UUID.randomUUID().toString();
    }
}
