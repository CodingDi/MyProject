package DFS;

public class FlattenMultilevelDoublyLinkedList {
    /*
// Definition for a Node.
class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;
};
*/
        public Node flatten(Node head) {
            if (head == null) {
                return head;
            }
            Node dummy = new Node(0, null, head, null);
            helper(dummy, head);
            dummy.next.prev = null;
            return dummy.next;

        }
        private Node helper(Node prev, Node cur) {
            //base case
            if (cur == null) {
                return prev;
            }

            cur.prev = prev;
            prev.next = cur;

            Node next = cur.next;
            Node tail = helper(cur, cur.child);
            cur.child = null;
            return helper(tail, next);
        }

}
