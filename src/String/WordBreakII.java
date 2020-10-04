package String;

import java.util.*;

public class WordBreakII {
    //solve in recursion way
        public List<String> wordBreak(String s, List<String> wordDict) {
            List<String> res = new ArrayList<>();
            Set<String> dict = new HashSet<>(wordDict);
            Map<String, List<String>> map = new HashMap<>();
            return helper(s, map, dict);

        }
        private List<String> helper(String s, Map<String, List<String>> map, Set<String> dict) {
            List<String> res = new ArrayList<>();

            //base case
            if (s == null || s.length() == 0) {
                return res;
            }

            //if it already exists i nthe map
            if (map.containsKey(s)) {
                return map.get(s);
            }

            if (dict.contains(s)) {
                res.add(s);
            }

            for (int i = 0; i < s.length(); i++) {
                String tmp = s.substring(i);

                if (dict.contains(tmp)) {
                    List<String> tmpRes = helper(s.substring(0, i), map, dict);
                    for (int j = 0; j < tmpRes.size(); j++) {
                        res.add(tmpRes.get(j) + " " + tmp);
                    }
                }



                map.put(s, res);
            }

            return res;

        }



}
