package LinkedList;

import Amazon.ListNode;

public class RotateList {
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

        public ListNode rotateRight(ListNode head, int k) {

            if (head == null || head.next == null) {
                return head;
            }
            int len = 1;
            ListNode fast = head;

            while (fast.next != null) {
                fast = fast.next;
                len++;
            }
            if (k%len == 0) {
                return head;
            }
            int shift = len - k % len - 1;

            ListNode dummy = new ListNode(0);
            dummy.next = head;
            ListNode newTail = head;

            for (int i = 0; i < shift ; i++) {
                newTail = newTail.next;
            }
            ListNode newHead = newTail.next;
            fast.next = head;
            newTail.next = null;

            return newHead;
        }

}
