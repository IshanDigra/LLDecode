package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles.SedanVehicle;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles.SportsVehicle;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles.Vehicle;



public class main {
    public static void main(String[] args) {
        Vehicle A = new SportsVehicle();
        Vehicle B = new SedanVehicle();
        System.out.print(" Vehicle A is ");
        A.drive();

        System.out.print(" Vehicle B is ");
        B.drive();
    }
}