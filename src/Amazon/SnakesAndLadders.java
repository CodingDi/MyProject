package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class SnakesAndLadders {

    //method 1: 此处不需要坐标转化，直接把matrix转化成一根线 但要注意遇到ladder或者snakes的时候
    //要注意跳转到棋盘对应的Index的下一个
        public int snakesAndLadders(int[][] board) {
            boolean moveRight = false;

            int n = board.length;//denote to move right in odd rows, move left in even rows

            //1.convert the matrix to 1-D array of size n*n + 1
            int[] path = new int[n*n + 1];
            int index = 1;//initalized to ve 1
            for(int i = n - 1; i >= 0; i--){
                moveRight = !moveRight;//reverse the move order for each row

                if(moveRight){
                    for(int j = 0; j < n; j++){
                        path[index++] = board[i][j];
                    }
                }else{
                    for(int j = n - 1; j >= 0; j--){
                        path[index++] = board[i][j];
                    }
                }
            }

            //use an int[] to denote the current steps also use to denote weather visited or not
            //where step[i] represents how many steps use to reache
            //if its 0, means not visited yet
            int[] step = new int[n*n + 1];

            //2. use BFS to start
            Queue<Integer> queue = new LinkedList<>();

            queue.offer(1);
            step[1] = 1;

            while(!queue.isEmpty()){
                int cur = queue.poll();

                for(int i = cur + 1; i <= Math.min(cur + 6, n*n); i++){
                    //when its not visited yet
                    int expand = path[i] == -1 ? i: path[i];

                    if(step[expand] == 0){
                        if(expand == n * n){
                            return step[cur];
                        }

                        step[expand] = step[cur] + 1;
                        queue.offer(expand);
                    }


                }
            }


            return -1;

        }

}
