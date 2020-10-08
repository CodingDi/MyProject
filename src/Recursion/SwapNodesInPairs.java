package Recursion;

import Amazon.ListNode;

public class SwapNodesInPairs {
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

        public ListNode swapPairs(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode newHead = head.next;
            ListNode next = head.next.next;
            newHead.next =head;
            head.next = swapPairs(next);

            return newHead;
        }

}
