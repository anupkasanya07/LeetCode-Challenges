class Solution {
    public String convert(String s, int numRows) {
        // Edge case: if numRows is 1 or greater than/equal to s length, no zigzag needed
        if (numRows == 1 || s.length() <= numRows) {
            return s;
        }

        // Initialize a StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }

        int currRow = 0;
        boolean goingDown = false;

        // Traverse each character and assign to appropriate row
        for (char c : s.toCharArray()) {
            rows[currRow].append(c);

            // Reverse direction when hitting top or bottom boundary
            if (currRow == 0 || currRow == numRows - 1) {
                goingDown = !goingDown;
            }

            currRow += goingDown ? 1 : -1;
        }

        // Combine all rows into a single string
        StringBuilder result = new StringBuilder();
        for (StringBuilder row : rows) {
            result.append(row);
        }

        return result.toString();
    }
}
