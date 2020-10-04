package BFS;

import java.util.*;

public class WordLadder {

        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
            // shortest -> BFS -> Queue
            //         start state: beginWord
            //         end state: endWord
            //         how to expand: for each word(String) in the queue,
            //                         try to replace each char with other ('a' - 'z')
            //                         if the new String is in the wordDict, add it to the queue
            //                         and expand later.
            //             each layer expansion in the queue, add step + 1.
            //             when finish: either the queue is empty or we visit a word == endWord

            //         tip1: fast access for wordList
            //         use a hashset

            //         tip2.avoid  duplicated expansion
            //             e.g.  dog -> dot
            //                   hot - > dot   in this case, dot will be expanded twice!!
            //             so make sure each word is expanded once only -> use a hashset

            // time: O(26 * wordlen)
            //space: O(26 * wordLen)

            if (beginWord.equals(endWord)) {
                return 0;
            }

            Set<String> wordDict = new HashSet<>(wordList);

            //initialization
            Queue<String> queue = new LinkedList<>();
            queue.offer(beginWord);
            int step = 0;

            while (!queue.isEmpty()) {
                int size = queue.size();
                step++;

                for (int j = 0; j < size; j++) {
                    String curStr = queue.poll();
                    char[] arr = curStr.toCharArray();

                    //end condition
                    if (curStr.equals(endWord)) {
                        return step;
                    }

                    //at curString, replace char
                    for (int i = 0; i < arr.length; i++) {
                        char tmpChar = arr[i];//record the curChar, as we will go back to replace back for next level

                        //replace tmpChar with all 26 chars
                        for (char c = 'a'; c <= 'z'; c++) {
                            if (c == tmpChar) {
                                continue;
                            }
                            arr[i] = c;
                            String newWord = new String(arr);

                            if (wordDict.contains(newWord)) {
                                queue.offer(newWord);
                                wordDict.remove(newWord);//remove for deduplication
                            }
                        }
                        arr[i] = tmpChar;//swap bac for next index
                    }
                }
            }
            return 0;

        }

}
