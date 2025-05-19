package threadtutorials;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class LatchExample implements Runnable {
    private final int id;
    private final CountDownLatch latch;

    public LatchExample(int id, CountDownLatch latch) {
        this.id = id;
        this.latch = latch;
    }

    public static void main(String[] args) {
        CountDownLatch latch = new CountDownLatch(5);
        ExecutorService service = Executors.newFixedThreadPool(2);

        for (int i = 0; i < 5; i++) {
            service.execute(new LatchExample(i, latch));
        }

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("all threads are done wait, code can continue here: ");
    }

    @Override
    public void run() {
        doWork();
        latch.countDown();
    }

    private void doWork() {
        try {
            System.out.println("Thread with Id " + this.id + " start working");
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
