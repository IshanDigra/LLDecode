package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StateDesignPattern.States;

public class Normal implements State {
    @Override
    public void eatFood() {
        System.out.println("Eating homecooked food");
    }
}
