package Tree;

public class DeleteNodeInBST {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode() {}
     *     TreeNode(int val) { this.val = val; }
     *     TreeNode(int val, TreeNode left, TreeNode right) {
     *         this.val = val;
     *         this.left = left;
     *         this.right = right;
     *     }
     * }
     */

        //recursive way
    //time: O(logn)
    //space:O(logn) = height
        public TreeNode deleteNode(TreeNode root, int key) {
            //edge case
            if (root == null) {
                return root;
            }

            //case1: go right to delete
            if (root.val < key) {
                root.right = deleteNode(root.right, key);
            } else if (root.val > key) {
                //case2. go left
                root.left = deleteNode(root.left, key);
            } else {
                //case3: update its value, and delete the node of its precessor/succeessor
                if (root.left == null && root.right == null) {
                    //case3.0 when its a leaf node
                    root = null;
                } else if (root.right != null) {
                    //case3.1 it has a right subtree
                    TreeNode successor = findSuccessor(root);
                    root.val = successor.val;
                    root.right = deleteNode(root.right, successor.val);
                } else {
                    //case3.2 right is null, and left is not null
                    TreeNode precessor = findPrecessor(root);
                    root.val = precessor.val;
                    root.left = deleteNode(root.left, precessor.val);
                }
            }

            return root;
        }


        //given the node, find its left subtree's rightmost node
        private TreeNode findPrecessor(TreeNode node) {
            TreeNode precessor = node.left;

            while (precessor.right != null) {
                precessor = precessor.right;
            }
            return precessor;
        }


        //given the node, find its right subtree's leftmost node
        private TreeNode findSuccessor(TreeNode node) {
            TreeNode successor = node.right;
            while (successor.left != null) {
                successor = successor.left;
            }

            return successor;
        }

}
