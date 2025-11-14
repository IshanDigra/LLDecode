package AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser;

import AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser.Notification.Observable;
import AsishPratapProblems.MEDIUM.ATM.Entities.CashDispenser.Notification.Observer;
import AsishPratapProblems.MEDIUM.ATM.Enums.CashDenomination;

import java.util.ArrayList;
import java.util.List;

public abstract class Handler implements Observable {
    protected Handler nextHandler;
    protected static int atmCash;
    protected static List<Observer> observers;
    protected CashDenomination denomination;

    {
        atmCash = 3000;
        observers = new ArrayList<>();
    }

    protected void dispenseCash(int amount){
        if(amount%denomination.getValue()==0){
            int count = amount/denomination.getValue();
            amount -= count*denomination.getValue();
            atmCash -= count*denomination.getValue();
            System.out.println("dispensed "+ count + " "+ denomination.getValue()+"Rs Notes by "+ this.getClass().getSimpleName());

            /*
            Over here we can add the notify observer code when the last dispense action takes place
            if the atm is running low on balance.
            * */
            if(atmCash<1000){
                notifyObservers("ATM is running low on cash of Rs."+atmCash);
            }
            return;
        }

        if(amount > denomination.getValue()){
            int count = amount/denomination.getValue();
            amount -= count*denomination.getValue();
            atmCash -= count*denomination.getValue();
            System.out.println("dispensed "+ count + " "+ denomination.getValue()+"Rs Notes by "+ this.getClass().getSimpleName());
        }
        nextHandler.dispenseCash(amount);
    }



    public void setNextHandler(Handler nextHandler) {
        this.nextHandler = nextHandler;
    }

    public static void addAtmCash(int atmCash) {
        Handler.atmCash += atmCash;
    }

    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    public void notifyObservers(String message){
        for(Observer observer : observers){
            observer.update(message);
        }
    }

}
