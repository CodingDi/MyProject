package Amazon;

import java.util.*;

public class NumberOfDistinctIslandsII {
        // HARD
        //http://www.noteanddata.com/leetcode-711-Number-of-Distinct-Islands-II-java-solution-note.html
        public int numDistinctIslands2(int[][] grid) {
            if(grid == null||grid.length == 0){
                return 0;
            }
            //for each cell unvisited and with value1, dfs it and
            //store this island with different tramsformation including
            //each form is a string encoded by sorted cell position
            //need to add all format to set.
            //and count will increase by one if any firm is alread exists

            int n = grid.length;
            int m = grid[0].length;

            int cnt = 0;


            boolean[][] visited = new boolean[n][m];
            Set<String> set = new HashSet<>();

            for(int i = 0; i < n; i++){
                for(int j = 0; j < m; j++){

                    if(!visited[i][j] && grid[i][j] == 1){

                        List<List<int[]>> island = new ArrayList<>();
                        for(int k = 0; k < 8; k++){
                            island.add(new ArrayList<int[]>());
                        }

                        dfs(grid, island, i, j, i, j, visited);


                        boolean flag = false;//initialized as false
                        List<String> sets = new ArrayList<>();//stores each unique form of each island
                        //for each form of this island, we sort each position
                        for(List<int[]> list: island){
                            if(list.size() == 0) continue;
                            Collections.sort(list, (a, b) ->(a[0] == b[0] ? a[1] - b[1]: a[0] - b[0]));
                            String form = encode(list); //encode each sorted form to String
                            if(set.contains(form)){
                                flag = true;//duplciate exists
                            }
                            sets.add(form);
                        }

                        if(!flag){
                            cnt++;
                            set.addAll(sets);
                        }
                    }
                }
            }
            return cnt;
        }

        //notice that after sorting, the base index would change, so we need to regularize it again
        //based on the base position
        private String encode(List<int[]> list){

            StringBuilder prefix = new StringBuilder();
            int ox = list.get(0)[0];
            int oy = list.get(0)[1];

            for(int[] cell: list){
                prefix.append(cell[0] - ox).append(',').append(cell[1] - oy).append(';');
            }

            String form = prefix.toString();;
            return form;
        }


        private void dfs(int[][] grid, List<List<int[]>> island, int x0, int y0, int i, int j, boolean[][] visited){
            int n = grid.length;
            int m = grid[0].length;

            if(i < 0 || i >= n|| j < 0 || j >= m || visited[i][j] || grid[i][j] == 0){
                return;
            }

            addPosition(island, i - x0, j - y0);//add the current position to all form
            visited[i][j] = true;
            //loop all four directions for DFS
            dfs(grid, island, x0, y0, i + 1, j, visited);
            dfs(grid, island, x0, y0, i - 1, j, visited);
            dfs(grid, island, x0, y0, i, j + 1, visited);
            dfs(grid, island, x0, y0, i, j - 1, visited);

        }


        private void addPosition(List<List<int[]>> island, int dx, int dy){

            island.get(0).add(new int[]{dx, dy});

            // rotation
            island.get(1).add(new int[]{-dy, dx});
            island.get(2).add(new int[]{-dx, -dy});
            island.get(3).add(new int[]{dy, -dx});

            // mirror
            island.get(4).add(new int[]{-dx, dy});
            island.get(5).add(new int[]{dx, -dy});

            island.get(6).add(new int[]{dy, dx});
            island.get(7).add(new int[]{dy, -dx});
        }

}
