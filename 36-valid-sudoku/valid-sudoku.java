import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        // Track seen numbers using HashSets
        Set<String> seen = new HashSet<>();

        for (int r = 0; r < 9; r++) {
            for (int c = 0; c < 9; c++) {
                char val = board[r][c];

                if (val != '.') {
                    // Unique string representations for row, col, and sub-box
                    String inRow = val + " in row " + r;
                    String inCol = val + " in col " + c;
                    String inBox = val + " in box " + (r / 3) + "-" + (c / 3);

                    // If adding to set fails, a duplicate was found
                    if (!seen.add(inRow) || !seen.add(inCol) || !seen.add(inBox)) {
                        return false;
                    }
                }
            }
        }

        return true;
    }
}