package oct5;

public class SumOfDigitsRecur {
    public static void main(String[] args) {
        int n = 1234;
        System.out.println(helper(n));
    }
    public static int helper(int n){
        if(n==0){
            return 0;
        }
        return helper(n/10) + (n%10);
    }
}
