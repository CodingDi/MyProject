package DynamicProgramming;

public class HouseRobII {
    class Solution {
        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }
            if (nums.length == 1) {
                return nums[0];
            }

            int headMax = robHelper(nums, 0, nums.length - 2);
            int tailMax = robHelper(nums, 1, nums.length - 1);
            return Math.max(headMax, tailMax);
        }

        private int robHelper(int[] nums, int left, int right) {
            if (left > right) {
                return 0;
            }

            int curMax = 0;
            int prevMax = 0;

            for (int i = left; i <= right; i++) {
                int nextPrev = curMax;
                curMax = Math.max(prevMax + nums[i], curMax);
                prevMax = nextPrev;
            }
            return curMax;
        }
    }
}
