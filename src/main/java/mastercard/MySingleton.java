package mastercard;

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.concurrent.locks.ReentrantLock;

public class MySingleton implements Serializable {
    private static final ReentrantLock lock = new ReentrantLock();
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
            synchronized (MySingleton.class) {
                if (getInstance == null) {
                    Thread.sleep(1000);
                    getInstance = new MySingleton();
                }
            }

        }

        return getInstance;
    }

    private Object readResolve() throws ObjectStreamException {
        return getInstance();
    }

    // Optional: Override toString for demonstration
    @Override
    public String toString() {
        return "Singleton instance: " + super.toString();
    }
}
