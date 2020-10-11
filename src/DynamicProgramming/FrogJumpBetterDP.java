package DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

public class FrogJumpBetterDP {

        public boolean canCross(int[] stones) {
            int n = stones.length;
            if (stones == null || stones.length <= 1) {
                return true;
            }

            if (stones[1] != 1) {
                return false;
            }
            Set<Integer> set = new HashSet<>();
            //如果下一个石头位置序号为当前序号的两倍，肯定不符合
            // https://leetcode-cn.com/problems/frog-jump/solution/javajie-fa-by-liu-jia-liang-8/
            for (int i = 0; i < n; i++) {
                if(i>3 && stones[i] >= 2*stones[i-1]){
                    return false;
                }
                set.add(stones[i]);
            }
            return helper(set, stones[n - 1], 1, 1);
        }
        private boolean helper(Set<Integer> set, int endPos, int curPos, int step) {
            //base case
            if (endPos == curPos) {
                return true;
            }

            //1.check step + 1 first --> greedy
            if (set.contains(curPos + step + 1)) {
                if (helper(set, endPos, curPos + step + 1, step + 1)) {
                    return true;
                }
            }

            if (set.contains(curPos + step)) {
                if (helper(set, endPos, curPos + step, step)) {
                    return true;
                }
            }

            if (step - 1 > 0 && set.contains(curPos + step - 1)) {
                if (helper(set, endPos, curPos + step - 1, step - 1)) {
                    return true;
                }
            }

            return false;
        }

}
