package BFS;

class Minesweeper {
    static final  int[][] dirs = new int[][]{{0, 1}, {0, -1}, {1, 0}, {-1, 0}, {1, 1}, {-1, -1}, {1, -1}, {-1, 1}};

    public char[][] updateBoard(char[][] board, int[] click) {
        if (board == null || board.length == 0) {
            return board;
        }
        int x = click[0];
        int y = click[1];
        if (board[x][y] == 'M') {
            board[x][y] = 'X';
        } else {
            reveal(board, click[0], click[1]);
        }

        return board;
    }

    private void reveal(char[][] board, int x, int y) {
        int n = board.length;
        int m = board[0].length;
        if (x < 0 || x >= n || y < 0 || y >= m ) {
            return;
        }

        int cnt = 0;
        for (int[] dir : dirs) {
            int r = x + dir[0];
            int c = y + dir[1];
            if (r < 0 || r >= n|| c < 0 || c >= m) {
                continue;
            }
            if (board[r][c] == 'M') {
                cnt++;
            }

        }

        if (cnt > 0) {
            board[x][y] = (char)('0' + cnt);
            return;
        } else {
            board[x][y] = 'B';
            for (int[] dir :dirs) {
                int r = dir[0] + x;
                int c = dir[1] + y;
                if (r < 0 || r >= n || c < 0 || c >= m ||board[r][c] != 'E') {
                    continue;
                }
                reveal(board, r, c);
            }
        }
    }
}


// M -> set as 'X' done
// E -> check 8 dirs, if any adj to mine, set cur E as digit
//                     else recursively reveal all 8 dirs