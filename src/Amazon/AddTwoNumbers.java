package Amazon;

public class AddTwoNumbers {
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
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            if (l1 == null && l2 == null) {
                return null;
            }

            if (l1 == null && l2 == null) {
                return l1 == null ? l2 : l1;
            }

            ListNode dummy = new ListNode();
            ListNode dummyHead = dummy;
            int carry = 0;

            while (l1 != null || l2 != null) {
                int val1 = l1 == null ? 0 : l1.val;
                int val2 = l2 == null ? 0 : l2.val;
                int sum = val1 + val2 + carry;
                carry = sum / 10;
                int cur = sum % 10;
                dummy.next = new ListNode(cur);
                dummy = dummy.next;

                if (l1 != null) {
                    l1 = l1.next;
                }

                if (l2 != null) {
                    l2 = l2.next;
                }

            }

            if (carry == 1) {
                dummy.next = new ListNode(carry);
                dummy = dummy.next;
            }

            return dummyHead.next;
        }

}
