package Concurrency_Problems.DinningPhilosophers;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

public class DiningPhilosophers {
    private Semaphore eatingSpace;
    private Semaphore[] forks;
    public DiningPhilosophers() {
        eatingSpace = new Semaphore(4);
        forks = new Semaphore[5];
        for(int i = 0 ; i < 5 ; i++){
            forks[i] = new Semaphore(1);
        }
    }

    // call the run() method of any runnable to execute its code
    public void wantsToEat(int philosopher,
                           Runnable pickLeftFork,
                           Runnable pickRightFork,
                           Runnable eat,
                           Runnable putLeftFork,
                           Runnable putRightFork) throws InterruptedException {

        eatingSpace.acquire();

        int leftFork = philosopher;
        int rightFork = (philosopher+1)%5;

        Semaphore lf = forks[leftFork];
        Semaphore rf = forks[leftFork];
        lf.acquire();
        rf.acquire();

        pickLeftFork.run();
        pickRightFork.run();
        eat.run();
        putLeftFork.run();
        lf.release();
        putRightFork.run();
        rf.release();

        eatingSpace.release();
    }
}
