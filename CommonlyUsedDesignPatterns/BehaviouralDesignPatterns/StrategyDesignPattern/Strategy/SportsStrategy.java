package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy;

public class SportsStrategy implements  DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Using Sports drive strategy");
    }
}
