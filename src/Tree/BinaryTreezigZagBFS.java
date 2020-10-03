package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class BinaryTreezigZagBFS {
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
            if (root == null) {
                return res;
            }

            Deque<TreeNode> deque = new ArrayDeque<>();
            deque.offerLast(root);
            int layer = 1;

            while(!deque.isEmpty()) {
                int size = deque.size();
                List<Integer> curLayer = new ArrayList<>();

                for (int i = 0; i < size; i++) {
                    if (layer % 2 == 0) {
                        TreeNode cur = deque.pollLast();
                        curLayer.add(cur.val);
                        if (cur.right != null) {
                            deque.offerFirst(cur.right);
                        }

                        if (cur.left != null) {
                            deque.offerFirst(cur.left);
                        }


                    } else {
                        TreeNode cur = deque.pollFirst();
                        curLayer.add(cur.val);

                        if (cur.left != null) {
                            deque.offerLast(cur.left);
                        }

                        if (cur.right != null) {
                            deque.offerLast(cur.right);
                        }
                    }
                }
                res.add(curLayer);

                layer++;
                //9  15 7

            }
            return res;
        }

}
