package Amazon;

import java.util.ArrayList;
import java.util.List;

public class WordSearchII {


        public List<String> findWords(char[][] board, String[] words) {

            TrieNode root = buildTrie(words);

            int n = board.length;
            int m = board[0].length;


            List<String> res = new ArrayList<>();

            for (int i = 0; i < n; i++) {
                for (int j = 0; j < m; j++) {
                    dfs(board, i, j, root, res);
                }

            }

            return res;
        }

        private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
            int n = board.length;
            int m = board[0].length;

            if (i < 0 || i >= n || j < 0|| j >= m) {
                return;
            }

            char curChar  = board[i][j];
            int index = curChar - 'a';
            if (curChar == '.' || node.children[index] == null) {
                return;
            }

            node = node.children[index];
            if (node.word != null) {
                res.add(node.word);
                node.word = null;//deduplication
            }

            board[i][j] = '.';

            dfs(board, i + 1, j, node, res);
            dfs(board, i - 1, j, node, res);
            dfs(board, i, j + 1, node, res);
            dfs(board, i, j - 1, node, res);

            board[i][j] = curChar;
        }






        public TrieNode buildTrie(String[] words) {
            TrieNode root = new TrieNode();

            for (String word : words) {
                TrieNode par = root;

                for (char cur: word.toCharArray()) {
                    int index = cur - 'a';

                    if (par.children[index] == null) {
                        par.children[index] = new TrieNode();
                    }
                    par = par.children[index];

                }
                par.word = word;
            }

            return root;
        }

        class TrieNode{
            String word;
            TrieNode[] children = new TrieNode[26];
       }

    }




