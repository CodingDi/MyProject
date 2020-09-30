package DFS;

public class Node {
        public int val;

        public Node next;
        public Node prev;
        public Node child;

    public Node() {}

        public Node(int _val) {
            val = _val;
        }
//
//        public Node(int _val, Node _left, Node _right, Node _next) {
//            val = _val;
//            left = _left;
//            right = _right;
//            next = _next;
//        }

        public Node(int val, Node prev, Node next, Node child) {
            this.val = val;
            this.prev = prev;
            this.next = next;
            this.child = child;
        }

}
