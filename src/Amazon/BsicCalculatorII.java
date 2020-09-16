package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class BsicCalculatorII {
        public int calculate(String s) {

            if(s == null){
                return 0;
            }

            Deque<Integer> stack = new ArrayDeque<>();

            char sign = '+';
            int num = 0;
            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);

                //case1. if cur is a digit
                if(Character.isDigit(cur)){
                    num = num*10 + cur - '0';
                }

                //case2. if cur is a sign
                if(cur != ' ' && !Character.isDigit(cur) || i == s.length() - 1){
                    if(sign == '+'){

                        stack.offerFirst(num);

                    }else if(sign == '-'){

                        stack.offerFirst(-num);

                    }else if(sign == '*'){

                        stack.offerFirst(stack.pollFirst() * num);

                    }else{

                        stack.offerFirst(stack.pollFirst()/num);

                    }
                    num = 0;//reset the number
                    sign = cur;//update the sign at the end
                }

            }



            int res = 0;
            while(!stack.isEmpty()){
                res += stack.pollFirst();
            }


            return res;
        }

}
