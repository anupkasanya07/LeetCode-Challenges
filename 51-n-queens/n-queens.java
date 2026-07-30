import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] board = new char[n][n];
        for (char[] row : board) {
            Arrays.fill(row, '.');
        }

        boolean[] cols = new boolean[n];
        boolean[] posDiag = new boolean[2 * n]; // row + col
        boolean[] negDiag = new boolean[2 * n]; // row - col + n

        backtrack(0, n, board, cols, posDiag, negDiag, result);
        return result;
    }

    private void backtrack(int row, int n, char[][] board, 
                           boolean[] cols, boolean[] posDiag, boolean[] negDiag, 
                           List<List<String>> result) {
        if (row == n) {
            result.add(constructBoard(board));
            return;
        }

        for (int col = 0; col < n; col++) {
            int pDiag = row + col;
            int nDiag = row - col + n; // Offset by n to handle negative indices

            if (cols[col] || posDiag[pDiag] || negDiag[nDiag]) {
                continue;
            }

            // Place queen
            board[row][col] = 'Q';
            cols[col] = true;
            posDiag[pDiag] = true;
            negDiag[nDiag] = true;

            backtrack(row + 1, n, board, cols, posDiag, negDiag, result);

            // Backtrack
            board[row][col] = '.';
            cols[col] = false;
            posDiag[pDiag] = false;
            negDiag[nDiag] = false;
        }
    }

    private List<String> constructBoard(char[][] board) {
        List<String> path = new ArrayList<>();
        for (char[] row : board) {
            path.add(new String(row));
        }
        return path;
    }
}