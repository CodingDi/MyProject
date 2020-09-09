package DFS;

import java.util.HashMap;
import java.util.Map;

public class ReconstructFromBST {

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
        public TreeNode buildTree(int[] preorder, int[] inorder) {
            Map<Integer, Integer> map = new HashMap<>();

            for(int i = 0; i < inorder.length; i++){
                map.put(inorder[i], i);
            }

            return construct(preorder,  0, preorder.length - 1, 0, inorder.length - 1, map);


        }

        private TreeNode construct(int[] preorder, int preleft, int preright, int inleft, int inright, Map<Integer, Integer> map) {
            if(preleft > preright){
                return null;
            }

            TreeNode root = new TreeNode(preorder[preleft]);
            int index = map.get(root.val);

            //left length [inleft, index-1] ->length index-inleft ->rightborder:
            root.left = construct(preorder, preleft + 1, index-inleft + preleft, inleft, index -1, map);

            //right length[index + 1, inright] -> length inright - index
            root.right = construct(preorder, index-inleft + preleft + 1, preright, index + 1, inright, map);

            return root;
        }

}
