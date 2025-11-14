package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StateDesignPattern.States;

public class Sick implements State {
    @Override
    public void eatFood() {
        System.out.println("Eating khickdi");
    }
}
