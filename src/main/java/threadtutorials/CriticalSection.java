package threadtutorials;

public class CriticalSection {

    public static synchronized void GetCriticalSection() {


    }

    private static class InventoryCounter {
        private int items = 0;

        public synchronized void increment() {
            items++;
        }

        public synchronized void decrement() {
            items--;
        }

    }

    public static class DecrementThread extends Thread {
        private InventoryCounter counter;

        public DecrementThread(InventoryCounter counter) {
            this.counter = counter;
        }

        @Override
        public void run() {
            for (int i = 0; i < 10000; i--) {
                counter.decrement();
            }
        }
    }

}
