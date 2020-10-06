package LinkedList;

import Amazon.ListNode;

public class SortList {
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

        public ListNode sortList(ListNode head) {
            if (head == null || head.next == null) {
                return head;
            }

            ListNode mid = getMid(head);
            ListNode right = sortList(mid.next);
            mid.next = null;
            ListNode left = sortList(head);

            return merge(left, right);

        }
        private ListNode merge(ListNode list1, ListNode list2) {
            ListNode dummyHead = new ListNode();
            ListNode tail = dummyHead;

            while (list1 != null && list2 != null) {
                if (list1.val < list2.val) {
                    tail.next = list1;
                    list1 = list1.next;
                } else {
                    tail.next = list2;
                    list2 = list2.next;
                }
                tail = tail.next;
            }
            tail.next = (list1 != null) ? list1 : list2;
            return dummyHead.next;
        }

        private ListNode getMid(ListNode head) {
            //1--2--3-
            //1--2--3--4--5
            if (head == null || head.next == null) {
                return head;
            }
            ListNode slow = head;
            ListNode fast = head;

            while(fast.next != null && fast.next.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }

            return slow;
        }

}
