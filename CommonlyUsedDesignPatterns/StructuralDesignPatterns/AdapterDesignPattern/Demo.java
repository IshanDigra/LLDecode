package CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern;

import CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.Adapter.AirConditionerAdapter;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.Adapter.HouseController;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.Adapter.SmartLightAdapter;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.ThirdParty.AirConditioner;
import CommonlyUsedDesignPatterns.StructuralDesignPatterns.AdapterDesignPattern.ThirdParty.SmartLight;

public class Demo {
    public static void main(String[] args) {
        HouseController aircondtioner = new AirConditionerAdapter(new AirConditioner());
        HouseController ligts = new SmartLightAdapter(new SmartLight());

        aircondtioner.switchOn();
        aircondtioner.switchOff();

        ligts.switchOn();
        ligts.switchOff();
    }
}
