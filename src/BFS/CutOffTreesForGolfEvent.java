package BFS;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class CutOffTreesForGolfEvent {


        static int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}};
        public int cutOffTree(List<List<Integer>> forest) {
            int n = forest.size();
            int m = forest.get(0).size();

            PriorityQueue<int[]> trees = new PriorityQueue<>((a, b) -> (forest.get(a[0]).get(a[1]) - forest.get(b[0]).get(b[1])));
            int total = 0;
            int[] start = new int[]{0, 0};



            for (int i = 0; i < forest.size(); i++) {
                for (int j = 0; j < forest.get(0).size(); j++) {
                    if (forest.get(i).get(j) > 1) {
                        trees.offer(new int[]{i, j});
                    }
                }
            }

            while (!trees.isEmpty()) {
                int[] goal = trees.poll();
                int step = minStep(forest, start, goal, n, m);

                if (step == -1) {
                    return -1;
                }
                total += step;
                start[0] = goal[0];
                start[1] = goal[1];
            }

            return total;

        }

        private int minStep(List<List<Integer>> forest, int[] start, int[] goal, int n, int m) {
            int step = 0;
            Queue<int[]> queue = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            queue.offer(start);
            int x = start[0];
            int y = start[1];
            visited[x][y] = true;

            while (!queue.isEmpty()) {
                int size = queue.size();
                for (int i = 0; i < size; i++) {
                    int[] pos = queue.poll();

                    if (pos[0] == goal[0] && pos[1] == goal[1]) {
                        return step;
                    }

                    for (int[] dir : dirs) {
                        int newX = pos[0] + dir[0];
                        int newY = pos[1] + dir[1];
                        if (newX < 0 || newX >= n || newY < 0 || newY >= m || forest.get(newX).get(newY) == 0 || visited[newX][newY]) {
                            continue;
                        }
                        queue.offer(new int[]{newX, newY});
                        visited[newX][newY] = true;
                    }
                }
                step++;

            }

            return -1;

        }

}
