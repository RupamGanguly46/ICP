package dec20;

public class LC_583_Delete_Operation_for_Two_Strings {
    class Solution {
        public int minDistance(String word1, String word2) {
            int m = word1.length();
            int n = word2.length();
            // DP array to store the length of LCS
            int[][] dp = new int[m + 1][n + 1];

            // Fill the DP table
            for (int i = 1; i <= m; i++) {
                for (int j = 1; j <= n; j++) {
                    if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                        dp[i][j] = dp[i - 1][j - 1] + 1; // Characters match
                    } else {
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]); // Take max from top or left
                    }
                }
            }

            int lcsLength = dp[m][n];
            return m + n - 2 * lcsLength; // Minimum deletions to make both strings the same
        }
    }    
}
