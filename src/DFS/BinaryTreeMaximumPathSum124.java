package DFS;

public class BinaryTreeMaximumPathSum124 {

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

        public int maxPathSum(TreeNode root) {
            // recursion
            // for each node as a parent node:
            // ask from subtree: node + max(max(left,0) , max(right,0))
            // for the current node: take max (left, 0) + max (right, 0) + node
            // alwasy update max as max root +max(right,0)+  max(rihgt, 0 )
            //time:O(n)
            //space::O(height)

            int[] max = new int[]{Integer.MIN_VALUE};
            helper(root, max);

            return max[0];
        }

        private int helper(TreeNode node, int[] max){
            if(node == null){
                return 0;
            }
            int left = helper(node.left, max);
            int right = helper(node.right, max);

            left = Math.max(0, left);
            right = Math.max(0, right);

            max[0] = Math.max(max[0], left + right + node.val);

            return node.val + Math.max(left, right);
        }

}
