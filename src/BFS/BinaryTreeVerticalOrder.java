package BFS;

import java.util.*;

public class BinaryTreeVerticalOrder {

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

        public List<List<Integer>> verticalOrder(TreeNode root) {
            //BFS way to solve it, use a map<column, List nodes with column width>>
            // start from the root
            //each each offer the corresponding width and the value
            //     to put in the map
            //     finally we output the map according to its key(column)

            //1. constrcut a map
            List<List<Integer>> res = new ArrayList<>();
            if(root == null) {
                return res;
            }
            Map<Integer, List<Integer>> map = new HashMap<>();

            //use offerFirst + pollLast
            Deque<Node> queue = new ArrayDeque<>();// a queue to do BFS visit order
            queue.offer(new Node(root, 0));

            map.put(0, new ArrayList<Integer>());
            map.get(0).add(root.val);

            int min = 0;
            int max = 0;

            while(!queue.isEmpty()){
                Node cur = queue.pollLast();
                int column = cur.column;
                min = Math.min(min, column);
                max = Math.max(max, column);

                TreeNode curNode = cur.node;

                if(curNode.left != null){
                    queue.offerFirst(new Node(curNode.left, column - 1));
                    if(!map.containsKey(column - 1)){
                        map.put(column - 1, new ArrayList<Integer>());
                    }
                    map.get(column - 1).add(curNode.left.val);
                }

                if(curNode.right != null){
                    queue.offerFirst(new Node(curNode.right, column + 1));

                    if(!map.containsKey(column + 1)){
                        map.put(column + 1, new ArrayList<Integer>());
                    }
                    map.get(column + 1).add(curNode.right.val);
                }
            }



            for(int i = min; i <= max; i++){
                res.add(map.get(i));//add from the smallest column as min
            }

            return res;
        }

        static class Node{
            TreeNode node;//the node
            int column;//the column in the vertical way
            Node(TreeNode node, int column){
                this.node = node;
                this.column = column;
            }
        }

}
