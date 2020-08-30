import java.util.*;

public class ZombieInMatrix {

    public static void main(String[] args) {
        //ZoombieInMatrix
        List<List<Integer>> grid = new ArrayList<>();
        List<Integer> r1 = new ArrayList<>(Arrays.asList(0, 1, 1, 0, 1));
        List<Integer> r2 = new ArrayList<>(Arrays.asList(0, 1, 0, 1, 0));
        List<Integer> r3 = new ArrayList<>(Arrays.asList(0, 0, 0, 0, 1));
        List<Integer> r4 = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 0));
        grid.add(r1);
        grid.add(r2);
        grid.add(r3);
        grid.add(r4);
        ZombieInMatrix t1 = new ZombieInMatrix();

        System.out.println(t1.minHours(4, 5, grid));
    }
    /**
     * Given a 2D grid, each cell is either a zombie 1 or a human 0.
     * Zombies can turn adjacent (up/down/left/right) human beings into zombies every hour.
     * Find out how many hours does it take to infect all humans?
     */

    private static int minHours(int rows, int columns, List<List<Integer>> grid) {
        if(grid == null || grid.size() == 0) return 0;
        int[][] matrix = new int[rows][columns];
        Queue<int[]> queue = new LinkedList<>();
        int hours = 0;//the number hours need so far
        int humans = 0;//the number of humans so far
        for(int i = 0; i < rows;i ++) {
            for(int j = 0; j < columns; j++) {
                int cur = grid.get(i).get(j);
                matrix[i][j] = cur;
                if(cur == 0){
                    humans++;
                } else{
                    queue.offer(new int[]{i, j});
                }
            }
        }

        int[][] directions = new int[][]{{0, 1}, {0, -1}, {-1, 0}, {1, 0}};//each four directions
        while (!queue.isEmpty()) {
            //output: if all humans are marked as zombies, its done, we output the hours need so far
            if(humans == 0) {
                return hours;
            }
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int[] cur = queue.poll();
                for (int[] dir : directions) {
                    int x = cur[0] + dir[0];
                    int y = cur[1] + dir[1];
                    if(x < 0 || x >= rows || y < 0 || y >= columns ||matrix[x][y] != 0) {
                        continue;
                    }
                    matrix[x][y] = 1;
                    queue.offer(new int[]{x, y});
                    humans--;//decrease the humans by one
                }
            }
            hours++;//each iteration, we increase the hours by one
        }
        return humans == 0 ? hours : -1;//final check
    }
}
