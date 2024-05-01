package threadtutorials.student_library;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Student implements Runnable {
    private int id;
    private Book[] book;
    private CyclicBarrier cyclicBarrier;
    private boolean canRead;
    private int counter;
    private Random random;

    public Student(int id, Book[] book, CyclicBarrier cyclicBarrier) {
        this.id = id;
        this.book = book;
        this.cyclicBarrier = cyclicBarrier;
        canRead = true;
        counter = 0;
        random = new Random();
    }

    @Override
    public void run() {

        while (canRead) {
            Book randomBook = book[random.nextInt(book.length)];
            try {
                if (randomBook.canStartRead(this)) {
                    counter++;
                    randomBook.finishRead(this);
                }
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            } finally {

            }
        }

        try {
            cyclicBarrier.await();
        } catch (InterruptedException | BrokenBarrierException e) {
            e.printStackTrace();
        }

    }

    public void stopReading() {
        this.canRead = false;
    }

    public int numberOfTotalReads() {
        return counter;
    }

    @Override
    public String toString() {
        return "Student " + this.id;
    }
}
