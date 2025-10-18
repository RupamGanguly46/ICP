package oct17;
import java.util.*;

public class Permutations_Recursion {
    public static void main(String[] args) {
        String s = "abc";
        // helper(s, "");

        // List<String> ans = new ArrayList<>();
        // helper2(s, "", ans);
        // System.out.println(ans);

        // System.out.println(helper3(s, "", new ArrayList<String>()));

        System.out.println(helper4(s, ""));
    }
    
    // Print strings
    private static void helper(String up, String p){
        if(up.length()==0){
            System.out.println(p);
            return;
        }
        char c = up.charAt(0);
        for(int i=0; i<p.length()+1; i++){
            System.out.println("i="+i+" p="+p+" up="+up);
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            helper(up.substring(1), first+c+second);
        }
    }

    // Store strings in arraylist
    private static void helper2(String up, String p, List<String> ans){
        if(up.length()==0){
            ans.add(p);
            return;
        }
        char c = up.charAt(0);
        for(int i=0; i<p.length()+1; i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            helper2(up.substring(1), first+c+second, ans);
        }
    }

    // Store strings in arraylist and return arraylist
    private static List<String> helper3(String up, String p, List<String> ans){
        if(up.length()==0){
            ans.add(p);
            return ans;
        }
        char c = up.charAt(0);
        for(int i=0; i<p.length()+1; i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            helper3(up.substring(1), first+c+second, ans);
        }
        return ans;
    }

    // Store strings in arraylist and return arraylist, also define list inside function
    private static List<String> helper4(String up, String p){
        List<String> ans = new ArrayList<>();
        if(up.length()==0){
            ans.add(p);
            return ans;
        }
        char c = up.charAt(0);
        for(int i=0; i<p.length()+1; i++){
            String first = p.substring(0, i);
            String second = p.substring(i, p.length());
            ans.addAll(helper4(up.substring(1), first+c+second));
        }
        return ans;
    }
}
