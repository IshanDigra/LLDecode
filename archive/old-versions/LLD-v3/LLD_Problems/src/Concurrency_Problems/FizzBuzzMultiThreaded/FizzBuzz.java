package Concurrency_Problems.FizzBuzzMultiThreaded;

import java.util.concurrent.Semaphore;
import java.util.function.IntConsumer;

public class FizzBuzz {
    private int n ;
    private Semaphore F;
    private Semaphore B;
    private Semaphore FB;
    private Semaphore N;

    public FizzBuzz(int n){
        this.n = n ;
        N = new Semaphore(1);
        F = new Semaphore(0);
        B = new Semaphore(0);
        FB = new Semaphore(0);
    }
    public void fizz(Runnable printFizz) throws InterruptedException {
        for(int i = 1; i <=n; i++){
            if(i%3 ==0 && i % 5 != 0){
                F.acquire();
                printFizz.run();
                N.release();
            }
        }
    }

    // printBuzz.run() outputs "buzz".
    public void buzz(Runnable printBuzz) throws InterruptedException {
        for(int i = 1; i <=n; i++){
            if(i%5 ==0 && i%3!=0){
                B.acquire();
                printBuzz.run();
                N.release();
            }
        }
    }

    // printFizzBuzz.run() outputs "fizzbuzz".
    public void fizzbuzz(Runnable printFizzBuzz) throws InterruptedException {
        for(int i = 1; i <=n; i++){
            if(i%5 ==0 && i%3 == 0){
                FB.acquire();
                printFizzBuzz.run();
                N.release();
            }
        }
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void number(IntConsumer printNumber) throws InterruptedException {
        for(int i = 1; i <= n ; i++){
            N.acquire();
            if(i%3==0 && i%5==0){
                FB.release();
            }
            else if(i%3 ==0){
                F.release();
            }
            else if(i%5 == 0){
                B.release();
            }
            else{
                printNumber.accept(i);
                N.release();
            }
        }
    }
}
