package BFS;
import java.util.*;
public class FriendsCircle {

        public int findCircleNum(int[][] M) {
            if (M == null || M.length == 0) {
                return 0;
            }

            int len = M.length;
            int circles = 0;
            boolean[] visited = new boolean[len];
            Queue<Integer> queue = new LinkedList<>();

            for (int i = 0; i < len; i++) {
                if (!visited[i]) {
                    queue.offer(i);
                    visited[i] = true;

                    while (!queue.isEmpty()) {
                        int cur = queue.poll();
                        for (int j = 0; j < len; j++) {
                            if (!visited[j] && M[cur][j] == 1) {
                                queue.offer(j);
                                visited[j] = true;
                            }
                        }
                    }
                    circles++;
                }
            }

            return circles;

        }

}
