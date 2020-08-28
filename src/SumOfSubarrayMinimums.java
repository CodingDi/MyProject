import java.util.ArrayDeque;
import java.util.Deque;

public class SumOfSubarrayMinimums  {
        public int sumSubarrayMins(int[] A) {
            Deque<int[]> s1 = new ArrayDeque<>();
            Deque<int[]> s2 = new ArrayDeque<>();

            int n = A.length;
            int[] left = new int[n];
            int[] right = new int[n];

            //construct the left[] : the max number larger than A[i] on left side
            for(int i = 0; i < n; i++){
                int cnt = 1;//initialize the number that larger than it lpn the left side is 1
                while(!s1.isEmpty() && s1.peekFirst()[0] > A[i]){
                    cnt += s1.pollFirst()[1];
                }
                s1.offerFirst(new int[]{A[i], cnt});
                left[i] = cnt;
            }

            //construct the right[]: the ma number >= than A[j] on the rihgt side
            for(int j = n - 1; j >= 0; j--){
                int cnt = 1;
                while(!s2.isEmpty() && s2.peekFirst()[0] >= A[j]) {
                    cnt += s2.pollFirst()[1];
                }
                s2.offerFirst(new int[]{A[j], cnt});
                right[j] = cnt;
            }

            //count the # of susarrays includes A[i] as the min
            int sum = 0;//total sum
            int mod = (int)1e9+7;
            for(int i = 0; i < n; i++){
                sum = (sum + left[i] * right[i] * A[i]) % mod;
            }


            return sum;
        }

}
