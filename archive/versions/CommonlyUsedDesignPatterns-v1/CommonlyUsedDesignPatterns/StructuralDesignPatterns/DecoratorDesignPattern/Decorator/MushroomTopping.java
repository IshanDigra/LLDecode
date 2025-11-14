package CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Decorator;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;

public class MushroomTopping implements ToppingsDecorator {
    BasePizza pizza ;

    public MushroomTopping(BasePizza pizza) {
        this.pizza = pizza;
    }


    @Override
    public int cost() {
        System.out.println("Adding Mushroom Toppings ");
        return pizza.cost()+20;
    }
}
