package Holiday_Problems;
import java.util.*;

public class Vasya_and_String_676C {
    public class Main{
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            int n=s.nextInt(), k=s.nextInt();
            String str=s.next();
            char[] c=str.toCharArray();
            System.out.println(Math.max(maxBeauty(c,n,k,'a'), maxBeauty(c,n,k,'b')));
        }
        static int maxBeauty(char[] c,int n,int k,char target){
            int[] dp=new int[n+1];
            int left=0,maxLen=0,changes=0;
            for(int right=0;right<n;right++){
                if(c[right]!=target) changes++;
                while(changes>k){
                    if(c[left]!=target) changes--;
                    left++;
                }
                maxLen=Math.max(maxLen,right-left+1);
            }
            return maxLen;
        }
    }
}
