import java.util.ArrayList;
import java.util.List;

public class RemoveInvalidParenthesis {
    class Solution {
        public List<String> removeInvalidParentheses(String s) {
            // use dfs to do the removal of parenthesis
            // use a cnt to denote the difference between left and right brackets
            //     left->cnt ++
            //     right->cnt--
            // we can remove right when cnt < 0
            // recursively call removal
            // the same for left brckets removal,but need to swap the pattern


            List<String> res = new ArrayList<>();
            remove(res, s, 0, 0, new char[]{'(', ')'});
            return res;

        }
        private void remove(List<String> res, String s, int left, int right, char[] pattern){
            int diff = 0;
            for(;right < s.length(); right++){
                char cur = s.charAt(right);
                if(cur == pattern[0]){
                    diff++;
                }else if(cur == pattern[1]){
                    diff--;
                }
                if(diff < 0){
                    break;
                }

            }

            //remove the pattern[1]
            if(diff < 0){
                for(int i = left; i <= right; i++){
                    char cur = s.charAt(i);
                    if(cur != pattern[1]){
                        continue;
                    }
                    if(i > 1 && s.charAt(i) == s.charAt(i - 1)){
                        continue;
                    }
                    remove(res, s.substring(0, i) + s.substring(i+1), i, right, pattern);
                }
            }else if(diff > 0){
                remove(res, new StringBuilder(s).reverse().toString(), 0, 0, new char[]{')', '('});
            }else{
                res.add(pattern[0] == '('? s: new StringBuilder(s).reverse().toString());
            }



        }
    }
}
