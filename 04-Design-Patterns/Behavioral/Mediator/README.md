# Mediator Pattern

## Intent
Define an object that encapsulates how a set of objects interact. Mediator promotes loose coupling by keeping objects from referring to each other explicitly.

## Mermaid Diagram
```mermaid
classDiagram
    class Mediator {
        <<interface>>
        +notify(sender, event)
    }
    class ConcreteMediator {
        -Component1 c1
        -Component2 c2
        +notify(sender, event)
    }
    class Component1 {
        -Mediator m
        +doA()
    }
    class Component2 {
        -Mediator m
        +doB()
    }
    Mediator <|.. ConcreteMediator
    ConcreteMediator --> Component1
    ConcreteMediator --> Component2
    Component1 --> Mediator
    Component2 --> Mediator
```

## Interview Note
Like an Air Traffic Controller. Airplanes don't communicate with each other directly; they only communicate with the controller.

## Easy to Remember Example (Java)
```java
class ChatRoom {
    public static void showMessage(User user, String message) {
        System.out.println(user.getName() + ": " + message);
    }
}

class User {
    private String name;
    public User(String name) { this.name = name; }
    public String getName() { return name; }

    public void sendMessage(String message) {
        ChatRoom.showMessage(this, message);
    }
}
```
