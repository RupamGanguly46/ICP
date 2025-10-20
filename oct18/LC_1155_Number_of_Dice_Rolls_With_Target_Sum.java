package oct18;
import java.util.*;
public class LC_1155_Number_of_Dice_Rolls_With_Target_Sum {
    private int[][] dp;
    private int MOD = 1000000007;
    public int numRollsToTarget(int n, int k, int target) {
        dp = new int[n+1][target+1];
        for(int[] row: dp){
            Arrays.fill(row, -1);
        }
        return helper(n, k, target);
    }
    private int helper(int n, int k, int target){
        if(target==0 && n==0){
            return 1;
        }
        if(target<0 || n==0){
            return 0;
        }

        if(dp[n][target] != -1){
            return dp[n][target];
        }

        long count = 0;

        for(int i=1; i<=k && i<=target; i++){
            count += helper(n-1, k, target-i);
            // Taking mod again and again is same as taking mod at the end of total
            count %= MOD;
        }

        return dp[n][target] = (int) count;
    }

}