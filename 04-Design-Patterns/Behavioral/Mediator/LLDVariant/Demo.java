package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Mediator.AuctionHouse;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.MediatorDesignPattern.Reciever.Bidder;

public class Demo {
    public static void main(String[] args) {
        AuctionHouse bombayStockExchange = new AuctionHouse();
        Bidder b1 = new Bidder("Ishan", bombayStockExchange);
        Bidder b2 = new Bidder("Pallav", bombayStockExchange);
        Bidder b3 = new Bidder("Mehak", bombayStockExchange);
        bombayStockExchange.register(b1);
        bombayStockExchange.register(b2);
        bombayStockExchange.register(b3);
        b1.placeBid(10);
        b2.placeBid(20);
        b3.placeBid(15);
        b1.placeBid(50);

    }
}
