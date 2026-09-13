package CommonlyUsedDesignPatterns.BehaviouralDesignPatterns.ObserverDesignPattern;

public class Demo {
    public static void main(String[] args) {
        Observer ishan = new EmailAlertObserver("Ishan");
        Observer gargi = new EmailAlertObserver("Gargi");
        Observer ishu = new MessageAlertObserver("Ishu");

        Observable iphonestocks = new IphoneObservableImpl();
        iphonestocks.add(ishan);
        iphonestocks.add(gargi);
        iphonestocks.add(ishu);

        iphonestocks.setData(10);
    }
}
