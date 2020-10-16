package PQ;
import java.util.*;
public class MergeKSortedList {
    /**
     * Definition for singly-linked list.
     *   */
     public class ListNode {
         int val;
        ListNode next;
         ListNode() {}
        ListNode(int val) { this.val = val; }
         ListNode(int val, ListNode next) { this.val = val; this.next = next; }
     }


        public ListNode mergeKLists(ListNode[] lists) {
            if (lists == null || lists.length == 0) {
                return null;
            }

            PriorityQueue<ListNode> minHeap = new PriorityQueue<>(new Comparator<ListNode>(){
                public int compare(ListNode a, ListNode b) {
                    if (a.val == b.val) {
                        return 0;
                    }
                    return a.val > b.val ? 1 : -1;
                }
            });

            for (int i = 0; i < lists.length; i++) {
                if (lists[i] != null) {
                    minHeap.offer(lists[i]);
                }

            }

            //construct the new list
            ListNode dummy = new ListNode();//used to construct the new LinkedList
            ListNode dummyHead = dummy;//used to return the new Head

            while (!minHeap.isEmpty()) {
                ListNode min = minHeap.poll();//make the min from the k list
                dummy.next = min;
                dummy = dummy.next;
                if (min.next != null) {
                    min = min.next;
                    minHeap.offer(min);
                }

            }
            return dummyHead.next;
        }

}
