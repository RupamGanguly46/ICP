package feb18new;
import java.util.*;
// Reverse rolling hashing technique
public class RabenKarpAlgoImplementation {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            String s = sc.next();
            String p = sc.next();
            List<Integer> ll = rkalgo(s, p);
            StringBuilder sb = new StringBuilder();

            if(ll.size() == 0){
                sb.append("Not Found");
                
            }
        }
    }

    public static void rkalgofixed(String s, String p){
        int n = s.length(), m = p.length();
        if(m > n) return;

        long mod = 1000000007;
        long pr = 31;

        long[] pow = new long[n];
        long[] dp = new long[n];

        pow[0] = 1;
        for(int i = 1; i < n; i++)
            pow[i] = (pow[i-1] * pr) % mod;

        // Prefix hash for text
        dp[0] = (s.charAt(0) - 'a' + 1);
        for(int i = 1; i < n; i++)
            dp[i] = (dp[i-1] + (s.charAt(i) - 'a' + 1) * pow[i] % mod) % mod;

        // Pattern hash
        long hv = 0;
        for(int i = 0; i < m; i++)
            hv = (hv + (p.charAt(i) - 'a' + 1) * pow[i] % mod) % mod;

        List<Integer> ans = new ArrayList<>();

        for(int i = 0; i + m - 1 < n; i++){
            int j = i + m - 1;

            long curr = dp[j];
            if(i > 0)
                curr = (curr - dp[i-1] + mod) % mod;

            if(curr == (hv * pow[i]) % mod)
                ans.add(i + 1);  // 1-based indexing
        }

        System.out.println(ans.size());
        for(int x : ans)
            System.out.print(x + " ");
        System.out.println();
    }


    public static void rkalgo(String s, String p){
        if(p.length() > s.length()) return;
        // Pattern
        long hv = 0;
        long pow = 1;
        long pr = 31;
        long mod = 1000_000_007;
        for(int i=0; i<p.length(); i++){
            hv = (hv + (p.charAt(i) - 'a' + 1) % mod) % mod;
            pow = (pow * pr) % mod;
        }

        // Text
        long[] dp = new long[s.length()];
        long[] pa = new long[s.length()]; // Power Array

        pa[0] = 1;
        pow = 31;
        
        dp[0] = s.charAt(0) - 'a' + 1;

        for(int i=1; i < s.length(); i++){
            dp[i] = (dp[i-1] + ((s.charAt(i) - 'a' + 1) * pow ) % mod) % mod; 
            pa[i] = pow;
            pow = (pow * pr) % mod;

        }

        // Answer Calculation
        List<Integer> ll = new ArrayList<>();
        int n = p.length();
        if(dp[n-1] == hv){
            ll.add(1);
        }

        for(int i = n; i < pa.length; i++){
            int k = i - n;
            // If dp[i] is smaller than dp[n], thus we need to add mod, and if value is positive,it may get too large
            // So, we % it by mod.
            long curr = (dp[i] - dp[n] + mod) % mod ;

            // We take k+2 for 1 based indexing
            if(curr == (hv + pa[k+1] % mod)){
                ll.add(k+2);
            }
        }

        System.out.println(ll.size());
        for(int x : ll){
            System.out.println(x + " ");
        }
        System.out.println();

    }
}
