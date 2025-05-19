package threadtutorials;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class CyclicBarrierExample implements Runnable {
    private final Random random;
    private final CyclicBarrier barrier;
    private final int id;

    public CyclicBarrierExample(int id, CyclicBarrier barrier) {
        this.id = id;
        this.random = new Random();
        this.barrier = barrier;
    }

    public static void main(String[] args) {
        Executor executor = Executors.newFixedThreadPool(5);
        CyclicBarrier barrier = new CyclicBarrier(5, new Runnable() {
            @Override
            public void run() {
                System.out.println("All tasks have been finished....");

            }
        });

        for (int i = 0; i < 5; i++) {
            executor.execute(new CyclicBarrierExample(i, barrier));
        }
    }

    @Override
    public void run() {
        try {
            System.out.println("Thread with id " + this.id + " start working");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            barrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

        System.out.println("Thread " + this.id + " continues");
    }

}
