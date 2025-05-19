package threadtutorials.student_library;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Book {
    private final int id;
    private final Lock lock;
    private final Random random;

    public Book(int id) {
        this.id = id;
        lock = new ReentrantLock();
        random = new Random();
    }

    public boolean canStartRead(Student student) throws InterruptedException {
        if (lock.tryLock(20, TimeUnit.MILLISECONDS)) {
            Thread.sleep(random.nextInt(100));
            System.out.println(student + " is reading " + this);
            return true;
        } else {
            return false;
        }
    }

    public void finishRead(Student student) {
        lock.unlock();
        System.out.println(student + " stopped reading " + this);
    }

    public String toString() {
        return "Book " + this.id;
    }
}
