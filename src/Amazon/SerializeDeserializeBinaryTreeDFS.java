package Amazon;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeDeserializeBinaryTreeDFS {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

    //the DFS way  好难啊。。。。。。。我好菜
    //康康我吧 可怜可怜我吧...

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return null;
            }
            StringBuilder sb = new StringBuilder();
            dfs(root, sb);

            return sb.toString();
        }

        private void dfs(TreeNode node, StringBuilder sb){
            if(node == null){
                sb.append("null").append(",");
                return;
            }

            sb.append(node.val).append(",");

            dfs(node.left, sb);
            dfs(node.right, sb);

        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if(data == null){
                return null;
            }
            String[] str = data.split(",");
            Queue<String> queue = new LinkedList<>(Arrays.asList(str));

            return deserialzieHelper(queue);
        }

        private TreeNode deserialzieHelper(Queue<String> queue){
            String cur = queue.poll();

            if(cur.equals("null")){
                return null;
            }
            TreeNode root = new TreeNode(Integer.valueOf(cur));

            root.left = deserialzieHelper(queue);

            root.right = deserialzieHelper(queue);
            return root;
        }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root));
}
