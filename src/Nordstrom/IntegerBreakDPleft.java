package Nordstrom;

public class IntegerBreakDPleft {

        public int integerBreak(int n) {
            //左大段 + 右小段
            int[] dp = new int[n+1];//dp[i] represents the max product with length i

            dp[1] = 1;
            for(int i = 2; i <= n; i++){
                int cur = 0;
                for(int j = 1; j < i; j++){
                    cur = Math.max(cur, Math.max(j,dp[j])* (i - j));
                }
                dp[i] = cur;
            }

            return dp[n];
        }

}
