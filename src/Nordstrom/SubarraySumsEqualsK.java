package Nordstrom;

public class SubarraySumsEqualsK {
    //time:O(n^2)
    //space:O(1)
    //try to find the start and the end index of each subarray, where right >= left
        public int subarraySum(int[] nums, int k) {
            int cnt = 0;

            if(nums == null || nums.length == 0){
                return 0;
            }

            for(int start = 0; start < nums.length; start++){
                int sum = 0;//reset the start of the subarray

                for(int end = start; end < nums.length; end++){
                    sum += nums[end];
                    if(sum == k){
                        cnt++;
                    }
                }
            }

            return cnt;
        }

}
