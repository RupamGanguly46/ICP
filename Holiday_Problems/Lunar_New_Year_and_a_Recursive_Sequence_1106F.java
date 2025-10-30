package Holiday_Problems;
import java.util.*;

public class Lunar_New_Year_and_a_Recursive_Sequence_1106F {
    public class Main{
        static final long P = 998244353L;
        static final long PHI = P-1;
        static long modPow(long a,long e,long mod){
            long r=1%mod;
            a%=mod;
            while(e>0){
                if((e&1)==1) r=(r*a)%mod;
                a=(a*a)%mod;
                e>>=1;
            }
            return r;
        }
        static long egcd(long a,long b,long[] xy){
            if(b==0){ xy[0]=1; xy[1]=0; return a; }
            long g=egcd(b,a%b,xy);
            long x=xy[1];
            long y=xy[0] - (a/b)*xy[1];
            xy[0]=x; xy[1]=y;
            return g;
        }
        static long invMod(long a,long m){
            long[] xy=new long[2];
            long g=egcd((a%m+m)%m,m,xy);
            if(g!=1) return -1;
            long x=(xy[0]%m+m)%m;
            return x;
        }
        static int discreteLog(long a,long b,long mod){
            a%=mod; b%=mod;
            if(b==1) return 0;
            int m = (int)Math.ceil(Math.sqrt(mod));
            Map<Long,Integer> vals = new HashMap<>();
            long cur=1;
            for(int j=0;j<m;j++){
                if(!vals.containsKey(cur)) vals.put(cur,j);
                cur = (cur * a) % mod;
            }
            long factor = modPow(a, m*(mod-2), mod); 
            long gamma = b;
            for(int i=0;i<=m;i++){
                Integer j = vals.get(gamma);
                if(j!=null){
                    int ans = i*m + j;
                    if(ans < mod) return ans;
                }
                gamma = (gamma * factor) % mod;
            }
            return -1;
        }
        static long[][] mulMat(long[][] A,long[][] B,int k,long mod){
            long[][] C = new long[k][k];
            for(int i=0;i<k;i++){
                for(int t=0;t<k;t++){
                    if(A[i][t]==0) continue;
                    long av=A[i][t];
                    for(int j=0;j<k;j++){
                        C[i][j] = (C[i][j] + av * B[t][j]) % mod;
                    }
                }
            }
            return C;
        }
        static long[][] powMat(long[][] M,long e,int k,long mod){
            long[][] res = new long[k][k];
            for(int i=0;i<k;i++) res[i][i]=1%mod;
            while(e>0){
                if((e&1)==1) res = mulMat(res,M,k,mod);
                M = mulMat(M,M,k,mod);
                e>>=1;
            }
            return res;
        }
        public static void main(String[]args){
            Scanner in=new Scanner(System.in);
            int k=in.nextInt();
            long[] b=new long[k];
            for(int i=0;i<k;i++) b[i]=in.nextLong()%(PHI);
            long n=in.nextLong();
            long m=in.nextLong();
            long g = 3;
            int E = discreteLog(g, m, P);
            if(E==-1){
                System.out.println(-1);
                return;
            }
            long exp = n - k;
            long mod = PHI;
            long[][] T = new long[k][k];
            for(int j=0;j<k;j++) T[0][j] = (b[j]%mod+mod)%mod;
            for(int i=1;i<k;i++) T[i][i-1]=1%mod;
            long[][] M = powMat(T, exp, k, mod);
            long c = M[0][0] % mod;
            c = (c%mod+mod)%mod;
            long g0 = Math.floorMod(java.math.BigInteger.valueOf(c).gcd(java.math.BigInteger.valueOf(mod)).longValue(), mod);
            long gg = java.math.BigInteger.valueOf(c).gcd(java.math.BigInteger.valueOf(mod)).longValue();
            if(gg==0) gg = mod;
            if(E % gg != 0){
                System.out.println(-1);
                return;
            }
            long mod2 = mod/gg;
            long c2 = c/gg;
            long E2 = E/gg;
            long inv = invMod(c2, mod2);
            if(inv==-1){
                System.out.println(-1);
                return;
            }
            long t0 = ( (E2 % mod2) * (inv % mod2) ) % mod2;
            long ansExp = t0;
            long fk = modPow(g, ansExp, P);
            System.out.println(fk);
        }
    }

}
