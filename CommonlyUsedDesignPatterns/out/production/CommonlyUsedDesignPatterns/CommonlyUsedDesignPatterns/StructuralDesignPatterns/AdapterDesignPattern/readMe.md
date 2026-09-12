# Adapter Design Pattern

---

## Definition

Convert the interface of a class into another interface that clients expect. The **Adapter** pattern allows classes with incompatible interfaces to work together. It acts as a bridge between two incompatible interfaces.

---

## Concept

The Adapter pattern is used when the interface of an existing class does not match the one a client needs. Instead of modifying the existing class (which might not be possible), we create an **Adapter** class that translates requests from the client into calls that are understood by the existing class.

> In essence, an Adapter wraps an existing class with a new interface so that it becomes compatible with the client.

---

## Structure

- **Target**: Defines the domain-specific interface used by the client.
- **Client**: Collaborates with objects conforming to the Target interface.
- **Adaptee**: An existing class with a useful behavior but incompatible interface.
- **Adapter**: Adapts the interface of the Adaptee to the Target interface.

---

## Note

1. The Adapter is helpful when integrating a legacy or third-party system that has a different interface than expected.
2. It promotes reusability by allowing existing functionality to work with new code without modification.
3. Two common types:
    - **Class Adapter**: Uses multiple inheritance to adapt one interface to another.
    - **Object Adapter**: Uses composition to adapt an Adaptee to the Target interface.
4. Ideal when client code cannot be changed but needs to work with different classes.
5. Makes code more flexible and easier to extend with new behaviors.

---

## Real World Examples

- **Power Plug Adapter**: Allows a device with a Type C plug to connect to a Type A socket.
- **SD Card to USB Adapter**: Converts an SD card interface to USB so it can be read by a computer.
- **Legacy Logger**: You have an old Logger with a `logMessage` method and a new app expects a `log(String level, String message)` method. An Adapter helps integrate the two.

---

## Example Code (Java-style Pseudocode)

```java
// Target interface
interface MediaPlayer {
    void play(String audioType, String fileName);
}

// Adaptee class
class AdvancedMediaPlayer {
    void playVlc(String fileName) {  }
    void playMp4(String fileName) {  }
}

// Adapter class
class MediaAdapter implements MediaPlayer {
    AdvancedMediaPlayer advancedPlayer = new AdvancedMediaPlayer();

    public void play(String audioType, String fileName) {
        if(audioType.equals("vlc")) {
            advancedPlayer.playVlc(fileName);
        } else if(audioType.equals("mp4")) {
            advancedPlayer.playMp4(fileName);
        }
    }
}
```

---

## Ending Note: Adapter vs. Bridge Pattern

Here is a professional comparison between the two patterns:

| Aspect                 | Adapter Pattern                                                                                 | Bridge Pattern                                                      |
|------------------------|------------------------------------------------------------------------------------------------|---------------------------------------------------------------------|
| **Intent**             | Make existing interfaces compatible without changing their source code                         | Separate abstraction from implementation so both can vary independently |
| **Approach**           | Wraps an object to provide a different interface                                               | Decouples abstraction and implementation via composition            |
| **When to Use**        | Integrating legacy/third-party code; incompatible interfaces                                   | Designing for future extensibility and scalability                  |
| **Focus**              | Solving problems with legacy or incompatible interfaces                                        | Designing for extensibility from the start                          |
| **Example**            | Power plug adapter, SD card to USB adapter                                                     | GUI toolkit with multiple platforms and rendering APIs              |

> **Summary:** Adapter focuses on compatibility and integration, while Bridge is about extensibility and flexibility in system design.

