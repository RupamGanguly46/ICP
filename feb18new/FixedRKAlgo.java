package feb18new;
import java.util.*;
public class FixedRKAlgo {
    static final long mod = 1000000007;
    static final long base = 31;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            String s = sc.next();
            String p = sc.next();

            List<Integer> result = rkalgo(s, p);

            if(result.size() == 0){
                System.out.println("Not Found");
            } else {
                System.out.println(result.size());
                for(int x : result)
                    System.out.print(x + " ");
                System.out.println();
            }

            System.out.println();
        }

        sc.close();
    }

    public static List<Integer> rkalgo(String s, String p){
        List<Integer> ans = new ArrayList<>();

        int n = s.length();
        int m = p.length();

        if(m > n) return ans;

        long[] pow = new long[n];
        long[] prefix = new long[n];

        // Precompute powers
        pow[0] = 1;
        for(int i = 1; i < n; i++)
            pow[i] = (pow[i-1] * base) % mod;

        // Build prefix hash for text
        prefix[0] = (s.charAt(0) - 'a' + 1);
        for(int i = 1; i < n; i++)
            prefix[i] = (prefix[i-1] + (s.charAt(i) - 'a' + 1) * pow[i] % mod) % mod;

        // Compute pattern hash
        long patternHash = 0;
        for(int i = 0; i < m; i++)
            patternHash = (patternHash + (p.charAt(i) - 'a' + 1) * pow[i] % mod) % mod;

        // Sliding window comparison
        for(int i = 0; i + m - 1 < n; i++){
            int j = i + m - 1;

            long currHash = prefix[j];
            if(i > 0)
                currHash = (currHash - prefix[i-1] + mod) % mod;

            // Align hash
            if(currHash == (patternHash * pow[i]) % mod)
                ans.add(i + 1); // 1-based indexing
        }

        return ans;
    }
}
