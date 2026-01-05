package dec23;
import java.util.*;

public class CF_H_Blackslex_and_Plants {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int q = sc.nextInt();
            long[] ans = new long[n + 1];

            while(q-->0){
                int l = sc.nextInt();
                int r = sc.nextInt();
                for(int i=l; i<=r; i++){
                    long x = i - l + 1;
                    ans[i] += x * (x & -x);
                }
            }

            for(int i=1; i<=n; i++) System.out.print(ans[i] + " ");
            System.out.println();
        }
    }
}

