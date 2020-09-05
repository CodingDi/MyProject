import Amazon.TreeNode;

public class ValidateBinarySearchTree {

    //time:O(n) space:O(n)  recrusion way
    public boolean isValidBST(TreeNode root) {
        if(root == null){
            return true;
        }
        return isValid(root, Long.MIN_VALUE, Long.MAX_VALUE);
    }

    //node should be in the range of (min, max)
    private boolean isValid(TreeNode node, long min, long max){
        if(node == null){
            return true;
        }
        if(node.val <= min || node.val >= max){
            return false;
        }

        return isValid(node.left, min, node.val) && isValid(node.right, node.val, max);
    }
}
