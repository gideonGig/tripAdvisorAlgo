package amazon_prep;

import java.util.*;

public class Amazon {
    // arrays

    /*
     * Given an array of integers nums and an integer target, return indices of the
     * two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may
     * not use the same element twice.
     * you can return the answer in any order.
     *
     * Input: nums = [2,7,11,15], target = 9
     * Output: [0,1]
     * Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
     */
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int[] res = new int[2];

        for (int i = 0; i < nums.length; i++) {
            Integer rem = target - nums[i];
            if (map.containsKey(rem)) {
                res[0] = i;
                res[1] = map.get(rem);
                return res;
            } else {
                map.put(nums[i], i);
            }
        }

        return res;

    }

    /*
     * Given a string s, find the length of the longest substring without repeating
     * characters.
     * Example 1:
     * Input: s = "abcabcbb"
     * Output: 3
     * Explanation: The answer is "abc", with the length of 3.
     * Example 2:
     * input: s = "bbbbb"
     * Output: 1
     * Explanation: The answer is "b", with the length of 1.
     * Example 3:
     * Input: s = "pwwkew"
     * Output: 3
     * Explanation: The answer is "wke", with the length of 3.
     * Notice that the answer must be a substring, "pwke" is a subsequence and not a
     * substring.
     */
    public static int lengthOfLongestSubstring(String s) {
        HashSet<Character> set = new HashSet<>();
        int max = 0;
        int leftPtr = 0;
        int rightPtr;
        for (rightPtr = 0; rightPtr < s.length(); rightPtr++) {
            Character c = s.charAt(rightPtr);
            while (set.contains(c)) {
                set.remove(s.charAt(leftPtr));
                leftPtr++;
            }
            set.add(c);
            max = Math.max(max, rightPtr - leftPtr + 1);
        }

        return max;
    }

    /*
     * Implement the myAtoi(string s) function, which converts a string to a 32-bit
     * signed integer.
     * The algorithm for myAtoi(string s) is as follows:
     * Whitespace: Ignore any leading whitespace (" ").
     * Signedness: Determine the sign by checking if the next character is '-' or
     * '+', assuming positivity is neither present.
     * Conversion: Read the integer by skipping leading zeros until a non-digit
     * character is encountered or the end of the
     * string is reached. If no digits were read, then the result is 0.
     * Rounding: If the integer is out of the 32-bit signed integer range [-231, 231
     * - 1],
     * then round the integer to remain in the range. Specifically, integers less
     * than -231 should be rounded to -231,
     * and integers greater than 231 - 1 should be rounded to 231 - 1.
     * eturn the integer as the final result.
     *
     */
    public static int myAtoi(String s) {
        int i = 0;
        int n = s.length();
        int sign = 1;
        long result = 0;

        if (s.isEmpty()) {
            return 0;
        }

        while (s.charAt(i) == ' ') {
            i++;
        }

        if (i < n && (s.charAt(i) == '+' || s.charAt(i) == '-')) {
            if (s.charAt(i) == '+') {
                sign = 1;
            } else if (s.charAt(i) == '-') {
                sign = -1;
            }
            i++;
        }

        while (i < n && Character.isDigit(s.charAt(i))) {
            int digit = s.charAt(i) - '0';
            result = (result * 10) + digit;

            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            } else if (sign == -1 && result * sign < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }

            i++;
        }

        result *= sign;
        return (int) result;
    }
    /*
     * You are given an integer array height of length n. There are n vertical lines
     * drawn such that the two endpoints of the
     * ith line are (i, 0) and (i, height[i]).
     * Find two lines that together with the x-axis form a container, such that the
     * container contains the most water.
     * Return the maximum amount of water a container can store.
     * Notice that you may not slant the container.
     */

    public static int maxArea(int[] height) {
        int leftPtr = 0;
        int rightPtr = height.length - 1;
        int max = 0;
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

    /*
     * convert Integer to Roman
     */
    public static String intToRoman(int num) {
        Integer[] numbers = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] roman = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        StringBuilder res = new StringBuilder();
        int n = num;
        for (int i = 0; i < numbers.length; i++) {
            if (n / numbers[i] > 0) {
                int numToDivide = n;
                int times = numToDivide / numbers[i];
                n = numToDivide % numbers[i];

                res.append(roman[i].repeat(Math.max(0, times)));
            }

        }

        return res.toString();

    }

    /*
     * convert roman to integer
     */
    public static int romanToInt(String s) {
        int pre = 0;
        int total = 0;
        HashMap<Character,Integer> map = new HashMap<>();
        map.put('M', 1000);
        map.put('D', 500);
        map.put('C', 100);
        map.put('L', 50);
        map.put('X', 10);
        map.put('V', 5);
        map.put('I', 1);

        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            Integer cur = map.get(c);

            if (pre < cur) {
                total = (total - pre) + (cur - pre);
            } else {
                total = total + cur;
            }

            pre = cur;
        }

        return total;
    }

    /*
     * Given an integer array nums, return all the triplets [nums[i], nums[j],
     * nums[k]]
     * such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
     * Notice that the solution set must not contain duplicate triplets.
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

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
                    List<Integer> cur = new ArrayList<>();
                    cur.add(nums[i]);
                    cur.add(nums[rightPtr]);
                    cur.add(nums[leftPtr]);
                    res.add(cur);
                    leftPtr++;
                    while (nums[leftPtr] == nums[leftPtr - 1] && leftPtr < rightPtr) {
                        leftPtr++;
                    }

                }

            }

        }
        return res;
    }

    public static int strStr(String haystack, String needle) {
        int startIndex = -1;
        int hSize = haystack.length();
        int nSize = needle.length();
        if (nSize > hSize) {
            return startIndex;
        }

        for (int i = 0; i < hSize - nSize + 1; i++) {
            int j = 0;
            while (j < nSize && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }

            if (j == nSize) {
                return i;
            }
        }

        return -1;
    }

    /*
     * Given an integer array nums of length n and an integer target, find three
     * integers in nums such that the sum is closest to target.
     * Return the sum of the three integers.
     * You may assume that each input would have exactly one solution.
     */

    public static int threeSumCloset(int[] nums, int target) {
        Arrays.sort(nums);
        int closeSum = nums[0] + nums[1] + nums[2];
        int n = nums.length;
        for (int i = 0; i < n - 2; i++) {
            int leftPtr = i + 1;
            int rightPtr = n - 1;

            while (leftPtr < rightPtr) {
                int curSum = nums[i] + nums[leftPtr] + nums[rightPtr];
                if (Math.abs(curSum - target) < Math.abs(closeSum - target)) {
                    closeSum = curSum;
                }

                if (curSum < target) {
                    leftPtr++;
                } else if (curSum > target) {
                    rightPtr--;
                } else {
                    return curSum;
                }
            }

        }

        return closeSum;
    }
    /*
     * You are given an n x n 2D matrix representing an image, rotate the image by
     * 90 degrees (clockwise).
     * You have to rotate the image in-place, which means you have to modify the
     * input 2D matrix directly.
     * do NOT allocate another 2D matrix and do the rotation.
     */

    public static void rotateImage(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;

        while (left < right) {
            int top = 0;
            int bottom = matrix.length - 1;
            for (int i = 0; i < right - left; i++) {
                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[right - i][bottom];
                matrix[right - i][bottom] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }

            left++;
            right--;
        }

    }

}
