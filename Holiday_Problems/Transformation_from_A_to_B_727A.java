package Holiday_Problems;
import java.util.*;

public class Transformation_from_A_to_B_727A {
    public class Main{
        static boolean dfs(long a,long b,ArrayList<Long> path){
            path.add(a);
            if(a==b) return true;
            if(a>b) {
                path.remove(path.size()-1);
                return false;
            }
            if(dfs(a*2,b,path)) return true;
            if(dfs(a*10+1,b,path)) return true;
            path.remove(path.size()-1);
            return false;
        }
        public static void main(String[] args){
            Scanner s=new Scanner(System.in);
            long a=s.nextLong();
            long b=s.nextLong();
            ArrayList<Long> path=new ArrayList<>();
            if(dfs(a,b,path)){
                System.out.println("YES");
                System.out.println(path.size());
                for(long x:path) System.out.print(x+" ");
            }else{
                System.out.println("NO");
            }
        }
    }
}
