package mastercard;

import java.util.concurrent.locks.ReentrantLock;

public class MySingleton {
    private static ReentrantLock lock = new ReentrantLock();
    private static MySingleton getIntance;

    private MySingleton() {
    }

    public static MySingleton getInstance() {
        lock.lock();
        try {
            if (getIntance == null) {
                getIntance = new MySingleton();
            }
            return getIntance;
        } finally {
            lock.unlock();
        }
    }
}
