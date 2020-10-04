package String;

import java.util.*;

public class ConcatinatedWordMemoRecursion {

        public List<String> findAllConcatenatedWordsInADict(String[] words) {
            Set<String> dict = new HashSet<>();
            List<String> res = new ArrayList<>();


            for (String word : words) {
                dict.add(word);
            }

            for (String word : words) {
                dict.remove(word);
                int[] memo = new int[word.length()  + 1];
                Arrays.fill(memo, -1);
                if (word == null || word.length() == 0) {
                    continue;
                }
                if (canBreak(word, dict, memo, 0)) {
                    res.add(word);
                }
                dict.add(word);
            }

            return res;

        }

        private boolean canBreak(String s, Set<String> dict, int[] memo, int index) {
            //base case
            if (index == s.length()) {
                return true;
            }

            //already exist
            if (memo[index] == 1) {
                return true;
            } else if (memo[index] == 0) {
                return false;
            }

            for (int i = index + 1; i <= s.length(); i++) {
                if (dict.contains(s.substring(index, i)) && canBreak(s, dict, memo, i)) {
                    memo[index] = 1;
                    return true;
                }
            }
            memo[index] = 0;
            return false;
        }

}
