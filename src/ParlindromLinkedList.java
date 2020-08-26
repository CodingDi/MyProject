public class ParlindromLinkedList {
    public boolean isPalindrome(ListNode head) {
        if(head == null||head.next == null){
            return true;
        }
        ListNode slow = head;
        ListNode fast = head;

        while(fast.next != null&&fast.next.next != null){
            slow=slow.next;
            fast = fast.next.next;
        }

        ListNode mid = slow;
        ListNode second = reverse(mid.next);
        while(head!= null&& second != null){
            if(head.val != second.val){
                return false;
            }
            head=head.next;
            second = second.next;
        }
        return true;
    }
    private ListNode reverse(ListNode head){
        if(head == null|| head.next == null){
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        while(cur != null){
            ListNode next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        return prev;
    }
}


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


