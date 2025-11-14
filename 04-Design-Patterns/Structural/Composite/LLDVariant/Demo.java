package CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component.Component;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component.Fan;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component.Lights;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component.Room;

public class Demo {
    public static void main(String[] args) {
        Component fan = new Fan();
        Component light = new Lights();
        Room room = new Room();
        room.addComponent(fan);
        room.addComponent(light);

        fan.turnOff();
        System.out.println("Turning off room components");
        room.turnOff();

    }
}
