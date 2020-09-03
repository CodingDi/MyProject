import java.util.*;

public class KDistanceFromNodes {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    class Solution {
        public List<Integer> distanceK(TreeNode root, TreeNode target, int K) {
            // 1.graph search problem+BFS
            Map<TreeNode, TreeNode> map = new HashMap<>();
            dfs(root, null, map);
            List<Integer> res = new ArrayList<>();
            // 2.need to construct the relationship(edge) tp its parent
            int layer = -1;
            Set<TreeNode> visited = new HashSet<>();
            visited.add(target);
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(target);
            while(!queue.isEmpty()){
                layer++;
                int size = queue.size();
                if(layer == K){
                    for(int i = 0; i < size; i++){
                        res.add(queue.poll().val);
                    }
                    return res;
                }else {
                    for(int i = 0; i < size; i++){
                        TreeNode cur = queue.poll();
                        if(cur.left != null && !visited.contains(cur.left)){
                            queue.offer(cur.left);
                            visited.add(cur.left);
                        }
                        if(cur.right != null && !visited.contains(cur.right)){
                            queue.offer(cur.right);
                            visited.add(cur.right);
                        }

                        TreeNode par = map.get(cur);
                        if(par != null && !visited.contains(par)){
                            queue.offer(par);
                            visited.add(par);
                        }
                    }
                }
            }

            return new ArrayList<Integer>();
        }

        private void dfs(TreeNode node, TreeNode par, Map<TreeNode, TreeNode> map){
            if(node == null){
                return;
            }

            if(!map.containsKey(node)){
                map.put(node, par);
            }

            dfs(node.left, node, map);
            dfs(node.right, node, map);
        }
    }
}
