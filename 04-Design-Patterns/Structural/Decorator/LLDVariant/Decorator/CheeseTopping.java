package CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Decorator;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;

public class CheeseTopping implements ToppingsDecorator {
    BasePizza pizza;

    public CheeseTopping(BasePizza pizza){
        this.pizza = pizza;
    }

    @Override
    public int cost() {
        System.out.println("Adding cheese toping ");
        return pizza.cost() + 10;
    }
}
