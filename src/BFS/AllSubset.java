package BFS;

import java.util.ArrayList;
import java.util.List;

public class AllSubset {

        public List<List<Integer>> subsets(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            if (nums == null) {
                return res;
            }

            List<Integer> preSol = new ArrayList<>();
            helper(preSol, res, nums, 0);

            return res;
        }

        private void helper(List<Integer> preSol, List<List<Integer>> res, int[] nums, int index) {
            //base case
            if (index == nums.length) {
                res.add(new ArrayList<>(preSol));
                return;
            }

            //other case
            preSol.add(nums[index]);
            helper(preSol, res, nums, index + 1);

            //go back
            preSol.remove(preSol.size() - 1);
            helper(preSol, res, nums, index + 1);
        }

}
