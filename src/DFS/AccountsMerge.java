package DFS;

import java.util.*;

public class AccountsMerge {

        public List<List<String>> accountsMerge(List<List<String>> accounts) {
            List<List<String>>  res = new ArrayList<>();

            Map<String, String> map = new HashMap<>(); // build the map<email, name>
            Set<String> emails = new HashSet<>();// build Set<String> for each unique email
            Map<String, Set<String>> neighbors = new HashMap<>();// build edge for each neighbor email

            //1. construct the relation
            for (List<String> account : accounts) {
                String name = account.get(0);

                for (int i = 1; i < account.size(); i++) {
                    String cur = account.get(i);
                    emails.add(cur);
                    map.put(cur, name);//map each email-name pair to hashmap
                    neighbors.putIfAbsent(cur, new HashSet<String>());
                    if (i == 1) continue;

                    //for i > 1, we connect it to its prev neighbour
                    String prev = account.get(i - 1);
                    neighbors.get(prev).add(cur);
                    neighbors.get(cur).add(prev);

                }
            }

            //2. for each email in the hashset, try to call dfs to construct a group for current account
            Set<String> visited = new HashSet<>();

            for (String email : emails) {
                if (!visited.contains(email)) {

                    List<String> group = new ArrayList<>();
                    visited.add(email);
                    group.add(email);
                    dfs(neighbors, email, visited, group);
                    Collections.sort(group);
                    group.add(0, map.get(email));
                    res.add(group);
                }
            }
            return res;
        }
        // use dfs to conenct them into one group,start from the given email
        private void dfs(Map<String, Set<String>> neighbors, String email, Set<String> visited, List<String> group) {
            for (String neighbor : neighbors.get(email)) {
                if (!visited.contains(neighbor)) {
                    group.add(neighbor);
                    visited.add(neighbor);
                    dfs(neighbors, neighbor, visited, group);
                }
            }
        }

}
