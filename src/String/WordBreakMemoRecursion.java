package String;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakMemoRecursion {
        public boolean wordBreak(String s, List<String> wordDict) {
            //memorization + recursion
            int[] memo = new int[s.length() + 1];
            Arrays.fill(memo, -1);
            Set<String> dict = new HashSet<>(wordDict);

            return helper(s, dict, memo, 0);

        }

        private boolean helper(String s, Set<String> dict, int[] memo, int index) {
            //base case
            if (index == s.length()) {
                return true;
            }

            if (memo[index] != -1) {
                return memo[index] == 1 ? true: false;
            }

            for (int i = index + 1; i <= s.length(); i++) {
                if(dict.contains(s.substring(index, i)) && helper(s, dict, memo, i)) {
                    memo[index] = 1;
                    return true;
                }
            }

            memo[index] = 0;
            return false;
        }

}
