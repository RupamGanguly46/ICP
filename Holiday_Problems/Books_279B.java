package Holiday_Problems;
import java.util.*;

public class Books_279B {
    public class Main{
        public static void main(String[]args){
            Scanner s=new Scanner(System.in);
            int n=s.nextInt();
            long t=s.nextLong();
            int[] a=new int[n];
            for(int i=0;i<n;i++) a[i]=s.nextInt();
            int left=0,right=0,maxBooks=0;
            long sum=0;
            while(right<n){
                sum+=a[right];
                while(sum>t){
                    sum-=a[left];
                    left++;
                }
                maxBooks=Math.max(maxBooks,right-left+1);
                right++;
            }
            System.out.println(maxBooks);
            s.close();

        }
    }
}
