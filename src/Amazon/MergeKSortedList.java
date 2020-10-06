package Amazon;

import java.util.PriorityQueue;

public class MergeKSortedList {
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
    //use a Prioirtyqueue of control the pointer of each list.
    //always pick the smallest to the res and move it to the next
        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy = new ListNode(0);
            ListNode dummyHead = dummy;

            PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> (a.val - b.val));
            for (int i = 0; i < lists.length; i++) {
                if (lists[i] == null) {
                    continue;
                }
                pq.offer(lists[i]);
            }

            while(!pq.isEmpty()) {
                ListNode min = pq.poll();
                if (min.next != null) {
                    pq.offer(min.next);
                }
                dummy.next = min;
                dummy = dummy.next;
            }

            return dummyHead.next;
        }

}
