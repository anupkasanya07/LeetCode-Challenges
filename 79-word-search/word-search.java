class Solution {
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;
        
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0)) {
                    return true;
                }
            }
        }
        
        return false;
    }
    
    private boolean dfs(char[][] board, String word, int r, int c, int index) {
        // Found all characters
        if (index == word.length()) {
            return true;
        }
        
        // Out of bounds or character mismatch
        if (r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != word.charAt(index)) {
            return false;
        }
        
        // Temporarily mark cell as visited
        char temp = board[r][c];
        board[r][c] = '#';
        
        // Explore 4 directions
        boolean found = dfs(board, word, r + 1, c, index + 1) ||
                        dfs(board, word, r - 1, c, index + 1) ||
                        dfs(board, word, r, c + 1, index + 1) ||
                        dfs(board, word, r, c - 1, index + 1);
        
        // Backtrack (restore original character)
        board[r][c] = temp;
        
        return found;
    }
}