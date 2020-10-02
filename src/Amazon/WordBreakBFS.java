package Amazon;

import java.util.*;

public class WordBreakBFS {
    //space:O(n)
    //time: O(n^2)
        public boolean wordBreak(String s, List<String> wordDict) {
            Set<String> set = new HashSet<>(wordDict);
            Queue<Integer> queue = new LinkedList<>();
            queue.offer(0);

            boolean[] visited = new boolean[s.length() + 1];

            while(!queue.isEmpty()) {
                int cur = queue.poll();
                if (visited[cur]) {
                    continue;
                }

                for (int i = cur + 1; i <= s.length(); i++) {
                    if (set.contains(s.substring(cur, i))) {

                        //base case
                        if (i == s.length()) {
                            return true;
                        }
                        queue.offer(i);
                    }
                }
                visited[cur] = true;
            }
            return false;
        }

}
