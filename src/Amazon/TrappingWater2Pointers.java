package Amazon;

public class TrappingWater2Pointers {
        public int trap(int[] height) {
            //method2: use two pointers
            //instead of dp, we go through only 1 iteration
            // use two pointers to maintain the highest two end bar and update it dynamically
            //be sure: 总是优先Move min(leftMax, rightMax) 并把当前的curMax - height[i]做差，做差后还要和0 比较，防止负数
            //time:O(n)
            //space:O(1)
            //corner case
            if(height == null || height.length == 0){
                return 0;
            }
            int n = height.length;
            int leftMax = height[0];
            int rightMax = height[n - 1];

            int left = 0;
            int right = n - 1;
            int res = 0;

            //when loop finished: left == right, no water
            while(left < right){
                if(height[left] > leftMax){
                    leftMax = height[left];
                }

                if(height[right] > rightMax){
                    rightMax = height[right];
                }

                if(leftMax < rightMax){
                    res += Math.max(0, leftMax - height[left]);
                    left++;
                }else{
                    res += Math.max(0, rightMax - height[right]);
                    right--;
                }
            }

            return res;
        }

}
