package Concurrency_Problems.FizzBuzzMultiThreaded;

import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.function.IntConsumer;

public class Demo {
    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        Scanner sc = new Scanner(System.in);
        System.out.print("Please input the number: ");
        int n = sc.nextInt();
        FizzBuzz fz = new FizzBuzz(n);

        //
        IntConsumer ic = i-> System.out.println(i);
        Runnable f = ()-> System.out.println("Fizz");
        Runnable b = ()-> System.out.println("Buzz");
        Runnable fb = ()-> System.out.println("FizzBuzz");

        executor.submit(()->{
            try {
                fz.number(ic);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.submit(()->{
            try {
                fz.fizz(f);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.submit(()->{
            try {
                fz.buzz(b);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.submit(()->{
            try {
                fz.fizzbuzz(fb);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        executor.shutdown();
    }
}
