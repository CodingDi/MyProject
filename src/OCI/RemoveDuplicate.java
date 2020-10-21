package OCI;
import java.util.*;

public class RemoveDuplicate {


        public String removeDuplicates(String S) {
            if (S == null || S.length() == 0) {
                return S;
            }
            Deque<Character> stack = new ArrayDeque<>();
            char[] charArr = S.toCharArray();

            for (int i = 0; i < charArr.length; i++) {
                char cur = charArr[i];
                if (!stack.isEmpty() && stack.peekFirst() == cur) {
                    stack.pollFirst();
                } else {
                    stack.offerFirst(charArr[i]);
                }
            }
            StringBuilder resStringBuilder = new StringBuilder();
            while (!stack.isEmpty()) {
                resStringBuilder.append(stack.pollFirst());
            }

            return resStringBuilder.reverse().toString();
        }

}
