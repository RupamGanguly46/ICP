package oct7;
import java.util.*;
public class Permutations_using_recursion {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        permus("", "123", ans);
        System.out.println(ans);   
    }
    public static void permus(String p, String up, List<String> ans){
        if(up.length()==0){
            ans.add(p);
            return;
        }
        for(int i=0; i<up.length(); i++){
            char c = up.charAt(i);
            String rem = up.substring(0, i) + up.substring(i+1);
            permus(p+c, rem, ans);
        }
    }

    // public static void arpermus(List<Character> p, List<Character> up, List<String> ans){
    //     if()
    // }
}
