package Concurrency_Problems.PrintZeroEvenOdd;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(3);

        Scanner sc = new Scanner(System.in);
        System.out.print("Please input N for your sequence: ");
        int N = sc.nextInt();

        ZeroEvenOdd z = new ZeroEvenOdd(N);

        PrintNumber p = n-> System.out.print(n+" ");

        // below implementation is for testing wheather different threads are working together or not.
        PrintNumber p2 = n-> System.out.println(Thread.currentThread().getName()+" printing "+n);


        executor.submit(()->{
            try {
                z.zero(p);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.submit(()->{
            try {
                z.even(p);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        executor.submit(()->{
            try {
                z.odd(p);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
    }
}
