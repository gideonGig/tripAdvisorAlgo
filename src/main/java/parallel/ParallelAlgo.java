package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ForkJoinPool;

public class ParallelAlgo {
    public static void main(String[] args)  {
        int itemSize = 1000000;
        List<Integer> arr = new ArrayList<>();
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < itemSize; i++) {
            arr.add(i);  
        }
        ForkJoinPool pool = new ForkJoinPool();
        SimpleRecurisiveTasks task = new SimpleRecurisiveTasks(arr, result);
        pool.invoke(task);

      System.out.println(task.getPrimeNumbersInArray().toString());
    }

}
