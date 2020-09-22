package Amazon;

import java.util.*;

public class WordLadder {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // 1. use a set to construct a dict for wordlist
            // 2. use queue to do BFS and offer beginword,
            //     from beginword, try to change each char to other 25,
            //     see if its equal to end,if yes, output
            //     if not, offer
            //     increase level each time

            Set<String> dict = new HashSet<>(wordList);



            //base case
            if (beginWord.equals(endWord)) {
                return 0;
            }

            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);

            //other
            int len = 0;
            while (!queue.isEmpty()) {
                int size = queue.size();
                len++;

                for(int i = 0; i < size; i++) {
                    String cur = queue.poll();

                    if (cur.equals(endWord)) {
                        return len;
                    }

                    StringBuilder sb = new StringBuilder(cur);

                    //loop the curStr and swap it with other 25
                    for (int j = 0; j < sb.length(); j++) {
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == sb.charAt(j)) {
                                continue;
                            }
                            sb.setCharAt(j, c);//set char at j as c

                            //if the word is in the dict
                            String tmp = sb.toString();
                            if (dict.contains(tmp)) {
                                queue.offer(tmp);
                                dict.remove(tmp);//deduplciation
                            }
                        }
                        sb.setCharAt(j, cur.charAt(j));//swap back
                    }
                }


            }

            return 0;
        }

}
