package Concurrency_Problems.BoundedBlockingQueue;

import java.util.concurrent.ConcurrentLinkedDeque;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.Semaphore;

public class BoundedBlockingQueue<T> {
    private final ConcurrentLinkedQueue<T> queue;
    private Semaphore empty;
    private Semaphore full;
    private final int n;

    public BoundedBlockingQueue(int n) {
        queue = new ConcurrentLinkedQueue<T>();
        this.n = n;
        empty = new Semaphore(n);
        full = new Semaphore(0);
    }

    public void addElement(T x) throws InterruptedException {
        empty.acquire();
        System.out.println("Element added to queue: "+x);
        queue.offer(x);
        full.release();
    }

    public T removeElement() throws  InterruptedException{

        full.acquire();
        T res = queue.poll();
        System.out.println("Element removed from queue: "+res);
        empty.release();
        return res;
    }

    public int size(){
        return queue.size();
    }

    public void printQueue(){
        queue.forEach(n-> System.out.print(n+", "));
    }
}
