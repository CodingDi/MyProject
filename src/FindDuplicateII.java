public class FindDuplicateII {
    class Solution {
        public int findDuplicate(int[] nums) {
            //method2: use bianry search and get the count, comapre it with the mid
            int n = nums.length;
            int l = 0;
            int r  = nums.length-1;
            while(l < r){
                int cnt = 0;
                int mid = l + (r- l)/2;
                for(int i = 0; i < n; i++){
                    if(nums[i] <= mid){
                        cnt++;
                    }
                }

                if(cnt > mid){
                    r = mid;
                }else{
                    l = mid + 1;
                }
            }

            return l;
        }
    }
}
