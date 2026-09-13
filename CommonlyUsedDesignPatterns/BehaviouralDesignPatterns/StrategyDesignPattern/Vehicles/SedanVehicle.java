package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy.SedanStrategy;

public class SedanVehicle extends Vehicle{

    public SedanVehicle() {
        super(new SedanStrategy());
    }
}
