package threadtutorials;

import java.math.BigDecimal;

public class InteruptThread {
    private BigDecimal base;
    private int n;

    private BigDecimal result;

    public InteruptThread(BigDecimal base, int n) {
        this.base = base;
        this.n = n;
        result = BigDecimal.valueOf(1);
    }

    public void interuptThread() {
        Thread t = new Thread(new LongCalculation());
        t.start();
        t.interrupt();

    }

    public class LongCalculation implements Runnable {
        @Override
        public void run() {

            try {
                Thread.sleep(1000);
                result = BigDecimal.valueOf(1);
                for (int i = 0; i < n; i++) {
                    result = result.multiply(base);
                }
                System.out.println(result);
            } catch (InterruptedException e) {
                System.out.println("Thread was interupted");
            }
        }
        /**
         for (int i = 0; i < n; i++) {
         if (Thread.interrupted()) {
         System.out.println("Thread is interrupted");
         return;
         }
         result = result.multiply(base);
         }
         System.out.println(result);
         }**/

    }

}
