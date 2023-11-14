package threadtutorials;

public class Thread2 extends Thread {
    @Override
    public void run() {

        System.out.println("started a new thread2");
        System.out.println("this is the thread " + Thread.currentThread().getName());
        System.out.println("the thread name and priority are " + Thread.currentThread().getName() + " " +
                Thread.currentThread().getPriority());
        System.out.println();
    }

    public  void createThread2() throws InterruptedException {
        Thread2 thread2 = new Thread2();


        System.out.println("this is the thread " + Thread.currentThread().getName());

        thread2.start();
        thread2.setName("Worker Thread2");
        thread2.setPriority(Thread.MIN_PRIORITY);
        System.out.println("this is the thread " + Thread.currentThread().getName());

        thread2.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("a criticaL error occured in thread " + t.getName() + " error is " + e.getMessage());
                // in this place you can also clean up onjects etc
            }
        });
        Thread.UncaughtExceptionHandler err = thread2.getUncaughtExceptionHandler();

        Thread.sleep(10000);
    }

    public static class Task2 implements Runnable {
        @Override
        public void run(){
            System.out.println("Hello from new thread");
        }
    }


}
