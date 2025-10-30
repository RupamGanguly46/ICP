package Holiday_Problems;
import java.util.*;

public class Nastya_and_Rice_1341A {
    public class Main{
        public static void main(String[]args){
            Scanner s=new Scanner(System.in);
            int t=s.nextInt();
            while(t-->0){
                int n=s.nextInt(),a=s.nextInt(),b=s.nextInt(),c=s.nextInt(),d=s.nextInt();
                int min=n*(a-b),max=n*(a+b);
                int low=c-d,high=c+d;
                if(max<low||min>high)System.out.println("No");
                else System.out.println("Yes");
            }
        }
    }

    public class Main2{
        static boolean f(int n,int a,int b,int c,int d){
            int min=n*(a-b),max=n*(a+b);
            int low=c-d,high=c+d;
            if(max<low||min>high)return false;
            return true;
        }
        static void solve(Scanner s,int t){
            if(t==0)return;
            int n=s.nextInt(),a=s.nextInt(),b=s.nextInt(),c=s.nextInt(),d=s.nextInt();
            System.out.println(f(n,a,b,c,d)?"Yes":"No");
            solve(s,t-1);
        }
        public static void main(String[]args){
            Scanner s=new Scanner(System.in);
            int t=s.nextInt();
            solve(s,t);
        }
    }
}
