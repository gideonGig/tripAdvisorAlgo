import neecode_150.NeetCode;
import neecode_150.NeetCode.MyStack;
import utilities.ListNode;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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
                 * Integer coin = BasicAlgo.coinChange(arr, 7);
                 * System.out.println(coin);
                 * 
                 * int sum = BasicAlgo.sumOfNaturalNumbers(10);
                 * System.out.println(sum);
                 **/

                /*
                 * Integer{} unsortedArr = {-3, 0, 2, 1, 5, 7, 6};
                 * BasicAlgo.mergeSort(unsortedArr);
                 * Arrays.stream(unsortedArr).forEach(System.out::println);
                 */

                /*
                 * BasicAlgo.MyQueue queue = new BasicAlgo.MyQueue();
                 * queue.append(10);
                 * queue.append(20);
                 * queue.append(30);
                 * queue.append(40);
                 * queue.append(50);
                 * System.out.println(queue.dequeue());
                 *
                 */

                /*
                 * BigDecimal pow = BasicAlgo.power(16, 0);
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
                 * ListNode node = BasicAlgo.findIntersectionBetweenNodes(nodeA, nodeB);
                 * 
                 * System.out.println(node.getVal());
                 **/
                /**
                 * char[][] arr = {{'1', '1', '1', '1', '0'},
                 * {'1','1','0','1','0'},
                 * {'1','1','0','0','0'},
                 * {'0','0','0','0','0'} };
                 * int times = BasicAlgo.numberOfIsland(arr);
                 * System.out.println(times);
                 */

                /*
                 * int[][] fishArr = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
                 * int maxFish = BasicAlgo.findMaxFish(fishArr);
                 * System.out.println(maxFish);
                 **/

                /**
                 * TicTac game = new TicTac();
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
                 * System.out.println(BasicAlgo.twitterWaterFall(arr));
                 */

                /*
                 * System.out.println(BasicAlgo.convertIntToRoman(1670));
                 **/

                /**
                 * System.out.println(BasicAlgo.validParathensis("()]"));
                 **/

                /**
                 * ListNode nodeA = new ListNode(1, new ListNode(2, new ListNode(3)));
                 * ListNode nodeB = new ListNode(1, new ListNode(3, new ListNode(4)));
                 * ListNode merged = BasicAlgo.mergeTwoSortedList(nodeA, nodeB);
                 * System.out.println(merged.getNext().stringifyNode());
                 **/

                /**
                 * ListNode nodeA = new ListNode(2, new ListNode(1, new ListNode(3)));
                 * System.out.println(BasicAlgo.sortList(nodeA).stringifyNode());
                 **/

                /**
                 * int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                 * BasicAlgo.rotate(arr);
                 **/

                /**
                 * int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
                 * BasicAlgo.rotate(arr);
                 **/

                /**
                 * int[] arr = {1, 1, 0, 6, 5};
                 * ListNode node = ListNode.convertToListNode(arr);
                 * ListNode rev = BasicAlgo.reverseEvenLengthGroups(node);
                 * System.out.println(rev.stringifyNode());
                 **/

                /**
                 * int[] arr = {3, 5};
                 * ListNode node = ListNode.convertToListNode(arr);
                 * ListNode rev = BasicAlgo.reverseBetween(node, 1, 2);
                 * System.out.println(rev.stringifyNode());
                 **/

                /**
                 * int[] arr = {2, 4, 9};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * 
                 * int[] arr2 = {5, 6, 4, 9};
                 * ListNode l2 = ListNode.convertToListNode(arr2);
                 * 
                 * ListNode node = BasicAlgo.addTwoNumbers(l1, l2);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * 
                 * int[] arr = {1, 2, 3, 4, 5};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = BasicAlgo.removeNthFromEnd(l1, 2);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] arr = {1, 2};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = BasicAlgo.rotateRight(l1, 2);
                 * /
                 **/

                /**
                 * int[] arr = {1, 2, 3, 3, 4, 4, 5};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = BasicAlgo.deleteDuplicates(l1);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] arr = {1, 2};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = BasicAlgo.rotateRight(l1, 2);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * StreamT.testStream();
                 */

                /**
                 * int[] arr = {1, 4, 3, 2, 5, 2};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = BasicAlgo.partition(l1, 3);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] divisors = {18, 6, 10, 3};
                 * ListNode divisorNode = ListNode.convertToListNode(divisors);
                 * ListNode result = BasicAlgo.insertGreatestCommonDivisors(divisorNode);
                 * System.out.println(result.stringifyNode());
                 **/

                /**
                 * int[] arr = {1, 8, 9};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = BasicAlgo.doubleIt(l1);
                 * System.out.println(node.stringifyNode());
                 **/

                /**
                 * int[] arr = {16, 2, 12, 19, 7, 20, 3, 21};
                 * //int[] arr = {1, 1, 1, 1};
                 * //int[] arr = {5, 2, 12, 3, 8};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * ListNode node = BasicAlgo.removeNodes(l1);
                 * System.out.println(node.stringifyNode());
                 **/

                /*
                 * int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
                 * ListNode l1 = ListNode.convertToListNode(arr);
                 * int[][] result = BasicAlgo.spiralMatrix(3, 5, l1);
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
                 * System.out.println(BasicAlgo.findKthLargest(arr2, 2));
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
                 * int[][] numArrs = {{1, 4}, {2, 4},{3, 1}, {3, 2}};
                 * System.out.println(NeetCode.Node.canFinishBfs(5, numArrs));
                 */

                /*
                 * int[][] isConnected = { {1, 1, 1}, {1, 1, 1}, {1, 1, 1}};
                 * System.out.println(NeetCode.Node.findCircleNum(isConnected));
                 */

                /*
                 * int[] arr = new int[10];
                 * BasicAlgo.QuickFind root = new BasicAlgo.QuickFind(arr);
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
                
                int[] arr = {1, 2, 2};
                System.out.println(NeetCode.subsetsWithDup(arr));




        }

}
