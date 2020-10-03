package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeLevelOrder {
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
            List<List<Integer>> res = new ArrayList<>();

            if (root == null) {
                return res;
            }

            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()) {
                int size = queue.size();
                List<Integer> layer = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    TreeNode cur = queue.poll();
                    if (cur.left != null) {
                        queue.offer(cur.left);
                    }

                    if (cur.right != null) {
                        queue.offer(cur.right);
                    }

                    layer.add(cur.val);
                }

                res.add(layer);
            }


            return res;
        }

}
