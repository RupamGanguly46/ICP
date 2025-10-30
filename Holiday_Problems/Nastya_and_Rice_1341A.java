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
}
