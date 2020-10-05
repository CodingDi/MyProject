package Amazon;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {

        public int[] twoSum(int[] nums, int target) {
            if (nums == null || nums.length < 2) {
                return new int[]{-1, -1};
            }

            Map<Integer, Integer> map = new HashMap<>();

            for (int i = 0; i < nums.length; i++) {
                int goal = target - nums[i];
                if (map.containsKey(goal)) {
                    return new int[]{i, map.get(goal)};
                }


            }

            return new int[] {-1, -1};

        }

}
