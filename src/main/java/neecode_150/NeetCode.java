package neecode_150;

import java.util.*;

import utilities.ListNode;

public class NeetCode {
    private static HashMap<Integer, Integer> map = new HashMap<>();

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

    public static class MyStack {
        private Deque<Integer> firstQueue;
        private Deque<Integer> secondQueue;
        private int count;
        private boolean isPeek = false;

        public MyStack() {
            firstQueue = new LinkedList<>();
            secondQueue = new LinkedList<>();
            count = 0;
        }

        public void push (int x) {
            firstQueue.add(x);
            count++;
        }

        public int pop() {
            if (!firstQueue.isEmpty()) {
                while (!firstQueue.isEmpty()) {
                    secondQueue.addFirst(firstQueue.remove());
                 
                }
            }

            if (!secondQueue.isEmpty()) {
                if (isPeek) {
                    isPeek = false;
                    return secondQueue.peek();
                } else {
                    isPeek = false;
                    count--;
                    return secondQueue.remove();
                }           
            }

            return -1;
        }

        public int top() {
            isPeek = true;
            return pop();
        }

        public boolean empty() {
            if (count > 0) {
                return false;
            }

            return true;
        }

    
    }

    public static ListNode reverseList(ListNode head) {
       if (head == null) {
           return head;
       }

       ListNode cur = head;
       ListNode next = new ListNode();
       ListNode prev = null;

       while (cur != null) {
        next = cur.next;
        cur.next = prev;
        prev = cur;
        cur = next;
       }

       return prev;
    }

    public static ListNode reverseListIteratively(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode node = reverseListIteratively(head.next);
        head.next.next = head;
        head.next = null;
        

        return node;

    }

    public static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans = climbStairs(n-2) + climbStairs(n-1);
        map.put(n, ans);
        return ans;
        
    }

    public static int[] sortArray(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        helper(nums, start, end);
        return nums;
    }

    private static void helper(int[] nums, int start, int end) {
        
       while (start < end) {
        int mid = start + (end  - start)/2;
        helper(nums, start, mid);
        helper(nums, mid + 1, end);
        merge(nums, start, mid, end);
       }

    }
       
    private static void merge(int[] nums, int start, int mid, int end ) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <=mid && j <= end )
        {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else  {
                temp[k++] = nums[j++];
            }
        }

       while ( i <= mid) {
        temp[k++] = nums[i++];
       }

       while (j <= end) {
        temp[k++] = nums[j++];
       }

       for (int x = start; x <= end; x++) {
        nums[x] = temp[x - start];
       }
    }
    
    public static void insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i - 1;
            while (j >= 0 && arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
                /** the  j--, backtracks to check thatv all prev number before is sorted **/
                j--;
            }
        }
    }

    public static int[] quickSort(int[] arr) {
       return quickSortHelper(arr, 0, arr.length-1);

    }

    private static int[] quickSortHelper(int[] arr, int startIndex, int pivotIndex) {
        if (pivotIndex - startIndex + 1 <= 1 ) {
            return arr;
        }

        int pivot = arr[pivotIndex];
        int left = startIndex;

        for (int i = startIndex; i < pivotIndex; i++) {
            if (arr[i] < pivot) {
                int temp = arr[i];
                arr[i] = arr[left];
                arr[left] = temp;
                left += 1;
            }
        }
        //swap pivot and the element at index of left
        arr[pivotIndex] = arr[left];
        arr[left] = pivot;

        quickSortHelper(arr, startIndex, left - 1 );
        quickSortHelper(arr, left + 1, pivotIndex);

        return arr;
    }
        
}
