package DFS;

public class WallsAndGates {
        public void wallsAndGates(int[][] rooms) {
            if (rooms == null || rooms.length == 0) {
                return;
            }
            int n = rooms.length;
            int m = rooms[0].length;
            boolean[][] visited = new boolean[n][m];

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    if (rooms[i][j] == 0) {
                        dfs(rooms, i, j, 0);
                    }
                }
            }
        }

        private void dfs(int[][] rooms, int i, int j, int distance) {
            int n = rooms.length;
            int m = rooms[0].length;

            if (i < 0 || i >= n || j < 0 || j >= m || rooms[i][j] < distance) {
                return;
            }

            rooms[i][j] = distance;//assgin the current cell as the current distance

            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};

            for (int[] dir : dirs) {
                int newX = dir[0] + i;
                int newY = dir[1] + j;
                dfs(rooms, newX, newY, distance + 1);
            }
        }
}
