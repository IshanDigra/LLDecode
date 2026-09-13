package CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Decorator;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;

public class Slami implements ToppingsDecorator {
    BasePizza pizza;

    public Slami(BasePizza pizza) {
        this.pizza = pizza;
    }

    public int cost(){
        System.out.println("Adding Slami to pizza");
        return pizza.cost() + 30;
    }
}
