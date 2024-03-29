package threadtutorials;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TestSemaphore {
    
    public static class Barrier {
        private int counter = 0;
        private int numThreads;
        private final Lock lock = new ReentrantLock();
        private final Semaphore semaphore = new Semaphore(0);

        public Barrier(int numThreads) {
            this.numThreads = numThreads;
        }

        public void blockThread() throws InterruptedException {
            lock.lock();
            boolean isLastThread = false;
            try {
                counter++;
                if (counter == numThreads) {
                    isLastThread = true;
                }
            } finally {
                lock.unlock();
            }

            if (isLastThread) {
                semaphore.release(numThreads - 1);
            } else {
                semaphore.acquire();
            }

        }

    }
    
    private Barrier barrier;
    public TestSemaphore(Barrier barrier) {
        this.barrier = barrier; 
    }

    public void testOrderedTaskWithSemaphore() throws InterruptedException {
  
        System.out.println(String.format("Task 1 is currently using thread %s", Thread.currentThread().getName()));
  
        barrier.blockThread();

        System.out.println(String.format("Task 2 is currently using thread %s", Thread.currentThread().getName()));
    }

    public static void main(String[] args) {
        int numThreads = 5;
        TestSemaphore.Barrier barrier = new TestSemaphore.Barrier(5);    
        for (int i = 0; i < numThreads; i++) {
            Thread t = new Thread(() -> {
                try {
                    TestSemaphore testSemaphore = new TestSemaphore(barrier);
                    testSemaphore.testOrderedTaskWithSemaphore();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
          
            t.start();
        }   
    }
}
