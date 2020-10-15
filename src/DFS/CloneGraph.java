package DFS;
import java.util.*;
public class CloneGraph {

    /*
// Definition for a Node.
*/

class Node {
    public int val;
    public List<Node> neighbors;

    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }

    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}


    class Solution {
        public Node cloneGraph(Node node) {

            if (node == null) {
                return node;
            }
            Map<Node, Node> map = new HashMap<>();
            dfs(map, node);
            return map.get(node);
        }

        private void dfs(Map<Node, Node> map, Node node) {
            if (!map.containsKey(node)) {
                Node copy = new Node(node.val, new ArrayList<Node>());
                map.put(node, copy);
            }

            for (Node nei : node.neighbors) {
                if (!map.containsKey(nei)) {
                    dfs(map, nei);
                }
                map.get(node).neighbors.add(map.get(nei));
            }

        }
    }
}
