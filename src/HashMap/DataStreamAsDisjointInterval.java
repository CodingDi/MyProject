package HashMap;
import java.util.*;
public class DataStreamAsDisjointInterval {


        TreeMap<Integer, int[]> map;
        /** Initialize your data structure here. */
        public DataStreamAsDisjointInterval() {
            map = new TreeMap<>();
        }

        public void addNum(int val) {
            if (map.containsKey(val)) {
                return;
            }
            Integer low = map.lowerKey(val);
            Integer high = map.higherKey(val);
            System.out.println(low + "," + high + "," + val);

            if (low != null && high != null && map.get(low)[1] + 1 == val && high - 1 == val) {

                map.get(low)[1] = map.get(high)[1];
                map.remove(high);

            } else if (low != null && map.get(low)[1] + 1 >= val) {
                map.put(low, new int[]{low,Math.max(val, map.get(low)[1])});
            } else if (high != null && high - 1 == val) {
                System.out.println(high + "," + val);
                map.put(val, new int[]{val, map.get(high)[1]});
                map.remove(high);
            } else {
                map.put(val, new int[]{val, val});
            }
        }

        public int[][] getIntervals() {
            int[][] res = new int[map.size()][2];
            int i = 0;
            for (int[] interval : map.values()) {
                res[i++] = interval;
            }
            return res;
        }



/**
 * Your SummaryRanges object will be instantiated and called as such:
 * SummaryRanges obj = new SummaryRanges();
 * obj.addNum(val);
 * int[][] param_2 = obj.getIntervals();
 */
}
