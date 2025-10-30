package Holiday_Problems;
import java.util.*;

public class Nastya_and_Door_1341B {
    public class Main{
        static void solve(Scanner s,int t){
            if(t==0)return;
            int n=s.nextInt(),k=s.nextInt();
            int[] a=new int[n];
            for(int i=0;i<n;i++)a[i]=s.nextInt();
            int[] p=new int[n];
            for(int i=1;i<n-1;i++)if(a[i]>a[i-1]&&a[i]>a[i+1])p[i]=1;
            int[] pre=new int[n];
            for(int i=1;i<n;i++)pre[i]=pre[i-1]+p[i];
            int best=0,pos=0;
            for(int i=0;i<=n-k;i++){
                int cnt=pre[i+k-2]-pre[i];
                if(cnt>best){best=cnt;pos=i;}
            }
            System.out.println((best+1)+" "+(pos+1));
            solve(s,t-1);
        }
        public static void main(String[]args){
            Scanner s=new Scanner(System.in);
            int t=s.nextInt();
            solve(s,t);
        }
    }
}
