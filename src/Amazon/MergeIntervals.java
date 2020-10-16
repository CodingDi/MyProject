package Amazon;
import java.util.*;
public class MergeIntervals {

        public int[][] merge(int[][] intervals) {
            if (intervals == null || intervals.length == 0) {
                return intervals;
            }

            Arrays.sort(intervals, (a, b) -> (a[0] - b[0]));
            List<int[]> res = new ArrayList<>();
            int[] prev = intervals[0];

            for (int i = 1; i < intervals.length; i++) {
                if (prev[1] >= intervals[i][0]) {
                    //merge
                    prev[1] = Math.max(prev[1], intervals[i][1]);
                } else {
                    res.add(prev);
                    prev = intervals[i];
                }
            }

            //post-processing
            res.add(prev);

            int[][] result = new int[res.size()][2];
            for (int i = 0; i < result.length; i++) {
                result[i] = res.get(i);
            }

            return result;
        }

}
