package threadtutorials.dining_philosopher;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DiningPhilospher {

    public static void main(String[] args) throws InterruptedException {
        Philosopher[] philosophers = new Philosopher[Constant.numberOfPhilosopher];

        CyclicBarrier cyclicBarrier = new CyclicBarrier(Constant.numberOfPhilosopher, () -> {
            for (Philosopher philosopher : philosophers) {
                System.out.println(philosopher.toString() + " ate " + philosopher.totalNumberOfEating() + " times");
            }
        });

        ExecutorService executorService = Executors.newFixedThreadPool(Constant.numberOfPhilosopher);

        try {
            for (int i = 0; i < philosophers.length; i++) {
                Chopstick leftChopstick = new Chopstick(i);
                Chopstick rightChopstick = new Chopstick((i + 1) % Constant.numberOfChopSticks);
                philosophers[i] = new Philosopher(i, leftChopstick, rightChopstick, cyclicBarrier);

                executorService.execute(philosophers[i]);
            }

            Thread.sleep(Constant.simulationTime);

            for (Philosopher philosopher : philosophers) {
                philosopher.setFull(true);
            }

        } finally {
            executorService.shutdown();
        }


    }
}
