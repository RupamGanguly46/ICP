package oct5;

public class Count {
    public static void main(String[] args) {
        int n = 1020304;
        System.out.println(helper(n, 0));
    }
    public static int helper(int n, int c){
        if(n==0){
            return c;
        }
        if(n%10==0){
            return helper(n/10, c+1);
        }
        else{
            return helper(n/10, c);
        }
    }
}
