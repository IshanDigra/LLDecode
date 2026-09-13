package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StateDesignPattern;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StateDesignPattern.States.State;

public class Human implements State {
    private State currentState;

    public Human(State currentState) {
        this.currentState = currentState;
    }

    public State getCurrentState() {
        return currentState;
    }

    public void setCurrentState(State currentState) {
        this.currentState = currentState;
    }

    @Override
    public void eatFood() {
        currentState.eatFood();
    }
}
