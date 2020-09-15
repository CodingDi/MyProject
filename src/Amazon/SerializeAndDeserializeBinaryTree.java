package Amazon;

import java.util.LinkedList;
import java.util.Queue;

public class SerializeAndDeserializeBinaryTree {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

        // Encodes a tree to a single string.
        public String serialize(TreeNode root) {
            if(root == null){
                return "";
            }
            StringBuilder sb = new StringBuilder();
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);

            while(!queue.isEmpty()){
                TreeNode cur = queue.poll();

                if(cur == null){
                    sb.append("null").append(",");
                }else{
                    sb.append(cur.val).append(",");
                    queue.offer(cur.left);
                    queue.offer(cur.right);
                }
            }

            return sb.toString();
        }

        // Decodes your encoded data to tree.
        public TreeNode deserialize(String data) {

            if(data == ""){
                return null;
            }
            String[] str = data.split(",");

            Queue<TreeNode> queue = new LinkedList<>();
            TreeNode root = new TreeNode(Integer.valueOf(str[0]));

            queue.offer(root);

            for(int i = 1; i < str.length; i++){

                TreeNode cur = queue.poll();

                if(!str[i].equals("null")){
                    cur.left = new TreeNode(Integer.valueOf(str[i]));
                    queue.offer(cur.left);
                }

                if(!str[++i].equals("null")){
                    cur.right = new TreeNode(Integer.valueOf(str[i]));
                    queue.offer(cur.right);
                }
            }

            return root;
        }


// Your Codec object will be instantiated and called as such:
// Codec codec = new Codec();
// codec.deserialize(codec.serialize(root))
}
