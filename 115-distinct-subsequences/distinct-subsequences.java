class Solution {
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();

        // dp[i][j] stores the number of distinct subsequences of s[0...i-1] that equal t[0...j-1]
        int[][] dp = new int[m + 1][n + 1];

        // Base case: An empty string t can be formed by 1 subsequence from any prefix of s (by deleting all characters)
        for (int i = 0; i <= m; i++) {
            dp[i][0] = 1;
        }

        // Fill the DP table
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    // Option 1: Use the matching character + Option 2: Skip the matching character in s
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    // Skip the character in s
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }

        return dp[m][n];
    }
}