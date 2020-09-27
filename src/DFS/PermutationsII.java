package DFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PermutationsII {

        public List<List<Integer>> permuteUnique(int[] nums) {
            //deduplication: nums[i] == nums[i - 1]   && !used[i - 1]   skip
            //for nums[i] == nums[i - 1] if used[i-1] we can still keep it like[1,1,2] use 1 twice
            //idea is we can use duplication only when they repeated exist at the same time
            boolean[] used = new boolean[nums.length];
            List<List<Integer>> res = new ArrayList<>();
            List<Integer> prefix = new ArrayList<>();
            Arrays.sort(nums);
            helper(res, prefix, nums, used);
            return res;
        }
        private void helper(List<List<Integer>> res, List<Integer> prefix, int[] nums, boolean[] used){
            //base case
            if(prefix.size() == nums.length){
                res.add(new ArrayList<>(prefix));
                return;
            }
            for(int i = 0; i < nums.length; i++){
                //already visited
                if(used[i]){
                    continue;
                }
                //deduplciation
                if(i >= 1 && nums[i] == nums[i - 1] && !used[i - 1]){
                    continue;
                }
                prefix.add(nums[i]);
                used[i] = true;
                helper(res, prefix, nums, used);
                //go back
                used[i] = false;
                prefix.remove(prefix.size() - 1);
            }
        }


}
