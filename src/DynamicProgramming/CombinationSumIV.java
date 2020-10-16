package DynamicProgramming;
import java.util.*;

public class CombinationSumIV {

        Map<Integer, Integer> memo = new HashMap<>(); //key = target value, value = possible tway to make up the key
        public int combinationSum4(int[] nums, int target) {
            int cnt = 0;
            if (target == 0) {
                return 1;
            }
            if (nums == null || nums.length == 0 || target < 0) {
                return 0;
            }


            if (memo.containsKey(target)) {
                return memo.get(target);
            }
            for (int num : nums) {
                cnt += combinationSum4(nums, target - num);
            }

            memo.put(target, cnt);
            return cnt;
        }


}
