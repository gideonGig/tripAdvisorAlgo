public class algo {

    public static void main(String[] args) {
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

        StreamT.testStream();

        BasicAlgo.ListNode nodeA = new BasicAlgo.ListNode(2, new BasicAlgo.ListNode(1, new BasicAlgo.ListNode(3)));
        System.out.println(BasicAlgo.sortList(nodeA).stringifyNode());
    }

}
