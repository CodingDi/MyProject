package DFS;

public class TheMaze {
    //time:O(m*n
    //space:O(m*n)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {

            int n = maze.length;
            int m = maze[0].length;
            boolean[][] visited = new boolean[n][m];
            return dfs(maze, start[0], start[1], destination, visited);
        }

        //helper function: at current pos(i, j) visit it and expad
        //case1. its the dest, return T
        //case2. empty move until reaches the end wall
        //go back one step and call recursion for next
        //we alway sassume the input(i, j) is valid
        //also used boolean[][] for deduplication, whenever we expand at the original pos, mark it as visited
        private boolean dfs(int[][] maze, int i, int j, int[] dest, boolean[][] visited) {

            //base case
            if (i == dest[0] && j == dest[1]) {
                return true;
            }

            int n = maze.length;
            int m = maze[0].length;

            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

            //expand it
            visited[i][j] = true;

            for (int[] dir : dirs) {
                int row = i;
                int col = j;
                while(row >= 0 && row < n && col >= 0 && col < m && maze[row][col] != 1) {
                    row += dir[0];
                    col += dir[1];
                }
                row -= dir[0];
                col -= dir[1];

                if (!visited[row][col] && dfs(maze, row, col, dest, visited)) {
                    return true;
                }
            }

            return false;
        }

}
