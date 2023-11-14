package threadtutorials;

public class Thread1 {

    public static void createThread() throws InterruptedException {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                System.out.println("started a new thread");
                System.out.println("this is the thread " + Thread.currentThread().getName());
                System.out.println("the thread name and priority are " + Thread.currentThread().getName() + " " +
                        Thread.currentThread().getPriority());
                System.out.println();
            }
        });

        System.out.println("this is the thread " + Thread.currentThread().getName());

        thread.start();
        thread.setName("Worker Thread");
        thread.setPriority(Thread.MIN_PRIORITY);
        System.out.println("this is the thread " + Thread.currentThread().getName());

        thread.setUncaughtExceptionHandler(new Thread.UncaughtExceptionHandler() {
            @Override
            public void uncaughtException(Thread t, Throwable e) {
                System.out.println("a criticaL error occured in thread " + t.getName() + " error is " + e.getMessage());
                // in this place you can also clean up onjects etc
            }
        });
        Thread.UncaughtExceptionHandler err = thread.getUncaughtExceptionHandler();

        Thread.sleep(10000);
    }

}
