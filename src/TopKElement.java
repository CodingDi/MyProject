import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKElement {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> map = new HashMap<>();
        //key=number value, value = occurence
        for(int i = 0; i < nums.length; i++){
            map.put(nums[i], map.getOrDefault(nums[i],0) + 1);
        }

        PriorityQueue<Integer> minHeap = new PriorityQueue<>((a, b) -> (map.get(a)- map.get(b)));

        for(int num: map.keySet()){
            minHeap.offer(num);
            if(minHeap.size() > k) {
                minHeap.poll();
            }
        }

        //output
        int[] res = new int[minHeap.size()];
        int i = 0;
        while(!minHeap.isEmpty()) {
            res[i++] = minHeap.poll();
        }

        return res;
    }
}
