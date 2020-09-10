package Design;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {


        Deque<Integer> stack;

        Deque<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            stack = new ArrayDeque<>();
            minStack = new ArrayDeque<>();
        }

        public void push(int x) {
            stack.offerFirst(x);
            if(minStack.isEmpty() ||minStack.peekFirst() >= x){
                minStack.offerFirst(x);
            }
        }

        public void pop() {
            int res =  stack.pollFirst();

            if(minStack.peekFirst()  == res){
                minStack.pollFirst();
            }
        }

        public int top() {
            return stack.peekFirst();
        }

        public int getMin() {
            return minStack.peekFirst();
        }


/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
}
