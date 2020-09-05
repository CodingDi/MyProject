package Amazon;

import java.util.*;
public class TreasureISlandIIDP {



        public static void main(String[] args) {
            char[][] A = new char[][] { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'D' },
                    { 'O', 'O', 'O', 'O', 'X' }, { 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };
            System.out.println(solution(A));

            char[][] A2 = new char[][] { { 'S', 'O', 'O', 'S', 'S' }, { 'D', 'O', 'D', 'O', 'O' },
                    { 'O', 'O', 'O', 'O', 'X' }, { 'X', 'D', 'D', 'O', 'O' }, { 'X', 'D', 'D', 'D', 'O' } };
            System.out.println(solution(A2));
        }

        public static int solution(char[][] A) {
            int R = A.length;
            int C = A[0].length;

            ArrayList<int[]> sPoints = new ArrayList<>();

            int[][] dp = new int[R][C];
            for (int r = 0; r < R; r++) {
                Arrays.fill(dp[r], Integer.MAX_VALUE / 2);
            }
            // first pass
            for (int r = 0; r < R; r++) {
                for (int c = 0; c < C; c++) {
                    if (A[r][c] == 'S') {
                        sPoints.add(new int[] { r, c });
                    }
                    if (A[r][c] == 'X') {
                        dp[r][c] = 0;
                        continue;
                    }
                    if (r == 0 && c == 0 || A[r][c] == 'D') {
                        continue;
                    }
                    if (r == 0) {
                        dp[r][c] = dp[r][c - 1] + 1;
                        continue;
                    }
                    if (c == 0) {
                        dp[r][c] = dp[r - 1][c] + 1;
                        continue;
                    }
                    dp[r][c] = 1 + Math.min(dp[r][c - 1], dp[r - 1][c]);
                }
            }

            // second pass
            for (int r = R - 1; r >= 0; r--) {
                for (int c = C - 1; c >= 0; c--) {
                    if (A[r][c] == 'X') {
                        continue;
                    }
                    if (r == R - 1 && c == C - 1 || A[r][c] == 'D') {
                        continue;
                    }
                    if (r == R - 1) {
                        dp[r][c] = Math.min(dp[r][c], dp[r][c + 1] + 1);
                        continue;
                    }
                    if (c == C - 1) {
                        dp[r][c] = Math.min(dp[r][c], dp[r + 1][c] + 1);
                        continue;
                    }
                    int tmp = Math.min(dp[r][c + 1], dp[r + 1][c]);
                    dp[r][c] = 1 + Math.min(dp[r][c], tmp);
                }
            }
            int min = Integer.MAX_VALUE;
            int[] minPt = null;
            for (int[] spt : sPoints) {
                if (dp[spt[0]][spt[1]] < min) {
                    min = dp[spt[0]][spt[1]];
                    minPt = spt;
                }
            }
            //System.out.printf("min val=%d @[%d, %d]\n", min, minPt[0], minPt[1]);
            return min;
        }

    }


