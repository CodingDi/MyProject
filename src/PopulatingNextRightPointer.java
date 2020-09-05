import java.util.LinkedList;
import java.util.Queue;
public class PopulatingNextRightPointer {
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
        public Node connect(Node root) {
            if(root == null) return root;
            Queue<Node> queue = new LinkedList<>();
            queue.offer(root);


            while(!queue.isEmpty()){
                int size = queue.size();
                Node prev = null;
                for(int i = 0; i < size; i++){
                    Node cur = queue.poll();
                    if(prev != null){
                        prev.next = cur;
                    }

                    prev = cur;
                    if(cur.left != null){
                        queue.offer(cur.left);
                    }

                    if(cur.right != null){
                        queue.offer(cur.right);
                    }
                }
                //end of the current layer
                prev.next = null;

            }

            return root;
        }

}
