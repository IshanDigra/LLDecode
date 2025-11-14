package CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.ThirdParty;

public class SmartLight {
    public void connectviaWifi(){
        System.out.println("Smart light connected via wifi");
    }
    public void disconnectviaWifi(){
        System.out.println("Smart light disconnected from wifi");
    }

    public void turnOn(){
        System.out.println("Turning on lights");
    }
    public void turnOff(){
        System.out.println("Turning off lights");
    }
}
