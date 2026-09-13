package CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.Adapter;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.ThirdParty.SmartLight;

public class SmartLightAdapter implements HouseController{
    private SmartLight smartLight;

    public SmartLightAdapter(SmartLight smartLight) {
        this.smartLight = smartLight;
    }

    @Override
    public void switchOn() {
        smartLight.connectviaWifi();
        smartLight.turnOn();
    }

    @Override
    public void switchOff() {
        smartLight.turnOff();
        smartLight.disconnectviaWifi();
    }
}
