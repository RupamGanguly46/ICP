package Day_7;

public class LC_509_Fibonacci_Number {
    int[] dp;
    public int fib(int n) {
        dp = new int[n+1];
        return recur(n);
    }
    public int recur(int n){
        if(n==0 || n==1){
            return n;
        }
        if(dp[n]!=0){
            return dp[n];
        }
        dp[n] = recur(n-1)+recur(n-2);
        return dp[n];
    }
}