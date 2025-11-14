package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Reciever;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Reciever.Bidder;

public interface reciever {
    void recieveBid(Bidder bidder, int amount);
}
