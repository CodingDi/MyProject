package Amazon;

import java.util.HashMap;
import java.util.Map;

public class ValidSudoku {

        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Integer>[] rows = new HashMap[9];
            Map<Integer, Integer>[] cols = new HashMap[9];
            Map<Integer, Integer>[] grids = new HashMap[9];

            for (int i = 0; i < 9; i++) {
                rows[i] = new HashMap<Integer, Integer>();
                cols[i] = new HashMap<Integer, Integer>();
                grids[i] = new HashMap<Integer, Integer>();
            }

            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {

                    if (board[i][j] == '.') {
                        continue;
                    }
                    int val = board[i][j] - '0';
                    int k = (i/3)*3 + j/3;

                    if (rows[i].containsKey(val) || cols[j].containsKey(val) || grids[k].containsKey(val)) {
                        return false;
                    }
                    //mark as used
                    rows[i].put(val, 1);
                    cols[j].put(val, 1);
                    grids[k].put(val, 1);

                }
            }

            return true;
        }

}
