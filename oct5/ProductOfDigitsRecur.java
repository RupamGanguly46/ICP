package oct5;

public class ProductOfDigitsRecur {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(helper2(n));
    }
    public static int helper(int n){
        if(n==0){
            return 1;
        }
        return helper(n/10) * (n%10);
    }
    public static int helper2(int n){
        if(n%10==n){
            return n;
        }
        return helper(n/10) * (n%10);
    }
}
