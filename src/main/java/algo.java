import neecode_150.BasicAlgo;
import neecode_150.NeetCode;
import neecode_150.NeetCode.MyStack;
import utilities.ListNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import mastercard.MySingleton;

public class algo {

        public static void main(String[] args) throws InterruptedException {

                /** Beginning of Thread1 **/ 

                /**
                 * Thread2 thread2 = new Thread2();
                 * thread2.createThread2();
                 * 
                 * InteruptThread interuptThread = new InteruptThread(BigDecimal.valueOf(10),
                 * 3);
                 * interuptThread.interuptThread();
                 **/

                // Basics test = new Basics();
                /**
                 * Object c = test.check(50);
                 * System.out.println(c.getClass().toString());
                 * 
                 * test.testObjecEquality();
                 **/

                // test.calculateValue("*", 2.0f, 10.0f);
                // test.testGenerics();

                /**
                 * Integer{} arr = {1,3,4,5};
                 * Integer coin = neecode_150.BasicAlgo.coinChange(arr, 7);
                 * System.out.println(coin);
                 * 
                 * int sum = neecode_150.BasicAlgo.sumOfNaturalNumbers(10);
                 * System.out.println(sum);
                 **/

                /*
                 * Integer{} unsortedArr = {-3, 0, 2, 1, 5, 7, 6};
                 * neecode_150.BasicAlgo.mergeSort(unsortedArr);
                 * Arrays.stream(unsortedArr).forEach(System.out::println);
                 */

                /*
                 * neecode_150.BasicAlgo.MyQueue queue = new neecode_150.BasicAlgo.MyQueue();
                 * queue.append(10);
                 * queue.append(20);
                 * queue.append(30);
                 * queue.append(40);
                 * queue.append(50);
                 * System.out.println(queue.dequeue());
                 *
                 */
                
                 /*
                 BasicAlgo algo = new BasicAlgo();
                 int[][] prerequisites = {{1,0}, {2,0}, {3,1}, {3,2}};
                 System.out.println(algo.findOrder(4, prerequisites));
                 /*


                /*
                 * BigDecimal pow = neecode_150.BasicAlgo.power(16, 0);
                 * System.out.println(pow);
                 */

                /**
                 * ListNode nodeA = new ListNode(1,
                 * new ListNode(2, new ListNode(3,
                 * new ListNode(4))));
                 * 
                 * 
                 * ListNode nodeB = new ListNode(4,
                 * new ListNode(6, new ListNode(8,
                 * new ListNode(10))));
                 * ListNode node = neecode_150.BasicAlgo.findIntersectionBetweenNodes(nodeA, nodeB);
                 * 
                 * System.out.println(node.getVal());
                 **/
                /**
                 * char[][] arr = {{'1', '1', '1', '1', '0'},
                 * {'1','1','0','1','0'},
                 * {'1','1','0','0','0'},
                 * {'0','0','0','0','0'} };
                 * int times = neecode_150.BasicAlgo.numberOfIsland(arr);
                 * System.out.println(times);
                 */

                /*
                 * int[][] fishArr = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
                 * int maxFish = neecode_150.BasicAlgo.findMaxFish(fishArr);
                 * System.out.println(maxFish);
                 **/

                /**
                 * tic_tac_game.TicTac game = new tic_tac_game.TicTac();
                 * Boolean isWin = false;
                 * while (isWin == false) {
                 * game.drawBoard();
                 * game.chooseSpot();
                 * if (game.checkWin()) {
                 * isWin = true;
                 * System.out.println(String.format("player" + game.getPlayer() + "has won the
                 * game"));
                 * } else if (game.checkBoardFull()) {
                 * game.drawBoard();
                 * isWin = true;
                 * System.out.println("Game is a draw");
                 * }
                 * game.togglePlayer();
                 * }
                 **/

                /**
                 * int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
                 * System.out.println(neecode_150.BasicAlgo.twitterWaterFall(arr));
                 */

                /*
                 * System.out.println(neecode_150.BasicAlgo.convertIntToRoman(1670));
                 **/

                /**
                 * System.out.println(neecode_150.BasicAlgo.validParathensis("()]"));
                 **/

                /**
                 * ListNode nodeA = new ListNode(1, new ListNode(2, new ListNode(3)));
                 * ListNode nodeB = new ListNode(1, new ListNode(3, new ListNode(4)));
                 * ListNode merged = neecode_150.BasicAlgo.mergeTwoSortedList(nodeA, nodeB);
                 * System.out.println(merged.getNext().stringifyNode());
                 **/

                /**
                 * ListNode nodeA = new ListNode(2, new ListNode(1, new ListNode(3)));
                 * System.out.println(neecode_150.BasicAlgo.sortList(nodeA).stringifyNode());
                 **/

                /**
                 * int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                 * neecode_150.BasicAlgo.rotate(arr);
                 **/

                /**
                 * int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                 * neecode_150.BasicAlgo.rotate(arr);
                 **/

                /**
                 * int[] arr = {1, 1, 0, 6, 5};
                 * ListNode node = ListNode.convertToListNode(arr);
                 * ListNode rev = neecode_150.BasicAlgo.reverseEvenLengthGroups(node);
                 * System.out.println(rev.stringifyNode());
                 **/

                /**
                 * int[] arr = {3, 5};
                 * ListNode node = ListNode.convertToListNode(arr);
                 * ListNode rev = neecode_150.BasicAlgo.reverseBetween(node, 1, 2);
                 * System.out.println(rev.stringifyNode());
                 **/

                /**
                 * int[] arr = {2, 4, 9};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * 
                 * int[] arr2 = {5, 6, 4, 9};
                 * ListNode l2 = ListNode.convertToListNode(arr2);
                 * 
                 * ListNode node = neecode_150.BasicAlgo.addTwoNumbers(l1, l2);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * 
                 * int[] arr = {1, 2, 3, 4, 5};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = neecode_150.BasicAlgo.removeNthFromEnd(l1, 2);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] arr = {1, 2};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = neecode_150.BasicAlgo.rotateRight(l1, 2);
                 * /
                 **/

                /**
                 * int[] arr = {1, 2, 3, 3, 4, 4, 5};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = neecode_150.BasicAlgo.deleteDuplicates(l1);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] arr = {1, 2};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = neecode_150.BasicAlgo.rotateRight(l1, 2);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * stream_test.StreamT.testStream();
                 */

                /**
                 * int[] arr = {1, 4, 3, 2, 5, 2};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = neecode_150.BasicAlgo.partition(l1, 3);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] divisors = {18, 6, 10, 3};
                 * ListNode divisorNode = ListNode.convertToListNode(divisors);
                 * ListNode result = neecode_150.BasicAlgo.insertGreatestCommonDivisors(divisorNode);
                 * System.out.println(result.stringifyNode());
                 **/

                /**
                 * int[] arr = {1, 8, 9};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = neecode_150.BasicAlgo.doubleIt(l1);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] arr = {16, 2, 12, 19, 7, 20, 3, 21};
                 * //int[] arr = {1, 1, 1, 1};
                 * //int[] arr = {5, 2, 12, 3, 8};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = neecode_150.BasicAlgo.removeNodes(l1);
                 * System.out.println(node.stringifyNode());
                 **/

                /*
                 * int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * int[][] result = neecode_150.BasicAlgo.spiralMatrix(3, 5, l1);
                 * System.out.println(result);
                 */

                /*
                 * String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
                 * int summ = NeetCode.calPoints(ops);
                 * System.out.println(summ);
                 */

                /*
                 * MyStack myStack = new MyStack();
                 * myStack.push(1);
                 * myStack.push(2);
                 * System.out.println(myStack.top());
                 * System.out.println(myStack.pop());
                 * System.out.println(myStack.pop());
                 * System.out.println(myStack.empty());
                 */

                /**
                 * int[] arr = {1, 2, 3, 4, 5};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode result = NeetCode.reverseListIteratively(l1);
                 * System.out.println(result.stringifyNode());
                 */

                /**
                 * System.out.println(NeetCode.climbStairs(4));
                 * int[] arr = new int[]{3,2,1,8, 5, 8};
                 * NeetCode.quickSort(arr);
                 * System.out.println(arr);
                 */

                /*
                 * int[] arr2 = new int[]{3,2, 1, 5, 6, 4};
                 * System.out.println(neecode_150.BasicAlgo.findKthLargest(arr2, 2));
                 */

                /**
                 * int[] piles = new int[]{30, 11, 23, 4, 20};
                 * System.out.println(NeetCode.minEatingSpeed(piles, 5));
                 */

                /*
                 * int[] preorder = {3, 9, 20, 15, 7};
                 * int[] inorder = {9, 3, 15, 20, 7};
                 * System.out.println(NeetCode.buildTreeIteratively(preorder, inorder));
                 */

                /**
                 * List<Integer> ans = new ArrayList<>();
                 * int[] largestElement= {};
                 * NeetCode.KthLargest res = new NeetCode.KthLargest(3, largestElement);
                 * ans.add(res.add(3));
                 * ans.add(res.add(5));
                 * ans.add(res.add(10));
                 * ans.add(res.add(9));
                 * ans.add(res.add(4));
                 * 
                 * System.out.println(ans.toString());
                 */

                /*
                 * int[] stones = {2, 7, 4, 1, 8, 1};
                 * int weight = NeetCode.lastStoneWeight(stones);
                 * System.out.println(weight);#
                 */

                /*
                 * int[][] points = { {0,1}, {1,0}};
                 * int[][] ans = NeetCode.kClosest(points, 2);
                 * System.out.println(ans.toString());
                 */

                /**
                 * int[][] island = { { 0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0 },
                 * { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                 * { 0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0 },
                 * { 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0 },
                 * { 0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0 },
                 * { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0 },
                 * { 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0 },
                 * { 0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0 } };
                 * NeetCode.GraphMaxArea area = new NeetCode.GraphMaxArea();
                 * int maxArea = area.maxAreaOfIsland(island);
                 * System.out.println(maxArea);
                 */

                /*
                 * 
                 * int[][] matrix = {{0,0,0},{1,1,0},{1,1,0}};
                 * int binaryShortest = NeetCode.GraphMaxArea.shortestPathBinaryMatrix(matrix);
                 * System.out.println(binaryShortest);
                 */

                /**
                 * 
                 * int[][] matrix = {{2,1,1},{1,1,0},{0,1,1}};
                 * int rottenOrange = NeetCode.GraphMaxArea.orangesRotting(matrix);
                 * System.out.println(rottenOrange);
                 */

                /*
                 * String[][] arrs = {{ "A", "B"}, {"B", "C"}, {"B", "E"}, {"C", "E"}, {"E",
                 * "D"}};
                 * HashMap<String, List<String>> map = NeetCode.Node.buildGraph(arrs);
                 * int count = NeetCode.Node.countToDestination(map, "A", "E");
                 * System.out.println(count);
                 */
                  
                 /*
                   int[][] numArrs = {{1, 4}, {2, 4},{3, 1}, {3, 2}};
                   System.out.println(NeetCode.Node.canFinishBfs(5, numArrs));
                 */
                
                 

                /*
                 * int[][] isConnected = { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
                 * System.out.println(NeetCode.Node.findCircleNum(isConnected));
                 */

                /*
                 * int[] arr = new int[10];
                 * neecode_150.BasicAlgo.QuickFind root = new neecode_150.BasicAlgo.QuickFind(arr);
                 * root.union(0, 1);
                 * root.union(0, 2);
                 * root.union(1, 3);
                 * root.union(4, 8);
                 * root.union(5, 6);
                 * root.union(5, 7);
                 * System.out.println(root.isConnected(0, 9));
                 */

                /**
                 * int[][] isConnected = { {1, 0}, {2, 0}, {3, 1}, {3, 2}};
                 * System.out.println(NeetCode.Node.findOrder(2, isConnected));
                 **/
                
                 /**
                int[] ar = { 67, 99, 105, 30, 4, 6, 70, 3, 2, 1 };
                int[] newAr = NeetCode.sortArray(ar);
                System.out.println(newAr.toString());
                 */
                
                 /* 
                int[] arr =  {1, 2, 3, 1};
                System.out.println(NeetCode.rob(arr));
                */
                
                /* 
                System.out.println(NeetCode.fibRecurrenceRelation(3));
                */
                /* 
                int[] arr = {0, 3,7, 2, 5, 6, 4,6, 0, 1};
                int[] arr2 = {100, 4, 200, 1, 3, 2};
                System.out.println(NeetCode.longestConsecutive(arr2));
                */

                //System.out.println(NeetCode.checkInclusion2("adc", "dcda"));

                //System.out.println(NeetCode.minWindow("bbaa", "aba"));
                
                /* 
                int[] nums = {1,3,-1,-3,5,3,6,7};
                System.out.println(NeetCode.maxSlidingWindow2(nums, 3).toString());
                */

                //System.out.println(NeetCode.isValid("(]"));
                /* 
                char[][] board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}};
                System.out.println(NeetCode.exist(board, "ABCCED"));
                */

                /* 
                int[] arr = {1, 2, 2};
                System.out.println(NeetCode.subsetsWithDup(arr));
                */
                 

               //System.out.println(NeetCode.generateParenthesis(3));

               //System.out.println(NeetCode.factorial(5, 2));
        
               /*
               int[] arr ={1, 3, 2, 5, 4, 6, 7};
               NeetCode.rearrange(arr);
               System.out.println(arr);
                */
               /* 
               MySingleton singleton = MySingleton.getInstance();       
               System.out.println(singleton);
               MySingleton singleton2 = MySingleton.getInstance(); 
               System.out.println(singleton);
               */ 

               /* 

               int[] temp = {30,60,90};
               System.out.println(NeetCode.dailyTemperaturesII(temp));
               */   
             
               /*      
               int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
               System.out.println(NeetCode.pacificAtlantic(heights));
               */
               
               /* 
                int[][] edges =  {{1,2},{2,3},{3,4},{1,4},{1,5}};
                int[] result = NeetCode.findRedundantConnection(edges);
                System.out.println(result.toString());
               */

        int[] arr = {-3, -2, -3};
        int res = NeetCode.maxSubarraySumCircular(arr);
        System.out.println(res);
    }

}
