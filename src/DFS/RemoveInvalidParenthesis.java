package DFS;

import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {


        public List<String> removeInvalidParentheses(String s) {

            List<String> res = new ArrayList<>();

            if(s == null) {
                return res;
            }

            remove(res, s, 0, 0, new char[]{'(', ')'});
            return res;

        }

        //right:we will process as long as right does not reaches the end
        //left: the position we were processing last time
        private void remove(List<String> res, String s, int left, int right, char[] pattern) {
            int diff = 0;

            for(; right < s.length(); right++){
                char cur = s.charAt(right);

                if(cur == pattern[0]){
                    diff++;
                } else if(cur == pattern[1]){
                    diff--;
                }

                if(diff < 0){
                    break;//break the current to remove one of the character from left till right
                }
            }

            //remove any pattern[1] within the range of [left,right]
            if(diff < 0){
                for(int i = left; i <= right; i++){
                    if(s.charAt(i) != pattern[1]){
                        continue;
                    }

                    if(i > 1 && s.charAt(i) == s.charAt(i - 1)){
                        continue;
                    }

                    remove(res, s.substring(0, i) + s.substring(i + 1), i, right, pattern);
                }
            } else if(diff > 0) {
                remove(res, new StringBuilder(s).reverse().toString(), 0, 0, new char[]{')', '('});
            } else {
                res.add(pattern[0] == '('? s: new StringBuilder(s).reverse().toString());
            }
        }

}
