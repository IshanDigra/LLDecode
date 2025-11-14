package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Mediator;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Reciever.Bidder;

import java.util.ArrayList;
import java.util.List;

public class AuctionHouse implements Mediator{
    private final List<Bidder> bidderList;

    public AuctionHouse() {
        bidderList = new ArrayList<>();
    }


    @Override
    public void register(Bidder bidder) {
        if(bidderList.contains(bidder)) System.out.println(bidder.getName()+" is already registered");
        else{
            bidderList.add(bidder);
        }
    }

    @Override
    public void unregister(Bidder bidder) {
        bidderList.remove(bidder);
    }


    @Override
    public void placeBid(Bidder bidder, int amount) {
        System.out.println("Bid amount of $"+ amount+" placed by "+bidder.getName());
        for(Bidder b : bidderList){
            // same person
           if(b == bidder) continue;
           b.recieveBid(bidder, amount);
        }
    }
}
