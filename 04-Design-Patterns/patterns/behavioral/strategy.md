# Strategy Design Pattern

## Explanation
Lets say we have a class Car which has a drive strategy = simple. Now we make numerous child classes from the parent class.
Now comes a set of child classes that need sports Drive strategy likewise comes a set of child classes that requires sedan drive strategy.
Now In this case we have hit a roadblock. each child class would have to build their own drive strategy that would lead to code
duplication. Another example would be that you are making an app like google maps that tells the best route now you could take walking route
by road route, water route or some other route. this is a strategy to choose from. hence we use strategy design patterns for this.

**Solution:** Like the name suggests strategy pattern is Define a family of algorithms, encapsulate each one, and make them interchangeable.
The strategy pattern lets the algorithm vary independently from client to client.

---

## Example: Vehicle Drive Strategies

### 1. DriveStrategy Interface
```java
package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy;

public interface DriveStrategy {
    public void drive();
}
```

### 2. Concrete Strategies
```java
// SedanStrategy.java
package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy;

public class SedanStrategy implements  DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Using Sedan drive strategy");
    }
}
```

```java
// SportsStrategy.java
package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy;

public class SportsStrategy implements  DriveStrategy{
    @Override
    public void drive() {
        System.out.println("Using Sports drive strategy");
    }
}
```

### 3. Vehicle Base Class
```java
package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy.DriveStrategy;

public class Vehicle{
    DriveStrategy obj;

    public Vehicle(DriveStrategy obj){
        this.obj = obj ;
    }

    public void drive(){
        obj.drive();
    }
}
```

### 4. Concrete Vehicle Types
```java
// SedanVehicle.java
package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy.SedanStrategy;

public class SedanVehicle extends Vehicle{
    public SedanVehicle() {
        super(new SedanStrategy());
    }
}
```

```java
// SportsVehicle.java
package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Strategy.SportsStrategy;

public class SportsVehicle extends Vehicle{
    public SportsVehicle(){
        super(new SportsStrategy());
    }
}
```

### 5. Demo
```java
package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern;

import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles.SedanVehicle;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles.SportsVehicle;
import CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.StrategyDesignPattern.Vehicles.Vehicle;

public class main {
    public static void main(String[] args) {
        Vehicle A = new SportsVehicle();
        Vehicle B = new SedanVehicle();
        System.out.print(" Vehicle A is ");
        A.drive();

        System.out.print(" Vehicle B is ");
        B.drive();
    }
}
```

---

## Key Points
- The Strategy pattern enables selecting an algorithm's behavior at runtime.
- It avoids code duplication and promotes code reusability.
- New strategies can be added without modifying existing code.
