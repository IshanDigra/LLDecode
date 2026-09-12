package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Reciever;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Mediator.Mediator;

public class Bidder implements reciever {
    private final String name;
    private final Mediator auctionHouse;

    public Bidder(String name, Mediator auctionHouse) {
        this.name = name;
        this.auctionHouse = auctionHouse;
    }

    public void placeBid(int amount){
        auctionHouse.placeBid(this, amount);
    }

    public void recieveBid(Bidder bidder, int amount){
        System.out.println(name + " is notified about bid amount of $"+amount+" place by: "+ bidder.getName());
    }

    public String getName() {
        return name;
    }

}
