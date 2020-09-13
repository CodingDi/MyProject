package Amazon;

public class TrappingWaterDP {

        public int trap(int[] height) {
            //method 1 dp
            //time:O(n)
            //space:O(n)

            if(height == null|| height.length == 0){
                return 0;
            }
            int n = height.length;

            int[] leftMax = new int[n];
            int[] rightMax = new int[n];

            //1 iteratin: find the leftMax
            leftMax[0] = height[0];

            for(int i = 1; i < n; i++){
                leftMax[i] = Math.max(leftMax[i - 1], height[i]);
            }

            //2.iteration: find the rightmax
            rightMax[n - 1] = height[n - 1];
            for(int i = n - 2; i >= 0; i--){
                rightMax[i] = Math.max(rightMax[i + 1], height[i]);
            }

            //3.iteration: output
            int res = 0;
            for(int i = 0; i < n; i++){
                res += (Math.min(leftMax[i], rightMax[i]) - height[i]);
            }

            return res;
        }

}
