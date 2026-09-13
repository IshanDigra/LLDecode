package CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.Adapter;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.ThirdParty.AirConditioner;

public class AirConditionerAdapter implements HouseController{
    private AirConditioner airConditioner;

    public AirConditionerAdapter(AirConditioner airConditioner) {
        this.airConditioner = airConditioner;
    }

    @Override
    public void switchOn() {
        airConditioner.connectViaBluetooth();
        airConditioner.startCooling();
    }

    @Override
    public void switchOff() {
        airConditioner.stopCooling();
        airConditioner.disconnectViaBluetooth();
    }
}
