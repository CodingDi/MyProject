package Amazon;

public class MergeTwoSortedList {

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

        //time:O(m + n)  space: O(1)
        public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
            // case1 both are null
            if (l1 == null && l2 == null) {
                return null;
            }
            // case2 any is null
            if (l1 == null || l2 == null) {
                return l1 == null ? l2 : l1;
            }
            // case3 both are not null, use 2 pointers, move the smaller one
            ListNode dummy = new ListNode(0);
            ListNode dummyHead = dummy;

            while(l1 != null && l2 != null) {
                if (l1.val < l2.val) {
                    dummy.next = l1;
                    l1 = l1.next;
                } else {
                    dummy.next = l2;
                    l2 = l2.next;
                }
                dummy = dummy.next;
            }

            if (l1 != null) {
                dummy.next = l1;
            }

            if (l2 != null) {
                dummy.next = l2;
            }

            return dummyHead.next;
        }

}
