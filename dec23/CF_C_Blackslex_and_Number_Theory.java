package dec23;
import java.util.*;

public class CF_C_Blackslex_and_Number_Theory {
    static long gcd(long a, long b){
        while(b != 0){
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextLong();
            }

            long min = arr[0];
            for(int i=1; i<n; i++){
                min = Math.min(min, arr[i]);
            }

            long ans = 0;
            for(int i=0; i<n; i++){
                ans = gcd(ans, arr[i] - min);
            }

            if(ans == 0){
                ans = min;
            }

            System.out.println(ans);
        }
    }
}



