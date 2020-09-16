package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class BsicCalculatorII {

        public int calculate(String s) {
            if(s == null || s.length() == 0){
                return 0;
            }

            int tmp = 0;
            char sign = '+';
            Deque<Integer> stack = new ArrayDeque<>();

            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);
                //1. deal with the digits
                if(Character.isDigit(cur)){
                    int num = cur - '0';
                    while(i + 1 < s.length() && Character.isDigit(s.charAt(i + 1))){
                        num = num*10 + s.charAt(i + 1) - '0';
                        i++;//avoid deap loop!!
                    }
                    tmp = num;
                }

                //2. deal with then operands and the last character
                if(cur != ' ' && !Character.isDigit(cur) || i == s.length() - 1){
                    if(sign == '+'){
                        stack.offerFirst(tmp);

                    }else if(sign == '-'){
                        stack.offerFirst(-tmp);

                    }else if(sign == '*'){
                        stack.offerFirst(stack.pollFirst()*tmp);

                    }else if(sign == '/'){
                        stack.offerFirst(stack.pollFirst()/tmp);

                    }

                    sign = cur;//update the sign because we just used the previous sign
                    tmp = 0;//reset the tmp
                }
            }

            int res = 0;

            while(!stack.isEmpty()){
                res += stack.pollFirst();
            }

            return res;
        }


}
