package Recursion;

import DFS.TreeNode;

public class FlattenBinaryTree {

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

        public void flatten(TreeNode root) {

            if (root == null) {
                return;
            }

            flatten(root.left);
            flatten(root.right);
            if (root.left != null) {
                TreeNode prev = root.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                //prev is the left substree's rightmost one
                prev.right = root.right;
                root.right = root.left;
                root.left = null;
            }
        }



// 所以递归函数的步骤可以理解如下：

// 当root为空时，不处理；
// 递归处理root的左子树；
// 递归处理root的右子树；(当然左右子树也可以后面再处理)
// 当root没有左子树时，无需处理；
// 当root有左子树时，要找到最后一个结点last，从root.left开始往下找（因为是已经处理完的，所以root.left只有右子树），循环找right直到最后一个结点即可；
// 关键：
// 将root的右子树移到last的右指针，last.right = root.right;
// root的左子树移到root的右指针:root.right = root.left;
// 清空root的左指针：root.left = null；

}
