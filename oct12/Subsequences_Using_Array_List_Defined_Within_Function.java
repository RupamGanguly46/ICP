package oct12;
import java.util.*;
public class Subsequences_Using_Array_List_Defined_Within_Function {
    public static void main(String[] args) {
        System.out.println(fun("","abc"));
    }
    private static List<String> fun(String p, String up){
        List<String> arr = new ArrayList<>();
        if(up.length()==0){
            arr.add(p);
            return arr;
        }
        char c = up.charAt(0);
        List<String> left = fun(p+c, up.substring(1));
        List<String> right = fun(p, up.substring(1));
        left.addAll(right);
        return left;

    }
}
