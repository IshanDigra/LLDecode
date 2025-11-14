package ConcurrencyProblems.ConsumerProducerProblem;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        CustomQueue q = new CustomQueue(2);
        ExecutorService executor = Executors.newFixedThreadPool(3);
        executor.submit(()->new Producer(q).run());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
        executor.submit(()->new Consumer(q).run());
        executor.submit(()->new Consumer(q).run());

        executor.shutdown();
    }
}
