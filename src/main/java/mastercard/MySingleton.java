package mastercard;

import java.util.concurrent.locks.ReentrantLock;

public class MySingleton {
    private static ReentrantLock lock = new ReentrantLock();
    private static MySingleton getInstance;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        lock.lock();
        try {
            if (getInstance == null) {
                getInstance = new MySingleton();
            }
            return getInstance;
        } finally {
            lock.unlock();
        }
    }

    public static MySingleton getInstanceWithDoubleLock() throws InterruptedException {
        if (getInstance == null) {
            try {
                synchronized(MySingleton.class) {
                    if (getInstance == null) {
                        Thread.sleep(1000);
                        getInstance = new MySingleton();
                    }
                }

            } finally {

            }
        }

        return getInstance;
    }
}
