package Amazon;

import java.util.ArrayDeque;
import java.util.Deque;

public class BasicCalculator {
        public int calculate(String s) {
            if(s == null ||s.length() == 0){
                return 0;
            }

            Deque<Integer> stack = new ArrayDeque<>();
            int tmp = 0;
            int sign = 1;

            for(int i = 0; i < s.length(); i++){
                char cur = s.charAt(i);
                if(Character.isDigit(cur)){
                    int num = cur - '0';
                    while(i + 1< s.length() && Character.isDigit(s.charAt(i + 1))){
                        num = num*10 + s.charAt(i+1) - '0';
                        i++;
                    }
                    tmp += sign*num;
                }else if(cur == '+'){
                    sign = 1;
                }else if(cur == '-'){
                    sign = -1;
                }else if(cur == '('){
                    stack.offerFirst(tmp);
                    stack.offerFirst(sign);

                    tmp = 0;
                    sign = 1;
                }else if(cur == ')'){
                    tmp =tmp*stack.pollFirst() + stack.pollFirst();
                }
            }

            return tmp;
        }

}
