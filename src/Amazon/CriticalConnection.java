package Amazon;

import java.util.*;

class CriticalConnection {
    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        // 1.build a connection map<key = node, value=list of nodes directly connected to it
        Map<Integer, Set<Integer>> map = buildMap(connections);

        // 2. initialize all id[] as -1 and find the id comapre it to the one its parent given
        int[] ID = new int[n];
        Arrays.fill(ID, -1);
        // 3. for cur node, check all its neighbors
        //if id is not define,s call recursion to find
        //     if samller, update
        // if equal to the parent given one, its a critical connection
        List<List<Integer>> res = new ArrayList<>();
        dfs(map, ID, -1, 0, 0, res);

        return res;
    }

    //id: the parent given to it
    private int dfs(Map<Integer, Set<Integer>> map, int[] ID, int par, int node, int id, List<List<Integer>> res) {
        ID[node] = id;
        Set<Integer> neighbors = map.get(node);
        for(Integer nei: neighbors) {
            if(nei == par){
                continue;
            }else if(ID[nei] == -1) {
                ID[node] = Math.min(ID[node], dfs(map, ID, node, nei, id + 1, res));
            }else{
                ID[node] = Math.min(ID[node], ID[nei]);
            }
        }

        //if the id found == the id parent give to it.its critical
        if(ID[node] == id && node != 0) {
            res.add(Arrays.asList(par,node));
        }

        return ID[node];
    }

    private Map<Integer, Set<Integer>> buildMap(List<List<Integer>> connections) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for(List<Integer> con: connections) {
            int a = con.get(0);
            int b = con.get(1);

            Set<Integer> neiA = map.getOrDefault(a, new HashSet<Integer>());
            Set<Integer> neiB = map.getOrDefault(b, new HashSet<Integer>());

            neiA.add(b);
            neiB.add(a);

            map.put(a, neiA);
            map.put(b, neiB);
        }
        return map;
    }
}