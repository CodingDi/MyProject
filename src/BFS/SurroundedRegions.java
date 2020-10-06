package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class SurroundedRegions {
        public void solve(char[][] board) {

            if (board == null || board.length == 0) {
                return;
            }
            //starts from the
            int n = board.length;
            int m = board[0].length;
            Queue<int[]> queue = new LinkedList<>();
            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            for (int i = 0; i < m; i++) {
                if (board[0][i] == 'O') {
                    queue.offer(new int[]{0, i});
                    board[0][i] = '.';
                }
                if (board[n - 1][i] == 'O') {
                    queue.offer(new int[]{n - 1, i});
                    board[n - 1][i] = '.';
                }
            }

            for (int j = 0; j < n; j++) {
                if (board[j][0] == 'O') {
                    queue.offer(new int[]{j, 0});
                    board[j][0] = '.';
                }
                if (board[j][m - 1] == 'O') {
                    queue.offer(new int[]{j, m - 1});
                    board[j][m - 1] = '.';
                }
            }

            while(!queue.isEmpty()) {
                int[] cur = queue.poll();
                for (int[] dir : dirs) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if (x < 0 || x >= n || y < 0 || y >= m || board[x][y] != 'O') {
                        continue;
                    }
                    queue.offer(new int[]{x, y});
                    board[x][y] = '.';
                }
            }

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (board[i][j] == 'O') {
                        board[i][j] = 'X';
                    } else if (board[i][j] == '.') {
                        board[i][j] = 'O';
                    }
                }
            }


        }

}
