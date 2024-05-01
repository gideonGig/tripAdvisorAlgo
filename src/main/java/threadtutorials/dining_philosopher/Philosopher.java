package threadtutorials.dining_philosopher;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Philosopher implements Runnable {

    private int id;
    private Random random;
    private Chopstick leftStick;
    private Chopstick rightStick;
    private boolean full;
    private CyclicBarrier cyclicBarrier;

    private int counter;

    public Philosopher(int id, Chopstick leftStick, Chopstick rightStick, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.leftStick = leftStick;
        this.rightStick = rightStick;
        this.cyclicBarrier = cyclicBarrier;
        this.random = new Random();
    }

    @Override
    public void run() {
        while (!full) {
            try {
                think();
                if (leftStick.pickUpChopStick(this, TypeChopstick.LEFT)) {
                    if (rightStick.pickUpChopStick(this, TypeChopstick.RIGHT)) {
                        eat();
                        counter++;
                        rightStick.dropChopStick(this, TypeChopstick.RIGHT);
                    }
                }
                leftStick.dropChopStick(this, TypeChopstick.LEFT);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }
    }

    public void think() throws InterruptedException {
        System.out.println(this + " is thinking");
        Thread.sleep(random.nextInt(100));
    }

    public void eat() throws InterruptedException {
        System.out.println(this + " is eating");
        Thread.sleep(random.nextInt(100));

    }

    public void setFull(boolean isFull) {
        this.full = isFull;
    }

    public int totalNumberOfEating() {
        return counter;
    }

    @Override
    public String toString() {
        return "Philosopher " + this.id;
    }
}
