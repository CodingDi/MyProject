import java.util.LinkedList;
import java.util.Queue;

public class TreasureIsland {
    //time:O(m*n) space:O(min(m,n))
    public static void main(String[] args) {
        char[][] grid = {
                {'O', 'O', 'O', 'O'},
                {'D', 'O', 'D', 'O'},
                {'O', 'O', 'D', 'O'},
                {'O', 'D', 'O', 'O'},
                {'X', 'O', 'O', 'O'}};
        System.out.println(minSteps(grid));
    }
        public static int minSteps(char[][] grid) {
            if(grid == null||grid.length == 0){
                return -1;
            }
            int n = grid.length;
            int m = grid[0].length;
            int steps = 0;
            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0,0});

            int[][] dirs = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
            while(!queue.isEmpty()){
                steps++;
                int size = queue.size();
                for(int k = 0; k < size; k++){
                    int[] cur = queue.poll();
                    int i = cur[0];
                    int j = cur[1];
                    //output
                    if(grid[i][j] == 'X'){
                        return steps;
                    }

                    for(int[] dir: dirs) {
                        int x = i + dir[0];
                        int y = j + dir[1];
                        if(x < 0 || x >=n || y < 0 || y >= m || grid[x][y] == 'D'){
                            continue;
                        } else if(grid[x][y] == 'X') {
                            return steps;
                        }else{
                            queue.offer(new int[]{x, y});
                        }
                    }
                }
            }
            return steps;
        }

}
