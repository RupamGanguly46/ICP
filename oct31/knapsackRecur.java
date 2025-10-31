package oct31;

public class knapsackRecur {
    public static void main(String[] args) {
        int[] wt = {10, 20, 30};
        int[] val = {60, 100, 120};
        
        int W = 50;
        int n = wt.length;

        System.out.println(K(wt, val, n, W));
    }

    public static int K(int[] wt, int[] val, int n, int W){
        if(n==0 || W==0){
            return 0;
        }

        if(wt[n-1]<=W){
            return Math.max(val[n-1]+K(wt, val, n-1, W-wt[n-1]), K(wt, val, n-1, W));
        }
        else{
            return K(wt, val, n-1, W);
        }
    }
}
