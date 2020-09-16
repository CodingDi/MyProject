package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
    class Solution {
        public int calculate(String s) {
            //corner case
            if(s == null || s.length() == 0){
                return 0;
            }

            Deque<Integer> stack = new ArrayDeque<>();
            char sign = '+';//initialize the sign as +
            int tmp = 0;

            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);

                if(Character.isDigit(cur)){
                    int num = cur - '0';

                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                        num = num*10 + s.charAt(i + 1) - '0';
                        i++;
                    }
                    tmp = num;
                }else if(cur == '('){
                    int j = i + 1;
                    int diff = 1;//the difference between left and right brackets

                    for(;j < s.length(); j++){
                        if(s.charAt(j) == '('){
                            diff++;
                        }else if(s.charAt(j) == ')'){
                            diff--;
                        }

                        //when equal,we can cut can call recursion
                        if(diff == 0){
                            break;
                        }
                    }

                    tmp = calculate(s.substring(i + 1, j));//call recursion for expression in the brackets
                    i = j;//update the i position
                }

                //deal with operands: push to the stack
                if(cur == '+' || cur == '-' || i == s.length() - 1){
                    if(sign == '+'){
                        stack.offerFirst(tmp);
                    }else if(sign == '-'){
                        stack.offerFirst(-tmp);
                    }

                    //reset the tmp variable and the sign
                    sign = cur;
                    tmp = 0;
                }
            }

            int res = 0;

            while(!stack.isEmpty()){
                res += stack.pollFirst();
            }

            return res;
        }
    }

}
