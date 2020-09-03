public class MaxAreaofIsland {
    class Solution {
        public int findDuplicate(int[] nums) {
            // use the value itself fot index the number as value ranges from 1-n
            // use slow and fast pointer to access
            if(nums == null){
                return -1;
            }

            if(nums.length ==1){
                return nums[0];
            }

            int slow = nums[0];
            int fast = nums[nums[0]];

            while(fast != slow){
                slow = nums[slow];//one step
                fast = nums[nums[fast]];//two steps
            }

            //now slow=fast is the intersection
            slow = 0;
            while(slow != fast){
                slow = nums[slow];
                fast = nums[fast];
            }

            return slow;

        }
    }
}
