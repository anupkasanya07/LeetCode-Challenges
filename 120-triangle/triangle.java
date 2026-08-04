class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        int n = triangle.size();
        // dp array to store the minimum path sum starting from the current element down to the bottom
        int[] dp = new int[n];

        // Initialize dp array with values from the bottom row
        for (int i = 0; i < n; i++) {
            dp[i] = triangle.get(n - 1).get(i);
        }

        // Bottom-up DP: move up from second to last row to top row
        for (int row = n - 2; row >= 0; row--) {
            for (int col = 0; col <= row; col++) {
                // Minimum sum to reach bottom from position (row, col)
                dp[col] = triangle.get(row).get(col) + Math.min(dp[col], dp[col + 1]);
            }
        }

        // Top element contains the minimum path sum
        return dp[0];
    }
}