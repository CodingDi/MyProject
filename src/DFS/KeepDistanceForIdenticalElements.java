package DFS;

public class KeepDistanceForIdenticalElements {

        public int[] keepDistance(int k) {
            // Write your solution here.
            int[] res = new int[k*2];//initialized as 0, each time we put a pair
            return helper(k, res) == true ? res: null;

        }

        private boolean helper(int k, int[] res) {
            //base case
            if (k == 0) {
                return true;
            }

            //recrusion rule
            for (int i = 0; i < res.length - k - 1; i++) {
                if (res[i] == 0 && res[i + k + 1] == 0) {
                    res[i] = k;
                    res[i + k + 1] = k;
                    if (helper(k - 1, res)) {
                        return true;
                    }
                    //go back
                    res[i] = 0;
                    res[i + k + 1] = 0;
                }
            }

            return false;
        }

}
