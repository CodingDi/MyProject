package Tree;

public class SearchInRotatedSortedArrayII {
        public boolean search(int[] nums, int target) {
            if (nums == null || nums.length == 0) {
                return false;
            }

            int left = 0;
            int right = nums.length - 1;

            while (left < right - 1) {
                int mid = left + (right - left)/2;
                if (nums[mid] == target) {
                    return true;
                } else if (nums[left] < nums[mid] || nums[mid] > nums[right]) {
                    //case2. when left part is sorted or the irght part is unsorted
                    if (nums[left] <= target && target < nums[mid]) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                } else if (nums[mid] < nums[right] || nums[left] > nums[mid]) {
                    //case3. if right part is sorted or left part is unsorted
                    if (nums[mid] < target && target <= nums[right]) {
                        left = mid + 1;
                    } else {
                        right = mid - 1;
                    }
                } else {
                    //case4. all the numbers all the same
                    right--;
                }
            }

            //post- processing
            if (nums[left] == target) {
                return true;
            }

            if (nums[right] == target) {
                return true;
            }
            return false;
        }

}
