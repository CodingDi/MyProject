package Nordstrom;

public class FriendCircle {

    //DFS: for each row, its actually a person
    //we do DFS for each of it.
    //in DFS function: check each of its friend, which is a direct relation.
    //time:O(n^2)
    //space:O(1)
        public int findCircleNum(int[][] M) {
            if(M == null || M.length == 0){
                return 0;
            }

            int n = M.length;
            boolean[] visited = new boolean[n];
            int cnt = 0;
            for(int i = 0; i < n; i++){
                if(!visited[i]){
                    dfs(M, i, visited);
                    cnt++;
                }
            }
            return cnt;
        }

        private void dfs(int[][] M, int i, boolean[] visited){
            int n = M.length;

            visited[i] = true;

            //check each of its direct friend
            for(int j = 0; j < n; j++){
                if(!visited[j] && M[i][j] == 1){
                    dfs(M, j, visited);
                }
            }

        }

}
