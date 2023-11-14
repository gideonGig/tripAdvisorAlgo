package neecode_150;

import java.util.*;

public class NeetCode {

    public static class MyStack {
        private Queue<Integer> firstQueue;
        private Queue<Integer> secondQueue;

        public MyStack() {
            firstQueue = new LinkedList<>();
            secondQueue = new LinkedList<>();
        }

        public void push(int x) {
            firstQueue.add(x);
        }

    }

    public static int calPoints(String[] operations) {
        Stack<String> stack = new Stack<>();
        for (int i = 0; i < operations.length; i++) {
            if (operations[i] == "+") {
                Integer newRecord = Integer.parseInt(stack.get(stack.size() - 1)) +
                        Integer.parseInt(stack.get(stack.size() - 2));
                stack.add(String.valueOf(newRecord));
            } else if (operations[i] == "D") {
                Integer newRecord = Integer.parseInt(stack.get(stack.size() - 1)) * 2;
                stack.add(String.valueOf(newRecord));
            } else if (operations[i] == "C") {
                stack.pop();
            } else {
                stack.add(operations[i]);
            }
        }

        int summ = 0;
        for (String s : stack) {
            summ = summ + Integer.parseInt(s);
        }
        return summ;
    }

    public static class MinStack {
        private Stack<Integer> arr;
        private Stack<Integer> minArr;

        public MinStack() {
            arr = new Stack<>();
            minArr = new Stack<>();
        }

        public void push(int val) {
            arr.push(val);
            int minimum = val;
            if (!minArr.isEmpty()) {
                minimum = Math.min(val, minArr.peek());
            }
            minArr.push(minimum);
        }

        public void pop() {
            arr.pop();
            minArr.pop();
        }

        public int getMin() {
            return minArr.peek();
        }
    }

    public static int countStudents(int[] students, int[] sandwiches) {
        int circular = 0;
        int square = 0;
        for (Integer i : students) {
            if (i == 1) {
                square++;
            } else {
                circular++;
            }
        }

        for (Integer i : sandwiches) {
            if (i == 0) {
                if (circular == 0) {
                    return square;
                }
                circular--;
            } else {
                if (square == 0) {
                    return circular;
                }
                square--;
            }
        }
        return 0;
    }
}
