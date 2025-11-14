package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy.DriveStrategy;

public class Vehicle{
    DriveStrategy obj;

    public Vehicle(DriveStrategy obj){
        this.obj = obj ;
    }

    public void drive(){
        obj.drive();
    }
}
