package DynamicProgramming;

public class HouseRobber {


        public int rob(int[] nums) {
            if (nums == null || nums.length == 0) {
                return 0;
            }

            int prevMax = 0;
            int curMax = 0;

            for (int i = 0; i < nums.length; i++) {
                int nextPrev = curMax;
                curMax = Math.max(prevMax + nums[i], curMax);
                prevMax = nextPrev;
            }

            return curMax;
        }


//              2                      1           1           2
// curMax  0 (0 + 2, 0) = 2  max(0+1,2) = 2    (2+1,2) = 3   (2 + 2, 3) = 4
// prevMax 0          0          2               2
}
