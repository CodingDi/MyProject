package Tree;
import java.util.*;
public class VerifyPreorderSequence {
        public boolean verifyPreorder(int[] preorder) {
            if (preorder == null || preorder.length == 0) {
                return true;
            }

            Deque<Integer> stack = new ArrayDeque<>();
            stack.offerFirst(preorder[0]);//offet the root vlaue
            int low = Integer.MIN_VALUE;

            for (int i = 1; i < preorder.length; i++) {
                if (preorder[i] < low) {
                    return false;
                } else {
                    while (!stack.isEmpty() && stack.peekFirst() < preorder[i]) {
                        low = stack.peekFirst();
                        stack.pollFirst();

                    }
                    stack.offerFirst(preorder[i]);
                }
            }

            return true;
        }

}
