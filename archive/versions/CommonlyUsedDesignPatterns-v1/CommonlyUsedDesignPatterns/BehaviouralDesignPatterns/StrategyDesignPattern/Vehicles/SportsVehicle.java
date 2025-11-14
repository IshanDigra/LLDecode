package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy.SportsStrategy;

public class SportsVehicle extends Vehicle{

    public SportsVehicle(){
        super(new SportsStrategy());
    }
}
