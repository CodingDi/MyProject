package TwoPointers;

public class ContainerWithMostWater {
        public int maxArea(int[] height) {
            int res = 0;

            if(height == null || height.length == 0){
                return res;
            }

            int left = 0;
            int right = height.length - 1;

            while(left < right){

                int min = Math.min(height[left], height[right]);
                res = Math.max(res, min * (right - left ));

                //move the left pointer, because we want to maitain the highest
                if(height[left] == min){
                    left++;
                }

                if(height[right] == min){
                    right--;
                }
            }
            return res;
        }

}
