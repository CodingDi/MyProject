public class PopulatingNextRightPointerIterative {

    /*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
    //very hard
        //iterative way:
        //time: O(n)
        //space:O(1)
        public Node connect(Node root) {
            if(root == null){
                return root;
            }

            Node prev = root;
            while(prev.left != null){
                Node cur = prev;
                while(cur != null){
                    //build connection left
                    cur.left.next = cur.right;
                    //build conenction right
                    if(cur.next != null){
                        cur.right.next  = cur.next.left;
                    }
                    cur = cur.next;
                }

                //end of the current layer
                prev = prev.left;
            }

            return root;
        }

}
