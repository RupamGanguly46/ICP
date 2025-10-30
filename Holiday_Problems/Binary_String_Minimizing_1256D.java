package Holiday_Problems;
import java.util.*;

public class Binary_String_Minimizing_1256D {
    public class Main{
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            int q = s.nextInt();
            while(q-->0){
                int n = s.nextInt();
                long k = s.nextLong();
                char[] c = s.next().toCharArray();
                int pos = 0; 
                for(int i = 0; i < n; i++){
                    if(c[i] == '0'){
                        long move = Math.min(i - pos, k);
                        if(move > 0){
                            c[(int)(i - move)] = '0';
                            c[i] = '1';
                            k -= move;
                        } else {
                            c[i] = '0';
                        }
                        pos++;
                        if(k == 0) break;
                    }
                }
                System.out.println(new String(c));
            }
        }
    }
}
