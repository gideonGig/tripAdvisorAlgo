package neecode_150;

import java.math.BigDecimal;
import java.util.*;

import utilities.ListNode;
import utilities.TreeNode;

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

        while (start < end) {
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

            list.remove(nums.length - 1);
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
            arr.addLast(val);
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

}
