import java.util.LinkedList;
import java.util.Queue;

public class TreasureIslandII {
    /*
    You have a map that marks the locations of treasure islands.
    Some of the map area has jagged rocks and dangerous reefs.
    Other areas are safe to sail in.
    There are other explorers trying to find the treasure.
    So you must figure out a shortest route to one of the treasure islands.
    Assume the map area is a two dimensional grid, represented by a matrix of characters.
    You must start from one of the starting point (marked as S) of the map
    and can move one block up, down, left or right at a time.
    The treasure island is marked as X.
    Any block with dangerous rocks or reefs will be marked as D.
    You must not enter dangerous blocks. You cannot leave the map area.
     Other areas O are safe to sail in.
     Output the minimum number of steps to get to any of the treasure islands.

Example:

Input:
[['S', 'O', 'O', 'S', 'S'],
 ['D', 'O', 'D', 'O', 'D'],
 ['O', 'O', 'O', 'D', 'D'],
 ['X', 'D', 'D', 'O', 'O'],
 ['X', 'D', 'D', 'D', 'O']]
    *
     */

    // "static void main" must be defined in a public class.
        static int m, n;
        public static void main(String[] args) {
            char[][] input = new char[][]{{'S', 'O', 'O', 'S', 'S'},
                    {'D', 'O', 'D', 'O', 'O'},
                    {'O', 'O', 'O', 'O', 'X'},
                    {'X', 'D', 'D', 'O', 'O'},
                    {'X', 'D', 'D', 'D', 'O'}};
            int rst = multiSourceShortest(input);
            System.out.println(rst);
        }

        public static int multiSourceShortest(char[][] matrix) {
            int n = matrix.length;
            int m = matrix[0].length;
            int MAX = m*n;
            int[][] rst = new int[n][m];
            int path = Integer.MAX_VALUE;

            // Sweep from upper left to bottom right
            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){
                    if(matrix[i][j] == 'D'){
                        rst[i][j] = MAX;
                    } else if(matrix[i][j] == 'X'){
                        rst[i][j] = 0;
                    } else {
                        int cellAbove = i > 0 ? rst[i-1][j] : MAX;
                        int cellLeft = j > 0 ? rst[i][j-1] : MAX;
                        rst[i][j] = Math.min(cellAbove, cellLeft) + 1;
                    }
                }
            }

            // Sweep from bottom right to upper left
            for(int i = n-1; i >= 0; i--){
                for(int j = m-1; j >= 0; j--){
                    if(matrix[i][j] != 'D'){
                        int cellBelow = i < n-1 ? rst[i+1][j] : MAX;
                        int cellRight = j < m-1 ? rst[i][j+1] : MAX;
                        rst[i][j] = Math.min(rst[i][j], Math.min(cellBelow, cellRight) + 1);
                    }

                    // pick out the source nodes and get min path length
                    if(matrix[i][j] == 'S'){
                        path = Math.min(path, rst[i][j]);
                    }
                }
            }

            return path;
        }
    }

