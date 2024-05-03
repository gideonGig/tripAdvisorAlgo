package threadtutorials.student_library;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class StudentLibrary {
    private static final int totalBooks = 2;
    private static final int totalStudents = 5;
    private static final int simulationTime = 2000;

    public static void main(String[] args) {
        Book[] books = new Book[totalBooks];
        Student[] students = new Student[totalStudents];

        CyclicBarrier cyclicBarrier = new CyclicBarrier(totalStudents, () -> {
            for (Student student : students) {
                System.out.println(student + " read " + student.numberOfTotalReads() + " times");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(totalStudents);

        try {
            for (int i = 0; i < totalBooks; i++) {
                books[i] = new Book(i + 1);
            }
            for (int i = 0; i < totalStudents; i++) {
                students[i] = new Student(i + 1, books, cyclicBarrier);
                executorService.execute(students[i]);
            }

            Thread.sleep(simulationTime);

            for (Student student : students) {
                student.stopReading();
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            executorService.shutdown();

        }
    }
}
