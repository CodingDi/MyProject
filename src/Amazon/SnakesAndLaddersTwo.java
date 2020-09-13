package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLaddersTwo {
    //method 2 : 把每个坐标都转化成了row + col 并且用一个visited[][] 来避免重复visit

        public int snakesAndLadders(int[][] board) {
            int n = board.length;
            Queue<Integer> q = new LinkedList<>();

            boolean[][] visited = new boolean[n][n];
            q.offer(1);
            int cnt = -1;//initialzied as - 1

            while(!q.isEmpty()){
                cnt++;
                int size = q.size();//老是忘记对size进行loop

                for(int j = 0; j < size; j++){
                    int cur = q.poll();
                    //base case!
                    if(cur == n*n){
                        return cnt;
                    }

                    int row = getRow(cur, n);
                    int col = getCol(cur, n);
                    //expand each 1-6 pooints
                    //!! 注意走6个点的时候不要越界 min(6, n*n - cur) n*n - cur表示在当下还有最多多少步可以走
                    for(int i = 1; i <= Math.min(6,n*n-cur); i++){
                        int val = cur + i;
                        int newRow = getRow(val, n);
                        int newCol = getCol(val, n);

                        //if we met a ladder or snake  should update the value first, and then get row and col
                        //不然newRow改变后去取gerCol(val,n)会出错
                        if(board[newRow][newCol] != -1){
                            val=board[newRow][newCol];
                            newRow = getRow(val, n);
                            newCol = getCol(val, n);
                        }
                        //更新snake后，对任何情况都可以直接offer 当前的val
                        if(! visited[newRow][newCol]){
                            q.offer(val);
                            visited[newRow][newCol]= true;
                        }
                    }
                }
            }
            return -1;
        }

        //get the corresponding row according to the value
        private int getRow(int val, int n){
            return  n - 1 - (val- 1)/n ;
        }
        //get the corresponding col according to the value
        private int getCol(int val, int n){
            int row = (val - 1)/n;
            //for odd row
            if(row % 2 != 0){
                return n - (val - 1)% n -1;
            }else{
                //for even row
                return (val - 1) % n;

            }

        }

}
