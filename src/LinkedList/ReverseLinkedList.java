package LinkedList;

import Amazon.ListNode;

public class ReverseLinkedList {

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
        public ListNode reverseList(ListNode head) {
            //iterative   time O(n)  space:O(1)
            if (head == null || head.next == null) {
                return head;
            }
            ListNode prev = null;
            ListNode cur = head;

            while (cur != null) {
                ListNode next = cur.next;
                cur.next = prev;
                prev = cur;
                cur = next;
            }
            return prev;

        }

}
