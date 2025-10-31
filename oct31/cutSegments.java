package oct31;

public class cutSegments {
    public static void main(String[] args) {
        int n = 10;
        int x = 5;
        int y = 3;
        int z = 2;

        int ans = maxer(n, x, y, z);

        if(ans<0){
            ans = 0;
        }
        
        System.out.println(ans);

    }
    public static int maxer(int n, int x, int y, int z) {
        if(n==0){
            return 0;
        }
        if(n<0){
            return Integer.MIN_VALUE;
        }

        int ans = Integer.MIN_VALUE;

        if(x<=n){
            ans = Math.max(ans, 1+maxer(n-x, x, y, z));
        }
        if(y<=n){
            ans = Math.max(ans, 1+maxer(n-y, x, y, z));
        }
        if(z<=n){
            ans = Math.max(ans, 1+maxer(n-z, x, y, z));
        }
        return ans;
    }
}
