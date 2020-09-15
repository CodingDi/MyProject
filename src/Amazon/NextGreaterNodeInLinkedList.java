package Amazon;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class NextGreaterNodeInLinkedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode() {}
     *     ListNode(int val) { this.val = val; }
     *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     * }
     */

        //totally two pass
        //time O(n)
        //space:O(n) because we used a list
        public int[] nextLargerNodes(ListNode head) {
            //corner case
            if(head == null){
                return new int[0];
            }

            List<Integer> list = new ArrayList<>();

            //store the values of all list nodes
            while(head != null){
                list.add(head.val);
                head = head.next;
            }

            //store the next node's value greater than the corresponding index
            int[] nodes = new int[list.size()];

            //queue stores the index of the node
            Deque<Integer> stack = new ArrayDeque<>();

            for(int i = 0; i < list.size(); i++){
                int curVal = list.get(i);

                while(!stack.isEmpty() && list.get(stack.peekFirst()) < curVal){
                    nodes[stack.pollFirst()] = curVal;
                }

                stack.offerFirst(i);
            }
            return nodes;
        }



}
