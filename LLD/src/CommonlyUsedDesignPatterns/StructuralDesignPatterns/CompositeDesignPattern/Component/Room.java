package CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.CompositeDesignPattern.Component.Component;

import java.util.ArrayList;
import java.util.List;

public class Room implements Component {
    private List<Component> roomComponentList;

    public Room() {
        roomComponentList = new ArrayList<>();
    }

    public void addComponent(Component component){
        roomComponentList.add(component);
    }
    public void removeComponent(Component component){
        roomComponentList.remove(component);
    }

    @Override
    public void turnOff() {
        for(Component c : roomComponentList){
            c.turnOff();
        }
    }
}
