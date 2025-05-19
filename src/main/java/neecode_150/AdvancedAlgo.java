package neecode_150;

import java.util.Arrays;

/**
 * https://livebook.manning.com/book/advanced-algorithms-and-data-structures/chapter-2/165
 **/
public class AdvancedAlgo {

    public static class Heap {

        private int[] priorityArr;

        private int arrSize;

        public Heap(int[] priorityArr) {
            this.priorityArr = priorityArr.clone();
            arrSize = priorityArr.length;
            heapify();
        }

        private void bubbleUp() {

            int index = arrSize - 1;
            int currentIndexElement = priorityArr[index];

            while (index > 0) {
                int parentIndex = (index - 1) / 2;
                if (currentIndexElement > priorityArr[parentIndex]) {
                    priorityArr[index] = priorityArr[parentIndex];
                    index = parentIndex;
                } else {
                    break;
                }

            }

            priorityArr[index] = currentIndexElement;
        }

        private void pushDown(int index) {
            int currentElement = priorityArr[index];

            while (index < arrSize - 1) {
                int childIndex = getChildIndexWithHighestPriority(index, priorityArr);
                if (childIndex > -1 && currentElement < priorityArr[childIndex]) {
                    priorityArr[index] = priorityArr[childIndex];
                    index = childIndex;
                } else {
                    break;
                }
            }

            priorityArr[index] = currentElement;
        }

        private int getChildIndexWithHighestPriority(int indexPriority, int[] priorityArr) {
            int leftIndex = (2 * indexPriority) + 1;
            int rightIndex = 2 * (indexPriority + 1);
            if (leftIndex >= arrSize) return -1;
            if (rightIndex >= arrSize) return leftIndex;
            return (priorityArr[leftIndex] > priorityArr[rightIndex]) ? leftIndex: rightIndex;

        }

        public void insert(int priority) {
            if (arrSize >= priorityArr.length) {
                //double the arrSize and copy elements, arrSize tracks the last element in the array,
                int[] newArr = new int[arrSize * 2];
                System.arraycopy(priorityArr, 0, newArr, 0, arrSize);
                priorityArr = newArr;
            }
            priorityArr[arrSize++] = priority;
            bubbleUp();
        }

        public int peek() {
            if (arrSize > 0) {
                return priorityArr[0];
            }

            return -1;
        }

        public int top() {
            if (arrSize == 0) {
                return -1;
            }
            int peeked = peek();
            priorityArr[0] = priorityArr[arrSize - 1];
            arrSize = arrSize - 1;
            if (arrSize > 0) {
                pushDown(0);
            }
            return peeked;
        }

        public void heapify() {
            for (int i = (arrSize - 1) / 2; i >= 0; i--) {
                pushDown(i);
            }
        }

        public int[] getTopElements(int[] arr, int k) {
            Heap heap = new Heap(new int[1]);

            for (int value : arr) {
                if (heap.arrSize == k && value > heap.peek()) {
                    heap.top();
                } else if (heap.arrSize < k) {
                    heap.insert(value);
                }
            }
            return Arrays.copyOf(heap.priorityArr, heap.arrSize);
        }

    }
}
