package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StateDesignPattern.States;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StateDesignPattern.Human;

public class Demo {
    public static void main(String[] args) {
        Human ishan = new Human(new Normal());
        ishan.eatFood();
        ishan.setCurrentState(new Happy());
        ishan.eatFood();
        ishan.setCurrentState(new Sick());
        ishan.eatFood();
    }
}
