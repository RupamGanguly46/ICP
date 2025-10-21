package oct20;
import java.util.*;
public class Maze_Paths_Diagonal {
    public static void main(String[] args) {
        System.out.println(paths(3, 3, ""));
    }
    private static List<String> paths(int r, int c, String p){
        if(r==1 && c==1){
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }
        List<String> ans = new ArrayList<>();
        if(r>1 && c>1){
            ans.addAll(paths(r-1, c-1, p+"D"));
        }
        if(r>1){
            ans.addAll(paths(r-1, c, p+"V"));
        }
        if(c>1){
            ans.addAll(paths(r, c-1, p+"H"));
        }
        return ans;
    }
}