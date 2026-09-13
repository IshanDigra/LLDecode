package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ObserverDesignPattern;

import java.util.ArrayList;
import java.util.List;

public class IphoneObservableImpl implements Observable{
    private List<Observer> iphoneStockObservers = new ArrayList<>();
    private int stock = 0 ;
    @Override
    public void add(Observer o) {
        iphoneStockObservers.add(o);
    }

    @Override
    public void remove(Observer o) {
        iphoneStockObservers.remove(o);
    }

    @Override
    public void notifySubscribers() {
        for(Observer o : iphoneStockObservers){
            o.update(this);
        }
    }

    @Override
    public void setData(int x) {
        if(stock == 0){
            stock+= x;
            notifySubscribers();
        }
        else stock+= x;
    }

    public int getData(){
        return stock;
    }
}
