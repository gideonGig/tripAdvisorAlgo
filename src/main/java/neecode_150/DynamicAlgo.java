package neecode_150;

import java.util.*;

public class DynamicAlgo {

    private static boolean canSum(int target, int[] arr) {
        return checkCanSum(target, arr, new HashMap<>());
    }

    private static boolean checkCanSum(int target, int[] arr, Map<Integer,Boolean> hashMap) {
        if (hashMap.containsKey(target)) {
            return hashMap.get(target);
        }

        if (target == 0) {
            return true;
        }

        if (target < 0) {
            return false;
        }


        for (int value : arr) {
            int remainder = target - value;
            if (checkCanSum(remainder, arr, hashMap)) {
                hashMap.put(target, true);
                return true;
            }

        }

        hashMap.put(target, false);
        return false;
    }

    private static List<List<Integer>> howSum(int target, int[] arr) {

        Map<Integer,List<List<Integer>>> hashMap = new HashMap<>();
        return getHowSum(target, arr, hashMap);
    }

    private static List<List<Integer>> getHowSum(int target, int[] arr, Map<Integer,List<List<Integer>>> hashMap) {

        if (target == 0) {
            List<Integer> baseList = new ArrayList<>();
            List<List<Integer>> result = new ArrayList<>();
            result.add(baseList);
            return result;
        }

        if (target < 0) {
            return new ArrayList<>();
        }

        if (hashMap.containsKey(target)) {
            return hashMap.get(target);
        }

        List<List<Integer>> allPaths = new ArrayList<>();


        for (int value : arr) {
            int remainder = target - value;
            var subPath = getHowSum(remainder, arr, hashMap);
            if (subPath != null) {
                for (List<Integer> path : subPath) {
                    List<Integer> newPath = new ArrayList<>();
                    newPath.add(value);
                    newPath.addAll(path);
                    allPaths.add(newPath);
                }
            }
        }

        hashMap.put(target, allPaths);
        return allPaths;
    }

    private static List<Integer> bestSum(int target, int[] arr) {
        Map<Integer,List<Integer>> hashMap = new HashMap<>();
        return getBestSum(target, arr, hashMap);
    }

    private static List<Integer> getBestSum(int target, int[] arr, Map<Integer,List<Integer>> hashMap) {
        if (target == 0) {
            return new ArrayList<>();
        }

        if (target < 0) {
            return new ArrayList<>();
        }

        if (hashMap.containsKey(target)) {
            return hashMap.get(target);
        }


        List<Integer> previousList = null;

        for (int value : arr) {
            var result = getBestSum(target - value, arr, hashMap);
            if (result != null) {
                var newList = new ArrayList<>(result);
                newList.add(value);
                if (previousList == null || newList.size() < previousList.size()) {
                    previousList = newList;
                }
            }
        }

        hashMap.put(target, previousList);
        return previousList;
    }

    private static boolean canConstruct(String word, String[] arrStr) {
        Map<String,Boolean> hashMap = new HashMap<>();
        return getCanConstruct(word, arrStr, "", hashMap);
    }

    private static boolean getCanConstruct(String word, String[] arrStr, String construct, Map<String,Boolean> hashMap) {
        if (word.equals(construct)) {
            return true;
        }

        if (word.length() < construct.length() || ! word.startsWith(construct)) {
            return false;
        }

        if (hashMap.containsKey(construct)) {
            return hashMap.get(construct);
        }


        for (String str : arrStr) {
            var inWord = construct.concat(str);
            var result = getCanConstruct(word, arrStr, inWord, hashMap);

            if (result) {
                hashMap.put(inWord, true);
                return true;
            }


        }

        hashMap.put(construct, false);
        return false;
    }

    private static int countConstruct(String word, String[] arrStr) {
        Map<String,Integer> hashMap = new HashMap<>();
        return getCountConstruct(word, arrStr, "", hashMap);
    }

    private static int getCountConstruct(String word, String[] arrStr, String construct, Map<String,Integer> hashMap) {
        if (word.equals(construct)) {
            return 1;
        }


        if (word.length() < construct.length() || ! word.startsWith(construct)) {
            return 0;
        }

        if (hashMap.containsKey(construct)) {
            return hashMap.get(construct);
        }

        int previousCount = 0;

        for (String str : arrStr) {
            var newWord = construct.concat(str);
            int res = getCountConstruct(word, arrStr, newWord, hashMap);
            previousCount = previousCount + res;
        }

        hashMap.put(construct, previousCount);
        return previousCount;
    }

    private static List<List<String>> allConstruct(String word, String[] arrString) {
        Map<String,List<List<String>>> hashMap = new HashMap<>();
        return getAllConstruct(word, arrString, "", hashMap);

    }

    private static List<List<String>> getAllConstruct(String word, String[] arrString, String construct,
                                                      Map<String,List<List<String>>> hashMap) {
        if (word.equals(construct)) {
            List<String> baseList = new ArrayList<>();
            List<List<String>> allList = new ArrayList<>();
            allList.add(baseList);
            return allList;
        }

        if (word.length() < construct.length() || ! word.startsWith(construct)) {
            return new ArrayList<>();
        }

        if (hashMap.containsKey(construct)) {
            return hashMap.get(construct);
        }

        List<List<String>> allConstruct = new ArrayList<>();

        for (String str : arrString) {
            String inWord = construct.concat(str);
            List<List<String>> resultList = getAllConstruct(word, arrString, inWord, hashMap);
            for (List<String> strInPath : resultList) {
                var newList = new ArrayList<>(strInPath);
                newList.add(str);
                allConstruct.add(newList);
            }
        }

        hashMap.put(construct, allConstruct);
        return allConstruct;
    }

    private static long fibDPTable(int n) {
        long[] dpTable = new long[n + 1];
        dpTable[0] = 0;
        dpTable[1] = 1;
        for (int i = 2; i < dpTable.length; i++) {
            if (i + 1 >= dpTable.length) {
                dpTable[i] = + dpTable[i] + dpTable[i - 1];
                return dpTable[n];
            }
            dpTable[i] = dpTable[i] + dpTable[i - 1];
            dpTable[i + 1] = dpTable[i + 1] + dpTable[i - 1];
        }

        return dpTable[n];
    }

    public static class Point {

        int x;

        int y;

        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (! (o instanceof Point p)) {
                return false;
            }

            return p.x == x && p.y == y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }

    }

    private static long houseRobber(int[] arrNum) {
        Map<Integer,Long> hashMap = new HashMap<>();
        return getHouseRobber(arrNum, 0, hashMap);
    }

    private static long getHouseRobber(int[] arrNum, int position, Map<Integer,Long> hashMap) {
        if (position >= arrNum.length) {
            return 0;
        }

        if (hashMap.containsKey(position)) {
            return hashMap.get(position);
        }

        long rob = arrNum[position] + getHouseRobber(arrNum, position + 2, hashMap);
        long skip = getHouseRobber(arrNum, position + 1, hashMap);

        long maxNum = Math.max(rob, skip);
        hashMap.put(position, maxNum);
        return maxNum;
    }

    private static long minimumClimbingCost(int[] cost) {
        Map<Integer,Long> hashMap = new HashMap<>();
        return Math.min(getminimumClimbingCost(cost, 0, hashMap),
                getminimumClimbingCost(cost, 1, hashMap));
    }

    private static long getminimumClimbingCost(int[] cost, int position, Map<Integer,Long> hashMap) {
        if (position >= cost.length) {
            return 0;
        }

        if (hashMap.containsKey(position)) {
            return hashMap.get(position);
        }

        long minCost = cost[position] + Math.min(getminimumClimbingCost(cost, position + 1, hashMap),
                getminimumClimbingCost(cost, position + 2, hashMap));

        hashMap.put(position, minCost);
        return minCost;
    }

    /**
     * Beginning of 2DP problems
     */
    private static long gridTraveller(int gridSize) {
        Point position = new Point(gridSize, gridSize);
        Map<Point,Long> hashMap = new HashMap<>();
        return getGridTravellerCount(position, hashMap);
    }

    private static long getGridTravellerCount(Point position, Map<Point,Long> hashMap) {

        if (position.x < 0 || position.y < 0) {
            return 0;
        }

        if (position.x == 0 && position.y == 0) {
            return 1;
        }

        if (hashMap.containsKey(position)) {
            return hashMap.get(position);
        }


        Point newLeftPosition = new Point(position.x - 1, position.y);
        long countInLeft = getGridTravellerCount(newLeftPosition, hashMap);


        Point newRightPosition = new Point(position.x, position.y - 1);
        long countInRight = getGridTravellerCount(newRightPosition, hashMap);

        hashMap.put(position, countInLeft + countInRight);
        return countInRight + countInLeft;
    }

    private static long getBinomialCoefficientDP(int x, int y) {
        int[][] dp = new int[x + 1][y + 1];
        for (int i = 0; i <= x; i++) {
            for (int j = 0; j <= Math.min(i, y); j++) {
                if (j == 0 || i == j) {
                    dp[i][j] = 1;
                } else {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                }
            }
        }

        return dp[x][y];
    }

    private static long binomialCoeffient(int x, int y) {
        Map<Point,Long> hashMap = new HashMap<>();
        return getBinomialCoefficient(x, y, new Point(0, 0), hashMap);
    }

    public static long getBinomialCoefficient(int x, int y, Point point, Map<Point,Long> hashMap) {
        if (point.x > x || point.y > y) {
            return 0;
        }
        if (point.x == x && point.y == y) {
            return 1;
        }

        if (hashMap.containsKey(point)) {
            return hashMap.get(point);
        }

        long pointLeft = getBinomialCoefficient(x, y, new Point(point.x + 1, point.y), hashMap);
        long pointRight = getBinomialCoefficient(x, y, new Point(point.x + 1, point.y + 1), hashMap);

        long resp = pointLeft + pointRight;
        hashMap.put(point, resp);
        return resp;
    }

    private static Set<String> allCommonSubsequence(String s1, String s2) {
        HashMap<String,HashSet<String>> map = new HashMap<>();
        return getAllCommonSubsequence(s1, s2, 0, 0, map);
    }

    private static Set<String> getAllCommonSubsequence(String s1, String s2, int i, int j,
                                                       HashMap<String,HashSet<String>> map) {
        if (i == s1.length() || j == s2.length()) {
            Set<String> base = new HashSet<>();
            base.add("");
            return base;
        }


        String dictKey = i + ":" + j;
        if (map.containsKey(dictKey)) {
            return map.get(dictKey);
        }

        HashSet<String> found = new HashSet<>();

        if (s1.charAt(i) == s2.charAt(j)) {
            var resp = getAllCommonSubsequence(s1, s2, i + 1, j + 1, map);
            var listOfArr = new HashSet<String>();
            for (var str : resp) {
                listOfArr.add(s1.charAt(i) + str);
                found.addAll(listOfArr);
            }
        }
        found.addAll(getAllCommonSubsequence(s1, s2, i + 1, j, map));
        found.addAll(getAllCommonSubsequence(s2, s2, i, j + 1, map));


        map.put(dictKey, found);
        return found;
    }

    private static Set<String> allCommonSubsequenceDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        Set<String>[][] dp = new HashSet[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = new HashSet<>();
                dp[i][j].add("");
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    for (String sub : dp[i - 1][j - 1]) {
                        dp[i][j].add(sub + s1.charAt(i - 1));
                    }
                }

                dp[i][j].addAll(dp[i - 1][j]);
                dp[i][j].addAll(dp[i][j - 1]);
            }
        }

        return dp[m][n];
    }

    private static int[][] editDistancePattern(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];
        int[][] pathWay = new int[m + 1][n + 1];

        for (int i = 0; i <= n; i++) {
            dp[0][i] = i;
        }

        for (int j = 0; j <= m; j++) {
            dp[j][0] = j;
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int deleteCost = 1 + dp[i - 1][j];
                int insertCost = 1 + dp[i][j - 1];
                int replacementCost = 1 + dp[i - 1][j - 1];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                    pathWay[i][j] = 0;
                } else {
                    dp[i][j] = Math.min(replacementCost, Math.min(deleteCost, insertCost));
                    if (dp[i][j] == replacementCost) {
                        pathWay[i][j] = 3;
                    } else if (dp[i][j] == insertCost) {
                        pathWay[i][j] = 1;
                    } else if (dp[i][j] == deleteCost) {
                        pathWay[i][j] = 2;
                    }
                }
            }
        }

        return pathWay;
    }

    private static String pathWayOfEditDistance(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = editDistancePattern(s1, s2);

        for (int i = 0; i <= n; i++) {
            dp[0][i] = 1;
        }

        for (int j = 0; j <= m; j++) {
            dp[j][0] = 2;
        }

        dp[0][0] = -1;
        StringBuilder path = new StringBuilder();
        reconstructPath(s1, s2, m, n, dp, path);
        return path.reverse().toString();
    }

    private static void reconstructPath(String s1, String s2, int i, int j, int[][] dp, StringBuilder path) {
        if (dp[i][j] == -1 || (i == 0 && j == 0)) {
            return;
        }

        if (dp[i][j] == 0) {
            path.append("M");
            reconstructPath(s1, s2, i - 1, j - 1, dp, path);
        }
        if (dp[i][j] == 1) {
            path.append("I");
            reconstructPath(s1, s2, i, j - 1, dp, path);
        }

        if (dp[i][j] == 2) {
            path.append("D");
            reconstructPath(s1, s2, i - 1, j, dp, path);
        }

        if (dp[i][j] == 3) {
            path.append("S");
            reconstructPath(s1, s2, i - 1, j - 1, dp, path);
        }
    }

    private static int longestCommonSubsequenceDP(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                int costOfDelete = dp[i - 1][j];
                int costOfInsert = dp[i][j - 1];

                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(costOfInsert, costOfDelete);
                }
            }
        }

        return dp[m][n];
    }

    private static int maximumMonotoneSubsequence(int[] arr) {
        int m = arr.length;
        int[] dp = new int[m];

        dp[0] = 1;
        int maxSubSequence = 1;

        for (int i = 1; i < m; i++) {
            int maxOfCurrentIndex = 0;
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    maxOfCurrentIndex = Math.max(maxOfCurrentIndex, dp[j]);
                }
            }

            dp[i] = maxOfCurrentIndex + 1;
            maxSubSequence = Math.max(maxSubSequence, dp[i]);
        }

        return maxSubSequence;
    }

    private static Map<Integer,List<Integer>> partitionProblem(int[] arr, int k) {
        int n = arr.length;
        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + arr[i];
        }

        int[][] dp = new int[n + 1][k + 1];

        int[][] split = new int[n + 1][k + 1];

        /*  base case when the partition is 1, get the prefix sum at each point */
        for (int i = 1; i <= n; i++) {
            dp[i][1] = prefix[i];
        }

        for (int p = 2; p <= k; p++) {
            for (int i = 1; i <= n; i++) {
                int minCost = Integer.MAX_VALUE;
                for (int j = 1; j < i; j++) {
                    int left = dp[j][p - 1];
                    int right = prefix[i] - prefix[j];
                    int cost = Math.max(left, right);
                    minCost = Math.min(cost, minCost);
                    split[i][p] = j;
                }

                dp[i][p] = minCost;
            }
        }

        int i = n;
        int j = k;

        List<Integer> splitPoints = new ArrayList<>();
        while (j > 0) {
            int m = split[i][j];
            int point = prefix[i] - prefix[j];
            splitPoints.add(point);
            i = m;
            j--;
        }

        var res = new HashMap<Integer,List<Integer>>();
        res.put(dp[n][k], splitPoints);

        return res;

    }

    private static int minimumTriangulationCost(int[] arr) {
        int n = arr.length;
        int[][] dp = new int[n][n];

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i + 2; j < n; j++) {
                int previousCost = Integer.MAX_VALUE;
                for (int k = i + 1; k < j; k++) {
                    int cost = dp[i][k] + dp[k][j] + calculateLengthOFVertex(i, j, k);
                    previousCost = Math.min(cost, previousCost);
                }
                dp[i][j] = previousCost;
            }
        }

        return dp[0][n - 1];
    }

    private static int calculateLengthOFVertex(int i, int j, int k) {
        return i * j * k;
    }


    /** Assignments on Dynamic Programming from the Algorithm
     * design manual by Steven Skiena
     */

    /**
     * 8-2. [4] Suppose you are given three strings of characters: X, Y , and Z, where |X| = n,
     * |Y | = m, and |Z| = n + m. Z is said to be a shuffle of X and Y iff Z can be
     * formed by interleaving the characters from X and Y in a way that maintains the
     * left-to-right ordering of the characters from each string.
     * (a) Show that cchocohilaptes is a shuffle of chocolate and chips, but chocochilatspe
     * is not.
     * (b) Give an efficient dynamic-programming algorithm that determines whether Z
     * is a shuffle of X and Y . Hint: the values of the dynamic programming matrix
     * you construct should be Boolean, not numeric.
     */
    public static boolean interleavingShuffle(String X, String Y, String Z) {
        int n = X.length();
        int m = Y.length();

        boolean[][] dp = new boolean[n + 1][m + 1];
        dp[0][0] = true;

        // Fill the first row
        for (int i = 1; i <= m; i++) {
            dp[i][0] = dp[i - 1][0] && X.charAt(i - 1) == Z.charAt(i - 1);
        }

        // Fill the first column
        for (int j = 1; j <= n; j++) {
            dp[0][j] = dp[0][j - 1] && Y.charAt(j - 1) == Z.charAt(j - 1);
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = (X.charAt(i - 1) == Z.charAt(i + j - 1) && dp[i - 1][j]) ||
                        (Y.charAt(j - 1) == Z.charAt(i + j - 1) && dp[i][j - 1]);
            }
        }

        return dp[n][m];
    }


    /**
     * The longest common substring (not subsequence) of two strings X and Y is
     * the longest string that appears as a run of consecutive letters in both strings. For
     * example, the longest common substring of photograph and tomography is ograph.
     * 8.10 EXERCISES 311
     * (a) Let n = |X| and m = |Y |. Give a Θ(nm) dynamic programming algorithm
     * for longest common substring based on the longest common subsequence/edit
     * distance algorithm.
     */

    public static int longestCommonSubString(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        int maxLength = 0;
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    maxLength = Math.max(maxLength, dp[i][j]);
                } else {
                    dp[i][j] = 0;
                }
            }
        }

        return maxLength;
    }


    public static String longestCommonSubStringValue(String X, String Y) {
        int m = X.length();
        int n = Y.length();

        String longestString = "";
        String[][] dp = new String[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = "";
            }
        }

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + X.charAt(i - 1) ;
                    if (dp[i][j].length() > longestString.length()) {
                        longestString = dp[i][j];
                    }
                }
            }
        }

        return longestString;
    }

    public static void main(String[] args) {

        System.out.println(longestCommonSubStringValue("chocolate", "mocolaui"));
        int[] arr = new int[]{10, 20, 30, 40};
        var ans = partitionProblem(arr, 2);
        System.out.println(String.format("Max subsequence is : %s", maximumMonotoneSubsequence(arr)));
        String s1 = "democrat";
        String s2 = "republican";
        var path = longestCommonSubsequenceDP(s1, s2);
        System.out.println(path);
    }

}
