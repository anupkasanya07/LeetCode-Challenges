class Solution {
    public void solveSudoku(char[][] board) {
        solve(board);
    }

    private boolean solve(char[][] board) {
        for (int row = 0; row < 9; row++) {
            for (int col = 0; col < 9; col++) {
                // Find an empty cell
                if (board[row][col] == '.') {
                    // Try digits '1' through '9'
                    for (char ch = '1'; ch <= '9'; ch++) {
                        if (isValid(board, row, col, ch)) {
                            board[row][col] = ch;

                            // Recursively solve the rest of the board
                            if (solve(board)) {
                                return true;
                            }

                            // Backtrack if placing ch doesn't lead to a solution
                            board[row][col] = '.';
                        }
                    }
                    return false; // Trigger backtracking if no digit fits
                }
            }
        }
        return true; // Board solved completely
    }

    private boolean isValid(char[][] board, int row, int col, char ch) {
        for (int i = 0; i < 9; i++) {
            // Check row duplicate
            if (board[row][i] == ch) return false;
            // Check column duplicate
            if (board[i][col] == ch) return false;
            // Check 3x3 sub-box duplicate
            int boxRow = 3 * (row / 3) + i / 3;
            int boxCol = 3 * (col / 3) + i % 3;
            if (board[boxRow][boxCol] == ch) return false;
        }
        return true;
    }
}