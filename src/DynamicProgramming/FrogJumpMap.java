package DynamicProgramming;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FrogJumpMap {
    //time:O(n^2) space:O(n)

        public boolean canCross(int[] stones) {
            // at each stones, where we can jump will depends on what's the jump unit at current
            // the jump unit needed to reached current varies, so we could use a hashmap to store it
            // induction rule:
            //     at each stones, for each jump units k to reach current,
            //         try to jump k -1, k, k + 1, to see where it could reaches to
            //             if the one is a stone position, afd the jump unit to it
            if (stones == null || stones.length <= 1) {
                return true;
            }
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int n = stones.length;
            //key = stone position, value = all jump unites that can reaches to key
            for (int i = 0; i < n; i++) {
                map.put(stones[i], new HashSet<Integer>());
            }

            map.get(0).add(0);

            for (int i = 0; i < n; i++) {
                for (int k : map.get(stones[i])) {
                    //try all k - 1, k, k + 1
                    for (int j = k - 1; j <= k + 1; j++) {
                        //stand at position i, if we jump j can reaches a stone
                        if (j > 0 && map.containsKey(stones[i] + j)) {
                            map.get(stones[i] + j).add(j);
                        }
                    }
                }
            }
            return map.get(stones[n - 1]).size() > 0 ? true : false;
    }
}
