package oct17;
import java.util.*;
public class Subsets_Ascii_Recursion {
    public static void main(String[] args) {
        System.out.println(helper("", "abc"));
    }
    private static List<String> helper(String p, String up){
        if(up.length()==0){
            List<String> arr = new ArrayList<>();
            arr.add(p);
            return arr;
        }
        char c = up.charAt(0);
        List<String> first = helper(p + c, up.substring(1));
        List<String> second = helper(p, up.substring(1));
        List<String> third = helper(p + (c+0), up.substring(1));
        first.addAll(second);
        first.addAll(third);
        return first;
    }
}
