package jan2new;

import java.util.Arrays;

public class LC_70_Climbing_Stairs {
    class Solution {
        public int climbStairs(int n) {
            int[] dp = new int[n+1];
            Arrays.fill(dp, -1);
            return fun(n, dp);
        }
        public int fun(int n, int[] dp){
            if(n==0) return 1;
            if(n<0) return 0;

            if(dp[n] != -1) return dp[n];

            int ways = 0;
            
            ways += fun(n-1, dp);
            ways += fun(n-2, dp);

            dp[n] = ways;

            return ways;
        }
    }

    class Solution2 {
        public int climbStairs(int n) {
            if(n==0) return 1;
            if(n<0) return 0;

            int numOfWays = 0;
            
            numOfWays += climbStairs(n-1);
            numOfWays += climbStairs(n-2);

            return numOfWays;
        }
    }
}
