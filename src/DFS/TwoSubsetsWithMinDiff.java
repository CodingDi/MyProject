package DFS;

import java.util.ArrayList;
import java.util.List;

public class TwoSubsetsWithMinDiff {

        public int minDifference(int[] array) {
            List<Integer> group1 = new ArrayList<>();
            List<Integer> group2 = new ArrayList<>();
            int sum1 = 0;
            int sum2 = 0;
            int[] min = new int[]{Integer.MAX_VALUE};
            helper(array, sum1, sum2, 0,min, group1, group2);
            return min[0];
        }

        private void helper(int[] arr, int sum1, int sum2, int index, int[] min, List<Integer> group1, List<Integer> group2) {
            //base case
            if (index == arr.length) {
                if (group1.size() == arr.length /2 || group2.size() == arr.length /2) {
                    min[0] = Math.min(Math.abs(sum1 - sum2), min[0]);
                }
                return;
            }

            //for current index, add it to group1
            group1.add(arr[index]);
            helper(arr, sum1 + arr[index], sum2, index + 1, min, group1, group2);
            group1.remove(group1.size() - 1);

            //add it to group2
            group2.add(arr[index]);
            helper(arr, sum1, sum2 + arr[index], index + 1, min, group1, group2);
            group2.remove(group2.size() - 1);
        }


}
