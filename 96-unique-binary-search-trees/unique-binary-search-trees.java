class Solution {
    public int numTrees(int n) {
        int[] dp = new int[n + 1];
        
        // Base cases
        dp[0] = 1;
        dp[1] = 1;

        // Fill dp table for length 2 up to n
        for (int len = 2; len <= n; len++) {
            for (int root = 1; root <= len; root++) {
                dp[len] += dp[root - 1] * dp[len - root];
            }
        }

        return dp[n];
    }
}