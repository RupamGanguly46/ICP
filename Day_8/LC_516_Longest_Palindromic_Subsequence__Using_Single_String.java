package Day_8;
import java.util.*;
public class LC_516_Longest_Palindromic_Subsequence__Using_Single_String {
    public int longestPalindromeSubseq(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for(int[] i: dp){
            Arrays.fill(i, -1);
        }
        return LPS(s, 0, s.length()-1, dp);
    }
    public int LPS(String s, int i, int j, int[][] dp){
        if(i>j) return 0;
        if(i==j) return 1;
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s.charAt(i)==s.charAt(j)){
            dp[i][j] = 2 + LPS(s, i+1, j-1, dp);
        }
        else{
            dp[i][j] = Math.max(LPS(s, i+1, j, dp), LPS(s, i, j-1, dp));
        }
        return dp[i][j];

    }
}