import java.util.*;

class CriticalRouters {
/*
*You are given an undirected connected graph.
* An articulation point (or cut vertex) is defined as a vertex which,
* when removed along with associated edges,
*  makes the graph disconnected (or more precisely,
* increases the number of connected components in the graph).
* The task is to find all articulation points in the given graph.
* Input:
* The input to the function/method consists of three arguments:
* numNodes, an integer representing the number of nodes in the graph.
* numEdges, an integer representing the number of edges in the graph.
* edges, the list of pair of integers - A, B representing an edge between the nodes A and B.
Output:
* Return a list of integers representing the critical nodes.
* Example:
* Input: numNodes = 7, numEdges = 7, edges = [[0, 1], [0, 2], [1, 3], [2, 3], [2, 5], [5, 6], [3, 4]]
*
 */
//    public static void main(String[] args) {
//        Set<Integer> res2 = criticalRouters(5, 3, new int[][]{{1,0}, {2, 1}, {2, 3},{3,4}});
//        Set<Integer> res1 = criticalRouters(7, 7, new int[][]{{0, 1}, {0, 2}, {1, 3}, {2, 3}, {2, 5}, {5, 6}, {3, 4}});
//        Set<Integer> res3 = criticalRouters(7, 7, new int[][]{{0, 1}, {1, 2}, {2,0}, {1, 3}, {1, 4}, {1, 6}, {3, 5},{5,4}});
//        Set<Integer> res4 = criticalRouters(7, 7, new int[][]{{0, 1}, {1, 2}, {2,0}, {1, 3}, {1, 4}, {1, 6}, {5, 3},{4,5}});
//        Set<Integer> res5 = criticalRouters(5, 3, new int[][]{{1,0}, {2, 1}, {2, 0},{3,0},{3,4}});
//        Set<Integer> res6 = criticalRouters(7, 3, new int[][]{{2,1}, {3, 1}, {3, 4},{4,2},{4,5},{3,6},{6,7}});
//        System.out.println(res5);
//        System.out.println(res6);
//        //static int time = 0;
//    }


    public static Set<Integer> criticalRouters(int numNodes, int numEdges, int[][] edges) {
            // 1.build a connection map<key = node, value=list of nodes directly connected to it
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int root = buildMap(map,edges);

            // 2. initialize all id[] as -1 and find the id comapre it to the one its parent given
            int[] ID = new int[numNodes];
            Arrays.fill(ID, -1);
            // 3. for cur node, check all its neighbors
            //if id is not define,s call recursion to find
            //     if samller, update
            // if equal to the parent given one, its a critical connection

            Set<Integer> routers = new HashSet<>();
            List<Integer> res = new ArrayList<>(routers);
            dfs(map, ID, root - 1, root, root, routers, root);

            return routers;
        }

        //id: the parent given to it
        private static int dfs(Map<Integer, Set<Integer>> map, int[] ID, int par, int node, int id, Set<Integer> routers, int root) {
            ID[node-root] = id;
            Set<Integer> neighbors = map.get(node);

            for(Integer nei: neighbors) {
                if(nei == par){
                    continue;
                }else if(ID[nei-root] == -1) {
                    ID[node-root] = Math.min(ID[node-root], dfs(map, ID, node, nei, id + 1, routers, root));
                }else{
                    ID[node-root] = Math.min(ID[node-root], ID[nei]);
                }
            }

            //if the id found == the id parent give to it.its critical
            if(ID[node-root] == id && node != 0) {
                if(map.get(par).size() > 1){
                    routers.add(par);
                }
                if(map.get(node).size() > 1) {
                    routers.add(node);
                }
            }

            return ID[node];
        }

        private static int buildMap(Map<Integer, Set<Integer>> map, int[][] edges) {

            int root = Integer.MAX_VALUE;
            for(int[] con: edges) {
                int a = con[0];
                int b = con[1];
                root = Math.min(root, Math.min(a,b));
                Set<Integer> neiA = map.getOrDefault(a, new HashSet<Integer>());
                Set<Integer> neiB = map.getOrDefault(b, new HashSet<Integer>());

                neiA.add(b);
                neiB.add(a);

                map.put(a, neiA);
                map.put(b, neiB);
            }
            return root;
        }

}