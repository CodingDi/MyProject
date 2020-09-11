package Amazon;

public class SubtreeOfAnotherTree {

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
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(s == null && t == null){
                return true;
            }

            if(s == null || t == null){
                return false;
            }

            if(isSame(t, s)){
                return true;
            }

            return isSubtree(s.left, t) || isSubtree(s.right, t);

        }

        private boolean isSame(TreeNode l, TreeNode r){
            if(l == null && r == null){
                return true;
            }

            if(l == null||r == null){
                return false;
            }

            if(l.val != r.val){
                return false;
            }


            return isSame(l.left, r.left) && isSame(l.right, r.right);
        }

}
