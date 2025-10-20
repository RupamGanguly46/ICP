package oct18;
import java.util.*;
public class LC_17_Letter_Combinations_of_a_Phone_Number {
    public static void main(String[] args) {
        String digits = "1217";
        System.out.println(helper2(digits, ""));
    }

    private static String[] arr = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    private static List<String> helper2(String up, String p){
        if(up.length()==0){
            List<String> res = new ArrayList<>();
            res.add(p);
            return res;
        }

        List<String> ans = new ArrayList<>();

        int dig = up.charAt(0) - '0';

        if(arr[dig].isEmpty()) return helper2(up.substring(1), p);
        for(int i=0; i<arr[dig].length(); i++){
            char c = arr[dig].charAt(i);
            ans.addAll(helper2(up.substring(1), p+c));
        }

        return ans;
    }
}
