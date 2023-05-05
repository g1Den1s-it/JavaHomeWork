package org.example.Lab_4;
import java.util.concurrent.CountDownLatch;

public class Lab4Main {
    public static void main(String[] args) throws InterruptedException {
        int numThreads = 5;
        CountDownLatch latch = new CountDownLatch(numThreads);

        for (int i = 0; i < numThreads; i++) {
            Thread thread = new Thread(() -> {
                // do some work...
                latch.countDown(); // signal that the thread has completed
            });
            thread.start();
        }

        latch.await(); // wait for all threads to complete

        System.out.println("All threads have completed.");
    }
}
