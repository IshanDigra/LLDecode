package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StateDesignPattern.States;

public class Happy implements State {
    @Override
    public void eatFood() {
        System.out.println("Eating good food");
    }
}
