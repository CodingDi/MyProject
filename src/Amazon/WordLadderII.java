package Amazon;

import java.util.*;

public class WordLadderII {
        public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
            List<List<String>> res = new ArrayList<>();
            Queue<List<String>> q = new LinkedList<>();
            List<String> path = new ArrayList<>();//prefix path   hot -> cot
            path.add(beginWord);                  //        -> dot ->dog->cog
            q.offer(path);
            Set<String> dict = new HashSet<>();
            for(String word : wordList){
                dict.add(word);
            }
            while(!q.isEmpty()){
                //base case
                if(!res.isEmpty()){
                    return res;
                }
                int size = q.size();
                for(int i = 0;i < size; i ++){
                    List<String> curList = q.poll();
                    String curWord = curList.get(curList.size() - 1);
                    if(curWord.equals(endWord)){
                        res.add(new ArrayList<>(curList));
                    }
                    dict.remove(curWord);
                    StringBuilder sb = new StringBuilder(curWord);
                    for(int j = 0; j < curWord.length(); j++){
                        for(char c = 'a'; c < 'z'; c++){
                            if(sb.charAt(j) == c){
                                continue;
                            }
                            sb.setCharAt(j,c);
                            if(dict.contains(sb.toString())){
                                curList.add(sb.toString());
                                q.offer(new ArrayList<>(curList));
                                curList.remove(curList.size() - 1);
                            }
                        }
                        sb.setCharAt(j , curWord.charAt(j));
                    }
                }
            }
            return res;
        }

}
