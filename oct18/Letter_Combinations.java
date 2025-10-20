package oct18;
import java.util.*;
public class Letter_Combinations {
    public static void main(String[] args) {
        String s = "12";
        // combo(s, "");
        // System.out.println(combo2(s, ""));
        System.out.println(combocount(s, ""));
    }
    private static void combo(String up, String p){
        if(up.length()==0){
            System.out.println(p);
            return;
        }

        // Converts char digit '2' to int digit 2
        int dig = up.charAt(0) - '0';

        for(int i=(dig-1)*3; i<dig*3; i++){
            char c = (char) ('a' + i);
            combo(up.substring(1), p+c);
        }
    }

    private static List<String> combo2(String up, String p){
        if(up.length()==0){
            List<String> l = new ArrayList<>();
            l.add(p);
            return l;
        }

        List<String> arr = new ArrayList<>();

        // Converts char digit '2' to int digit 2
        int dig = up.charAt(0) - '0';

        for(int i=(dig-1)*3; i<dig*3; i++){
            char c = (char) ('a' + i);
            arr.addAll(combo2(up.substring(1), p+c));
        }

        return arr;
    }

    private static int combocount(String up, String p){
        if(up.length()==0){
            return 1;
        }
        int count = 0;
        int dig = up.charAt(0) - '0';
        for(int i=(dig-1)*3; i < dig*3; i++ ){
            char c = (char) ('a' + i);
            count += combocount(up.substring(1), p+c);
        }
        return count;
    }
}
