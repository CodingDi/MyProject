package Amazon;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreakMemo {
//timeO(n^2) for substring() function and loop
  //  space:O(n)  for Boolean[] array

        public boolean wordBreak(String s, List<String> wordDict) {

            Boolean[] memo = new Boolean[s.length()];
            Set<String> dict = new HashSet<>(wordDict);

            return helper(s, dict, 0, memo);


        }

        public boolean helper(String s, Set<String> dict, int start, Boolean[] memo){
            //base case
            if(start == s.length()){
                return true;
            }

            //if memo[]
            if(memo[start] != null){
                return memo[start];
            }

            for(int i = start + 1; i <= s.length(); i++){
                if(dict.contains(s.substring(start, i)) && helper(s, dict, i, memo)){
                    memo[start] = true;
                    return memo[start];
                }
            }
            memo[start] = false;

            return memo[start];
        }


}
