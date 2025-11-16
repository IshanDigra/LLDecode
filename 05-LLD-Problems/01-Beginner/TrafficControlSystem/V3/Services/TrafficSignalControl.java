package V2.Services;


import V2.Entities.Config.GlobalSignalConfig;
import V2.Entities.Config.SignalConfig;
import V2.Entities.Road;
import V2.Entities.TrafficSignal;
import V2.Enums.SignalType;

import java.util.Deque;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.logging.Logger;

public class TrafficSignalControl {
    private static volatile TrafficSignalControl instance;
    private final Deque<Road> roads;
    private final ScheduledExecutorService executor;

    /*
    * There is a flaw in our previous emergency situation handling via a boolean
    * why? If more than two emergencies are hit and one of them is resolved then
    * we are making the situation normal even if the other one is not resolved.
    * Instead we can use AtomicInteger here.
    *
    * */
    //private volatile Boolean emergencySituationCheck;

    private AtomicInteger emergencySituationCheck;

    private SignalConfig globalSignalConfig;

    private static final Logger logger = Logger.getLogger(TrafficSignal.class.getName());

    private TrafficSignalControl() {
        roads = new ConcurrentLinkedDeque<>();
        emergencySituationCheck = new AtomicInteger(0);
        executor = Executors.newScheduledThreadPool(1);
        // although this part should also be done via dependency injection
        globalSignalConfig = new GlobalSignalConfig(2,2,2);
    }

    public static TrafficSignalControl getInstance(){
        if(instance == null){
            synchronized (TrafficSignal.class){
                if(instance == null){
                    instance = new TrafficSignalControl();
                }
            }
        }
        return instance;
    }

    public void addRoad(Road road){
        if(roads.contains(road)){
            logger.warning("The given road already registered");
            return;
        }

        roads.addLast(road);
    }

    public void setGlobalSignalConfig(SignalConfig globalSignalConfig) {
        this.globalSignalConfig = globalSignalConfig;
    }

    public synchronized void startSystem()
    {
        executor.scheduleWithFixedDelay(()->singleCycle(),0,1,TimeUnit.SECONDS);
    }

    public synchronized void singleCycle(){
        if(roads.isEmpty()){
            logger.warning("No Road is associated");
            return;
        }
        Road road = roads.pollFirst();
        TrafficSignal light = road.getTrafficLight();


        sleep(globalSignalConfig.getSignalDuration(light.getCurrSignal()));
        if(emergencySituationCheck.get()>0){
            roads.offerFirst(road);
            return;
        }
        logger.info(road.getName()+": Changing the singal from red to green");
        light.setCurrSignal(SignalType.GREEN);

        sleep(globalSignalConfig.getSignalDuration(light.getCurrSignal()));
        if(emergencySituationCheck.get()>0){
            // resetting the signal
            light.setCurrSignal(SignalType.RED);
            roads.offerFirst(road);
            return;
        }
        logger.info(road.getName()+": Changing the singal from green to yellow");
        light.setCurrSignal(SignalType.YELLOW);

        sleep(globalSignalConfig.getSignalDuration(light.getCurrSignal()));
        if(emergencySituationCheck.get()>0){
            light.setCurrSignal(SignalType.RED);
            roads.offerFirst(road);
            return;
        }
        logger.info(road.getName()+": Changing the singal from yellow to red");
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
        emergencySituationCheck.incrementAndGet();
        logger.info("Emergency has occured in "+ road.getName());
    }

    public void clearEmergency(){
        logger.info("Emergency cleared");
        emergencySituationCheck.decrementAndGet();
    }
}

