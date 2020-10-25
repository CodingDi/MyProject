package Tree;

import java.util.ArrayList;
import java.util.List;

public class LevelOrderTraversal {

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

        public List<List<Integer>> levelOrder(TreeNode root) {
            //recursive way
            List<List<Integer>> res = new ArrayList<>();
            if (root == null) {
                return res;
            }
            printLayer(res, root, 0);
            return res;

        }

        //heper function to print the cur layer
        private void printLayer(List<List<Integer>> res, TreeNode node, int layer) {
            if (node == null) {
                return;
            }

            if (res.size() == layer) {
                res.add(new ArrayList<>());
            }

            res.get(layer).add(node.val);
            printLayer(res, node.left, layer + 1);
            printLayer(res, node.right, layer + 1);
        }

}
