package oct5;

public class reverseNumber {
    public static void main(String[] args) {
        int n = 12345;
        // System.out.println(helper(0, n));
        // System.out.println(helper2(n));
        int digits = (int) Math.log10(n) + 1;
        System.out.println(helper3(n, digits));
    }
    public static int helper(int p, int up){
        if(up==0){
            return p;
        } 
        return helper((p*10)+(up%10), up/10);
    }
    public static int helper2(int n){
        return (n%10) + helper2(n/10);
    }

    static int sum = 0;
    public static int helper3(int n, int c){
        if(n==n%10){
            return n;
        }
        // if(n==0) return 0;
        int rem = n%10;
        sum+= rem * Math.pow(10, c-1) + helper3(n/10, c-1);
        return sum;
    }
}
