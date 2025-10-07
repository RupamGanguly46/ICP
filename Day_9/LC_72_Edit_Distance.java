package Day_9;
import java.util.*;
public class LC_72_Edit_Distance {
    public int minDistance(String word1, String word2) {
        int dp[][] = new int[word1.length()][word2.length()];
        for(int[] arr: dp){
            Arrays.fill(arr, -1);
        }
        return fun(word1, word2, 0, 0, dp);
    }
    int fun(String s1, String s2, int i, int j, int[][] dp){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(s1.charAt(i) == s2.charAt(j)){
            dp[i][j] = fun(s1, s2, i+1, j+1, dp);
        }
        else{
            int insertion = fun(s1, s2, i, j+1, dp);
            int replace = fun(s1, s2, i+1, j+1, dp);
            int delete = fun(s1, s2, i+1, j, dp);
            int ans = Math.min(insertion, Math.min(replace, delete)) + 1;
            dp[i][j] = ans;
        }
        return dp[i][j];
    }
}