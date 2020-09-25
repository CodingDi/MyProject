package BFS;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class AllSubsetII {


        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            //corner case
            if (nums == null) {
                return res;
            }

            Arrays.sort(nums);

            List<Integer> preSol = new ArrayList<>();
            Arrays.sort(nums);

            helper(res, preSol, nums, 0);

            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> preSol, int[] nums, int index) {
            //base case
            if (index == nums.length) {
                res.add(new ArrayList<>(preSol));
                return;
            }

            preSol.add(nums[index]);//forward
            helper(res, preSol, nums, index + 1);

            //deduplication
            while (index + 1 < nums.length && nums[index] == nums[index + 1]) {
                index++;
            }

            preSol.remove(preSol.size() - 1);//go backward
            helper(res, preSol, nums, index + 1);
        }

}
