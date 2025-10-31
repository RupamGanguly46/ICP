// We can use dp as when we have cut 2 then 3, and in other path we cut 3 then 2, then for both paths we have same situation.
// If we calculate once, then we can reuse answer for the next.
// We can use a dp to store the max ans for a given situation (maxlength).
package oct31;
import java.util.*;
public class cutSegmentsDP {
    public static void main(String[] args) {
        int n = 10;
        int x = 5;
        int y = 3;
        int z = 2;

        int[] dp = new int[n+1];
        // as n is included.

        Arrays.fill(dp, -1);

        int ans = maxer(n, x, y, z, dp);

        if(ans<0){
            ans = 0;
        }
        
        System.out.println(ans);

    }
    public static int maxer(int n, int x, int y, int z, int[] dp) {
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }

        if(dp[n]!=-1){
            return dp[n];
        }

        int ans = Integer.MIN_VALUE;

        if(x<=n){
            ans = Math.max(ans, 1+maxer(n-x, x, y, z, dp));
        }
        if(y<=n){
            ans = Math.max(ans, 1+maxer(n-y, x, y, z, dp));
        }
        if(z<=n){
            ans = Math.max(ans, 1+maxer(n-z, x, y, z, dp));
        }

        dp[n] = ans;
        return ans;
    }
}
