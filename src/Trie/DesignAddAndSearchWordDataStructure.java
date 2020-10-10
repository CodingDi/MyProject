package Trie;

import java.util.HashMap;
import java.util.Map;

public class DesignAddAndSearchWordDataStructure {
    TrieNode root;
    boolean isWord = false;
    public DesignAddAndSearchWordDataStructure() {
        root = new TrieNode();
    }

    public class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isWord = false;
        public TrieNode(){}
    }

    public void addWord(String word) {
        TrieNode node = root;
        for (char cur : word.toCharArray()) {
            if (!node.children.containsKey(cur)) {
                node.children.put(cur, new TrieNode());
            }
            //move for the next child and add to next child
            node = node.children.get(cur);
        }
        node.isWord = true;
    }

    public boolean search(String word) {
        return searchInNode(word, root);
    }

    //helper function used to search given specified node
    private boolean searchInNode(String word, TrieNode node) {
        for (int i = 0; i < word.length(); i++) {
            char cur = word.charAt(i);

            //case 1, not exsit in map
            if (!node.children.containsKey(cur)) {
                //case1.1 its a dot
                if (cur == '.') {
                    for (char key : node.children.keySet()) {
                        //call recursion to try each key
                        TrieNode child = node.children.get(key);
                        if (searchInNode(word.substring(i + 1), child)) {
                            return true;
                        }
                    }
                }
                return false;//if an trial failed or its not a dot
            }

            //case 2: it exists for current char, move to next index to  check
             node = node.children.get(cur);
        }
        //after check each index
        return node.isWord;
    }
}
