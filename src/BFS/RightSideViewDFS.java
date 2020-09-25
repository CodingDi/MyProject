package BFS;

import java.util.ArrayList;
import java.util.List;

public class RightSideViewDFS {

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

        public List<Integer> rightSideView(TreeNode root) {

            //DFS alwasy visit the right side first
            List<Integer> res = new ArrayList<>();

            // for each layer, we add the current layer's last one to the res
            dfs(root, 0, res);

            return res;
        }

        private void dfs(TreeNode root, int depth, List<Integer> res) {
            if (root == null) {
                return;
            }

            if (depth == res.size()) {
                res.add(root.val);
            }

            //visit right first
            if (root.right != null) {
                dfs(root.right, depth + 1, res);
            }

            //visit the left first
            if (root.left != null) {
                dfs(root.left, depth + 1, res);
            }
        }

}
