package BFS;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class MinimumKnightMoves {
        public int minKnightMoves(int x, int y) {
            x = Math.abs(x);
            y = Math.abs(y);

            Queue<int[]> queue = new LinkedList<>();
            queue.offer(new int[]{0, 0});
            Set<String> set = new HashSet<>();
            set.add(0 + "," + 0);

            int[][] dirs = new int[][]{{2, 1}, {-2, 1}, {2, -1}, {-2, -1}, {1, 2}, {1, -2}, {-1, -2}, {-1, 2}};
            int step = -1;

            while(!queue.isEmpty()) {
                int size = queue.size();
                step++;

                for (int i = 0; i < size; i++) {
                    int[] cur = queue.poll();

                    //base case
                    if (cur[0] == x && cur[1] == y) {
                        return step;
                    }

                    for (int[] dir :dirs) {
                        int row = cur[0] + dir[0];
                        int col = cur[1] + dir[1];

                        if (row >= -1 && col >= -1 && !set.contains(row + "," + col)) {
                            queue.offer(new int[]{row, col});
                            set.add(row + "," + col);
                        }
                    }
                }
            }
            return step;
        }

}
