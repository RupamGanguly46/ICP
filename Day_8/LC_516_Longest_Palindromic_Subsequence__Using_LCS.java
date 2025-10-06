package Day_8;

import java.util.Arrays;

public class LC_516_Longest_Palindromic_Subsequence__Using_LCS {
    public int longestPalindromeSubseq(String s) {
        String rev = reverse(s);
        int[][] dp = new int[s.length()][rev.length()];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return LCS(s, rev, 0, 0, dp);
    }
    public int LCS(String s1, String s2, int i, int j, int[][] dp){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s1.charAt(i)==s2.charAt(j)){
            dp[i][j] = 1 + LCS(s1, s2, i+1, j+1, dp);
        }
        else{
            dp[i][j] = Math.max(LCS(s1, s2, i+1, j, dp), LCS(s1, s2, i, j+1, dp));
        }
        return dp[i][j];
    }
    public String reverse(String s){
        if(s.length()==1){
            return s;
        }
        return reverse(s.substring(1)) + s.charAt(0);
    }
}
