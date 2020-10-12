package Trie;

import java.util.*;

public class DesignSearchAutoComplete {


        //iniatialization for the trienode
        class TrieNode {
            Map<Character, TrieNode> children;
            Map<String, Integer> counts;
            boolean isWord;
            public TrieNode () {
                children = new HashMap<>();
                counts = new HashMap<>();
                isWord = false;
            }
        }
        //initialization for the system
        TrieNode root;
        String prefix;

        public DesignSearchAutoComplete(String[] sentences, int[] times) {
            //initialziation for the constructor
            root = new TrieNode();
            prefix = "";

            for (int i = 0; i < sentences.length; i++) {
                add(sentences[i], times[i]);
            }
        }

        public List<String> input(char c) {
            List<String> res = new ArrayList<>();
            //base case
            if (c == '#') {
                add(prefix, 1);
                prefix = "";//reset the prefix str
                return res;
            }

            prefix = prefix + c;
            TrieNode node = root;
            for (char ch : prefix.toCharArray()) {
                if (node.children.get(ch) == null) {
                    return res;
                }
                node = node.children.get(ch);
            }

            PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) -> (a.getValue() == b.getValue() ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue()));
            pq.addAll(node.counts.entrySet());

            for (int i = 0; i < 3; i++) {
                if (!pq.isEmpty()) {
                    res.add(pq.poll().getKey());
                }
            }

            return res;

        }

        //add the given string s to the trie with count as frequency
        private void add(String s, int count) {
            TrieNode node = root;

            for (char c : s.toCharArray()) {
                if (!node.children.containsKey(c)) {
                    TrieNode newNode = new TrieNode();
                    node.children.put(c, newNode);
                }
                node = node.children.get(c);
                node.counts.put(s, node.counts.getOrDefault(s, 0) + count);
            }
            node.isWord = true;
        }


/**
 * Your AutocompleteSystem object will be instantiated and called as such:
 * AutocompleteSystem obj = new AutocompleteSystem(sentences, times);
 * List<String> param_1 = obj.input(c);
 */
}
