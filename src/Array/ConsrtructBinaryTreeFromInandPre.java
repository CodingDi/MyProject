package Array;

import java.util.HashMap;
import java.util.Map;

public class ConsrtructBinaryTreeFromInandPre {


     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }

    class Solution {
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            if (preorder == null || preorder.length == 0) {
                return null;
            }
            Map<Integer, Integer> index = new HashMap<>();//key = value of inorder, value = index in inorder
            for (int i = 0; i < inorder.length; i++) {
                index.put(inorder[i], i);
            }


            return construct(index, preorder, 0, inorder.length - 1, 0, preorder.length - 1);
        }
        private TreeNode construct(Map<Integer, Integer> index, int[] preorder, int inLeft, int inRight, int preLeft, int preRight) {
            if (preLeft > preRight) {
                return null;
            }
            TreeNode root = new TreeNode(preorder[preLeft]);
            int rootIndex = index.get(root.val);


            root.left = construct(index, preorder, inLeft, rootIndex - 1, preLeft + 1, rootIndex - inLeft + preLeft);
            root.right = construct(index, preorder, rootIndex + 1, inRight, rootIndex - inLeft + preLeft + 1, preRight);
            return root;
        }
    }
}
