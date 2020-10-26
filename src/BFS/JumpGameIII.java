package BFS;

import java.util.LinkedList;
import java.util.Queue;

public class JumpGameIII {

        public boolean canReach(int[] arr, int start) {
            if (arr == null || arr.length == 0) {
                return false;
            }
            if (arr[start] == 0){
                return true;
            }

            Queue<Integer> queue = new LinkedList<>();//queue stores the index
            queue.offer(start);
            boolean[] visited = new boolean[arr.length];
            visited[start] = true;
            while (!queue.isEmpty()) {
                int curIndex = queue.poll();
                int prev = curIndex - arr[curIndex];
                int next = curIndex + arr[curIndex];
                //base case
                if (prev >= 0 && !visited[prev]) {
                    if (arr[prev] == 0) {
                        return true;
                    } else {
                        queue.offer(prev);
                        visited[prev] = true;
                    }
                }

                if (next < arr.length && !visited[next]) {
                    if (arr[next] == 0) {
                        return true;
                    } else {
                        queue.offer(next);
                        visited[next] = true;
                    }
                }
            }
            return false;
        }

}
