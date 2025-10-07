package oct7;
import java.util.*;
public class Combinations_using_recursion {
    public static void main(String[] args) {
        List<String> ans = new ArrayList<>();
        String s = "ABC";
        combi(s, "", ans, 0);
        System.out.println(ans);

        List<List<Integer>> ans2 = new ArrayList<>();
        int[] arr = {1, 2, 3};
        combi2(arr, new ArrayList<>(), ans2, 0);
        System.out.println(ans2);
    }
    public static void combi(String s, String p, List<String> ans, int index){
        if(index>=s.length()){
            ans.add(p);
            return;
        }
        combi(s, p+s.charAt(index), ans, index+1);
        combi(s, p, ans, index+1);
    }
    public static void combi2(int[] arr, List<Integer> curr, List<List<Integer>> ans2,  int index){
        if(index>=arr.length){
            ans2.add(new ArrayList<>(curr));
            return;
        }
        curr.add(arr[index]);
        combi2(arr, curr, ans2, index+1);

        curr.removeLast();
        combi2(arr, curr, ans2, index+1);
    }
}
