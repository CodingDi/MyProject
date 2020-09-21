package DivideAndConquer;

import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKSortedList {

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

        public ListNode mergeKLists(ListNode[] lists) {
            ListNode dummy=new ListNode(0);//create a dummy node
            ListNode cur=dummy;//current processing node:also pointer
            //initialization of pq minHeap to store the current smallest k listnodes so far
            PriorityQueue<ListNode> minHeap=new PriorityQueue<ListNode>(11,new Comparator<ListNode>(){
                public int compare(ListNode l1,ListNode l2){
                    if(l1.val==l2.val){
                        return 0;
                    }else{
                        return l1.val>l2.val?1:-1;
                    }
                }
            });
            //first step:insert all smallest header in all lists to the minHeap
            for(ListNode head:lists){
                if(head!=null){
                    minHeap.offer(head);
                }
            }
            while(!minHeap.isEmpty()){
                //we take out the top elments: which will be automatically smallest amaong the k heads
                //and connect it with the cur
                cur.next=minHeap.poll();
                if(cur.next.next!=null){
                    //if there's still any node in this linkedlist, we move and insert it in the minHeap
                    minHeap.offer(cur.next.next);
                }
                cur=cur.next;
            }
            return dummy.next;

        }

}
