package threadtutorials;

public class WaitNotify {
    private final Object lock = new Object();

    public static void main(String[] args) throws InterruptedException {
        WaitNotify waitNotify = new WaitNotify();

        Thread t1 = new Thread(() -> {
            waitNotify.waitForThread();
        }, "Wait thread 1");

        Thread t2 = new Thread(() -> {
            waitNotify.waitForThread();
        }, "Wait Thread 2");

        Thread t3 = new Thread(() -> {
            waitNotify.notifyThread();
        }, "Wait Thread 3");

        t1.start();
        t2.start();
        Thread.sleep(1000);
        t3.start();
    }

    public void waitForThread() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " begins to wait");
                lock.wait();
                System.out.println(Thread.currentThread().getName() + " has stopped waiting");
            } catch (InterruptedException ex) {
                Thread.currentThread().interrupt();
            } finally {

            }

        }
    }

    public void notifyThread() {
        synchronized (lock) {
            try {
                System.out.println(Thread.currentThread().getName() + " begins to notify");
                lock.notifyAll();
                System.out.println(Thread.currentThread().getName() + " stops to notify");
            } finally {

            }
        }
    }
}
