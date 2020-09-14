package Amazon;

public class TicTakToe {

    class TicTacToe {
        int[][] countRow;
        int[][] countCol;
        int[] dial1;
        int[] dial2;
        int len;
        /** Initialize your data structure here. */
        public TicTacToe(int n) {
            len = n;
            countRow = new int[n][3];
            //countRow[i][j] means the player j in ith row

            countCol = new int[n][3];
            //countCol[i][j] means the number of placement player j in the ith col

            dial1 = new int[3];
            dial2 = new int[3];
        }

        /** Player {player} makes a move at ({row}, {col}).
         @param row The row of the board.
         @param col The column of the board.
         @param player The player, can be either 1 or 2.
         @return The current winning condition, can be either:
         0: No one wins.
         1: Player 1 wins.
         2: Player 2 wins. */
        public int move(int row, int col, int player) {
            //cehck the row
            if(++countRow[row][player] == len){
                return player;
            }

            //check the column
            if(++countCol[col][player] == len){
                return player;
            }

            //check the diagnal
            if(row == col){
                if(++dial1[player] == len){
                    return player;
                }
            }

            //cehck the anti-diagnal
            if(row + col == len - 1){
                if(++dial2[player] == len){
                    return player;
                }
            }

            return 0;
        }


    }

/**
 * Your TicTacToe object will be instantiated and called as such:
 * TicTacToe obj = new TicTacToe(n);
 * int param_1 = obj.move(row,col,player);
 */
}
