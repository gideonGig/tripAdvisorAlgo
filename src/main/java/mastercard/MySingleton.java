package mastercard;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class MySingleton {
   public static ReentrantReadWriteLock reentrantReadWriteLock = new ReentrantReadWriteLock();
   public static Lock lock = reentrantReadWriteLock.readLock();

    private static volatile MySingleton getIntance;
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
