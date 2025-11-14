package CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Pizza;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.DecoratorDesignPattern.Pizza.BasePizza;

public class MargheritaBase implements BasePizza {

    @Override
    public int cost() {
        return 100;
    }
}
