import java.util.ArrayList;
import java.util.List;

class Solution {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);

        int rows = board.length;
        int cols = board[0].length;

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                dfs(board, r, c, root, result);
            }
        }

        return result;
    }

    private void dfs(char[][] board, int r, int c, TrieNode node, List<String> result) {
        char ch = board[r][c];

        if (ch == '#' || node.children[ch - 'a'] == null) {
            return;
        }

        node = node.children[ch - 'a'];

        if (node.word != null) {
            result.add(node.word);
            node.word = null; // Avoid adding duplicate entries
        }

        board[r][c] = '#'; // Mark cell as visited

        int[] dr = {-1, 1, 0, 0};
        int[] dc = {0, 0, -1, 1};

        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];

            if (nr >= 0 && nr < board.length && nc >= 0 && nc < board[0].length) {
                dfs(board, nr, nc, node, result);
            }
        }

        board[r][c] = ch; // Backtrack/restore original character
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode node = root;
            for (char ch : word.toCharArray()) {
                int idx = ch - 'a';
                if (node.children[idx] == null) {
                    node.children[idx] = new TrieNode();
                }
                node = node.children[idx];
            }
            node.word = word;
        }
        return root;
    }
}