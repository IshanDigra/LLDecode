package CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Decorator.CheeseTopping;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Decorator.MushroomTopping;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Decorator.Slami;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Pizza.FarmHouseBasePizza;

public class Demo {
    public static void main(String[] args) {
        BasePizza pizza = new FarmHouseBasePizza();
        int cost = pizza.cost();
        System.out.println(cost);

        pizza = new CheeseTopping(pizza);
        cost = pizza.cost();
        System.out.println(cost);

        pizza = new MushroomTopping(pizza);
        cost = pizza.cost();
        System.out.println(cost);

        pizza = new Slami(pizza);
        cost = pizza.cost();
        System.out.println(cost);
    }
}
