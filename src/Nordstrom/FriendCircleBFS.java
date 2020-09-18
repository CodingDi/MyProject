package Nordstrom;

import java.util.LinkedList;
import java.util.Queue;

public class FriendCircleBFS {
    //BFS way expand from each row. offer it to the queue + boolean[]
        public int findCircleNum(int[][] M) {
            if(M == null || M.length == 0){
                return 0;
            }

            Queue<Integer> queue = new LinkedList<>();
            boolean[] visited = new boolean[M.length];
            int cnt = 0;

            for(int i = 0; i < M.length; i++){
                if(!visited[i]){
                    cnt ++;
                    queue.offer(i);
                    visited[i] = true;

                    while(!queue.isEmpty()){
                        int cur = queue.poll();
                        // visited[cur] = true;

                        for(int j = 0; j < M.length; j++){
                            if(!visited[j] && M[cur][j] == 1){
                                queue.offer(j);
                                visited[j] = true;
                            }
                        }
                    }

                }

            }

            return cnt;
        }



}
