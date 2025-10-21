package oct20;
import java.util.*;
public class Maze_Paths {
    public static void main(String[] args) {
        System.out.println(paths("", 3, 3));
    }
    // private static List<String> paths(String p, int rows, int cols){
    //     if(rows==1 && cols==1){
    //         List<String> res = new ArrayList<>();
    //         res.add(p);
    //         return res;
    //     }

    //     if(rows==1){
    //         return paths(p+"R", rows, cols-1);
    //     }
    //     if(cols==1){
    //         return paths(p+"D", rows-1, cols);
    //     }

    //     List<String> ans = new ArrayList<>();
    //     ans.addAll(paths(p+"R", rows, cols-1));
    //     ans.addAll(paths(p+"D", rows-1, cols));

    //     return ans;
    // }

    private static List<String> paths(String p, int rows, int cols){
        if(rows==1 && cols==1){
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        List<String> ans = new ArrayList<>();

        if(rows>1){
            ans.addAll(paths(p+"D", rows-1, cols));
        }
        if(cols>1){
            ans.addAll(paths(p+"R", rows, cols-1));
        }

        return ans;
    }
}
