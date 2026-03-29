package feb21new;
import java.util.*;
public class CF_D_Cost_of_Tree {
    
    static int n;
    static long[] a, sub, dp, ans;
    static int[] d, maxd;
    static ArrayList<Integer>[] g;

    static void dfs(int u, int p){
        sub[u] = a[u];
        maxd[u] = d[u];

        for(int v: g[u]){
            if(v == p) continue;
            d[v] = d[u] + 1;
            dfs(v, u);

            sub[u] += sub[v];
            dp[u] += dp[v] + sub[v];
            maxd[u] = Math.max(maxd[u], maxd[v]);
        }
    }

    static void dfs2(int u, int p){
        long res = 0;

        for(int v: g[u]){
            if(v == p) continue;

            res = Math.max(res, sub[v] * (maxd[u] - d[u] - 1));

            res = Math.max(res, ans[v] - dp[v]);

        }

        ans[u] = dp[u] + res;
    
        for(int v: g[u]){
            if(v!= p) dfs2(v, u);
        }

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0){
            n = sc.nextInt();

            a = new long[n+1];
            for(int i=1; i<=n; i++){
                a[i] = sc.nextLong();
            }

            g = new ArrayList[n+1];
            for(int i = 1; i <= n; i++){
                g[i] = new ArrayList<>();
            }

            for(int i = 0; i<n-1; i++){
                int u = sc.nextInt();
                int v = sc.nextInt();
                g[u].add(v);
                g[v].add(u);
            }

            sub = new long[n+1];
            dp = new long[n+1];
            ans = new long[n+1];
            d = new int[n+1];
            maxd = new int[n+1];

            dfs(1, 0);
            dfs(1, 0);

            for(int i=1; i<= n; i++){
                System.out.println(ans[i] + " ");

            }
            System.out.println();

        }
    }



}
