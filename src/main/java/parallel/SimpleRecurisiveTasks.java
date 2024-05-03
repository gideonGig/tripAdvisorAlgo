package parallel;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveAction;

public class SimpleRecurisiveTasks extends RecursiveAction {
  private List<Integer> result = new ArrayList<Integer>();
  private List<Integer> arr;

  public SimpleRecurisiveTasks(List<Integer> arr, List<Integer> result) {
    this.arr = arr;
    this.result = result;
  }

  @Override
  protected void compute() {
    if (arr.size() < 100) {
      for (int i = 0; i < arr.size(); i++) {
        Integer val = arr.get(i);
        boolean isPrime = true;
        for (int j = 2; j <= 9; j++) {
          if (val % j == 0) {
            isPrime = false;
          }
        }
        if (isPrime && val != null) {
          result.add(val);
        }

      }
    } else {
      List<Integer> left = arr.subList(0, arr.size() / 2);
      List<Integer> right = arr.subList(arr.size() / 2, arr.size());
      SimpleRecurisiveTasks action1 = new SimpleRecurisiveTasks(left, result);
      SimpleRecurisiveTasks action2 = new SimpleRecurisiveTasks(right, result);

      invokeAll(action1, action2);
    }
  }

  public List<Integer> getPrimeNumbersInArray() {
    return result;
  }

}
