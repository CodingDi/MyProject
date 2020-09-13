package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Four4SumOptimized {

    //此题关键的优化在于！ 有四个candidate i j left right  其中 i j 太大可以直接break;
    //    i j 太小可以continue ,下一步Increase  i/j
        public List<List<Integer>> fourSum(int[] nums, int target) {

            List<List<Integer>> res = new ArrayList<>();

            if(nums == null || nums.length < 4){
                return res;
            }

            int n = nums.length;
            Arrays.sort(nums);

            for(int i = 0; i < n - 3; i++){
                //too large -> break in advance
                if(nums[i] + nums[i + 1] + nums[i + 2] + nums[i + 3] > target){
                    break;
                }

                //too small, directly check another
                if(nums[i] + nums[n - 1] + nums[n - 2] + nums[n - 3] < target){
                    continue;
                }

                //deduplication for i
                if(i > 0 && nums[i] == nums[i - 1]){
                    continue;
                }

                for(int j = i + 1; j < n - 2; j++){
                    //too large
                    if(nums[i] + nums[j] + nums[j + 1] + nums[j + 2] > target){
                        break;
                    }

                    //too small, directly check another
                    if(nums[i] + nums[n - 1] + nums[n - 2] + nums[j] < target){
                        continue;
                    }

                    //deduplication for j
                    if(j > i + 1 && nums[j] == nums[j - 1]){
                        continue;
                    }

                    int left = j + 1;
                    int right = n - 1;

                    while(left < right){
                        int cur = nums[i] + nums[j] + nums[left] + nums[right];

                        if(cur == target){
                            res.add(Arrays.asList(nums[i], nums[j], nums[left], nums[right]));
                            left++;//move left pointer

                            //deduplication for left
                            while(left < right && nums[left] == nums[left - 1]){
                                left++;
                            }

                        }else if(cur < target){
                            left++;
                        }else{
                            right--;
                        }
                    }


                }
            }

            return res;
        }

}
