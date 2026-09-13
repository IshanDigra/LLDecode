package CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.ThirdParty;

public class AirConditioner {
    public void connectViaBluetooth(){
        System.out.println("Air Conditioner connecting via bluetooth");
    }
    public void disconnectViaBluetooth(){
        System.out.println("Air Conditioner disconnecting from bluetooth");
    }

    public void startCooling(){
        System.out.println("Air conditioner is now cooling");
    }

    public void stopCooling(){
        System.out.println("Air conditioner stopped cooling");
    }
}
