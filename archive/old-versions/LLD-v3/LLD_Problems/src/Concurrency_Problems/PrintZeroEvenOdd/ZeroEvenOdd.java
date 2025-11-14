package Concurrency_Problems.PrintZeroEvenOdd;

import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.AtomicInteger;

public class ZeroEvenOdd {

/// printNumber.accept(x) outputs "x", where x is an integer.
    private final int n ;
    private Semaphore Z ;
    private Semaphore E ;
    private Semaphore O ;

    public ZeroEvenOdd(int n) {
        this.n = n;
        Z = new Semaphore(1);
        E = new Semaphore(0);
        O = new Semaphore(0);
    }

    public void zero(PrintNumber printNumber) throws InterruptedException {
        int odd = 1;
        for(int i = 1; i <=n ; i++){
            Z.acquire();
            printNumber.acceptNumber(0);
            if((odd&1)==1){
                O.release();
            }
            else{
                E.release();
            }
            odd ^=1;
        }
    }

    public void even(PrintNumber printNumber) throws InterruptedException {
        for(int i = 2; i <=n; i+=2){
            E.acquire();
            printNumber.acceptNumber(i);
            Z.release();
        }
    }

    public void odd(PrintNumber printNumber) throws InterruptedException {
        for(int i = 1; i <=n; i+=2){
            O.acquire();
            printNumber.acceptNumber(i);
            Z.release();
        }
    }
}
