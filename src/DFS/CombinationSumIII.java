package DFS;
import java.util.*;
public class CombinationSumIII {
        public List<List<Integer>> combinationSum3(int k, int n) {
            int[] candidates = new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9};
            List<List<Integer>> res = new ArrayList<>();

            List<Integer> path = new ArrayList<>();
            dfs(res, candidates, 0, path, n, k);
            return res;
        }

        private void dfs(List<List<Integer>> res, int[] candidates, int index, List<Integer> path, int target, int k) {
            if (target <= 0) {
                if (target == 0 && path.size() == k) {
                    res.add(new ArrayList<>(path));
                }
                return;
            }



            for (int i = index; i < candidates.length; i++) {
                path.add(candidates[i]);
                dfs(res, candidates, i + 1, path, target - candidates[i], k);
                path.remove(path.size()  - 1);

            }
        }

}
