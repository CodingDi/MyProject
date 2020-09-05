import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

// Definition for a Node.
static class Node {
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

        public Node cloneGraph(Node node) {
            if(node == null){
                return node;
            }
            Map<Node, Node> map = new HashMap<>();
            return dfs(node, map);


        }

        private Node dfs(Node node, Map<Node, Node> map){
            if(node == null){
                return node;
            }

            if(map.containsKey(node)){
                return map.get(node);
            }

            if(!map.containsKey(node)){
                map.put(node, new Node(node.val, new ArrayList<Node>()));
            }

            for(Node nei: node.neighbors){
                map.get(node).neighbors.add(dfs(nei, map));
            }
            return map.get(node);
        }

}
