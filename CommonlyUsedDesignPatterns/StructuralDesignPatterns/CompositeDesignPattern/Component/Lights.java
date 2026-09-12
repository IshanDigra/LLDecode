package CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component.Component;

public class Lights implements Component {
    @Override
    public void turnOff() {
        System.out.println("Light turned Off");
    }
}
