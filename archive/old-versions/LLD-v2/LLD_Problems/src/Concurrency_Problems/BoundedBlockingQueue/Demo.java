package Concurrency_Problems.BoundedBlockingQueue;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Demo {
    public static void main(String[] args) throws InterruptedException {
        BoundedBlockingQueue<String> q = new BoundedBlockingQueue<String>(2);
        ExecutorService producers = Executors.newFixedThreadPool(1);
        ExecutorService consumers = Executors.newFixedThreadPool(1);
        producers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.addElement("1");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        consumers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.removeElement();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        consumers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.removeElement();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });
        producers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.addElement("0");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });   // The producer thread enqs 0 to the q. The consumer thread is unblocked and returns 0 from the q.
        producers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.addElement("2");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });  // The producer thread enqs 2 to the q.
        producers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.addElement("3");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });  // The producer thread enqs 3 to the q.
        producers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.addElement("4");

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });   // The producer thread is blocked because the q's capacity (2) is reached.
        consumers.submit(()-> {
            try {
//                Thread.sleep(10);
                q.removeElement();

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });    // The consumer thread returns 2 from the q. The producer thread is unblocked and enqs 4 to the q.
        //int k = q.size();
        //System.out.println("Size of Queue: "+k);
        //q.printQueue();
        producers.shutdown();
        consumers.shutdown();
    }
}
