package AsishPratapProblems.EASY.TrafficControlSystem.V2.Entities;

import AsishPratapProblems.EASY.TrafficControlSystem.V2.Enums.SignalType;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.*;

public class TrafficSignalControl {
    private static TrafficSignalControl instance;
    private final Deque<Road> roads;
    private final ScheduledExecutorService executor;
    private boolean emergencySituationCheck;

    private TrafficSignalControl() {
        roads = new LinkedBlockingDeque<>();
        emergencySituationCheck = false;
        executor = Executors.newScheduledThreadPool(1);
    }

    public static synchronized TrafficSignalControl getInstance(){
        if(instance == null){
            instance = new TrafficSignalControl();
        }
        return instance;
    }

    public void addRoad(Road road){
        if(roads.contains(road)){
            System.err.println("The given road already registered");
            return;
        }

        roads.addLast(road);
    }

    public void startSystem(){
        executor.scheduleWithFixedDelay(()->singleCycle(),0,1,TimeUnit.SECONDS);
    }

    public void singleCycle(){
        if(roads.isEmpty()){
            System.err.println("No Road is associated");
            return;
        }
        Road road = roads.pollFirst();
        TrafficLight light = road.getLight();


        sleep(light.getCurrentSignalDuration());
        if(emergencySituationCheck){
            roads.offerFirst(road);
            return;
        }
        System.out.println(road.getName()+": Changing the singal from red to green");
        light.setCurrSignal(SignalType.GREEN);

        sleep(light.getCurrentSignalDuration());
        if(emergencySituationCheck){
            roads.offerFirst(road);
            return;
        }
        System.out.println(road.getName()+": Changing the singal from green to yellow");
        light.setCurrSignal(SignalType.YELLOW);

        sleep(light.getCurrentSignalDuration());
        if(emergencySituationCheck){
            roads.offerFirst(road);
            return;
        }
        System.out.println(road.getName()+": Changing the singal from yellow to red");
        light.setCurrSignal(SignalType.RED);
        roads.addLast(road);
    }

    public void sleep(int t){
        try {
            Thread.sleep(t*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void startEmergency(Road road){
        emergencySituationCheck = true;
        System.err.println("Emergency has occured in "+ road.getName());
    }

    public void clearEmergency(){
        System.out.println("Emergency cleared");
        emergencySituationCheck = false;
    }
}

