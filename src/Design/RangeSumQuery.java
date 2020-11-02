package Design;

public class RangeSumQuery {

        int[] arr;

        public RangeSumQuery(int[] nums) {
            arr = nums;
        }

        public void update(int i, int val) {
            //reset
            arr[i] = val;
        }

        public int sumRange(int i, int j) {
            int sum = 0;
            for (int index = i; index <= j; index++) {
                sum += arr[index];
            }

            return sum;
        }


/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
}
