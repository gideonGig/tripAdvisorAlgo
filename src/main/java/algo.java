import neecode_150.NeetCode;
import threadtutorials.InteruptThread;
import threadtutorials.Thread1;
import threadtutorials.Thread2;

import java.math.BigDecimal;

public class algo {

    public static void main(String[] args) throws InterruptedException {

        /** Beginning of Thread1 **/

        /**
        Thread2 thread2 = new Thread2();
        thread2.createThread2();

        InteruptThread interuptThread = new InteruptThread(BigDecimal.valueOf(10), 3);
        interuptThread.interuptThread();
         **/




        //Basics test = new Basics();
        /**
        Object c = test.check(50);
        System.out.println(c.getClass().toString());

        test.testObjecEquality();
         **/

       //test.calculateValue("*", 2.0f, 10.0f);
        // test.testGenerics();

        /**
         Integer{} arr = {1,3,4,5};
         Integer coin = BasicAlgo.coinChange(arr, 7);
         System.out.println(coin);

         int sum = BasicAlgo.sumOfNaturalNumbers(10);
         System.out.println(sum);
         **/

        /*
        Integer{} unsortedArr = {-3, 0, 2, 1, 5, 7, 6};
        BasicAlgo.mergeSort(unsortedArr);
        Arrays.stream(unsortedArr).forEach(System.out::println);
         */

        /*
        BasicAlgo.MyQueue queue = new BasicAlgo.MyQueue();
        queue.append(10);
        queue.append(20);
        queue.append(30);
        queue.append(40);
        queue.append(50);
        System.out.println(queue.dequeue());
        *
         */

        /*
        BigDecimal pow = BasicAlgo.power(16, 0);
        System.out.println(pow);
         */

        /**
        BasicAlgo.ListNode nodeA = new BasicAlgo.ListNode(1,
                new BasicAlgo.ListNode(2, new BasicAlgo.ListNode(3,
                        new BasicAlgo.ListNode(4))));


        BasicAlgo.ListNode nodeB = new BasicAlgo.ListNode(4,
                new BasicAlgo.ListNode(6, new BasicAlgo.ListNode(8,
                        new BasicAlgo.ListNode(10))));
        BasicAlgo.ListNode node = BasicAlgo.findIntersectionBetweenNodes(nodeA, nodeB);

        System.out.println(node.getVal());
         **/
        /**
        char[][] arr = {{'1', '1', '1', '1', '0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'} };
        int times = BasicAlgo.numberOfIsland(arr);
        System.out.println(times);
         */

        /*
        int[][] fishArr = {{0, 2, 1, 0}, {4, 0, 0, 3}, {1, 0, 0, 4}, {0, 3, 2, 0}};
        int maxFish = BasicAlgo.findMaxFish(fishArr);
        System.out.println(maxFish);
        **/

        /**
        TicTac game = new TicTac();
        Boolean isWin = false;
        while (isWin == false) {
            game.drawBoard();
            game.chooseSpot();
            if (game.checkWin()) {
                isWin = true;
                System.out.println(String.format("player" + game.getPlayer() + "has won the game"));
            } else if (game.checkBoardFull()) {
                game.drawBoard();
                isWin = true;
                System.out.println("Game is a draw");
            }
            game.togglePlayer();
        }
         **/

        /**
        int[] arr = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(BasicAlgo.twitterWaterFall(arr));
         */

        /*
        System.out.println(BasicAlgo.convertIntToRoman(1670));
        **/

        /**
        System.out.println(BasicAlgo.validParathensis("()]"));
         **/

        /**
        BasicAlgo.ListNode nodeA = new BasicAlgo.ListNode(1, new BasicAlgo.ListNode(2, new BasicAlgo.ListNode(3)));
        BasicAlgo.ListNode nodeB = new BasicAlgo.ListNode(1, new BasicAlgo.ListNode(3, new BasicAlgo.ListNode(4)));
        BasicAlgo.ListNode merged = BasicAlgo.mergeTwoSortedList(nodeA, nodeB);
        System.out.println(merged.getNext().stringifyNode());
         **/

        /**
        BasicAlgo.ListNode nodeA = new BasicAlgo.ListNode(2, new BasicAlgo.ListNode(1, new BasicAlgo.ListNode(3)));
        System.out.println(BasicAlgo.sortList(nodeA).stringifyNode());
         **/
        
         /** 
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        BasicAlgo.rotate(arr);
        **/

        /**
        int[][] arr = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        BasicAlgo.rotate(arr);
         **/

        /**
        int[] arr = {1, 1, 0, 6, 5};
        BasicAlgo.ListNode node = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode rev = BasicAlgo.reverseEvenLengthGroups(node);
        System.out.println(rev.stringifyNode());
         **/

        /**
        int[] arr = {3, 5};
        BasicAlgo.ListNode node = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode rev = BasicAlgo.reverseBetween(node, 1, 2);
        System.out.println(rev.stringifyNode());
         **/

        /**
        int[] arr = {2, 4, 9};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);

        int[] arr2 = {5, 6, 4, 9};
        BasicAlgo.ListNode l2 = BasicAlgo.ListNode.convertToListNode(arr2);

        BasicAlgo.ListNode node = BasicAlgo.addTwoNumbers(l1, l2);
        System.out.println(node.stringifyNode());
         **/

        /**

        int[] arr = {1, 2, 3, 4, 5};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode node = BasicAlgo.removeNthFromEnd(l1, 2);
        System.out.println(node.stringifyNode());
         **/

        /**
        int[] arr = {1, 2};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode node = BasicAlgo.rotateRight(l1, 2);
/
         **/

        /**
        int[] arr = {1, 2, 3, 3, 4, 4, 5};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode node = BasicAlgo.deleteDuplicates(l1);
        System.out.println(node.stringifyNode());
         **/


         /** 
        int[] arr = {1, 2};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode node = BasicAlgo.rotateRight(l1, 2);
        System.out.println(node.stringifyNode());
        **/
        
        /** 
        StreamT.testStream();
        */

        /**
        int[] arr = {1, 4, 3, 2, 5, 2};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode node = BasicAlgo.partition(l1, 3);
        System.out.println(node.stringifyNode());
         **/

        /**
        int[] divisors = {18, 6, 10, 3};
        BasicAlgo.ListNode divisorNode = BasicAlgo.ListNode.convertToListNode(divisors);
        BasicAlgo.ListNode result = BasicAlgo.insertGreatestCommonDivisors(divisorNode);
        System.out.println(result.stringifyNode());
         **/

        /**
        int[] arr = {1, 8, 9};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode node = BasicAlgo.doubleIt(l1);
        System.out.println(node.stringifyNode());
         **/

        /**
        int[] arr = {16, 2, 12, 19, 7, 20, 3, 21};
        //int[] arr = {1, 1, 1, 1};
        //int[] arr = {5, 2, 12, 3, 8};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        BasicAlgo.ListNode node = BasicAlgo.removeNodes(l1);
        System.out.println(node.stringifyNode());
         **/

        /**
        int[] arr = {3, 0, 2, 6, 8, 1, 7, 9, 4, 2, 5, 5, 0};
        BasicAlgo.ListNode l1 = BasicAlgo.ListNode.convertToListNode(arr);
        int[][] result = BasicAlgo.spiralMatrix(3, 5, l1);
        System.out.println(result);
         **/

       String[] ops = {"5", "-2", "4", "C", "D", "9", "+", "+"};
       int summ = NeetCode.calPoints(ops);
       System.out.println(summ);


    }

}


































































