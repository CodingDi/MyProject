package DynamicProgramming;

public class UniquePathsI {

        public int uniquePaths(int m, int n) {
            //O(m*n) time
            //O(m*n) space

            int size = 0;

            int[][] dp = new int[m][n];

            dp[m - 1][n - 1] = 1;

            for(int i = m - 1; i >= 0; i--){
                for(int j = n - 1; j >= 0; j--){
                    if(i == m - 1 && j == n - 1){
                        dp[i][j] = 1;
                    }else if(i == m - 1){
                        dp[i][j] = dp[i][j + 1];
                    }else if(j == n - 1){
                        dp[i][j] = dp[i + 1][j];
                    }else{
                        dp[i][j] = dp[i + 1][j] + dp[i][j + 1];
                    }
                }
            }

            return dp[0][0];



        }

}