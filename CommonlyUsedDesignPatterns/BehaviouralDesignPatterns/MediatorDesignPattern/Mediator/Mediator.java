package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Mediator;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Reciever.Bidder;

public interface Mediator {
    void register(Bidder bidder);
    void unregister(Bidder bidder);
    void placeBid(Bidder bidder, int amount);
}
