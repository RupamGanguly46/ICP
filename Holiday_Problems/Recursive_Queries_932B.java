package Holiday_Problems;
import java.util.*;

public class Recursive_Queries_932B {
    public class Main{
        static int f(int x){
            int p=1;
            while(x>0){
                int d=x%10;
                if(d!=0)p*=d;
                x/=10;
            }
            return p;
        }
        static int g(int x){
            if(x<10)return x;
            return g(f(x));
        }
        public static void main(String[]args){
            Scanner s=new Scanner(System.in);
            int Q=s.nextInt();
            int N=1000000;
            int[][] pre=new int[10][N+1];
            for(int i=1;i<=N;i++){
                int v=g(i);
                for(int j=1;j<=9;j++)pre[j][i]=pre[j][i-1]+(v==j?1:0);
            }
            while(Q-->0){
                int l=s.nextInt(),r=s.nextInt(),k=s.nextInt();
                System.out.println(pre[k][r]-pre[k][l-1]);
            }
        }
    }

}
