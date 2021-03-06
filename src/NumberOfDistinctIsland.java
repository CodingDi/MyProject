import java.util.HashSet;
import java.util.Set;

public class NumberOfDistinctIsland {
//use direction of 'o':original
//                    'd':down
//                    'u':up
//                    'l':left
//                    'r': right
    public static void main(String[] args){
        int[][] grid1 = new int[][]{{1,1,1},
                                    {0,1,0}};
        numDistinctIslands(grid1);
    }

    public static int numDistinctIslands(int[][] grid) {
        Set<String> set = new HashSet<>();
        for(int i = 0; i < grid.length; i++) {
            for(int j = 0; j < grid[i].length; j++) {
                if(grid[i][j] != 0) {
                    StringBuilder sb = new StringBuilder();
                    dfs(grid, i, j, sb, "o"); // origin
                    grid[i][j] = 0;
                    set.add(sb.toString());
                }
            }
        }
        for(String shape :set){
            System.out.println(shape);
        }
        return set.size();
    }
    private static void dfs(int[][] grid, int i, int j, StringBuilder sb, String dir) {
        if(i < 0 || i == grid.length || j < 0 || j == grid[i].length
                || grid[i][j] == 0) return;
        sb.append(dir);
        grid[i][j] = 0;
        dfs(grid, i-1, j, sb, "u");
        dfs(grid, i+1, j, sb, "d");
        dfs(grid, i, j-1, sb, "l");
        dfs(grid, i, j+1, sb, "r");
        sb.append("b"); // back
    }
}


