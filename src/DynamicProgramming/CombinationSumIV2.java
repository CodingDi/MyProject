package DynamicProgramming;

import java.util.Arrays;

public class CombinationSumIV2 {

        int[] memo;
        public int combinationSum4(int[] nums, int target) {
            memo = new int[target + 1];
            Arrays.fill(memo, -1);
            memo[0] = 1;
            return check(nums, target);
        }

        private int check(int[] nums, int target){
            if (target < 0) {
                return 0;
            }
            if (memo[target] != -1) {
                return memo[target];
            }

            int cnt = 0;
            for (int num : nums) {
                cnt += check(nums, target - num);
            }
            memo[target] = cnt;
            return cnt;
        }

}
