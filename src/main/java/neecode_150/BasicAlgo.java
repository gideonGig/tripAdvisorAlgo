package neecode_150;

import java.math.BigDecimal;
import java.util.*;

import utilities.ListNode;
import utilities.TreeNode;

public class BasicAlgo {

    public static class MyQueue {
        private Stack<Integer> list1;
        private Stack<Integer> list2;

        public MyQueue() {
            list1 = new Stack();
            list2 = new Stack();
        }

        // always append to list1 and pop from list2
        public void append(Integer value) {
            list1.add(value);
        }

        // efficient algorithm is using 2 stacks for Enqueue and Dequeue Operation..we
        // wuld always pop from list2
        // firt check that list2 is empyy, if it is empty, remove all elements from
        // list1 to list2
        // second always pop from list2
        public Integer dequeue() {
            Integer ans = -1;
            if (list2.isEmpty()) {
                // move all elemets from list1 to list2
                while (!list1.isEmpty()) {
                    list2.add(list1.pop());
                }

            }

            if (!list2.isEmpty()) {
                ans = list2.pop();
            }
            return ans;
        }

    }

    public static class Points {
        private Integer number1;
        private Integer number2;

        public Points(Integer number1, Integer number2) {
            this.number1 = number1;
            this.number2 = number2;
        }
    }

    public static class XPoint {
        private String val1;
        private int val2;

        public XPoint(String val1, int val2) {
            this.val1 = val1;
            this.val2 = val2;
        }
    }

    /**
     * >><<
     **/
    public static String completeAnglesUsingStack(String angles) {
        Stack<Character> stack = new Stack();
        StringBuilder finalStr = new StringBuilder();
        StringBuilder buildStr = new StringBuilder();
        for (Character angle : angles.toCharArray()) {
            if (angle == '<') {
                stack.push(angle);
            } else if (angle == '>') {
                if (!stack.empty()) {
                    stack.pop();
                } else {
                    finalStr.append('<');
                }
            }

            finalStr.append(angle);
        }
        stack.forEach(angle -> buildStr.append('>'));
        finalStr.append(buildStr);

        return finalStr.toString();
    }

    public static int twoSum(Integer[] arr, Integer sum) {

        List<Points> points = new ArrayList();
        Integer found = 0;
        Arrays.sort(arr);
        Integer i = 0;
        Integer j = arr.length - 1;
        while (i < arr.length) {
            Integer lookUp = sum - arr[i];
            while (i < j) {
                if (lookUp.equals(arr[j])) {
                    found += 1;
                    points.add(new Points(found, arr[i]));
                }
                j -= 1;
            }
            i += 1;
            j = arr.length - 1;
        }
        System.out.println(points);
        return found;
    }

    public static Integer coinChange(Integer[] coins, int amount) {
        Integer[] dp = new Integer[amount + 1];
        Arrays.setAll(dp, i -> amount + 1);
        dp[0] = 0;
        for (int i = 1; i < amount + 1; i++) {
            for (int j = 0; j < coins.length; j++) {
                if (i - coins[j] >= 0) {
                    dp[i] = Math.min(dp[i], (1 + dp[i - coins[j]]));
                }
            }
        }

        if (dp[amount] == amount + 1) {
            return -1;
        }

        return dp[amount];
    }

    public static TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode current = root;
        while (current != null) {
            if (p.val > current.val && q.val > current.val) {
                current = current.right;
            } else if (p.val < current.val && q.val < current.val) {
                current = current.left;
            } else {
                return current;
            }
        }
        return current;
    }

    public static int sumOfNaturalNumbers(Integer num) {
        return helpFuncSum(num, 0);
    }

    public static int helpFuncSum(Integer num, Integer ans) {
        if (num == 0) {
            return ans;
        }
        ans = ans + num;
        return helpFuncSum(num - 1, ans);
    }

    public static void mergeSort(Integer[] arr) {
        mergeSortHelper(arr, 0, arr.length - 1);
    }

    public static void mergeSortHelper(Integer[] arr, Integer start, Integer end) {
        if (start < end) {
            Integer mid = start + (end - start) / 2;
            mergeSortHelper(arr, start, mid);
            mergeSortHelper(arr, mid + 1, end);
            merge(arr, start, end, mid);
        }
    }

    public static void merge(Integer[] arr, Integer start, Integer end, Integer mid) {
        Integer[] temp = new Integer[end - start + 1];
        Integer i = start;
        Integer j = mid + 1;
        Integer k = 0;

        while (i <= mid && j <= end) {
            if (arr[i] <= arr[j]) {
                temp[k++] = arr[i++];
            } else {
                temp[k++] = arr[j++];
            }
        }

        while (i <= mid) {
            temp[k++] = arr[i++];
        }

        while (j <= end) {
            temp[k++] = arr[j++];
        }

        for (i = start; i <= end; i++) {
            arr[i] = temp[i - start];
        }

    }

    public static List<Integer> breadthFirstSearch(TreeNode node) {
        if (node == null) {
            return new ArrayList();
        }
        Queue<TreeNode> queue = new LinkedList();
        List<Integer> values = new ArrayList();
        queue.add(node);
        while (!queue.isEmpty()) {
            TreeNode current = queue.remove();
            values.add(current.val);
            if (current.left != null) {
                queue.add(current.left);
            } else if (current.right != null) {
                queue.add(current.right);
            }
        }
        return values;
    }

    public static BigDecimal power(int x, int n) {
        if (x < 0) {
            x = 1 / x;
            n = Math.abs(n);
        }

        return solve(x, n);
    }

    public static BigDecimal solve(int x, int n) {
        if (n == 0) {
            return BigDecimal.valueOf(1.0);
        }

        if (x == 0) {
            return BigDecimal.valueOf(0.0);
        }
        BigDecimal remainder = solve(x, n / 2);
        if (n % 2 == 0) {
            return remainder.multiply(remainder);
        } else {
            return BigDecimal.valueOf(x).multiply(remainder).multiply(remainder);
        }
    }

    public static ListNode findIntersectionBetweenNodes(ListNode a, ListNode b) {
        ListNode ptrA = a;
        ListNode ptrB = b;
        while (ptrA != ptrB) {
            ptrA = (ptrA != null) ? ptrA.next : b;
            ptrB = (ptrB != null) ? ptrB.next : a;
        }

        return ptrA;
    }

    public static int numberOfIsland(char[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        Boolean[][] visited = new Boolean[rows][cols];
        Arrays.stream(visited).forEach(y -> Arrays.fill(y, false));
        int numberIsland = 0;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c] == '1' && !visited[r][c]) {
                    bfs(grid, r, c, visited);
                    numberIsland += 1;

                }
            }
        }
        return numberIsland;
    }

    private static void bfs(char[][] grid, int row, int col, Boolean[][] visited) {
        Queue<Points> queue = new LinkedList();
        queue.add(new Points(row, col));
        visited[row][col] = true;

        while (!queue.isEmpty()) {
            Points position = queue.remove();
            Integer r = position.number1;
            Integer c = position.number2;
            Integer[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (Integer[] points : directions) {
                Integer rr = r + points[0];
                Integer cc = c + points[1];
                if ((rr >= 0 && rr < grid.length) && (cc >= 0 && cc < grid[0].length)
                        && !visited[rr][cc] && grid[rr][cc] == '1') {
                    queue.add(new Points(rr, cc));
                    visited[rr][cc] = true;
                }

            }
        }
    }

    public static int findMaxFish(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int max = 0;
        for (int r = 0; r < row; r++) {
            for (int c = 0; c < col; c++) {
                if (grid[r][c] > 0) {
                    max = Math.max(max, bfsFish(grid, r, c));
                }
            }
        }
        return max;

    }

    private static int bfsFish(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Arrays.stream(visited).forEach(arr -> Arrays.fill(arr, false));
        Queue<Points> queue = new LinkedList<>();
        queue.add(new Points(row, col));
        visited[row][col] = true;
        int fishCash = 0;
        while (!queue.isEmpty()) {
            Points p = queue.remove();
            fishCash = grid[p.number1][p.number2] + fishCash;
            int[][] directions = { { 1, 0 }, { -1, 0 }, { 0, 1 }, { 0, -1 } };
            for (int[] d : directions) {
                int r = p.number1 + d[0];
                int c = p.number2 + d[1];
                if ((r >= 0 && r < m) && (c >= 0 && c < n) && grid[r][c] > 0 && !visited[r][c]) {
                    visited[r][c] = true;
                    queue.add(new Points(r, c));
                }

            }

        }
        return fishCash;
    }

    public static int twitterWaterFall(int[] arr) {
        int totalSum = 0;
        int[] maxRightArr = new int[arr.length];
        int[] maxLeftArr = new int[arr.length];
        int maxRight = 0;
        int maxLeft = 0;
        for (int i = 0; i < arr.length; i++) {
            maxRight = Math.max(maxRight, arr[i]);
            maxRightArr[i] = maxRight;
        }

        for (int i = 0; i < arr.length; i++) {
            int p = arr.length - 1 - i;
            maxLeft = Math.max(maxLeft, arr[p]);
            maxLeftArr[p] = maxLeft;
        }

        for (int i = 0; i < arr.length; i++) {
            totalSum += Math.min(maxLeftArr[i], maxRightArr[i]) - arr[i];
        }
        return totalSum;
    }

    public static String convertIntToRoman(int number) {
        XPoint[] maps = { new XPoint("M", 1000),
                new XPoint("CM", 900), new XPoint("D", 500), new XPoint("CD", 400), new XPoint("C", 100),
                new XPoint("XC", 90), new XPoint("L", 50), new XPoint("XL", 40), new XPoint("X", 10),
                new XPoint("IX", 9),
                new XPoint("V", 5), new XPoint("IV", 4), new XPoint("I", 1) };

        StringBuilder ans = new StringBuilder();
        for (XPoint p : maps) {
            String romanNumeral = p.val1;
            int val = p.val2;
            if (number / val > 0) {
                int times = number / val;
                for (int i = 0; i < times; i++) {
                    ans.append(romanNumeral);
                }
                number = number % val;
            }
        }
        return ans.toString();
    }

    public static boolean validParathensis(String str) {
        char[] strArr = str.toCharArray();
        HashMap<Character, Character> map = new HashMap<>();
        map.put('[', ']');
        map.put('{', '}');
        map.put('(', ')');
        Stack<Character> stack = new Stack<>();
        for (char c : strArr) {
            if (map.containsKey(c)) {
                stack.add(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    Character pop = stack.pop();
                    if (c != map.get(pop)) {
                        return false;
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }
        return true;
    }

    public static ListNode mergeTwoSortedList(ListNode nodeA, ListNode nodeB) {
        ListNode cur = new ListNode();
        ListNode ref = cur;
        ListNode curA = nodeA;
        ListNode curB = nodeB;

        while (curA != null && curB != null) {
            if (curA.val < curB.val) {
                ref.next = curA;
                curA = curA.next;

            } else {
                ref.next = curB;
                curB = curB.next;
            }
            ref = ref.next;
        }

        if (curA != null) {
            ref.next = curA;
        }
        if (curB != null) {
            ref.next = curB;
        }
        return cur;
    }

    // using array is not making it memory efficient, we can use a merge sort
    public static ListNode sortList(ListNode head) {
        ListNode cur = head;
        List<Integer> arr = new ArrayList();
        // copy the list1 into an array, sort it and copy it back.
        while (cur != null) {
            arr.add(cur.val);
            cur = cur.next;
        }

        Collections.sort(arr);
        cur = head;
        int i = 0;
        while (i < arr.size()) {
            cur.val = arr.get(i);
            cur = cur.next;
            i += 1;
        }

        return head;
    }

    // solve this challenge later
    public static void rotateByOne(int[][] matrix) {
        int left = 0;
        int right = matrix.length - 1;
        int top = 0;
        int bottom = matrix.length - 1;
        while (top < bottom || left < right) {
            int temp = matrix[left][top];
            int i = bottom;
            while (i > top) {
            }
        }
    }

    public static int kthSmallest(TreeNode root, int k) {
        // using depth first search inorder traversal, inorder trasversal make sure you
        // each the end of the left subtree
        // before
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        stack.add(cur);
        while (true) {
            while (cur != null) {
                stack.add(cur);
                cur = cur.left;
            }
            TreeNode node = stack.pop();
            if (--k == 0) {
                return node.val;
            }
        }
    }

    public static List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        boolean leftSided = true;
        while (!queue.isEmpty()) {
            int levelSize = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < levelSize; i++) {
                TreeNode cur = queue.remove();
                if (leftSided) {
                    list.add(cur.val);
                } else {
                    list.add(0, cur.val);
                }

                if (cur.left != null) {
                    queue.add(cur.left);
                }

                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }

            leftSided = !leftSided;
            ans.add(list);
        }

        return ans;
    }

    /*** LINKED LIST QUESTION ***/
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode curA = headA;
        ListNode curB = headB;

        while (curA != curB) {
            curA = curA != null ? curA.next : headB;
            curB = curB != null ? curB.next : headA;
        }
        return curA;
    }

    public static ListNode oddEvenList(ListNode head) {
        ListNode odd = head;
        ListNode even = head.next;
        ListNode oddPtr = odd;
        ListNode evenPtr = even;

        // link evenNodes and oddNodes
        while (evenPtr != null && evenPtr.next != null) {
            oddPtr.next = evenPtr.next;
            oddPtr = oddPtr.next;
            evenPtr.next = oddPtr.next;
            evenPtr = evenPtr.next;
        }
        oddPtr.next = null;

        // reverse the evenPtr node
        ListNode prev = null;
        ListNode cur = even;
        ListNode nextNode;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }
        even = prev;

        // merge both oddNode and evenNode
        ListNode mergedNode = new ListNode();
        ListNode ptr = mergedNode;

        while (even != null || odd != null) {
            while (odd != null) {
                ptr.next = odd;
                odd = odd.next;
                ptr = ptr.next;
            }

            while (even != null) {
                ptr.next = even;
                even = even.next;
                ptr = ptr.next;
            }

        }

        return mergedNode.next;
    }

    public static ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode cur = head;
        ListNode prev = null;
        ListNode nextNode;

        while (cur != null) {
            nextNode = cur.next;
            cur.next = prev;
            prev = cur;
            cur = nextNode;
        }

        return prev;

    }

    // could not solve this, yet.... not all test cases passed, and code is not
    // memory efficient, it needs to be optimized
    public static ListNode reverseEvenLengthGroups(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode dummyPtr = dummy;
        ListNode cur = head;

        return dummy.next;
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || head.next == null) {
            return head;
        }
        // set a dummy node and use a two pointer technique;
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode dummyPtr = dummy;
        int i = 1;
        while (i < left) {
            dummyPtr = cur;
            cur = cur.next;
            i = i + 1;
        }

        ListNode prev = null;
        int j = 0;
        while (j < right - left + 1) {
            ListNode temp = cur.next;
            cur.next = prev;
            prev = cur;
            cur = temp;
            j++;
        }

        dummyPtr.next.next = cur;
        dummyPtr.next = prev;
        return dummy.next;
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode();
        ListNode sumPtr = sum;

        ListNode l1Ptr = l1;
        ListNode l2Ptr = l2;
        int carryOver = 0;
        while (l1Ptr != null && l2Ptr != null) {
            int val = l1Ptr.val + l2Ptr.val + carryOver;
            carryOver = val / 10;
            sumPtr.next = new ListNode(val % 10);
            sumPtr = sumPtr.next;
            l1Ptr = l1Ptr.next;
            l2Ptr = l2Ptr.next;
        }

        while (l1Ptr != null) {
            int val = l1Ptr.val + carryOver;
            carryOver = val / 10;
            sumPtr.next = new ListNode(val % 10);
            sumPtr = sumPtr.next;
            l1Ptr = l1Ptr.next;
        }

        while (l2Ptr != null) {
            int val = l2Ptr.val + carryOver;
            carryOver = val / 10;
            sumPtr.next = new ListNode(val % 10);
            sumPtr = sumPtr.next;
            l2Ptr = l2Ptr.next;
        }

        if (carryOver > 0) {
            sumPtr.next = new ListNode(carryOver);
        }

        return sum.next;
    }

    // you can use two pointer technique to solve this, the cur pointer will move in
    // n step first,
    // then the second pointer will move, when the cur pointer is null skip the
    // second pointer next by setting
    // second pointer's next to next.next
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        // we can use two pointer technique for this
        ListNode pre = new ListNode(0, head);
        ListNode cur = head;
        ListNode prePtr = pre;
        int i = 0;
        while (cur != null && i < n) {
            cur = cur.next;
            i++;
        }

        while (cur != null) {
            prePtr = prePtr.next;
            cur = cur.next;
        }

        prePtr.next = prePtr.next.next;
        return pre.next;

    }

    // study this swap node clearly...you watched neetcode for this..
    public static ListNode swapPairs(ListNode head) {
        ListNode prev = new ListNode(0, head);
        ListNode prevPtr = prev;
        ListNode cur = head;

        while (cur != null && cur.next != null) {
            // save the initial pointers
            ListNode secondPtr = cur.next;
            ListNode secondNextPtr = cur.next.next;
            // repoint the pointer
            secondPtr.next = cur;
            cur.next = secondNextPtr;
            prevPtr.next = secondPtr;

            // update the nodes
            prevPtr = cur;
            cur = cur.next;
        }

        return prev.next;

    }

    // you solved this yourself but took time, always look out for nulls, null
    // should not start the beginning of a newNode,
    // don't forget to always iterate thougha linkedList by the pointers.
    // avoid circular linkedlist;
    // always changed the pointer of the linkedList to avoid circular linked list,
    // if a points to b, b can point to a,
    // only when a points to c and not b. if a points to b and b points to a, you
    // have a circular linkedList,
    // learn how to derefence yout linkedList;
    public static ListNode rotateRight(ListNode head, int k) {
        // alway know that the amount of rotation k is equal to the amount of rotation k
        // % (len of ListNodes)..
        ListNode cur = head;
        if (head == null || head.next == null || k == 0) {
            return head;
        }
        int i = 0;
        while (cur != null) {
            cur = cur.next;
            i++;
        }

        k = k % i;

        return rotate(head, k);
    }

    public static ListNode rotate(ListNode head, int k) {
        ListNode pre = new ListNode(0, head);
        ListNode prePtr = pre;
        ListNode cur = head;

        while (k > 0) {
            cur = cur.next;
            k--;
        }

        while (cur != null) {
            cur = cur.next;
            prePtr = prePtr.next;
        }
        ListNode startNew = prePtr.next;
        prePtr.next = null;

        ListNode startPtr = startNew;
        if (startPtr == null) {
            return pre.next;
        } else {
            while (startPtr.next != null) {
                startPtr = startPtr.next;
            }
            startPtr.next = pre.next;
        }

        return startNew;
    }

    public static ListNode removeDuplicateNode(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode prePtr = dummy;

        cur = cur.next;
        prePtr = prePtr.next;

        while (cur != null) {
            if (prePtr.val != cur.val) {
                prePtr = prePtr.next;
            } else {
                prePtr.next = cur.next;
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    /**
     * public static ListNode deleteDuplicates(ListNode head) {
     * ListNode dummy = new ListNode(0, head);
     * ListNode prev = dummy;
     * ListNode cur = head;
     * 
     * if (cur.next != null && cur.next.val == cur.val) {
     * while (cur.next != null && cur.next.val == cur.val) {
     * cur = cur.next;
     * }
     * cur.next = null;
     * cur = cur.next;
     * prev.next = cur;
     * } else {
     * prev = cur;
     * cur = cur.next;
     * }
     * }
     **/

    // you solved this yourself, have two pointers that points to the head,
    // move the less pointer only when when the current pointer value is less than
    // the value
    // move the greater than pointer only when the current pointer is greater than
    // the value,
    // break the greater pointer at the end, because the next will always point at
    // the lastcurrent values next
    // set the less pointer to point to the GreaterNode's next
    public static ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, null);
        ListNode dummy2 = new ListNode(0, null);
        ListNode cur = head;
        ListNode less = dummy;
        ListNode great = dummy2;

        while (cur != null) {
            if (cur.val < x) {
                less.next = cur;
                less = less.next;
            } else {
                great.next = cur;
                great = great.next;

            }
            cur = cur.next;
            great.next = null;
        }

        less.next = dummy2.next;
        return dummy.next;
    }

    public static TreeNode sortedListToBST(ListNode head) {
        // using two pointer technique
        return null;

    }

    // I solved this myself, please remember this, the technique here is to save the
    // curent and previous pointers
    // before updatiung them
    public static ListNode insertGreatestCommonDivisors(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0, head);
        ListNode cur = head.next;
        ListNode prev = dummy.next;

        while (cur != null) {
            ListNode divNode = checkCommonDivior(prev, cur);
            if (divNode != null) {
                ListNode oldCurNext = cur.next;
                ListNode oldPrevNext = prev.next;
                prev.next = divNode;
                divNode.next = cur;

                cur = oldCurNext;
                prev = oldPrevNext;
            } else {
                cur = cur.next;
                prev = prev.next;
            }
        }

        return dummy.next;
    }

    private static ListNode checkCommonDivior(ListNode prevNext, ListNode curNext) {
        int preNo = prevNext.val;
        int curNo = curNext.val;

        int minNo = Math.min(preNo, curNo);
        int gce = 0;

        while (minNo > 0) {
            int preGce = preNo % minNo;
            int curGce = curNo % minNo;
            if (preGce == 0 && curGce == 0) {
                gce = minNo;
                break;
            }
            minNo--;
        }

        if (gce > 0) {
            return new ListNode(gce);
        }

        return null;
    }

    // I also solved this, it is very simple, just multiply every Node by 2, if it
    // is 2 decimal places
    // i.e greater than 9, add 1 to the prev Node before it, or set the new Node
    public static ListNode doubleIt(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode(0, head);
        ListNode cur = head;
        ListNode prev = dummy;
        while (cur != null) {
            int val = cur.val * 2;
            if (val > 9) {
                int newVal = val % 10;
                int remVal = val / 10;
                cur.val = newVal;
                prev.val = prev.val + remVal;
            } else {
                cur.val = val;
            }
            cur = cur.next;
            prev = prev.next;
        }

        if (dummy.val == 0) {
            return dummy.next;
        }
        return dummy;
    }

    public static int[][] spiralMatrix(int m, int n, ListNode head) {
        int[][] result = new int[m][n];
        Arrays.stream(result).forEach(arr -> Arrays.fill(arr, -1));

        int left = 0;
        int right = n;
        int top = 0;
        int bottom = m;

        ListNode cur = head;
        while ((left < right) && (top < bottom)) {
            // move from left to right
            for (int i = left; i < right; i++) {
                if (cur != null) {
                    result[top][i] = cur.val;
                } else {
                    break;
                }
                cur = cur.next;
            }
            top = top + 1;

            // move from top to bottom
            for (int i = top; i < bottom; i++) {
                if (cur != null) {
                    result[i][right - 1] = cur.val;
                } else {
                    break;
                }
                cur = cur.next;
            }
            right = right - 1;

            if (!((left < right) && (top < bottom))) {
                break;
            }

            // move from right to left
            for (int i = right - 1; i >= left; i--) {
                if (cur != null) {
                    result[bottom - 1][i] = cur.val;
                } else {
                    break;
                }
                cur = cur.next;
            }
            bottom = bottom - 1;

            // move from bottom to top
            for (int i = bottom - 1; i >= top; i--) {
                if (cur != null) {
                    result[i][left] = cur.val;
                } else {
                    break;
                }
                cur = cur.next;
            }
            left = left + 1;

        }

        return result;
    }

    // study thgis longestValidParenthesis again, know how it works

    public int longestValidParentheses(String s) {
        if (s.isEmpty())
            return 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        Integer maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.isEmpty()) {
                    stack.push(i);
                } else {
                    int length = stack.peek();
                    maxLen = Math.max(maxLen, length);
                }
            }
        }
        return maxLen;
    }

    public static int findKthLargest(int[] nums, int k) {
        // sort the arr, using QuickSort
        nums = quickSort(nums, 0, nums.length - 1);
        return nums[nums.length - k];
    }

    // the wuick sort on uses an o(n*n) runtime order
    private static int[] quickSort(int[] nums, int startIndex, int endIndex) {
        // base case
        if (endIndex - startIndex + 1 <= 1)
            return nums;
        int pivotElement = nums[endIndex];
        int leftPtr = startIndex;

        for (int i = startIndex; i < endIndex; i++) {
            if (nums[i] < pivotElement) {
                int temp = nums[i];
                nums[i] = nums[leftPtr];
                nums[leftPtr] = temp;
                leftPtr++;
            }
        }

        nums[endIndex] = nums[leftPtr];
        nums[leftPtr] = pivotElement;

        quickSort(nums, startIndex, leftPtr - 1);
        quickSort(nums, leftPtr + 1, endIndex);

        return nums;
    }

    public static class QuickUnion {
        private int[] arr;
        /*
         * for optimization, we can introducing a union by rank
         * which reduces the find time complexity from o(n) to 0(logn)
         */
        private int[] rank;

        public QuickUnion(int[] numArr) {
            arr = numArr;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
                rank[i] = 1;
            }
        }

        public void quickUnion(int a, int b) {
            if (a > arr.length - 1 || b > arr.length) {
                return;
            }

            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                arr[rootB] = rootA;
            }
        }

        public int find(int a) {
            if (a > arr.length - 1) {
                return -1;
            }

            while (arr[a] != a) {
                a = arr[a];
            }

            return a;
        }

        public void unionByRank(int a, int b) {
            int rootA = find(a);
            int rootB = find(b);

            if (rootA != rootB) {
                if (rank[rootA] > rank[rootB]) {
                    arr[rootB] = rootA;
                } else if (rank[rootA] < rank[rootB]) {
                    arr[rootA] = rootB;
                } else {
                    arr[rootB] = rootA;
                    rank[rootA] = rank[rootA] + 1;
                }
            }
        }

        public boolean isConnected(int a, int b) {
            return find(a) == find(b);
        }
    }

    public static class QuickFind {
        private int[] arr;

        public QuickFind(int[] numArr) {
            arr = numArr;
            for (int i = 0; i < arr.length; i++) {
                arr[i] = i;
            }
        }

        public int quickFind(int a) {
            return arr[a];
        }

        public void union(int a, int b) {
            int rootA = quickFind(a);
            int rootB = quickFind(b);

            if (rootA != rootB) {
                for (int i = 0; i < arr.length; i++) {
                    if (arr[i] == rootA) {
                        arr[i] = rootB;
                    }
                }
            }
        }

        public boolean isConnected(int a, int b) {
            return quickFind(a) == quickFind(b);
        }

    }

    /** not finished yet **/
    public int leastInterval(char[] tasks, int n) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            Character val = Character.valueOf(tasks[i]);
            if (map.containsValue(val)) {
                map.put(val, map.get(val) + 1);
            } else {
                map.put(val, 1);
            }
        }

        return n;

    }
    
    /* use topological sort for clarity */
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int visit = 0;
        int[] result = new int[numCourses];
        Queue<Integer>  queue = new LinkedList<>();
        int[] freq = new int[numCourses];
        List<Integer>[] adj = new ArrayList[numCourses];
        for (int i = 0; i < adj.length; i++) {
            adj[i] = new ArrayList<>();
        }

        for (int[] pre : prerequisites) {
            adj[pre[1]].add(pre[0]);
            freq[pre[0]]++;
        }

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] == 0) {
                queue.add(i);
            }
        }

        while(!queue.isEmpty()) {
            int cur = queue.poll();
            result[visit++] = cur;
            for (int neigh : adj[cur]) {
                freq[neigh]--;
                if (freq[neigh] == 0) {
                    queue.add(neigh);
                }
            }
        }

        if (visit == numCourses) {
            return result;

        }

        result = new int[0];
        return result;
    }

}
