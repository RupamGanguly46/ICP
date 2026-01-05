package dec23;
import java.util.*;

public class CF_B_Blackslex_and_Showering {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i=0; i<n; i++){
                arr[i] = sc.nextInt();
            }

            int totaltime = 0;
            for(int i=0; i<n-1; i++){
                totaltime += Math.abs(arr[i] - arr[i+1]);
            }

            int maxer = 0;
            maxer = Math.max(maxer, Math.abs(arr[0] - arr[1]));
            for(int i = 1; i < n - 1; i++){
                int before = Math.abs(arr[i-1] - arr[i]) + Math.abs(arr[i] - arr[i+1]);
                int after = Math.abs(arr[i-1] - arr[i+1]);
                maxer = Math.max(maxer, before-after);
            }
            maxer = Math.max(maxer, Math.abs(arr[n-2] - arr[n-1]));
            
            System.out.println(totaltime-maxer);
        }
    }
}
