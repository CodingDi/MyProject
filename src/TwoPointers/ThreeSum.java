package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    //time:O(n) space:O(1)
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();

            if(nums == null || nums.length < 3){
                return res;
            }

            int n = nums.length;
            Arrays.sort(nums);//sort for deduplication

            for(int i = 0; i < n - 2; i++){

                if(i >0 && nums[i] == nums[i - 1]){
                    continue;
                }

                int left = i + 1;
                int right = n - 1;

                while(left < right){
                    int cur = nums[i] + nums[left] + nums[right];

                    if(cur == 0) {
                        res.add(Arrays.asList(nums[i], nums[left], nums[right]));
                        left++;

                        while(left < right && nums[left] == nums[left - 1]){
                            left++;
                        }
                    }else if(cur < 0){
                        left++;
                    }else{
                        right --;
                    }
                }

            }

            return res;
        }

}
