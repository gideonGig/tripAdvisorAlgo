package neecode_150;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;

import javafx.util.Pair;
import utilities.ListNode;
import utilities.TreeNode;

public class NeetCode {

    public static class Encoder {
        // Encodes a list of strings to a single string.
        public String encode(List<String> strs) {
            StringBuilder builder = new StringBuilder();
            for (String s : strs) {
                builder.append(String.valueOf(s.length()) + "#" + s);
            }
            return builder.toString();
        }

        // Decodes a single string to a list of strings.
        public List<String> decode(String s) {
            List<String> res = new ArrayList<>();
            int i = 0;
            while (i < s.length()) {
                int j = i;
                while (s.charAt(j) != '#') {
                    j++;
                }
                int len = Integer.valueOf(s.substring(i, j));
                String word = s.substring(j + 1, j + len + 1);
                res.add(word);
                i = j + 1 + 1 + len;

            }

            return res;
        }
    }

    public static int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int max = 0;
        int len = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                continue;
            }

            if (nums[i] + 1 == nums[i + 1]) {
                len++;
            } else {
                max = Math.max(len, max);
                len = 0;
            }
        }

        return Math.max(len, max) + 1;
    }

    public static int[] twoSumInputSorted(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        int[] res = new int[2];
        while (i < j) {
            int sum = numbers[i] + numbers[j];
            if (sum == target) {
                res[0] = i + 1;
                res[1] = j + 1;
                break;
            } else if (sum < target) {
                i++;
            } else {
                j--;
            }
        }
        return res;
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length < 3 || nums[0] > 0) {
            return res;
        }
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            int leftPtr = i + 1;
            int rightPtr = nums.length - 1;

            while (leftPtr < rightPtr) {
                int sum = nums[leftPtr] + nums[rightPtr] + nums[i];
                if (sum > 0) {
                    rightPtr--;
                } else if (sum < 0) {
                    leftPtr++;
                } else {
                    List<Integer> list = new ArrayList<>();
                    list.add(nums[leftPtr]);
                    list.add(nums[i]);
                    list.add(nums[rightPtr]);
                    res.add(list);
                    leftPtr++;
                    while (nums[leftPtr] == nums[leftPtr - 1] && leftPtr < rightPtr) {
                        leftPtr++;
                    }

                }
            }
        }
        return res;
    }

    public static int maxArea(int[] height) {
        int max = 0;
        int leftPtr = 0;
        int rightPtr = height.length - 1;
        while (leftPtr < rightPtr) {
            int area = Math.min(height[leftPtr], height[rightPtr]) * (rightPtr - leftPtr);
            max = Math.max(max, area);
            if (height[leftPtr] <= height[rightPtr]) {
                leftPtr++;
            } else {
                rightPtr--;
            }
        }
        return max;
    }

    public static int trap(int[] height) {
        int total = 0;
        int len = height.length;
        int leftMax = 0;
        int[] leftMaxArr = new int[len];
        int rightMax = 0;
        int[] rightMaxArr = new int[len];

        for (int i = 0; i < len; i++) {
            leftMax = Math.max(leftMax, height[i]);
            leftMaxArr[i] = leftMax;
        }

        for (int j = len - 1; j >= 0; j--) {
            rightMax = Math.max(rightMax, height[j]);
            rightMaxArr[j] = rightMax;
        }

        for (int k = 0; k < len; k++) {
            total += Math.min(leftMaxArr[k], rightMaxArr[k]) - height[k];
        }
        return total;

    }
    /*
     * kandane Allgorithm
     */

    public static int maxProfit(int[] prices) {
        int max = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            min = Math.min(prices[i], min);
            max = Math.max(prices[i] - min, max);
        }
        return max;

    }

    /*
     * Beginning of Two Pointer and Sliding Window Technique
     */
    public static int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int max = 0;
        for (rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            char c = s.charAt(rightPtr);
            while (set.contains(c)) {
                set.remove(s.charAt(leftPtr));
                leftPtr++;

            }
            set.add(c);
            max = Math.max(max, rightPtr - leftPtr + 1);
        }
        return max;
    }

    public static int characterReplacement(String s, int k) {
        HashMap<Character, Integer> freq = new HashMap<>();
        int leftPtr = 0;
        int rightPtr = 0;
        int maxFreq = 0;
        for (rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            Character c = s.charAt(rightPtr);
            int val = freq.getOrDefault(c, 0) + 1;
            freq.put(c, val);
            maxFreq = Math.max(val, maxFreq);
            /*
             * we can get the maximum frequency in constant time
             * ad we are adding the counter to the dictionary
             */
            if ((rightPtr - leftPtr + 1) - maxFreq > k) {
                Character rm = s.charAt(leftPtr);
                freq.replace(rm, freq.get(rm), freq.get(rm) - 1);
                leftPtr++;
            }
        }

        return rightPtr - leftPtr;

    }

    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }

        int k = s1.length();
        int leftPtr = 0;
        int rightPtr = 0;

        char[] s1Arr = s1.toCharArray();
        Arrays.sort(s1Arr);
        String sortedS1 = new String(s1Arr);
        for (rightPtr = k - 1; rightPtr < s2.length(); rightPtr++) {
            String s = s2.substring(leftPtr, rightPtr + 1);
            char[] sarr = s.toCharArray();
            Arrays.sort(sarr);
            String ssort = new String(sarr);

            if (ssort.equals(sortedS1)) {
                return true;
            } else {
                leftPtr++;
            }
        }
        return false;

    }

    public static boolean checkInclusion2(String s1, String s2) {
        if (s1 == null || s2 == null || s1.length() > s2.length()) {
            return false;
        }
        int leftPtr = 0;
        int rightPtr = 0;
        int k = s1.length();
        for (rightPtr = k - 1; rightPtr < s2.length(); rightPtr++) {
            int[] alpha = new int[26];
            int i = 0;
            while (i < s1.length()) {
                alpha[s1.charAt(i) - 'a']++;
                alpha[s2.charAt(leftPtr + i) - 'a']--;
                i++;
            }

            boolean allMatch = true;
            for (int j = 0; j < alpha.length; j++) {
                if (alpha[j] != 0) {
                    allMatch = false;
                    break;
                }
            }

            if (allMatch) {
                return true;
            }

            leftPtr++;
        }

        return false;
    }

    public static String minWindow(String s, String t) {
        int havelength = 0;
        int minWindow = Integer.MAX_VALUE;
        int[] winPtr = new int[2];
        if (t.equals("")) {
            return "";
        }
        int rightPtr = 0;
        int leftPtr = 0;
        Map<Character, Integer> tmap = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            int val = tmap.getOrDefault(t.charAt(i), 0) + 1;
            tmap.put(t.charAt(i), val);
        }
        int reqLen = tmap.size();

        Map<Character, Integer> smap = new HashMap<>();

        for (rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            Character sh = s.charAt(rightPtr);
            int skey = smap.getOrDefault(sh, 0) + 1;
            smap.put(sh, skey);
            if (tmap.containsKey(sh) && tmap.get(sh).equals(smap.get(sh))) {
                havelength++;
            }
            while (havelength == reqLen) {
                int window = rightPtr - leftPtr + 1;
                if (window < minWindow) {
                    minWindow = window;
                    winPtr[0] = leftPtr;
                    winPtr[1] = rightPtr;
                } else if (window == reqLen) {
                    return s.substring(winPtr[0], winPtr[1] + 1);
                }

                /*
                 * decrease the window and test the condition, that is
                 * why we set the while loop intially
                 */
                Character leftChar = s.charAt(leftPtr);
                int keychar = smap.get(leftChar) - 1;
                smap.put(leftChar, keychar);
                /**
                 * check if the decrease in leftPtr caused havelength to decrease
                 * also
                 */
                if (tmap.containsKey(leftChar) && tmap.get(leftChar) > smap.get(leftChar)) {
                    havelength--;
                }
                leftPtr++;
            }
        }
        if (minWindow != Integer.MAX_VALUE) {
            return s.substring(winPtr[0], winPtr[1] + 1);
        } else {
            return "";
        }
    }

    /**
     * optimized version, the max sliding window uses the Deque
     * what get added to the deque is the index, because we can
     * always find the value of the index, we do this because
     * we want to know if the leftPtr is out of scope.
     */
    public static int[] maxSlidingWindow2(int[] nums, int k) {
        Deque<Integer> q = new ArrayDeque<>();
        int[] res = new int[nums.length - k + 1];
        int resPtr = 0;
        int leftPtr = 0;
        int rightPtr = 0;
        while (rightPtr < nums.length) {
            while (!q.isEmpty() && nums[rightPtr] > nums[q.getLast()]) {
                q.removeLast();
            }
            q.add(rightPtr);

            if (leftPtr > q.getFirst()) {
                q.removeFirst();
            }

            if (rightPtr + 1 >= k) {
                res[resPtr++] = nums[q.getFirst()];
                leftPtr++;
            }

            rightPtr++;
        }

        return res;
    }

    public static int numOfSubarrays(int[] arr, int k, int threshold) {
        int leftPtr = 0;
        int rightPtr = 0;
        int max = 0;
        int count = 0;
        for (rightPtr = 0; rightPtr < arr.length; rightPtr++) {
            max += arr[rightPtr];
            if (rightPtr - leftPtr + 1 == k) {
                if (max / k >= threshold) {
                    count++;
                }
                max = max - arr[leftPtr];
                leftPtr++;
            }
        }
        return count;
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        // if k == 0, everything is disitinct, no duplicates will exist
        if (k == 0) {
            return true;
        }
        int leftPtr = 0;
        int rightPtr = 1;
        HashSet<Integer> set = new HashSet<>();
        set.add(nums[leftPtr]);
        for (rightPtr = 1; rightPtr < nums.length; rightPtr++) {
            if (set.contains(nums[rightPtr])) {
                return true;
            }

            if (rightPtr - leftPtr == k) {
                set.remove(nums[leftPtr]);
                leftPtr++;
            }

            set.add(nums[rightPtr]);
        }

        return false;

    }

    public static int minSubArrayLen(int target, int[] nums) {
        int leftPtr = 0;
        int rightPtr = 0;
        int res = Integer.MAX_VALUE;
        int total = 0;
        for (rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            total += nums[rightPtr];
            while (total >= target) {
                res = Math.min(rightPtr - leftPtr + 1, res);
                total = total - nums[leftPtr];
                leftPtr++;
            }
        }

        if (res == Integer.MAX_VALUE) {
            return 0;
        }

        return res;
    }

    public static int maxSubarraySumCircular(int[] nums) {
        int rightPtr = 0;
        int curSum = 0;
        int maxSum = Integer.MIN_VALUE;
        int totalSum = 0;

        int minSum = Integer.MAX_VALUE;
        int mini = 0;

        for (rightPtr = 0; rightPtr < nums.length; rightPtr++) {
            totalSum += nums[rightPtr];
            curSum = Math.max(curSum + nums[rightPtr], nums[rightPtr]);
            maxSum = Math.max(curSum, maxSum);

            mini = Math.min(mini + nums[rightPtr], nums[rightPtr]);
            minSum = Math.min(mini, minSum);
        }

        if (maxSum > 0) {
            return Math.max(maxSum, totalSum - minSum);
        }

        return maxSum;

    }

    public static boolean isValid(String s) {
        HashMap<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('{', '}');
        map.put('[', ']');

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            if (map.containsKey(c)) {
                stack.add(c);
            } else {
                if (!stack.isEmpty()) {
                    Character lastchar = stack.pop();
                    if (!map.get(lastchar).equals(c)) {
                        return false;
                    }
                } else {
                    return false;

                }
            }
        }
        if (!stack.isEmpty()) {
            return false;

        }

        return true;

    }

    public static boolean isPalindrome(String s) {
        s = s.toUpperCase();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            if (!Character.isLetterOrDigit(s.charAt(i))) {
                i++;
                continue;
            }
            if (!Character.isLetterOrDigit(s.charAt(j))) {
                j--;
                continue;
            }
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;

    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        HashMap<Character, Integer> sMap = new HashMap<>();
        HashMap<Character, Integer> tMap = new HashMap<>();

        for (char valS : s.toCharArray()) {
            int keyS = sMap.getOrDefault(Character.valueOf(valS), 0) + 1;
            sMap.put(valS, keyS);
        }

        for (char valT : t.toCharArray()) {
            int keyT = tMap.getOrDefault(Character.valueOf(valT), 0) + 1;
            tMap.put(valT, keyT);
        }

        for (Character val : sMap.keySet()) {
            if (!(sMap.containsKey(val) && tMap.containsKey(val) && sMap.get(val).equals(tMap.get(val)))) {
                return false;
            }
        }

        return true;
    }

    public static boolean isAnagram2(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] alp = new int[26];
        for (int i = 0; i < s.length(); i++) {
            alp[s.charAt(i) - 'a']++;
            alp[t.charAt(i) - 'a']--;
        }
        for (int n : alp) {
            if (n != 0) {
                return false;
            }
        }

        return true;

    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<>();
        if (strs == null) {
            return result;
        }

        HashMap<String, List<String>> map = new HashMap<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String sortedWord = new String(c);

            List<String> key = map.getOrDefault(sortedWord, new ArrayList<>());
            key.add(s);
            map.put(sortedWord, key);
        }

        for (String key : map.keySet()) {
            result.add(map.get(key));
        }

        return result;
    }

    public static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            int rem = target - nums[i];
            if (map.containsKey(rem)) {
                res[0] = i;
                res[1] = map.get(rem);
                break;
            } else {
                map.put(nums[i], i);

            }
        }
        return res;
    }

    public static int[] topKFrequent(int[] nums, int k) {
        PriorityQueue<Map.Entry<Integer, Integer>> pq = new PriorityQueue<>((a, b) -> b.getValue() - a.getValue());
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            int freq = map.getOrDefault(num, 0) + 1;
            map.put(num, freq);

        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry);
        }

        int[] res = new int[k];
        for (int i = 0; i < k; i++) {
            res[i] = pq.poll().getKey();
        }

        return res;
    }

    public static int maxSubArray(int[] nums) {
        int submax = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            submax = Math.max(nums[i], nums[i] + max);
            max = Math.max(submax, max);
        }
        return max;

    }

    public static int[] productExceptSelf(int[] nums) {
        int[] forward = new int[nums.length];
        int[] backward = new int[nums.length];

        int prev = 1;
        for (int i = 0; i < nums.length; i++) {
            prev = nums[i] * prev;
            forward[i] = prev;
        }

        prev = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            prev = nums[i] * prev;
            backward[i] = prev;
        }

        int[] result = new int[nums.length];
        result[0] = backward[1];
        result[nums.length - 1] = forward[nums.length - 2];

        for (int i = 1; i < nums.length - 1; i++) {
            result[i] = forward[i - 1] * backward[i + 1];
        }

        return result;
    }

    public static boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Set<Character> rowSet = new HashSet<>();
            Set<Character> colSet = new HashSet<>();

            for (int j = 0; j < board.length; j++) {
                char r = board[i][j];
                char c = board[j][i];

                if (r != '.') {
                    if (rowSet.contains(r)) {
                        return false;
                    } else {
                        rowSet.add(r);
                    }
                }
                if (c != '.') {
                    if (colSet.contains(c)) {
                        return false;
                    } else {
                        colSet.add(c);
                    }
                }
            }

            /** check block */
            for (int x = 0; x < board.length; x = x + 3) {
                for (int y = 0; y < board.length; y = y + 3) {
                    if (!checkBox(x, y, board)) {
                        return false;
                    }
                }

            }
        }

        return true;
    }

    public static boolean checkBox(int i, int j, char[][] board) {
        Set<Character> set = new HashSet<>();
        int row = i + 3;
        int col = j + 3;
        for (int x = i; x < row; x++) {
            for (int y = j; y < col; y++) {
                char c = board[x][y];
                if (c != '.') {
                    if (set.contains(c)) {
                        return false;
                    } else {
                        set.add(c);
                    }

                }
            }
        }

        return true;
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

    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(Integer.valueOf(nums[i]))) {
                return true;
            } else {
                set.add(nums[i]);

            }
        }

        return false;
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

        public void push(int x) {
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
        HashMap<Integer, Integer> map = new HashMap<>();
        if (n <= 3) {
            return n;
        }

        if (map.containsKey(n)) {
            return map.get(n);
        }

        int ans = climbStairs(n - 2) + climbStairs(n - 1);
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

        if (start < end) {
            int mid = start + (end - start) / 2;
            helper(nums, start, mid);
            helper(nums, mid + 1, end);
            merge(nums, start, mid, end);
        }

    }

    private static void merge(int[] nums, int start, int mid, int end) {
        int[] temp = new int[end - start + 1];
        int i = start;
        int j = mid + 1;
        int k = 0;

        while (i <= mid && j <= end) {
            if (nums[i] <= nums[j]) {
                temp[k++] = nums[i++];
            } else {
                temp[k++] = nums[j++];
            }
        }

        while (i <= mid) {
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
                /** the j--, backtracks to check that all prev number before is sorted **/
                j--;
            }
        }
    }

    /**
     * go over this again to understand clearly
     */
    public static int[] quickSort(int[] arr) {
        return quickSortHelper(arr, 0, arr.length - 1);

    }

    private static int[] quickSortHelper(int[] arr, int startIndex, int pivotIndex) {
        if (pivotIndex - startIndex + 1 <= 1) {
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
        // swap pivot and the element at index of left
        arr[pivotIndex] = arr[left];
        arr[left] = pivot;

        // call quicksort recursive from startIndex to the index before the left
        quickSortHelper(arr, startIndex, left - 1);
        // call quicksort recursive from the value after the left index to the
        // pivotIndex which is usually
        // for our vase the end index
        quickSortHelper(arr, left + 1, pivotIndex);

        return arr;
    }

    /** This algorithm uses a bucket sort technique */
    public void sortColors(int[] nums) {
        // elements are between 0 1, 2
        int[] colorTypes = { 0, 0, 0 };
        for (int i = 0; i < nums.length; i++) {
            colorTypes[nums[i]]++;
        }

        int i = 0;
        for (int j = 0; j < colorTypes.length; j++) {
            int k = 0;
            while (k < colorTypes[j]) {
                nums[i] = j;
                k++;
                i++;
            }
        }
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = Arrays.stream(matrix)
                .flatMapToInt(x -> Arrays.stream(x)).toArray();
        int l = 0;
        int r = arr.length - 1;

        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (target > arr[mid]) {
                l = mid + 1;
            } else if (target < arr[mid]) {
                r = mid - 1;
            } else {
                return true;
            }
        }

        return false;
    }

    /**
     * the minEatingSpeed algorithm is tricky but it uses Binary search under the
     * hood,
     * we are searching for the minimum number of hours less than or equal to h that
     * will
     * maker us finish each pile in the banana i.e piles[i] in less than h;
     * so the trick is simple, we set the maximum value in the array to the
     * rightPtr,
     * and the mininum value to 1. and we find the minimumn value that go through
     * each index
     * in less than or equal to h using binaruSearch, if you don't get this in the
     * future please
     * watch https://www.youtube.com/watch?v=U2SozAs9RzA
     *
     * @param piles
     * @param h
     * @return
     */

    public static int minEatingSpeed(int[] piles, int h) {
        int maxPile = Arrays.stream(piles).max().getAsInt();
        int l = 1;
        int r = maxPile;
        int minimumSpeed = maxPile;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isMinimumSpeed(piles, mid, h)) {
                minimumSpeed = mid;
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }

        return minimumSpeed;
    }

    private static boolean isMinimumSpeed(int[] piles, int mid, int h) {
        int rem = h;
        for (int i = 0; i < piles.length; i++) {
            int getWhole = 0;
            int value = piles[i] / mid;
            double doubleModules = piles[i] % mid;
            if (doubleModules > 0) {
                getWhole = value + 1;
            } else {
                getWhole = value;
            }
            rem = rem - getWhole;
            if (rem < 0) {
                return false;
            }
        }

        return true;
    }

    public static TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }

        if (val > root.val) {
            root = searchBST(root.right, val);
        } else if (val < root.val) {
            root = searchBST(root.left, val);

        }

        return root;
    }

    public static TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val, null, null);
        }

        if (val < root.val) {
            root.left = insertIntoBST(root.left, val);
        } else if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }

        return root;
    }

    /**
     * we will be using the minimumNode method deletion, so we would search for the
     * minimum in the rightNode,
     * this algorithm is very ticky, relearn it everyday until ypu are used to it
     */
    public static TreeNode deleteNodeBST(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key > root.val) {
            root.right = deleteNodeBST(root.right, key);
        } else if (key < root.val) {
            root.left = deleteNodeBST(root.left, key);
        } else {
            if (root.right == null)
                return root.left;
            else if (root.left == null)
                return root.right;
            else {
                TreeNode minimum = findMinimumNode(root.right);
                root.right = deleteNodeBST(root.right, minimum.val);
            }
        }
        return root;
    }

    private static TreeNode findMinimumNode(TreeNode root) {
        if (root == null) {
            return null;
        }

        TreeNode cur = root.left;
        while (cur != null && cur.left != null) {
            cur = cur.left;
        }
        return cur;
    }

    /*
     * the inorder traversal of a Binary Search tree always produces a sorted tree,
     * the
     * runtime for inorderTraversal is 0(n) while the runtime for sorting a
     * BinarySearchTree
     * is 0(nlogn) d for doing both it will be 0(nlonN) + o(n) = o(nlogn)
     * The algorithm is a bit tricky and different from the rest above i.e the
     * isertiuon, deletion and search
     * we are returning root if we get to a leave Node, learn the Iterative pattern,
     * 
     */
    public static List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> arr = new ArrayList<>();
        traverseInOrder(root, arr);
        return arr;
    }

    private static TreeNode traverseInOrder(TreeNode root, List<Integer> arr) {
        if (root == null) {
            return root;
        }

        root.left = traverseInOrder(root.left, arr);
        arr.add(root.val);
        root.right = traverseInOrder(root.right, arr);
        return root;
    }

    public static List<Integer> inorderTraversalIterative(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        List<Integer> arr = new ArrayList<>();
        TreeNode cur = root;
        while (cur != null) {
            while (cur != null || !stack.isEmpty()) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            arr.add(cur.val);
            cur = cur.right;
        }

        return arr;
    }

    /**
     * Another tricky question, we knownthat the smallest value in the BST can only
     * be found
     * on the left Node, but in this case we are find the Kth smallest, which can be
     * found also in the right Node
     * so please complete the Inorder traversal
     */
    public static int kthSmallest(TreeNode root, int k) {
        int i = 1;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.isEmpty()) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            if (i == k) {
                return cur.val;
            }
            cur = cur.right;
            i++;
        }

        return i;
    }

    /**
     * Understand this deeply, also learn the iterative version, to strengthen your
     * knowlege on stacks
     */
    public static TreeNode buildTree(int[] preorder, int[] inorder) {

        if (inorder.length == 0 || preorder.length == 0) {
            return null;
        }

        int rootVal = preorder[0];
        TreeNode root = new TreeNode(rootVal, null, null);
        int indexVal = getIndexOfInOrderArray(inorder, rootVal);

        int[] subSetPreOrderLeft = Arrays.copyOfRange(preorder, 1, indexVal + 1);
        int[] subSetInOrderLeft = Arrays.copyOfRange(inorder, 0, indexVal);

        int[] subSetPreOrderRight = Arrays.copyOfRange(preorder, indexVal + 1, preorder.length);
        int[] subSetInOrderRight = Arrays.copyOfRange(inorder, indexVal + 1, inorder.length);

        root.left = buildTree(subSetPreOrderLeft, subSetInOrderLeft);
        root.right = buildTree(subSetPreOrderRight, subSetInOrderRight);

        return root;

    }

    private static int getIndexOfInOrderArray(int[] inorder, int val) {
        int ans = -1;
        for (int i = 0; i < inorder.length; i++) {
            if (inorder[i] == val) {
                ans = i;
            }
        }

        return ans;
    }

    /**
     * Study how this Tree is built using Iterative approach, study why it works,
     * how the code wires
     * especially getting the parent node and determine the right and left
     */
    public static TreeNode buildTreeIteratively(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null || preorder.length != inorder.length || preorder.length == 0) {
            return null;
        }

        Map<Integer, Integer> inorderMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = new TreeNode(preorder[0], null, null);
        stack.push(root);

        for (int i = 1; i < preorder.length; i++) {
            TreeNode node = new TreeNode(preorder[i], null, null);
            TreeNode parent = null;

            while (!stack.isEmpty() && inorderMap.get(preorder[i]) > inorderMap.get(stack.peek().val)) {
                parent = stack.pop();
            }

            if (parent != null) {
                parent.right = node;
            } else {
                stack.peek().left = node;
            }

            stack.push(node);
        }

        return root;
    }

    public static int breadthFirstSearch(TreeNode node) {
        if (node == null) {
            return 0;
        }

        int level = 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int i = 0;
            int len = queue.size();
            while (i < len) {
                TreeNode cur = queue.remove();
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
                i++;
            }
            level++;
        }

        return level;
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode current = queue.remove();
                list.add(current.val);
                if (current.left != null) {
                    queue.add(current.left);
                }

                if (current.right != null) {
                    queue.add(current.right);
                }
            }

            ans.add(list);
        }

        return ans;
    }

    /**
     * prettty straight forward, you solved this yourself, just get the last element
     * in each level order traversal,
     * this is why i used the if statement
     */
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                TreeNode cur = queue.poll();
                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
                if (i == len - 1) {
                    ans.add(cur.val);
                }

            }

        }

        return ans;
    }

    /**
     * This is a simple one, get the base case and go left and right, you solved it
     * without help
     */

    public static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }

        targetSum = targetSum - root.val;
        if (root.left == null && root.right == null && targetSum == 0) {
            return true;
        }

        if (hasPathSum(root.left, targetSum)) {
            return true;
        }

        if (hasPathSum(root.right, targetSum)) {
            return true;
        }

        return false;
    }

    public static List<TreeNode> generateTrees(int n) {
        if (n == 0) return new ArrayList<>();
        Map<Pair<Integer, Integer>, List<TreeNode>> memo = new HashMap<>();
        return getAllBST(1, n, memo);

    }

    private static List<TreeNode> getAllBST(int start, int end, Map<Pair<Integer, Integer>, List<TreeNode>> memo) {
        List<TreeNode> res = new ArrayList<>();
        if (start > end) {
            res.add(null);
            return res;
        }

        Pair<Integer, Integer> pair = new Pair<>(start, end);
        if (memo.containsKey(pair)) {
            return memo.get(pair);
        }

        for (int i = start; i <= end; i++) {
            List<TreeNode> leftSubTree = getAllBST(start, i - 1, memo);
            List<TreeNode> rightSubTree = getAllBST(i + 1, end, memo);

            for (TreeNode left : leftSubTree) {
                for (TreeNode right : rightSubTree) {
                    TreeNode node = new TreeNode(i, left, right);
                    res.add(node);
                }
            }
        }

        memo.put(new Pair<>(start, end), res);
        return res;
    }

    public static int numTrees(int n) {
        int start = 1;
        int end = n;
        Map<Pair<Integer, Integer>, Integer> memo = new HashMap<>();
        return getNumTreesByRecursion(start, end, memo);

    }

    private static int getNumTreesByRecursion(int start, int end,  Map<Pair<Integer, Integer>, Integer> memo) {
        if (start >= end) {
            return 1;
        }

        Pair<Integer, Integer> pair = new Pair<>(start, end);
        if (memo.containsKey(pair)) {
            return memo.get(pair);
        }

        int total = 0;
        for (int i = start; i <= end; i++) {
            total += getNumTreesByRecursion(start, i - 1, memo) * getNumTreesByRecursion(i + 1, end, memo);
        }
        memo.put(new Pair<>(start, end), total);

        return total;
    }

    public static boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }

        TreeNode[] prev = new TreeNode[1];
        return isValidBSTInOrder(root, prev);
    }

    private static boolean isValidBSTInOrder(TreeNode root, TreeNode[] prev) {
        if (root == null) {
            return true;
        }

        if (!isValidBSTInOrder(root.left, prev)) {
            return false;
        }

        if (prev != null && prev[0].val >= root.val) {
            return false;
        }

        prev[0] = root;

        return isValidBSTInOrder(root.right, prev);
    }

    /**
     * This is a clear Example of a Backtrcaking problem, it usually buiulds a DFS
     * Tree, and each tree path can
     * have various decisions, backtracking can be from complex to simple solutions,
     * you may need time to master
     * it, backtracking builds on the concept of Recursion, DFS
     *
     */
    public static List<List<Integer>> subsets(int[] nums) {
        /** I will try use two pointer technique */
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        helperSubset(0, nums, result, list);
        return result;

    }

    private static void helperSubset(int start, int[] nums, List<List<Integer>> result, List<Integer> list) {
        if (start >= nums.length) {
            result.add(new ArrayList<>(list));
        } else {
            Integer element = nums[start];
            list.add(element);
            helperSubset(start + 1, nums, result, list);

            list.remove(list.size() - 1);
            helperSubset(start + 1, nums, result, list);
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> result = new ArrayList<>();
        combinationSumHelper(0, list, result, target, candidates);
        return result;

    }

    private static void combinationSumHelper(int start, List<Integer> list, List<List<Integer>> result, int target,
            int[] candidate) {
        if (target == 0) {
            result.add(new ArrayList<>(list));
        } else if (target < 0 || start >= candidate.length) {
            return;
        } else {
            int element = candidate[start];
            list.add(element);
            combinationSumHelper(start, list, result, target - element, candidate);

            list.remove(list.size() - 1);
            combinationSumHelper(start + 1, list, result, target, candidate);
        }

    }

    public static List<List<Integer>> combinationSum3(int k, int n) {
        int[] contains = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> list = new ArrayList<>();
        combinationSum3Helper(0, result, list, k, n, contains);
        return result;

    }

    private static void combinationSum3Helper(int start, List<List<Integer>> result, List<Integer> list,
            int k, int target, int[] contains) {
        if (target == 0 && list.size() == k) {
            result.add(new ArrayList<>(list));
            ;
        } else if (list.size() > k || target < 0 || start >= contains.length) {
            return;
        } else {
            int element = contains[start];
            list.add(element);
            combinationSum3Helper(start + 1, result, list, k, target - element, contains);

            list.remove(list.size() - 1);
            combinationSum3Helper(start + 1, result, list, k, target, contains);
        }

    }

    public static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        boolean[][] isFirstStart = new boolean[row][col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == word.charAt(0)) {
                    if (existBfs(board, 0, word, i, j)) {
                        return true;

                    }

                }

            }
        }
        return false;

    }

    private static boolean existBfs(char[][] board, int i, String word, int r, int c) {
        int row = board.length;
        int col = board[0].length;
        if (i >= word.length()) {
            return true;
        }

        char temp = board[r][c];
        board[r][c] = '#';
        boolean isExist = existBfs(board, i + 1, word, r + 1, c) ||
                existBfs(board, i + 1, word, r - 1, c) ||
                existBfs(board, i + 1, word, r, c + 1) ||
                existBfs(board, i + 1, word, r, c - 1);
        board[r][c] = temp;
        return isExist;
    }

    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            Stack<Integer> set = new Stack<>();
            set.add(nums[i]);
            permuteDfs(nums, set, res);
        }

        return res;
    }

    private static void permuteDfs(int[] nums, Stack<Integer> set, List<List<Integer>> res) {
        List<Integer> arr = new ArrayList<>();
        if (set.size() == nums.length) {
            arr = new ArrayList<>(set.stream().toList());
            res.add(arr);

        }

        for (int n = 0; n < nums.length; n++) {
            if (!set.contains(nums[n])) {
                int val = nums[n];
                set.add(val);
                permuteDfs(nums, set, res);
                set.pop();
            }
        }

    }

    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> stack = new Stack<>();
        combinationSum2BackTrack(candidates, target, 0, stack, res);
        return res;

    }

    private static void combinationSum2BackTrack(int[] candidates, int target, int start,
            List<Integer> list, List<List<Integer>> res) {
        if (target == 0) {
            res.add(new ArrayList<>(list));
        }
        if (target < 0) {
            return;
        }
        for (int i = start; i < candidates.length; i++) {
            if (i > 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            list.add(candidates[i]);
            combinationSum2BackTrack(candidates, target - candidates[i], start + 1, list, res);
            list.remove(list.size() - 1);
        }
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();

        HashMap<List<Integer>, List<Integer>> map = new HashMap<>();
        List<Integer> list = new ArrayList<>();
        int start = 0;
        subsetsWithDupDfs(nums, start, map, list, res);

        return res;
    }

    private static void subsetsWithDupDfs(int[] nums, int start, HashMap<List<Integer>, List<Integer>> map,
            List<Integer> list, List<List<Integer>> res) {
        if (start >= nums.length) {
            list.sort((a, b) -> a - b);
            if (!map.containsKey(list)) {
                map.put(list, list);
                res.add(new ArrayList<>(list));
            }
        } else {
            int element = nums[start];
            list.add(element);
            subsetsWithDupDfs(nums, start + 1, map, list, res);

            list.remove(list.size() - 1);
            subsetsWithDupDfs(nums, start + 1, map, list, res);
        }
    }

    public static List<List<Integer>> subsetsWithDup2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        Stack<Integer> stack = new Stack<>();
        int index = 0;
        subsetsWithDupDfs2(nums, stack, res, index);
        return res;
    }

    private static void subsetsWithDupDfs2(int[] nums, Stack<Integer> stack, List<List<Integer>> res, int index) {
        if (stack.size() <= nums.length) {
            res.add(new ArrayList<>(stack.stream().toList()));
        }

        for (int i = index; i < nums.length; i++) {
            if (i != index && nums[i] == nums[i - 1]) {
                continue;
            }

            int val = nums[i];
            stack.add(val);
            subsetsWithDupDfs2(nums, stack, res, i + 1);
            stack.pop();
        }
    }

    public static List<String> generateParenthesis(int n) {
        int len = n * 2;
        List<String> res = new ArrayList<>();
        List<Character> c = new ArrayList<>();
        int numOpen = 0;
        int numClose = 0;
        backTrackGenerateParanthesis(n, c, res, numOpen, numClose);
        return res;
    }

    private static void backTrackGenerateParanthesis(int n, List<Character> c, List<String> res, int numOpen,
            int numClose) {
        if (c.size() == n * 2) {
            StringBuilder st = new StringBuilder();
            for (char ch : c) {
                st.append(ch);
            }
            res.add(st.toString());
            return;
        }

        // add open Parenthesis
        if (numOpen < n) {
            c.add('(');
            backTrackGenerateParanthesis(n, c, res, numOpen + 1, numClose);
            c.remove(c.size() - 1);
        }

        if (numClose < numOpen) {
            c.add(')');
            backTrackGenerateParanthesis(n, c, res, numOpen, numClose + 1);
            c.remove(c.size() - 1);
        }

    }

    /*
     * using a monotically decreasing stack, we keep track of elements
     * in decreasing order
     */
    public static int[] dailyTemperaturesII(int[] temperature) {
        int[] res = new int[temperature.length];
        Stack<Integer> stack = new Stack<Integer>();
        stack.add(0);
        for (int i = 1; i < temperature.length; i++) {
            while (!stack.isEmpty() && temperature[i] > temperature[stack.peek()]) {
                int position = stack.pop();
                res[position] = i - position;
            }

            stack.add(i);
        }

        while (!stack.isEmpty()) {
            int position = stack.pop();
            res[position] = 0;
        }

        return res;

    }

    public static class KthLargest {

        private List<Integer> arr = new ArrayList<Integer>();
        private int n;

        public KthLargest(int k, int[] nums) {
            arr.add(-1);
            for (int i = 0; i < nums.length; i++) {
                heapify(nums[i] * -1);
            }

            n = k;
            if (nums.length > k) {
                popNElement();
            }

        }

        public void heapify(int val) {
            arr.add(val);
            int indexVal = arr.size() - 1;
            int parentIndex = indexVal / 2;
            while (parentIndex > 0 &&
                    arr.get(indexVal) > arr.get(parentIndex)) {

                int temp = arr.get(indexVal);
                arr.set(indexVal, arr.get(parentIndex));
                arr.set(parentIndex, temp);
                indexVal = parentIndex;
                parentIndex = indexVal / 2;
            }
        }

        public int pop() {
            if (arr.size() == 1) {
                return Integer.MIN_VALUE;
            }

            if (arr.size() == 2) {
                return arr.remove(1);
            }

            int res = arr.get(1);
            arr.set(1, arr.remove(arr.size() - 1));

            int index = 1;
            while (index * 2 < arr.size()) {
                if ((index * 2) + 1 < arr.size() && arr.get((index * 2) + 1) > arr.get(index * 2)
                        && arr.get(index) < arr.get((index * 2) + 1)) {
                    int temp = arr.get((index * 2) + 1);
                    arr.set((index * 2) + 1, arr.get(index));
                    arr.set(index, temp);
                    index = (index * 2) + 1;
                } else if (arr.get(index) < arr.get(index * 2)) {
                    int temp = arr.get(index * 2);
                    arr.set(index * 2, arr.get(index));
                    arr.set(index, temp);
                    index = index * 2;

                } else {
                    break;
                }

            }

            return res;

        }

        public int add(int val) {
            heapify(val * -1);
            int popElement = pop();
            if (arr.size() > 1) {
                return arr.get(1) * -1;

            } else {
                return popElement * -1;
            }

        }

        public void popNElement() {
            for (int i = 0; i < arr.size() - n; i++) {
                int val = pop();
                System.out.println(val);
            }

        }

    }

    public static int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(stones).forEach(pQueue::add);

        while (pQueue.size() > 1) {
            int x = pQueue.poll();
            int y = pQueue.poll();

            int newWeight = Math.abs(y - x);
            if (newWeight > 0) {
                pQueue.add(newWeight);

            }
        }
        if (pQueue.size() > 0) {
            return pQueue.peek();
        }

        return 0;

    }

    public static int[][] kClosest(int[][] points, int k) {
        int[][] ans = new int[k][];
        PriorityQueue<int[]> pQueue = new PriorityQueue<>(
                (a, b) -> Integer.compare((a[0] * a[0]) + (a[1] * a[1]), (b[0] * b[0]) + (b[1] * b[1])));
        for (int i = 0; i < points.length; i++) {
            pQueue.add(points[i]);
        }

        for (int i = 0; i < k; i++) {
            ans[i] = pQueue.poll();
        }

        return ans;

    }

    public static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
        Arrays.stream(nums).forEach(pQueue::add);
        int ans = 0;
        for (int i = 0; i < k; i++) {
            ans = pQueue.poll();
        }

        return ans;
    }

    /**
     * This LRU cache us not optimized the placeInfrontOfStack method uses o(n),
     * it can be optimized using double linkedlist, created a LinkNode
     */

    public static class LRUCache {

        private Deque<Integer> stack;
        private HashMap<Integer, Integer> map;
        private int capacity;

        public LRUCache(int capacity) {
            stack = new ArrayDeque<Integer>();
            map = new HashMap<>();
            this.capacity = capacity;
        }

        public int get(int key) {
            int ans = -1;
            if (map.containsKey(key)) {
                ans = map.get(key);
                placeInFrontOfStack(key);
            }

            return ans;

        }

        public void put(int key, int value) {
            if (isFull() && !map.containsKey(key)) {
                remove();
            }
            add(key, value);

        }

        private boolean isFull() {

            return stack.size() == capacity;
        }

        private void remove() {
            if (!stack.isEmpty()) {
                int key = stack.remove();
                map.remove(key);
            }
        }

        private void add(int key, int value) {
            map.put(key, value);
            placeInFrontOfStack(key);
        }

        public void placeInFrontOfStack(int key) {
            stack.remove(key);
            stack.add(key);

        }
    }

    public static class LRUCacheII {

        public static class Node {
            private int key;
            private int val;
            private Node prev;
            private Node next;

            public Node(int key, int val) {
                this.key = key;
                this.val = val;
                this.prev = null;
                this.next = null;
            }

            @Override
            public int hashCode() {
                final int prime = 31;
                int result = 1 * prime;
                result = prime * result + (prev == null ? 0 : prev.hashCode());
                result = prime * result + (next == null ? 0 : next.hashCode());
                result = prime * result + key;
                result = prime * result + val;
                return result;
            }

            @Override
            public boolean equals(Object obj) {
                if (this == obj)
                    return true;
                if (obj == null)
                    return false;
                if (this.getClass() != obj.getClass())
                    return false;
                Node castNode = (Node) obj;
                if (prev == null) {
                    if (castNode.prev != null)
                        return false;

                } else if (!prev.equals(castNode.prev))
                    return false;

                /** continue the pattern */
                return true;
            }

        }

        /* this give the less recently used Node */
        private Node left;
        /* this gives the most recently used Node */
        private Node right;
        private int capacity;
        private HashMap<Integer, Node> map;

        public LRUCacheII(int capacity) {
            this.left = new Node(0, 0);
            this.right = new Node(0, 0);
            this.left.next = this.right;
            this.right.prev = this.left;
            this.capacity = capacity;
            this.map = new HashMap<>();
        }

        public void remove(Node node) {
            Node prevNode = node.prev;
            Node nextNode = node.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
        }

        public void insert(Node node) {
            Node rightNode = right;
            Node leftNode = right.prev;

            leftNode.next = node;
            right.prev = node;
            node.next = rightNode;
            node.prev = leftNode;

        }

        public int get(int key) {
            if (map.containsKey(key)) {
                Node node = map.get(key);
                this.remove(node);
                this.insert(node);
                return node.val;
            }
            return -1;
        }

        public void put(int key, int value) {
            Node node;
            if (map.containsKey(key)) {
                node = map.get(key);
                remove(node);
            }
            node = new Node(key, value);
            map.put(key, node);
            insert(node);
            if (map.size() > capacity) {
                Node lru = this.left.next;
                remove(lru);
                map.remove(lru.key);
            }
        }

    }
    /*
     * use dfs and backtracking technique, for bfs technique check
     * neecode_150.BasicAlgo.java
     */

    public static int numIslands(char[][] grid) {
        int count = 0;
        int[][] visit = new int[grid.length][grid[0].length];
        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[0].length; c++) {
                if (grid[r][c] == '1' && visit[r][c] == 0) {
                    numberIslandDfsHelper(grid, r, c, visit);
                    count++;
                }
            }
        }
        return count;

    }

    public static void numberIslandDfsHelper(char[][] grid, int r, int c, int[][] visit) {
        int row = grid.length;
        int col = grid[0].length;

        if ((r < 0 || c < 0) || (r >= row || c >= col) || grid[r][c] == '0' || visit[r][c] == 1) {
            return;
        }
        // once visited, we would not be visiting it again
        visit[r][c] = 1;
        numberIslandDfsHelper(grid, r + 1, c, visit);
        numberIslandDfsHelper(grid, r - 1, c, visit);
        numberIslandDfsHelper(grid, r, c + 1, visit);
        numberIslandDfsHelper(grid, r, c - 1, visit);
    }

    public static class GraphMaxArea {

        public static class Point {
            private int r;
            private int c;
            private int l;
            private boolean visited = false;
            private boolean isWaterEscaped = false;

            public Point(int row, int col, int len) {
                this.r = row;
                this.c = col;
                this.l = len;
            }

            public Point(boolean visited, boolean isWaterEscaped) {
                this.visited = visited;
                this.isWaterEscaped = isWaterEscaped;
            }
        }

        public static int maxAreaOfIsland(int[][] grid) {
            int maximum = 0;
            for (int r = 0; r < grid.length; r++) {
                for (int c = 0; c < grid[0].length; c++) {
                    if (grid[r][c] == 1) {
                        Point point = new Point(r, c, 0);
                        maximum = Math.max(maximum, maxAreaOfIslandDfsHelper(grid, point));
                    }

                }
            }
            return maximum;

        }

        private static int maxAreaOfIslandDfsHelper(int[][] grid, Point p) {
            int count;
            int row = grid.length;
            int col = grid[0].length;
            int[][] visit = new int[row][col];
            count = 1;
            Queue<Point> queue = new LinkedList<>();
            queue.add(p);
            while (!queue.isEmpty()) {
                Point x = queue.remove();
                int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
                for (int[] d : directions) {
                    int rr = x.r + d[0];
                    int cc = x.c + d[1];
                    if ((rr >= 0 && rr < row && cc >= 0 && cc < col)
                            && grid[rr][cc] == 1
                            && visit[rr][cc] == 0) {
                        visit[rr][cc] = 1;
                        Point newPoint = new Point(rr, cc, 1);
                        queue.add(newPoint);
                        count++;
                    }

                }
            }

            return count;
        }

        /**
         * this is a variation that needs to add the distance to the point, as you
         * calculate along
         */
        public static int shortestPathBinaryMatrix(int[][] grid) {
            if (grid[0][0] == 1) {
                return -1;
            }

            return shortestPathBinaryMatrixHelper(grid, 0, 0);

        }

        private static int shortestPathBinaryMatrixHelper(int[][] grid, int r, int c) {
            int n = grid.length;
            int[][] visit = new int[n][n];
            visit[r][c] = 1;
            Point point = new Point(r, c, 1);
            Queue<Point> queue = new LinkedList<>();
            queue.add(point);
            while (!queue.isEmpty()) {
                Point x = queue.remove();
                if (x.r == n - 1 && x.c == n - 1) {
                    return x.l;
                }

                int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 },
                        { 1, 1 }, { -1, -1 }, { 1, -1 },
                        { -1, 1 } };
                for (int[] d : directions) {
                    int rr = x.r + d[0];
                    int cc = x.c + d[1];

                    if ((rr >= 0 && rr < n && cc >= 0 && cc < n)
                            && visit[rr][cc] == 0
                            && grid[rr][cc] == 0) {
                        queue.add(new Point(rr, cc, 1 + x.l));
                        visit[rr][cc] = 1;
                    }
                }

            }
            return -1;

        }

        /**
         * my solution, it was not efficient, the
         * idea, is first counting the rotten oranges and add the good oranges
         * to a queue, you can then do a bfs on the rotten oranges
         */
        public static int orangesRotting(int[][] grid) {
            int freshOranges = 0;
            int times = 0;
            int row = grid.length;
            int col = grid[0].length;
            Queue<Point> queue = new ArrayDeque<>();
            for (int r = 0; r < row; r++) {
                for (int c = 0; c < col; c++) {
                    if (grid[r][c] == 2) {
                        queue.add(new Point(r, c, 0));
                    }
                    if (grid[r][c] == 1) {
                        freshOranges = freshOranges + 1;
                    }
                }
            }
            int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            while (!queue.isEmpty() && freshOranges > 0) {
                times++;
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    Point p = queue.remove();
                    for (int[] d : directions) {
                        int rr = p.r + d[0];
                        int cc = p.c + d[1];
                        if ((rr >= 0 && rr < row && cc >= 0 && cc < col)
                                && (grid[rr][cc] == 1)) {
                            grid[rr][cc] = 2;
                            queue.add(new Point(rr, cc, 0));
                            freshOranges = freshOranges - 1;
                        }
                    }
                }

            }
            if (freshOranges == 0) {
                return times;
            }
            return -1;
        }

    }

    public static List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        int row = heights.length;
        int col = heights[0].length;
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        boolean[][] pacificVisited = new boolean[row][col];
        boolean[][] atlanticVisited = new boolean[row][col];

        /*
         * add border of pacific to pacificQueue and initialize it to be visited, same
         * for atlantic queue
         */
        for (int r = 0; r < row; r++) {
            pacificQueue.add(new int[] { r, 0 });
            atlanticQueue.add(new int[] { r, col - 1 });
            pacificVisited[r][0] = true;
            atlanticVisited[r][col - 1] = true;
        }

        for (int c = 0; c < col; c++) {
            pacificQueue.add(new int[] { 0, c });
            atlanticQueue.add(new int[] { row - 1, c });
            pacificVisited[0][c] = true;
            atlanticVisited[row - 1][c] = true;
        }

        findMaxTowardsOceanBfs(heights, pacificQueue, pacificVisited);
        findMaxTowardsOceanBfs(heights, atlanticQueue, atlanticVisited);

        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (pacificVisited[r][c] && atlanticVisited[r][c]) {
                    List<Integer> list = new ArrayList<>();
                    list.add(r);
                    list.add(c);
                    result.add(list);
                }
            }
        }

        return result;

    }

    private static void findMaxTowardsOceanBfs(int[][] heights, Queue<int[]> q, boolean[][] visited) {
        int row = visited.length;
        int col = visited[0].length;
        int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
        while (!q.isEmpty()) {
            int[] cur = q.remove();
            for (int[] d : directions) {
                int rr = d[0] + cur[0];
                int cc = d[1] + cur[1];

                if (rr < row && rr >= 0 && cc < col && cc >= 0 &&
                        !visited[rr][cc] && heights[rr][cc] >= heights[cur[0]][cur[1]]) {
                    q.add(new int[] { rr, cc });
                    visited[rr][cc] = true;
                }
            }

        }

    }

    public static int[] findRedundantConnection(int[][] edges) {
        int totalLength = edges.length + 1;
        Queue<Integer> q = new LinkedList<>();
        List<Integer>[] adj = new ArrayList[totalLength];
        int[] freq = new int[totalLength];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<Integer>();
        }

        for (int[] e : edges) {
            adj[e[1]].add(e[0]);
            freq[e[0]]++;
        }
        for (int i = 0; i < freq.length; i++) {
            if (freq[i] > 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int cur = q.remove();
            for (int neigh : adj[cur]) {
                freq[neigh]--;
                if (freq[neigh] == 0) {
                    q.add(neigh);
                }
            }
        }

        int cycleVertex = -1;
        for (int i = freq.length - 1; i >= 0; i--) {
            if (freq[i] > 0) {
                cycleVertex = i;
                break;
            }
        }

        for (int i = edges.length - 1; i >= 0; i--) {
            if (edges[i][0] == cycleVertex) {
                return edges[i];
            }
        }

        return new int[] {};
    }

    public static class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }

        public Node cloneGraph(Node node) {
            HashMap<Node, Node> map = new HashMap<>();

            if (node == null) {
                return null;
            }
            return cloneDfs(node, map);
        }

        /** fully undertsand this problem */

        public Node cloneDfs(Node oldNode, HashMap<Node, Node> map) {
            Node newNode;
            if (map.containsKey(oldNode)) {
                return map.get(oldNode);
            } else {
                newNode = new Node(oldNode.val);
                map.put(oldNode, newNode);
            }

            for (Node childNode : oldNode.neighbors) {
                Node node = cloneDfs(childNode, map);
                newNode.neighbors.add(node);
            }

            return newNode;
        }

        /**
         * you can use an oject of hashmap ton represent a grap,
         * where the key is the node and value is a list containing
         * it's neighbours (vertex)
         */
        public static HashMap<String, List<String>> buildGraph(String[][] arrs) {
            HashMap<String, List<String>> map = new HashMap<>();
            for (String[] arr : arrs) {
                if (!map.containsKey(arr[0])) {
                    List<String> neighbours = new ArrayList<>();
                    map.put(arr[0], neighbours);
                }

                if (!map.containsKey(arr[1])) {
                    List<String> neighbours = new ArrayList<>();
                    map.put(arr[1], neighbours);
                }

                map.get(arr[0].toString()).add(arr[1]);

            }
            return map;
        }

        /**
         * using dfs we can find the count between start and end
         */
        public static int countToDestination(HashMap<String, List<String>> map, String start, String end) {
            HashSet<String> visited = new HashSet<>();
            return countToDestinationBfs(map, start, end);
        }

        private static int countToDestinationBfs(HashMap<String, List<String>> map, String start, String end) {
            int count = 0;
            Queue<String> queue = new LinkedList<>();
            HashSet<String> visit = new HashSet<>();
            queue.add(start);
            visit.add(start);
            while (!queue.isEmpty()) {
                int len = queue.size();
                for (int i = 0; i < len; i++) {
                    String newStart = queue.remove();
                    if (newStart == end) {
                        return count;
                    }

                    List<String> neighbours = map.get(newStart);
                    for (String s : neighbours) {
                        if (!visit.contains(s)) {
                            queue.add(s);
                            visit.add(s);
                        }
                    }

                }
                count++;
            }

            return count;
        }

        /**
         * this uses a toplogical sort=, if toplogical sort exist, then the course can
         * be
         * completed
         * else if there is a cycle in the graph, the toplogical will be fail, and we
         * can say the
         * courses do not exist
         */
        public static boolean canFinishBfs(int numCourses, int[][] prerequisites) {
            int visit = 0;
            Queue<Integer> queue = new LinkedList<>();
            int[] noOfDegree = new int[numCourses];
            List<Integer>[] arr = new ArrayList[numCourses];
            for (int i = 0; i < arr.length; i++) {
                arr[i] = new ArrayList<>();
            }

            for (int[] pre : prerequisites) {
                arr[pre[1]].add(pre[0]);
                noOfDegree[pre[0]] = noOfDegree[pre[0]] + 1;
            }

            for (int i = 0; i < numCourses; i++) {
                if (noOfDegree[i] == 0) {
                    queue.add(i);
                }
            }

            while (!queue.isEmpty()) {
                int cur = queue.remove();
                visit = visit + 1;
                for (int neigh : arr[cur]) {
                    noOfDegree[neigh] = noOfDegree[neigh] - 1;
                    if (noOfDegree[neigh] == 0) {
                        queue.add(neigh);
                    }
                }

            }

            return visit == numCourses;
        }

        public static int findCircleNum(int[][] isConnected) {
            int n = isConnected.length;
            boolean[] visited = new boolean[n];
            int connectedNo = 0;

            for (int i = 0; i < n; i++) {
                if (!visited[i]) {
                    connectedNo++;
                    findCircleNumBfs(isConnected, i, visited);
                }
            }
            return connectedNo;
        }

        private static void findCircleNumBfs(int[][] isConnected, int city, boolean[] visited) {
            Queue<Integer> queue = new LinkedList<>();
            visited[city] = true;
            queue.add(city);

            while (!queue.isEmpty()) {
                int popedCity = queue.remove();
                for (int i = 0; i < isConnected.length; i++) {
                    if (isConnected[popedCity][i] == 1 && !visited[i]) {
                        visited[i] = true;
                        queue.add(i);
                    }
                }
            }
        }

        public static int[] findOrder(int numCourses, int[][] prerequisites) {
            /** use topological sort */
            int visited = 0;
            int tracker = 0;
            Queue<Integer> q = new LinkedList<>();
            int[] result = new int[numCourses];
            List<Integer>[] adj = new ArrayList[numCourses];
            int[] in = new int[numCourses];

            for (int i = 0; i < numCourses; i++) {
                adj[i] = new ArrayList<>();
            }

            for (int[] pre : prerequisites) {
                adj[pre[1]].add(pre[0]);
                in[pre[0]] = in[pre[0]] + 1;
            }

            for (int i = 0; i < in.length; i++) {
                if (in[i] == 0) {
                    q.add(i);
                    result[tracker++] = i;
                }
            }

            while (!q.isEmpty()) {
                int n = q.remove();
                visited++;
                for (int num : adj[n]) {
                    in[num]--;
                    if (in[num] == 0) {
                        q.add(num);
                        result[tracker++] = num;
                    }
                }
            }

            if (visited == numCourses) {
                return result;

            }

            int[] empty = new int[0];
            return empty;
        }

    }

    public static String alienOrder(String[] words) {
        Map<Character, List<Character>> graph = new HashMap<>();
        Map<Character, Integer> indegree = new HashMap<>();

        for (String word : words) {
            for (Character w : word.toCharArray()) {
                graph.putIfAbsent(w, new ArrayList<Character>());
                indegree.putIfAbsent(w, 0);
            }
        }

        for (int i = 0; i < words.length - 1; i++) {
            String parent = words[i];
            String child = words[i + 1];

            if (parent.length() > child.length() && parent.startsWith(child)) {
                return "";
            }

            for (int j = 0; j < Math.min(parent.length(), child.length()); j++) {
                Character p = parent.charAt(j);
                Character c = child.charAt(j);
                if (p != c) {
                    graph.get(p).add(c);
                    indegree.put(c, indegree.get(c) + 1);
                    break;
                }
            }

        }

        Queue<Character> queue = new LinkedList<>();
        for (Character c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder s = new StringBuilder();
        while (!queue.isEmpty()) {
            Character c = queue.poll();
            s.append(c);

            for (Character neighbour : graph.get(c)) {
                indegree.put(neighbour, indegree.get(neighbour) - 1);
                if (indegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        String result = s.toString();
        if (s.length() < indegree.size()) {
            return "";
        }

        return result;
    }

    public static List<Integer> findMinHeightTrees(int n, int[][] edges) {
        if (n == 1) {
            return Collections.singletonList(0);
        }
        List<Set<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
           graph.add(new HashSet<>());
        }
        
        /* initialize an undirected graph */
        for (int i = 0; i < edges.length; i++) {
            int[] edge = edges[i];
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }
        
        List<Integer> leaves = new ArrayList<>();
        for (int i = 0; i < graph.size(); i++) {
            if (graph.get(i).size() == 1) {
               leaves.add(i);
            }
        }
        
        //remove leave nodes from the graph
        while (n > 2) {
            n = n - leaves.size();
            List<Integer> newLeaves = new ArrayList<>();
            for (int leaf : leaves) {
                //you can do this, remember the leaves contain only one leaf node
                int neigh = graph.get(leaf).iterator().next();
                graph.get(neigh).remove(leaf);
                //when the leaf node has been reduced to one, add it to a new Leaves
                if (graph.get(neigh).size() == 1) {
                    newLeaves.add(neigh);
                }
            }

            leaves = newLeaves;
        }

        return leaves;                           
    }

    public static int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] cache = new int[m][n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                ans = Math.max(ans, dfsIncreasingPath(matrix, cache, i,j));
            
            }
        }
        return ans;
    }

    private static int dfsIncreasingPath(int[][] matrix, int[][] cache, int m, int n) {
        if (cache[m][n] != 0) {
            return cache[m][n];
        }
        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
        int ans = 0;
        for (int[] d : directions) {
            int x = d[0] + m;
            int y = d[1] + n;

            if (x >= 0 && x < matrix.length &&
                    y >= 0 && y < matrix[0].length &&
                    matrix[x][y] > matrix[m][n]) {
                        cache[m][n] = Math.max(cache[m][n], dfsIncreasingPath(matrix, cache, x, y));
            }

        }

        return ++cache[m][n];
    }

    public static int longestIncreasingPathII(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        int result = 0;

        int[][] directions = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };

        Map<Integer, List<int[]>> graph = new HashMap<>();
        int[][] indegree = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                graph.putIfAbsent((i * m) + j, new ArrayList<>());
                for (int[] d : directions) {
                    int x = d[0] + i;
                    int y = d[1] + j;
                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length && matrix[x][y] > matrix[i][j]) {
                        graph.get((i * m) + j).add(new int[] { x, y });
                        indegree[x][y]++;
                    }
                }

            }
        }

        Queue<int[]> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (indegree[i][j] == 0) {
                    queue.offer(new int[] { i, j });
                }
            }
        }

        while (!queue.isEmpty()) {
            int k = queue.size();
            result++;
            for (int i = 0; i < k; i++) {
                int[] cur = queue.poll();
                int r = cur[0];
                int c = cur[1];
                for (int[] neigh : graph.get((r * m) + c)) {
                    int row = neigh[0];
                    int col = neigh[1];
                    indegree[row][col]--;
                    if (indegree[row][col] == 0) {
                        queue.offer(new int[] { row, col });
                    }
                }
            }

        }

        return result;

    }

    /**
     * this is a typical dynamic programming questiuoin that uses recurrence
     * relation
     * learn recurrence relation and you can unlock the key to understanding dynamic
     * programming
     */
    public static int rob(int[] nums) {

        int firstRob = 0;
        int secondRob = 0;
        // [firstRob, secondRob, n, n+1]
        for (int i = 0; i < nums.length; i++) {
            int temp = Math.max(firstRob + nums[i], secondRob);
            firstRob = secondRob;
            secondRob = temp;
        }

        return Math.max(firstRob, secondRob);
    }

    public static int fibRecurrenceRelation(int n) {
        if (n <= 1) {
            return n;
        }

        int[] dp = { 0, 1 };
        for (int i = 2; i <= n; ++i) {
            int temp = dp[1];
            dp[1] = dp[0] + dp[1];
            dp[0] = temp;
        }

        return dp[1];
    }

    public static int factorial(int n, int k) {
        /*
         * nCk = n! /(k! * (n -k)!)
         */
        if (k < 0 || k > n) {
            return 0;
        }

        int fN = getFactorial(n);

        int fK = getFactorial(k);

        int fNK = getFactorial(n - k);
        return fN / (fK * fNK);
    }

    public static int getFactorial(int num) {
        int res = 1;
        if (num == 0) {
            return res;
        }
        for (int i = 1; i <= num; i++) {
            res = res * i;
        }

        return res;
    }

    /**
     * rearrange array ar a1<a2>a3<a4
     */

    public static void rearrange(int[] nums) {
        Arrays.sort(nums);

        for (int i = 1; i < nums.length - 1; i += 2) {
            swapIndex(nums, i, i + 1);
        }
    }

    private static void swapIndex(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;

    }

    /*
     * create a graph and perform a dfs traversal
     */

    public class Graph {
        public Integer vertex;
        public List<Integer>[] adj;

        public Graph(Integer vertex) {
            for (int i = 0; i < vertex; i++) {
                adj[i] = new ArrayList<Integer>();
            }
        }

        public void add(int source, int dest) {
            adj[source].add(dest);

        }

        public void dfs(int start) {
            boolean[] visited = new boolean[vertex];
            dfsTraversal(start, visited);
        }

        public void dfsTraversal(int vertex, boolean[] visited) {
            visited[vertex] = true;
            System.out.println(vertex + " -> ");

            for (int neighbours : adj[vertex]) {
                if (!visited[neighbours]) {
                    dfsTraversal(neighbours, visited);
                }
            }
        }
    }
}
