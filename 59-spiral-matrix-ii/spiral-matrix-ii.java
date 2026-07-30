class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];

        int top = 0;
        int bottom = n - 1;
        int left = 0;
        int right = n - 1;

        int num = 1;
        int target = n * n;

        while (num <= target) {
            // 1. Fill Left to Right
            for (int j = left; j <= right; j++) {
                matrix[top][j] = num++;
            }
            top++;

            // 2. Fill Top to Bottom
            for (int i = top; i <= bottom; i++) {
                matrix[i][right] = num++;
            }
            right--;

            // 3. Fill Right to Left
            for (int j = right; j >= left; j--) {
                matrix[bottom][j] = num++;
            }
            bottom--;

            // 4. Fill Bottom to Top
            for (int i = bottom; i >= top; i--) {
                matrix[i][left] = num++;
            }
            left++;
        }

        return matrix;
    }
}