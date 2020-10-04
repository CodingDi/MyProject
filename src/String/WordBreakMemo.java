package String;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakMemo {
    //timeLO(n^2)
    //space:O(n)
         public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> dict = new HashSet<>(wordDict);
            Boolean[] memo = new Boolean[s.length() + 1];

            return helper(s, 0, memo, dict);



        }
        private boolean helper(String s, int index, Boolean[] memo, Set<String> dict) {
            //base case
            if (index == s.length()) {
                return true;
            }
            if (memo[index] != null) {
                return memo[index];
            }

            for (int i = index + 1; i <= s.length(); i++) {
                if (dict.contains(s.substring(index, i)) && helper(s, i, memo, dict)) {
                    memo[index] = true;
                    return true;
                }
            }

            return memo[index] = false;
        }

}
