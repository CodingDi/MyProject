package Tree;

import java.util.ArrayList;
import java.util.List;

public class BinaryTreeZigZagDFS {
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

        public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            int layer = 0;

            helper(res, layer, root);
            return res;
        }

        private void helper(List<List<Integer>> res, int layer, TreeNode node) {
            if (node == null) {
                return;
            }
            if (res.size() == layer) {
                List<Integer> cur = new ArrayList<>();
                cur.add(node.val);
                res.add(cur);
            } else{
                if (layer % 2 == 0) {
                    res.get(layer).add(node.val);
                } else{
                    res.get(layer).add(0, node.val);
                }
            }

            helper(res, layer + 1, node.left);
            helper(res, layer + 1, node.right);

        }

}
