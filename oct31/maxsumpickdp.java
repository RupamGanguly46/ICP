package oct31;
import java.util.*;
// Can't take adjacent values
public class maxsumpickdp {
    public static void main(String[] args) {
        int[] arr = {1, 4, 2, -10, 5};
        int[] dp = new int[arr.length];
        Arrays.fill(dp, -1);
        System.out.println(fun(arr, 0, 0, dp));
    }
    public static int fun(int[] arr, int i, int ans, int[] dp){
        if(i==arr.length){
            return ans;
        }
        return 0;
    }
    

}
