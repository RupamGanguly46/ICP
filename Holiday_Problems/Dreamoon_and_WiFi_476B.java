package Holiday_Problems;
import java.util.*;

public class Dreamoon_and_WiFi_476B {
    public class Main{
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            String s1=s.next();
            String s2=s.next();
            int target=0;
            for(char c:s1.toCharArray()) target+=(c=='+')?1:-1;
            int n=s2.length();
            double[][] dp=new double[n+1][2*n+1];
            int offset=n;
            dp[0][offset]=1.0;
            for(int i=0;i<n;i++){
                for(int j=0;j<=2*n;j++){
                    if(dp[i][j]==0) continue;
                    char c=s2.charAt(i);
                    if(c=='+'){
                        dp[i+1][j+1]+=dp[i][j];
                    }else if(c=='-'){
                        dp[i+1][j-1]+=dp[i][j];
                    }else{
                        dp[i+1][j+1]+=dp[i][j]*0.5;
                        dp[i+1][j-1]+=dp[i][j]*0.5;
                    }
                }
            }
            if(target+offset<0 || target+offset>2*n){
                System.out.printf("%.12f\n",0.0);
            }else{
                System.out.printf("%.12f\n",dp[n][target+offset]);
            }
        }
    }
}
