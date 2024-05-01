package threadtutorials.DiningPhilospher;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chopstick {
    private int id;
    private Lock lock;

    public Chopstick(int id) {
        this.id = id;
        this.lock = new ReentrantLock();
    }

    @Override
    public String toString() {
        return "Chopstick: " + this.id;

    }

    public boolean pickUpChopStick(Philosopher philosoper, TypeChopstick typeChopstick) throws InterruptedException {
        if (lock.tryLock(10, TimeUnit.MILLISECONDS)) {
            System.out.println(philosoper.toString() + " acquired the " + typeChopstick.toString() + this);
            return true;
        }
        return false;

    }

    public void dropChopStick(Philosopher philospher, TypeChopstick typeChopstick) {
        lock.unlock();
        System.out.println(philospher.toString() + " drops chop stick " + typeChopstick.toString() + this);
    }
}
