package Holiday_Problems;
import java.util.*;

public class Little_Elephant_and_Function_221A {
    public class Main{
    static void f(int n){
        if(n==1){
            System.out.print("1 ");
            return;
        }
        System.out.print(n+" ");
        for(int i=1;i<n;i++)System.out.print(i+" ");
    }
    public static void main(String[]args){
        Scanner s=new Scanner(System.in);
        int n=s.nextInt();
        f(n);
        s.close();
    }
    }
}
