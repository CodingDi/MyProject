package DFS;

import java.util.ArrayList;
import java.util.List;

public class FactorCombinations {


        public List<List<Integer>> getFactors(int n) {

            List<List<Integer>> res = new ArrayList<>();
            if (n <= 1) {
                return res;
            }
            List<Integer> cur = new ArrayList<>();
            List<Integer> factors = allFactors(n);

            helper(res, cur, factors, 0, n);
            return res;
        }

        private void helper(List<List<Integer>> res, List<Integer> cur, List<Integer> factors, int index, int target) {
            //base case
            if (index == factors.size()) {
                if (target == 1) {
                    res.add(new ArrayList<Integer>(cur));
                }
                return;
            }

            int factor = factors.get(index);
            //not add
            helper(res, cur, factors, index + 1, target);

            //add
            int cnt = 0;
            while (target % factor == 0) {
                cur.add(factor);
                cnt++;
                target /= factor;
                helper(res, cur, factors, index + 1, target);

            }

            //go back
            while (cnt > 0) {
                cur.remove(cur.size() - 1);
                cnt--;
            }


        }
        private List<Integer> allFactors(int n) {
            List<Integer> factors = new ArrayList<>();

            for (int i = 2; i <= n/2; i++) {
                if (n%i == 0) {
                    factors.add(i);
                }

            }
            return factors;
        }

}
