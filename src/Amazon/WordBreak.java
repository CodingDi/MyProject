package Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

        public boolean wordBreak(String s, List<String> wordDict) {
            boolean[] dp = new boolean[s.length() + 1];
            //where dp[i] represents can we cut at the ith slots, there are totally n+1 slots
            Set<String> set = new HashSet<>(wordDict);
            dp[0] = true;

            for(int i = 1; i <= s.length(); i++){
                for(int j = 0; j < i; j++) {
                    if (dp[j] && set.contains(s.substring(j, i))) {
                        dp[i] = true;
                    }
                }
            }
            return dp[s.length()];
        }

}
