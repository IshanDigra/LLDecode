package Concurrency_Problems.DinningPhilosophers;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class demo {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        DiningPhilosophers dp = new DiningPhilosophers();

        Runnable pl = ()-> System.out.println("Picking left fork");
        Runnable pr = ()-> System.out.println("Picking right fork");
        Runnable e = ()-> System.out.println(Thread.currentThread().getName()+ " eating");
        Runnable pL = ()-> System.out.println("putting down left fork");
        Runnable pR = ()-> System.out.println("putting down right fork");

        for(int i = 0 ; i < 5; i++){
            int k = i ;
            executorService.submit(() -> {
                try {
                    dp.wantsToEat(k, pl, pr, e, pL, pR);
                } catch (InterruptedException ex) {
                    throw new RuntimeException(ex);
                }
            });
        }

        executorService.shutdown();
    }
}
