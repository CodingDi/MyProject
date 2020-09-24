public class LinkedList {

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

        public MergeTwoSortedList mergeTwoLists(MergeTwoSortedList l1, MergeTwoSortedList l2) {
            MergeTwoSortedList dummy=new MergeTwoSortedList(0);
            MergeTwoSortedList head=dummy;
            if(l1==null||l2==null){
                return l1==null?l2:l1;
            }
            while(l1!=null&&l2!=null){
                if(l1.val<l2.val){
                    dummy.next=l1;
                    l1=l1.next;
                }else{
                    dummy.next=l2;
                    l2=l2.next;
                }
                dummy=dummy.next;
            }
            if(l1!=null){
                dummy.next=l1;
            }
            if(l2!=null){
                dummy.next=l2;
            }
            return head.next;

        }

}
