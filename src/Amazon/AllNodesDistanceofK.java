package Amazon;

import java.util.*;

public class AllNodesDistanceofK {

    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */

        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            // 1. use a hashmap to construct the relation of parent
            // 2. use BFS to search each node starts from the center(target node)
            //     increase distance by one for each parent/left/right branch
            //     once reaches the K, add to result
            Map<TreeNode, TreeNode> map = new HashMap<>();

            TreeNode prev = null;
            build(map, root, prev);


            List<Integer> res = new ArrayList<>();

            Queue<Node> queue = new LinkedList<>();
            Set<TreeNode> visited = new HashSet<>();
            visited.add(target);

            queue.offer(new Node(0, target));

            while(!queue.isEmpty()){

                int size = queue.size();

                for(int i = 0 ; i< size; i++){

                    Node node = queue.poll();
                    TreeNode cur = node.node;
                    int distance = node.distance;

                    if(distance  == K){
                        res.add(cur.val);
                    }

                    //offer par
                    if(map.get(cur) != null && !visited.contains(map.get(cur))){
                        queue.offer(new Node(distance + 1, map.get(cur)));
                        visited.add(map.get(cur));//mark as visited
                    }

                    //offer left
                    if(cur.left != null && !visited.contains(cur.left)){
                        queue.offer(new Node(distance + 1, cur.left));
                        visited.add(cur.left);
                    }

                    //offer right
                    if(cur.right != null && !visited.contains(cur.right)){
                        queue.offer(new Node(distance + 1, cur.right));
                        visited.add(cur.right);
                    }
                }
            }

            return res;
        }

        class Node{
            int distance;
            TreeNode node;
            Node(int distance, TreeNode node){
                this.distance = distance;
                this.node = node;
            }
        }

        //construct the map <key = curnode, value: its parent node>
        private void build(Map<TreeNode, TreeNode> map, TreeNode node, TreeNode par){

            if(node == null){
                return;
            }

            if(!map.containsKey(node)){
                map.put(node, par);
            }

            //do the same for its left + right subtree
            build(map, node.left, node);

            build(map, node.right, node);
        }

}
