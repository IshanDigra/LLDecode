package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy;

public class SedanStrategy implements  DriveStrategy{

    @Override
    public void drive() {
        System.out.println("Using Sedan drive strategy");
    }
}
