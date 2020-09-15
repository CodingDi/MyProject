package Amazon;

import java.util.*;

public class SynonymousSentences {

        public List<String> generateSentences(List<List<String>> synonyms, String text) {
            if(synonyms == null || text == null){
                return new ArrayList<String>();
            }

            //1. constuc the gaph
            //map<ky = word, value = list of its synonyms string
            Map<String, List<String>> graph = new HashMap<>();
            construct(graph, synonyms);

            //store in treeset so that its well ordered
            Set<String> res = new TreeSet<>();

            //2. use Queue to do BFS expand
            //by expand: we try to replace each word in the string and replace it
            Queue<String> queue = new LinkedList<>();
            queue.offer(text);

            while(!queue.isEmpty()){
                String cur = queue.poll();
                res.add(cur);

                String[] input = cur.split("\\s");

                for(int i = 0; i < input.length; i++){
                    if(!graph.containsKey(input[i])){
                        continue;
                    }
                    List<String> list = graph.get(input[i]);

                    for(String word: list){
                        input[i] = word;
                        //join each word in input by an empty to a string
                        String newStr = String.join(" ", input);

                        if(!res.contains(newStr)){
                            queue.offer(newStr);
                        }
                    }
                }
            }

            return new ArrayList<String>(res);

        }

        private void construct(Map<String, List<String>> graph, List<List<String>> synonyms){

            for(List<String> syn: synonyms){
                String a = syn.get(0);
                String b = syn.get(1);

                if(!graph.containsKey(a)){
                    graph.put(a, new ArrayList<String>());
                }

                if(!graph.containsKey(b)){
                    graph.put(b, new ArrayList<String>());
                }

                graph.get(a).add(b);
                graph.get(b).add(a);

            }
        }

}
