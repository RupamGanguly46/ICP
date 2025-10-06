package Day_8;
import java.util.*;
public class LC_1143_Longest_Common_Subsequence {
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()][text2.length()];
        for(int a[]: dp){
            Arrays.fill(a, -1);
        }
        return LCS(text1, text2, 0, 0, dp);
    }
    public int LCS(String s, String t, int i, int j, int[][] dp){
        if(i>=s.length() || j>=t.length()) return 0;
        if(dp[i][j]!=-1) return dp[i][j];
        int ans;
        if(s.charAt(i)==t.charAt(j)){
            ans = 1 + LCS(s, t, i+1, j+1, dp);
        }
        else{
            ans = Math.max(LCS(s, t, i, j+1, dp), LCS(s, t, i+1, j, dp));
        }
        return dp[i][j] = ans;
    }
}