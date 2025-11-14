package CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component.Component;

public class Fan implements Component {
    @Override
    public void turnOff() {
        System.out.println("fan turned off");
    }
}
