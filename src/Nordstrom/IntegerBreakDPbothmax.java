package Nordstrom;

public class IntegerBreakDPbothmax {


        public int integerBreak(int n) {
            //左大段+ 右打断

            int[] dp = new int[n + 1];
            //dp[i] represents the max prodcut by break integer i

            //induction rule dp[i] = max(max(j, dp[j])*  max(i - j)*dp[i - j])
            //where j <= i/2
            dp[1] = 1;

            for(int i = 2; i <= n; i++){
                int cur = 0;
                for(int j = 1; j <= i/2; j++){
                    cur = Math.max(cur, Math.max(j, dp[j]) * Math.max(i - j, dp[i - j]));
                }
                dp[i] = cur;
            }

            return dp[n];
        }

}
