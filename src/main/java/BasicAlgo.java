import java.math.BigDecimal;
import java.util.*;
public class BasicAlgo {

    public static class ListNode {
        private Integer val;
        private ListNode next;

        public ListNode() {

        }

        public ListNode(Integer val) {
            this.val = val;
            this.next = null;
        }

        public ListNode(Integer val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public Integer getVal() {
            return val;
        }

        public ListNode getNext() {
            return next;
        }

        public String stringifyNode() {
            StringBuilder builder = new StringBuilder();
            ListNode ref = this;
            while (ref != null) {
                builder.append(ref.val);
                ref = ref.next;
                if (ref != null) {
                    builder.append("->");
                }
            }
            return builder.toString();
        }

    }

    public static class MyQueue {
        private Stack<Integer> list;
        private Stack<Integer> list2;

        public MyQueue() {
            list = new Stack();
            list2 = new Stack();
        }

        public void append(Integer value) {
            list.add(value);
        }

        //this is an ineffcient algorithm, as for every pop operation it runs an 0(n)
        public Integer pop() {
            Integer ans = -1;
            Integer lengthList = list.size();
            Integer newArrlength = lengthList - 1;
            Integer[] arr = new Integer[lengthList - 1];
            for (int i = 0; i < lengthList; i++) {
                Integer value = list.pop();
                if (i == lengthList - 1) {
                    ans = value;
                } else {
                    arr[newArrlength - i - 1] = value;
                }
            }

            list = new Stack();
            Collections.addAll(list, arr);
            return ans;
        }

        //efficient algorithm is using 2 stacks for Enqueue and Dequeue Operation..we wuld always pop from list2
        public Integer dequeue() {
            Integer ans = -1;
            if (list2.isEmpty()) {
                //move all elemets from list to list2
                while (!list.isEmpty()) {
                    list2.add(list.pop());
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

    public static class TreeNode {
        public int value;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int value, TreeNode left, TreeNode right) {
            this.value = value;
            this.left = left;
            this.right = right;
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
            if (p.value > current.value && q.value > current.value) {
                current = current.right;
            } else if (p.value < current.value && q.value < current.value) {
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
            //we want to exactly replace arr[i] position with values in temp such that i - start starts from 0..
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
            values.add(current.value);
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
                    int num = 0;
                    bfs(grid, r, c, visited);
                    numberIsland += 1;

                }
            }
        }
        return numberIsland;
    }

    public static void bfs(char[][] grid, int row, int col, Boolean[][] visited) {
        Queue<Points> queue = new LinkedList();
        queue.add(new Points(row, col));
        visited[row][col] = true;
        Integer times = 0;

        while (!queue.isEmpty()) {
            Points position = queue.remove();
            Integer r = position.number1;
            Integer c = position.number2;
            Integer[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
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

    public static int bfsFish(int[][] grid, int row, int col) {
        int m = grid.length;
        int n = grid[0].length;
        boolean[][] visited = new boolean[m][n];
        Arrays.stream(visited).forEach(arr -> Arrays.fill(arr, false));
        Queue<Points> queue = new LinkedList();
        queue.add(new Points(row, col));
        visited[row][col] = true;
        int fishCash = 0;
        while (!queue.isEmpty()) {
            Points p = queue.remove();
            fishCash = grid[p.number1][p.number2] + fishCash;
            int[][] directions = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
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
        XPoint[] maps = {new XPoint("M", 1000),
                new XPoint("CM", 900), new XPoint("D", 500), new XPoint("CD", 400), new XPoint("C", 100),
                new XPoint("XC", 90), new XPoint("L", 50), new XPoint("XL", 40), new XPoint("X", 10), new XPoint("IX", 9),
                new XPoint("V", 5), new XPoint("IV", 4), new XPoint("I", 1)};

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
            System.out.println(cur.getNext().stringifyNode());
        }

        if (curA != null) {
            ref.next = curA;
        }
        if (curB != null) {
            ref.next = curB;
        }
        return cur;
    }

    public static ListNode sortList(ListNode head) {
        ListNode cur = head;
        List<Integer> arr = new ArrayList();
        //copy the list into an array, sort it and copy it back.
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

    public static void rotate(int[][] matrix) {
        int left = 0;
        int right = matrix[0].length - 1;
        while (left < right) {
            for (int i = 0; i < right - left; i++) {
                int top = 0;
                int bottom = matrix.length - 1;

                int temp = matrix[top][left + i];
                matrix[top][left + i] = matrix[bottom - i][left];
                matrix[bottom - i][left] = matrix[bottom][right - i];
                matrix[bottom][right - i] = matrix[top + i][right];
                matrix[top + i][right] = temp;
            }
            left += 1;
            right -= 1;
        }
    }

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
}




