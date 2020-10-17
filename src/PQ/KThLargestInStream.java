package PQ;
import java.util.*;
public class KThLargestInStream {

        PriorityQueue<Integer> maxHeap ;
        int size;
        public KThLargestInStream(int k, int[] nums) {
            maxHeap = new PriorityQueue<>();
            size = k;
            int i = 0;
            for (int num : nums) {
                add(num);
            }
        }

        public int add(int val) {
            maxHeap.offer(val);
            if (maxHeap.size() > size) {
                maxHeap.poll();
            }
            return maxHeap.peek();
        }


/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */
}
