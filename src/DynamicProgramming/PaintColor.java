package DynamicProgramming;

public class PaintColor {

        public int minCost(int[][] costs) {
            if (costs == null ||costs.length == 0) {
                return 0;
            }
            int n = costs.length;
            int[][] dp = costs;
            int j = 0;

            for (int i = 1; i < n; i++) {
                dp[i][0] = costs[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
                dp[i][1] = costs[i][1] + Math.min(dp[i - 1][2], dp[i - 1][0]);
                dp[i][2] = costs[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
            }
            return Math.min(dp[n - 1][0], Math.min(dp[n - 1][1], dp[n - 1][2]));
        }

}
